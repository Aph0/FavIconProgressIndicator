package org.vaadin.johan.doubleprogressindicator.client.faviconprogressbar;

import org.vaadin.johan.doubleprogressindicator.FaviconProgressIndicator;
import org.vaadin.johan.doubleprogressindicator.client.faviconprogressbar.FaviconProgressbarState;

import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.client.ui.VProgressIndicator;
import com.vaadin.client.ui.progressindicator.ProgressIndicatorConnector;
import com.vaadin.shared.ui.Connect;

import com.vaadin.client.communication.StateChangeEvent;

@Connect(FaviconProgressIndicator.class)
public class FaviconProgressbarConnector extends ProgressIndicatorConnector {

	private VProgressIndicator extendedPI;


	
	@Override
	protected void init() {
		
		super.init();
	}

	@Override
	public FaviconProgressbarState getState() {
		return (FaviconProgressbarState) super.getState();
	}

	@Override
	public void onStateChanged(StateChangeEvent stateChangeEvent) {
		super.onStateChanged(stateChangeEvent);
		System.out.println("State: " + getState().state);
		if (stateChangeEvent.hasPropertyChanged("color") || stateChangeEvent.hasPropertyChanged("background") || stateChangeEvent.hasPropertyChanged("shadow")) {
			updateOptions();
		}

		updateProgressInFavIcon();
	}

	private native void updateOptionsJS(String color, String background, String shadow, boolean fallBack) /*-{
	$wnd.Piecon.setOptions({
			color: color,
			background: background,
			shadow: shadow,
			fallback: fallBack 
	});
	}-*/;

	private void updateOptions() {
		updateOptionsJS(getState().color, getState().background, getState().shadow, false);
	}

	private void updateProgressInFavIcon() {
		updateProgressInFavIconJS((int) (getState().state * 100));
	}

	
	private native void updateProgressInFavIconJS(int statePercentage) /*-{
		$wnd.Piecon.setProgress(statePercentage);
	}-*/;

}
