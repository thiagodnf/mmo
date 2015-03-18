package mmo.util;

import java.util.HashMap;

/**
 * Define a set of Parameters that will be defined
 * by user and used by metaheuristic
 * 
 * @author Thiago Nascimento
 * @since 2015-03-17
 * @version 1.0
 */
public class ParameterSet {

	protected HashMap<String, Object> parameters;

	public ParameterSet() {
		this.parameters = new HashMap<String, Object>();
	}

	public void add(String key, Object value) {
		this.parameters.put(key, value);
	}

	public boolean exists(String key) {
		return parameters.containsKey(key);
	}

	public String getString(String key) {
		return getString(key, "");
	}
	
	public String getString(String key, String defaultValue) {
		if (exists(key)) {
			return String.valueOf(parameters.get(key));
		}
		return defaultValue;
	}

	public int getInt(String key) {
		return getInt(key, 0);
	}

	public int getInt(String key, int defaultValue) {
		if (exists(key)) {
			return Integer.parseInt(getString(key));
		}
		return defaultValue;
	}

	public double getDouble(String key) {
		return getDouble(key, 0.0);
	}

	public double getDouble(String key, double defaultValue) {
		if (exists(key)) {
			return Double.parseDouble(getString(key));
		}
		return defaultValue;
	}
}
