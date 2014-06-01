package org.gwtbootstrap3.extras.fullcalendar.client.ui;

import java.util.HashMap;
import java.util.Map;



public abstract class AbstractViewOptionFormat {
	
	protected abstract void populateDefaultOptions(Map<ViewOptionHash,String> options);
	protected AbstractViewOptionFormat(){
		
	}
	
	protected  Map<ViewOptionHash,String> getDefaultOptions(){
		Map<ViewOptionHash,String> map = new HashMap<ViewOptionHash,String>();
		populateDefaultOptions(map);
		return map;
	}
}
