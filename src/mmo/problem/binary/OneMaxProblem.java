package mmo.problem.binary;

import mmo.solution.Solution;

public class OneMaxProblem extends BinaryProblem {

	public OneMaxProblem(int n) {
		super(n);
	}

	@Override
	public double evaluate(Solution sol) {
		int countOnes = 0;

		for (int i = 0; i < sol.getNumberOfBits(); i++) {
			if ((int) sol.getValue(i) == 1) {
				countOnes++;
			}
		}

		return maximize(countOnes);
	}
}
