package mmo.operator.mutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import mmo.solution.Solution;

/**
 * Differential Evolution's Mutation Class
 * 
 * @author Thiago Nascimento
 * @since 2015-03-17
 * @version 1.0
 */
public abstract class DEMutation extends Mutation{

	protected double f;

	public DEMutation() {
		this(0.4);
	}

	public DEMutation(double f) {
		this.f = f;
	}
	
	/**
	 * Multiply two solutions
	 * 
	 * @param value The value
	 * @param s The solution tow
	 * @return the multiplication between a value and a solutions
	 */
	protected Solution mult(double value, Solution s) {
		Solution sol = s.clone();

		for (int i = 0; i < sol.getNumberOfBits(); i++) {
			sol.setValue(i, (double) sol.getValue(i) * value);
		}

		return sol;
	}

	/**
	 * Subtract two solutions
	 * 
	 * @param s1 The solution one
	 * @param s2 The solution tow
	 * @return the subtract between two solutions
	 */
	protected Solution minus(Solution s1, Solution s2) {
		Solution result = (Solution) s1.clone();

		for (int i = 0; i < result.getNumberOfBits(); i++) {
			result.setValue(i, (double) s1.getValue(i) - (double) s2.getValue(i));
		}

		return result;
	}
	
	/**
	 * Sum two solutions
	 * 
	 * @param s1 The solution one
	 * @param s2 The solution tow
	 * @return the sum between two solutions
	 */
	protected Solution sum(Solution s1, Solution s2) {
		Solution result = (Solution) s1.clone();

		for (int i = 0; i < result.getNumberOfBits(); i++) {
			result.setValue(i, (double) s1.getValue(i) + (double) s2.getValue(i));
		}

		return result;
	}
	
	/**
	 * Generate a list with random numbers
	 * 
	 * @param size Max size of list
	 * @return list with random numbers
	 */
	protected List<Integer> getRandomPositions(int size) {
		// Randomize the solutions
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < size; i++) {
			list.add(i);
		}

		Collections.shuffle(list);

		return list;
	}
	
	/**
	 * Execute the Differential Mutation
	 * 
	 * @param targetId Current solution
	 * @param population Set of Solutions
	 * @return a new muted solution
	 */
	public abstract Solution execute(int targetId, Solution[] population);
}
