package org.vaadin.addons.chart.client;

import java.util.List;

import org.vaadin.addons.chart.StackLineChart;
import org.vaadin.addons.chart.shared.Color;
import org.vaadin.addons.chart.shared.StackLineChartState;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;

/**
 * Client side connector to the stack line chart.
 * 
 * @author bogdanudrescu
 */
@SuppressWarnings("serial")
@Connect(StackLineChart.class)
public class StackLineChartConnector extends AbstractComponentConnector {

	@Override
	public void onStateChanged(StateChangeEvent stateChangeEvent) {
		super.onStateChanged(stateChangeEvent);

		List<String> categories = getState().getCategories();
		List<Double> values = getState().getValues();
		List<Color> colors = getState().getColors();

		Window.alert("onStateChanged: " + categories + ", " + values + ", " + colors);

		getWidget().setChartValues(categories, values, colors);
	}

	/* (non-Javadoc)
	 * @see com.vaadin.client.ui.AbstractConnector#createState()
	 */
	@Override
	protected StackLineChartState createState() {
		return new StackLineChartState();
	}

	/* (non-Javadoc)
	 * @see com.vaadin.client.ui.AbstractFieldConnector#getState()
	 */
	@Override
	public StackLineChartState getState() {
		return (StackLineChartState) super.getState();
	}

	/* (non-Javadoc)
	 * @see com.vaadin.client.ui.AbstractComponentConnector#createWidget()
	 */
	@Override
	protected VStackLineChart createWidget() {
		VStackLineChart widget = GWT.create(VStackLineChart.class);

		List<String> categories = getState().getCategories();
		List<Double> values = getState().getValues();
		List<Color> colors = getState().getColors();

		Window.alert("createWidget: " + categories + ", " + values + ", " + colors);

		widget.setChartValues(categories, values, colors);

		return widget;
	}

	/* (non-Javadoc)
	 * @see com.vaadin.client.ui.AbstractComponentConnector#getWidget()
	 */
	@Override
	public VStackLineChart getWidget() {
		return (VStackLineChart) super.getWidget();
	}

	/* (non-Javadoc)
	 * @see com.vaadin.client.ui.AbstractConnector#init()
	 */
	@Override
	protected void init() {
		super.init();

		getWidget().registerLayoutManager(getLayoutManager());
	}

	/* (non-Javadoc)
	 * @see com.vaadin.client.ui.AbstractComponentConnector#onUnregister()
	 */
	@Override
	public void onUnregister() {
		super.onUnregister();

		getWidget().unregisterLayoutManager(getLayoutManager());
	}

}
