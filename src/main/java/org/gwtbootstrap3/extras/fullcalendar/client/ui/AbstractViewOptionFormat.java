package org.gwtbootstrap3.extras.fullcalendar.client.ui;

import java.util.HashMap;
import java.util.Map;


/**
 * A super class to help model the view options
 * 
 * @author Jeff Isenhart
 * @see http://arshaw.com/fullcalendar/docs/views/View_Option_Hash/
 * Currently, View Option Hashes only work for dragOpacity, titleFormat, columnFormat, and timeFormat.
 */
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
