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
	
	public Solution(Problem p, Object[] values) {
		this.p = p;
		this.values = values;
		this.numberOfBits = values.length;
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

	public void setValue(int index, Object value) {
		this.values[index] = value;
	}

	public Object getValue(int index) {
		return this.values[index];
	}
	
	/**
	 * Subtract a solution
	 * 
	 * @param s the solution that will be multiply
	 * @return the subtract between two solutions
	 */
	public Solution minus(Solution s) {
		Solution result = this.clone();

		for (int i = 0; i < result.getNumberOfBits(); i++) {
			result.setValue(i, (double) getValue(i) - (double) s.getValue(i));
		}

		return result;
	}
	
	/**
	 * Sum a solution
	 * 
	 * @param s the solution that will be multiply
	 * @return the sum between two solutions
	 */
	public Solution sum(Solution s) {
		Solution result = this.clone();

		for (int i = 0; i < result.getNumberOfBits(); i++) {
			result.setValue(i, (double) getValue(i) + (double) s.getValue(i));
		}

		return result;
	}
	
	/**
	 * Multiply by a number
	 * 
	 * @param value the value that will be multiply
	 * @return the multiplication between a value and a solution
	 */
	public Solution multiply(double value) {
		Solution sol = this.clone();

		for (int i = 0; i < sol.getNumberOfBits(); i++) {
			sol.setValue(i, (double) getValue(i) * value);
		}

		return sol;
	}
	
	/**
	 * Multiply by a solution
	 * 
	 * @param s the solution that will be multiply
	 * @return the multiplication between two solutions
	 */
	public Solution multiply(Solution s) {
		Solution sol = this.clone();

		for (int i = 0; i < sol.getNumberOfBits(); i++) {
			sol.setValue(i, (double) getValue(i) * (double) s.getValue(i));
		}

		return sol;
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

	
}
