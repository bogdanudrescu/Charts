package org.vaadin.addons.chart.test;

import javax.servlet.annotation.WebServlet;

import org.vaadin.addons.chart.StackLineChart;
import org.vaadin.addons.chart.shared.Color;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("charts")
@Widgetset("org.vaadin.addons.chart.StackLineChartWidgetset")
public class ChartsUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = ChartsUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setSizeFull();
		layout.setMargin(true);
		setContent(layout);

		StackLineChart chart = new StackLineChart(new String[] { "Red", "Blue", "Green" }, new double[] { 7, 13, 17 }, new Color[] { Color.RED,
				Color.BLUE, Color.GREEN });
		chart.setSizeFull();

		layout.addComponent(chart);
	}
}