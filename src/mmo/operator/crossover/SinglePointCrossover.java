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

package mmo.operator.crossover;

import mmo.solution.Solution;
import mmo.util.PseudoRandom;

public class SinglePointCrossover extends Crossover {

	protected double probability;

	public SinglePointCrossover(double probability) {
		this.probability = probability;
	}

	@Override
	public Solution[] execute(Solution s1, Solution s2) {
		int pos = PseudoRandom.randInt(0, s1.getNumberOfBits() - 1);

		Solution[] childrens = new Solution[2];

		if (PseudoRandom.randDouble() <= probability) {
			childrens[0] = (Solution) s1.clone();
			childrens[1] = (Solution) s2.clone();

			int numberOfBits = s1.getNumberOfBits();

			// Generate the children
			for (int i = 0; i < numberOfBits; i++) {
				if (i <= pos) {
					childrens[0].setValue(i, s1.getValue(i));
					childrens[1].setValue(i, s2.getValue(i));
				} else {
					childrens[0].setValue(i, s2.getValue(i));
					childrens[1].setValue(i, s1.getValue(i));
				}
			}
		} else {
			childrens[0] = s1.clone();
			childrens[1] = s2.clone();
		}

		return childrens;
	}
}
