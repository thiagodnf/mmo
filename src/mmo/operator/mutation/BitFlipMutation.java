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

package mmo.operator.mutation;

import mmo.solution.Solution;
import mmo.util.PseudoRandom;

public class BitFlipMutation extends Mutation {

	protected double probability;

	/**
	 * Create the Bit Flip Mutation
	 * 
	 * @param probability Probability of Mutation
	 */
	public BitFlipMutation(double probability) {
		this.probability = probability;
	}

	@Override
	public Solution execute(Solution s) {
		for (int i = 0; i < s.getNumberOfBits(); i++) {
			if (PseudoRandom.randDouble() <= probability) {
				if ((int) s.getValue(i) == 0) {
					s.setValue(i, 1);
				} else {
					s.setValue(i, 0);
				}
			}
		}

		return s;
	}

	@Override
	public Solution execute(int targetId, Solution[] population) {
		// No use
		return null;
	}
}
