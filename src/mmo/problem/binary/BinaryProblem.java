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

import mmo.problem.Problem;
import mmo.solution.Solution;
import mmo.util.PseudoRandom;

public abstract class BinaryProblem extends Problem {

	protected int numberOfVariable;

	public BinaryProblem(int numberOfVariable) {
		this.numberOfVariable = numberOfVariable;
	}

	@Override
	public Solution generateRandomSolution() {
		Solution sol = new Solution(this, numberOfVariable);

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
