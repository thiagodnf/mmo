package mmo.util;

import java.util.ArrayList;
import java.util.List;

import mmo.solution.Solution;

/**
 * Convert Class
 * 
 * @author Thiago Nascimento
 * @since 2015-03-17
 * @version 1.0;
 */
public class Convert {

	public static List<Solution> toList(Solution[] population) {
		if (population == null || population.length == 0) {
			throw new IllegalArgumentException("The population cannot be null or empty");
		}

		List<Solution> list = new ArrayList<Solution>();

		for (int i = 0; i < population.length; i++) {
			list.add(population[i]);
		}

		return list;
	}
}
