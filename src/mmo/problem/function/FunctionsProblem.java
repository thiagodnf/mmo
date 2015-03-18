package mmo.problem.function;

import mmo.problem.Problem;
import mmo.solution.Solution;
import mmo.util.PseudoRandom;

/**
 * Default template to functions problems
 * 
 * @author Thiago Nascimento
 * @since 2015-03-15
 * @version 1.0
 */
public abstract class FunctionsProblem extends Problem {

	protected int numberOfVariables;

	public FunctionsProblem(int numberOfVariables) {
		this.numberOfVariables = numberOfVariables;
	}

	@Override
	public Solution generateNeighborhoodSolution(Solution s) {
		Solution sol = s.clone();

		// Get a random position in solution
		int pos = PseudoRandom.randInt(0, sol.getNumberOfBits() - 1);
		
		if (PseudoRandom.randDouble() <= 0.5) {
			sol.setValue(pos, (double) sol.getValue(pos) + PseudoRandom.randDouble());
		} else {
			sol.setValue(pos, (double) sol.getValue(pos) - PseudoRandom.randDouble());
		}

		return sol;		
	}

	@Override
	public Solution generateRandomSolution() {
		Solution sol = new Solution(this, numberOfVariables);

		// Define the random solution between 0 and 1
		for (int i = 0; i < sol.getNumberOfBits(); i++) {
			sol.setValue(i, PseudoRandom.randDouble());
		}

		return sol;
	}
}
