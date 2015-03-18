package mmo.problem.binary;

import mmo.problem.Problem;
import mmo.solution.Solution;
import mmo.util.PseudoRandom;

public class OneMaxProblem extends Problem {

	private int n;

	public OneMaxProblem(int n) {
		this.n = n;
	}

	@Override
	public double evaluate(Solution sol) {
		int countOnes = 0;

		for (int i = 0; i < sol.getNumberOfBits(); i++) {
			if ((int) sol.getValue(i) == 1) {
				countOnes++;
			}
		}

		return -countOnes;
	}

	@Override
	public Solution generateRandomSolution() {
		Solution sol = new Solution(this, n);

		for (int i = 0; i < sol.getNumberOfBits(); i++) {
			if (PseudoRandom.randDouble() <= 0.5) {
				sol.setValue(i, 0);
			} else {
				sol.setValue(i, 1);
			}
		}

		return sol;
	}

	@Override
	public Solution generateNeighborhoodSolution(Solution s) {
		Solution sol = s.clone();

		// Get a random position in solution
		int pos = PseudoRandom.randInt(0, sol.getNumberOfBits() - 1);

		// Swap the bit in the random position
		if ((int) sol.getValue(pos) == 0) {
			sol.setValue(pos, 1);
		} else {
			sol.setValue(pos, 0);
		}

		return sol;
	}

}
