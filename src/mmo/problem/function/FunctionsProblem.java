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
