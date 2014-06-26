package org.vaadin.addons.chart.shared;


/**
 * Utility methods.
 * 
 * @author bogdanudrescu
 */
public class ChartUtils {

	/**
	 * Calculate the total sum of the numbers in the specified collection.
	 * @param values	the list of values to sum.
	 * @return	the sum of the values.
	 */
	public static double sumAsDouble(Iterable<? extends Number> values) {
		double total = 0;
		for (Number value : values) {
			total += value.doubleValue();
		}

		return total;
	}

}
