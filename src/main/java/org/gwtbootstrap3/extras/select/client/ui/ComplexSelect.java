package org.gwtbootstrap3.extras.select.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2014 GwtBootstrap3
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.Command;

/**
 * @author David Buhler
 * 
 * @param <T> the value type
 */
public abstract class ComplexSelect<T> extends Select implements IHasComplexSelect<T>, IHasTypedValue<T>
{
	@SuppressWarnings("unused")
	private static final Logger	LOG		= Logger.getLogger(ComplexSelect.class.getName());
	private HashMap<String, T>	_map	= null;
	private T					_value	= null;

	@UiConstructor
	public ComplexSelect()
	{
		super();
	}

	protected void addAcceptableValue(T value)
	{
		doMap();
		addOption(value);
		refresh();
	}

	protected void addAcceptableValues(List<T> newValues)
	{
		doMap();
		for (T t : newValues)
		{
			addOption(t);
		}
		refresh();
	}

	protected void addOption(T value)
	{
		TypedOption<T> typedOption = new TypedOption<T>(value)
		{
			@Override
			protected String render(T o)
			{
				return ComplexSelect.this.getOptionName(o);
			}
		};
		typedOption.setValue(Utility.uuid());
		add(typedOption);
		_map.put(typedOption.getValue(), value);
	}

	@Override
	public void clear()
	{
		_map = null;
		super.clear();
		refresh();
	}

	private void doMap()
	{
		if (_map == null)
		{
			_map = new HashMap<String, T>();
		}
	}

	protected void fireChangeEvent()
	{
		NativeEvent event = Document.get().createChangeEvent();
		DomEvent.fireNativeEvent(event, this);
	}

	protected HashMap<String, T> getMap()
	{
		return _map;
	}

	@Override
	public T getSelectedValue()
	{
		T ret = null;
		if ((_map != null) && (super.getValue() != null))
		{
			ret = _map.get(super.getValue());
		}
		return ret;
	}

	@Override
	public void handleHasValueState()
	{
		setEnabled(true);
	}

	@Override
	public void handleNoValueState()
	{
		setEnabled(false);
	}

	protected boolean hasListValues(List<T> newValues)
	{
		return (newValues != null) && (newValues.size() > 0);
	}

	protected boolean listHasValues(List<T> list)
	{
		return (list != null) && (list.size() > 0);
	}

	private void recordValue()
	{
		_value = getSelectedValue();
	}

	public void setAcceptableValue(final T value)
	{
		clear();
		if (value != null)
		{
			handleHasValueState();
			addAcceptableValue(value);
		}
		else
		{
			handleNoValueState();
		}
	}

	public void setAcceptableValues(final List<T> newValues)
	{
		clear();
		if (hasListValues(newValues))
		{
			handleHasValueState();
			addAcceptableValues(newValues);
		}
		else
		{
			handleNoValueState();
		}
		refresh();
		fireChangeEvent();
	}
	/*
	 * Set the value and display it in the select element. Will not add the value to the acceptable set if it is not already there.
	 * 
	 * (non-Javadoc)
	 * @see org.gwtbootstrap3.extras.select.client.ui.IHasComplexSelect#setSelectedValue(java.lang.Object, boolean)
	 * 
	 * Concrete classes should override this method with a typed object after implementing org.gwtbootstrap3.extras.select.client.ui.IHasComplexSelect
	 * Example:
	 * 
		@Override
		public void setSelectedValue(YourDTO object, final boolean fireEvent)
		{
			HashMap<String, YourDTO> map = getMap();
			if (map != null)
			{
				for (YourDTO t : map.values())
				{
					if (t.equals(object))
					{
						setValue(t.getYourDTOName());
						Scheduler.get().scheduleDeferred(new Command()
						{
							@Override
							public void execute()
							{
								fireChangeEvent();
							}
						});
						break;
					}
				}
			}
		}
	 */
	@Override
	public void setSelectedValue(final T object, final boolean fireEvent)
	{
		HashMap<String, T> map = getMap();
		if (map != null)
		{
			for (Map.Entry<String, T> entry : map.entrySet())
			{
				final String key = entry.getKey();
				T value = entry.getValue();
				if (value.equals(object))
				{
					setValue(key);
					refresh();
					if (fireEvent)
					{
						Scheduler.get().scheduleDeferred(new Command()
						{
							@Override
							public void execute()
							{
								if (valueHasChanged(key))
								{
									fireChangeEvent();
									recordValue();
								}
							}
						});
					}
				}
				break;
			}
		}
	}
	
	@Override
	public void setSelectedValue(final T object)
	{
		setSelectedValue(object, true);
	}

	public int size()
	{
		int ret = 0;
		if (_map != null)
		{
			ret = this._map.size();
		}
		return ret;
	}

	protected boolean valueHasChanged(Object value)
	{
		return (value == this._value) || ((this._value != null) && this._value.equals(value));
	}
}
