/*
 * Copyright 2015 Thiago Nascimento
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package mmo.problem.binary;

import mmo.solution.Solution;

/**
 * Knapsak Problem
 * 
 * @author Thiago Nascimento
 * @since 2015-03-18
 * @version 1.0
 */
public class KnapsackProblem extends BinaryProblem {

	/** The value of knapsack's items */
	private double[] value;

	/** The weight of knapsack's items */
	private double[] weight;

	private double maxWeight;

	/**
	 * Constructor
	 * 
	 * @param numberOfItems Number of available items for selection 
	 */
	public KnapsackProblem(int numberOfItems) {
		super(numberOfItems);
	}

	@Override
	public double evaluate(Solution sol) {
		double sumValue = 0.0;
		double sumWeight = 0.0;

		// Sum the values
		for (int i = 0; i < numberOfVariable; i++) {
			sumValue += (int) sol.getValue(i) * value[i];
			sumWeight += (int) sol.getValue(i) * weight[i];
		}

		// Penalizes the solution that exceeds the knapsack's limit
		double alpha = 0.0;

		for (int i = 0; i < numberOfVariable; i++) {
			alpha += value[i];
		}

		return maximize(sumValue - alpha * Math.max(0, sumWeight - maxWeight));
	}

	public double[] getValue() {
		return value;
	}

	public void setValue(double[] value) {
		this.value = value;
	}

	public double[] getWeight() {
		return weight;
	}

	public void setWeight(double[] weight) {
		this.weight = weight;
	}

	public void setMaxWeight(double maxWeight) {
		this.maxWeight = maxWeight;
	}

	public double getMaxWeight() {
		return maxWeight;
	}
}
