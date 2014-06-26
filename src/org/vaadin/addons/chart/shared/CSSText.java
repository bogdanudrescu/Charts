package org.vaadin.addons.chart.shared;

/**
 * Generates a simple CSS style.
 * 
 * @author bogdanudrescu
 */
public class CSSText {

	/*
	 * The buffer with the json.
	 */
	private StringBuilder css;

	/**
	 * Create a CSS style text document.
	 */
	public CSSText() {
		css = new StringBuilder();
	}

	/**
	 * Adds a String entry into the css.
	 * @param name	the name of the entry.
	 * @param value	the value of the entry.
	 * @return	this instance of CSS.
	 */
	public CSSText setProperty(String name, Object value) {
		if (value != null) {
			addSeparator();
			addPropertyName(name);
			addPropertyValue(value);
		}
		return this;
	}

	/*
	 * Add the comma if necessary.
	 */
	private void addSeparator() {
		if (css.length() > 0) {
			css.append(";");
		}
	}

	/*
	 * Adds the key for a json entry.
	 */
	private void addPropertyName(String name) {
		css.append(name).append(":");
	}

	/*
	 * Adds the value as an object.
	 */
	private void addPropertyValue(Object value) {
		css.append(value);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return css.toString();
	}

}
