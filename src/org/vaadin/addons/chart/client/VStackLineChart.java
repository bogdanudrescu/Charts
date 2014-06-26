package org.vaadin.addons.chart.client;

import java.util.ArrayList;
import java.util.List;

import org.vaadin.addons.chart.shared.CSSText;
import org.vaadin.addons.chart.shared.ChartUtils;
import org.vaadin.addons.chart.shared.Color;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.LayoutManager;
import com.vaadin.client.ui.layout.ElementResizeEvent;
import com.vaadin.client.ui.layout.ElementResizeListener;

/**
 * The browser widget for a StackLineChart.
 * 
 * @author bogdanudrescu
 */
public class VStackLineChart extends Widget {

	/*
	 * The categories list.
	 */
	private List<String> categories = new ArrayList<String>();

	/*
	 * The values list.
	 */
	private List<Double> values = new ArrayList<Double>();

	/*
	 * The colors list.
	 */
	private List<Color> colors = new ArrayList<Color>();

	/*
	 * The main element.
	 */
	private DivElement element;

	/*
	 * The element items in the chart element.
	 */
	private List<Element> items = new ArrayList<Element>();

	/**
	 * Create a StackLineChart widget.
	 */
	public VStackLineChart() {
		setElement(Document.get().createDivElement());

		element = Document.get().createDivElement();
		element.addClassName("v-chart");
		element.addClassName("v-chart-stackline");

		getElement().appendChild(element);
	}

	/*
	 * Refresh the chart view.
	 */
	private void refreshChart() {

		if (layoutManager == null) {
			return;
		}

		double total = ChartUtils.sumAsDouble(values);
		int totalWidth = layoutManager.getInnerWidth(element);

		int totalWidthSoFar = 0;

		for (int i = 0; i < categories.size(); i++) {
			Element item;

			if (i < items.size()) {
				item = items.get(i);

			} else {
				item = Document.get().createDivElement();

				element.appendChild(item);
				items.add(item);
			}

			item.addClassName("v-chart-stacklineitem");

			boolean isLeft = i == 0;
			boolean isRight = i == categories.size() - 1;

			if (isLeft) {
				item.addClassName("v-left");
			}
			if (isRight) {
				item.addClassName("v-right");
			}

			Double value = values.get(i);

			double widthPercentage = value * 100 / total;
			int width = isRight ? totalWidth - totalWidthSoFar : (int) Math.round(value * totalWidth / total);

			CSSText css = new CSSText();
			//css.setProperty("width", widthPercentage + "%");
			css.setProperty("width", width + "px");
			css.setProperty("background", colors.get(i).getCSS());

			item.setAttribute("style", css.toString());

			totalWidthSoFar += width;

		}

		// Remove any extra elements due to changes in the state configuration.
		while (categories.size() < items.size()) {
			items.remove(items.size() - 1);
		}

	}

	/**
	 * Sets the categories.
	 * @param categories	the new categories to set.
	 */
	public void setChartValues(List<String> categories, List<Double> values, List<Color> colors) {

		// TODO: throw an exception if the sizes differ.

		this.categories.clear();
		this.categories.addAll(categories);

		this.values.clear();
		this.values.addAll(values);

		this.colors.clear();
		this.colors.addAll(colors);

		refreshChart();
	}

	private LayoutManager layoutManager;

	/*
	 * Register the layout manager.
	 */
	void registerLayoutManager(LayoutManager layoutManager) {
		this.layoutManager = layoutManager;

		layoutManager.addElementResizeListener(element, resizeListener);
	}

	/*
	 * Unregister the layout manager.
	 */
	void unregisterLayoutManager(LayoutManager layoutManager) {
		layoutManager.removeElementResizeListener(element, resizeListener);

		this.layoutManager = null;
	}

	/*
	 * The resize listener.
	 */
	private ElementResizeListener resizeListener = new ElementResizeListener() {

		@Override
		public void onElementResize(ElementResizeEvent e) {
			//Window.alert("onElementResize: " + e.getElement());
			refreshChart();
		}
	};

}
