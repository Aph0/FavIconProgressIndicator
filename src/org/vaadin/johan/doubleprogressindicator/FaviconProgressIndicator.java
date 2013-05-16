package org.vaadin.johan.doubleprogressindicator;

import org.vaadin.johan.doubleprogressindicator.client.faviconprogressbar.FaviconProgressbarState;

import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.ProgressIndicator;

@JavaScript("piecon.js")
public class FaviconProgressIndicator extends ProgressIndicator {


	
	public FaviconProgressIndicator() {
		getState().indeterminate = false;
	}

	@Override
	public FaviconProgressbarState getState() {
		return (FaviconProgressbarState) super.getState();
	}

	public void setColor(String color) {
		getState().color = color;
	}
	
	public String getColor() {
		return getState().color;
	}
	
	public void setBackgroundColor(String background) {
		getState().background = background;
	}
	
	public String getBackgroundColor() {
		return getState().background;
	}
	
	public void setShadowColor(String shadow) {
		getState().shadow = shadow;
	}
	
	public String getShadowColor() {
		return getState().shadow;
	}
    
}
