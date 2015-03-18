package mmo.solution;

import java.util.Arrays;

import mmo.problem.Problem;

public class Solution implements Cloneable, Comparable<Solution>{

	protected int numberOfBits;

	protected double fitness;
	
	protected Problem p;
	
	private Object[] values;

	public Solution(Problem p, int numberOfBits) {
		this.p = p;
		this.numberOfBits = numberOfBits;
		this.values = new Object[numberOfBits];
	}

	public int getNumberOfBits() {
		return numberOfBits;
	}

	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

	public double getFitness() {
		return this.fitness;
	}
	
	@Override
	public int compareTo(Solution s) {
		double diff = p.evaluate(this) - p.evaluate(s);

		if (diff < 0) {
			return -1;
		} else if (diff > 0) {
			return 1;
		}

		return 0;
	}

	@Override
	public Solution clone() {
		Solution s = new Solution(p, numberOfBits);
		s.fitness = fitness;
		s.values = values.clone();
		return s;
	}

	@Override
	public String toString() {
		return Arrays.toString(values);
	}

	public void setValue(int index, Object value) {
		this.values[index] = value;
	}

	public Object getValue(int index) {
		return this.values[index];
	}
}
