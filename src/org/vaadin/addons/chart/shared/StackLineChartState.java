package org.vaadin.addons.chart.shared;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.shared.AbstractComponentState;

/**
 * The shared state of the server and client component.
 * 
 * @author bogdanudrescu
 */
public class StackLineChartState extends AbstractComponentState {

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

	/**
	 * Gets the categories.
	 * @return	the categories.
	 */
	public List<String> getCategories() {
		return categories;
	}

	/**
	 * Gets the values.
	 * @return	the values.
	 */
	public List<Double> getValues() {
		return values;
	}

	/**
	 * Gets the colors.
	 * @return	the colors.
	 */
	public List<Color> getColors() {
		return colors;
	}

	/**
	 * Sets the categories.
	 * @param categories	the new categories to set.
	 */
	public void setCategories(List<String> categories) {
		this.categories.clear();
		this.categories.addAll(categories);
	}

	/**
	 * Sets the values.
	 * @param values	the new values to set.
	 */
	public void setValues(List<Double> values) {
		this.values.clear();
		this.values.addAll(values);
	}

	/**
	 * Sets the colors.
	 * @param colors	the new colors to set.
	 */
	public void setColors(List<Color> colors) {
		this.colors.clear();
		this.colors.addAll(colors);
	}

	/**
	 * Sets the categories.
	 * @param categories	the new categories to set.
	 */
	public void setCategories(String[] categories) {
		this.categories.clear();
		for (String category : categories) {
			this.categories.add(category);
		}
	}

	/**
	 * Sets the values.
	 * @param values	the new values to set.
	 */
	public void setValues(double[] values) {
		this.values.clear();
		for (double value : values) {
			this.values.add(value);
		}
	}

	/**
	 * Sets the colors.
	 * @param colors	the new colors to set.
	 */
	public void setColors(Color[] colors) {
		this.colors.clear();
		for (Color color : colors) {
			this.colors.add(color);
		}
	}

}
