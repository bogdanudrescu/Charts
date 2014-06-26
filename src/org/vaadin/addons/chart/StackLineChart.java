package org.vaadin.addons.chart;

import org.vaadin.addons.chart.shared.Color;
import org.vaadin.addons.chart.shared.StackLineChartState;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import com.vaadin.ui.AbstractComponent;

/**
 * Chart component showing one stack line.
 * 
 * @author bogdanudrescu
 */
@SuppressWarnings("serial")
public class StackLineChart extends AbstractComponent {

	/**
	 * Create a stack line chart with the specified categories.
	 * @param categories	the chart categories.
	 */
	public StackLineChart(String... categories) {
		getState().setCategories(categories);
	}

	/**
	 * Create a stack line chart with the full input values.
	 * @param categories	the categories title.
	 * @param values		the values for each category.
	 * @param colors		the colors for each category.
	 */
	public StackLineChart(String[] categories, double[] values, Color[] colors) {
		getState().setCategories(categories);
		getState().setValues(values);
		getState().setColors(colors);
	}

	/* (non-Javadoc)
	 * @see com.vaadin.server.AbstractClientConnector#createState()
	 */
	@Override
	protected StackLineChartState createState() {
		return new StackLineChartState();
	}

	/* (non-Javadoc)
	 * @see com.vaadin.ui.AbstractComponent#getState()
	 */
	@Override
	protected StackLineChartState getState() {
		return (StackLineChartState) super.getState();
	}

	/**
	 * Sets the values for each category. The number of arguments must be the same as the number of categories.
	 * @param values	the values to set.
	 */
	public void setValues(double... values) {
		getState().setValues(values);
	}

	/**
	 * Sets the colors for each category. The number of arguments must be the same as the number of categories.
	 * @param colors	the colors to set.
	 */
	public void setColors(Color... colors) {
		getState().setColors(colors);
	}

	/**
	 * Sets a value for the specified category.
	 * @param value		the value to set.
	 * @param category	the category for which to set the value.
	 */
	public void setValue(double value, String category) {
		throw new NotImplementedException();
	}

	/**
	 * Sets the color for the specified category.
	 * @param color		the color to set.
	 * @param category	the category for which to set the color.
	 */
	public void setColor(Color color, String category) {
		throw new NotImplementedException();
	}

	/**
	 * Add a category and its value.
	 * @param category	the name of the category.
	 * @param value		the value to show in the chart.
	 * @param color		the category color.
	 */
	public void addCategory(String category, double value, Color color) {
		throw new NotImplementedException();
	}

}
