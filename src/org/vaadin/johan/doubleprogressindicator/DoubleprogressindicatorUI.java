package org.vaadin.johan.doubleprogressindicator;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.ProgressIndicator;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * Main UI class
 */
@SuppressWarnings("serial")
@Theme("doubleprogressindicator")
public class DoubleprogressindicatorUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		
		final FaviconProgressIndicator pi = new FaviconProgressIndicator();
		pi.setPollingInterval(1000);
		pi.setIndeterminate(false);
		pi.setValue(0f);
		
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
		layout.addComponent(pi);
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					

					try {
						getUI().getSession().getLockInstance().lock();
						pi.setValue(((float) (i + 1)) / 1000f);
						pi.markAsDirty();
					} finally {
						getUI().getSession().getLockInstance().unlock();
					}
					
					try {
						Thread.sleep(150);
					} catch (InterruptedException e) {

					}
				}
				
			}
		};
		new Thread(r).start();
	}

}