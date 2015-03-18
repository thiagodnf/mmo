package mmo.problem.binary;

import mmo.solution.Solution;

public class KnapsackProblem extends BinaryProblem {

	/** The value of knapsack's items */
	private double[] value;

	/** The weight of knapsack's items */
	private double[] weight;

	private double maxWeight;

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
