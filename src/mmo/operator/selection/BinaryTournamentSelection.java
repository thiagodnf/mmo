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

package mmo.operator.selection;

import mmo.solution.Solution;
import mmo.util.PseudoRandom;

public class BinaryTournamentSelection extends Selection {

	@Override
	public Solution execute(Solution[] population) {
		Solution s1 = population[PseudoRandom.randInt(0, population.length - 1)].clone();
		Solution s2 = population[PseudoRandom.randInt(0, population.length - 1)].clone();

		int flag = s1.compareTo(s2);

		if (flag == -1) {
			return s1;
		} else if (flag == 1) {
			return s2;
		} else {
			if (PseudoRandom.randDouble() <= 0.5) {
				return s1;
			} else {
				return s2;
			}
		}
	}

}
