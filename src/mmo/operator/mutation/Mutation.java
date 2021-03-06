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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import mmo.operator.Operator;
import mmo.solution.Solution;

public abstract class Mutation extends Operator {
	
	/**
	 * Generate a list with random numbers
	 * 
	 * @param size Max size of list
	 * @return list with random numbers
	 */
	protected List<Integer> getRandomPositions(int size) {
		// Randomize the solutions
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < size; i++) {
			list.add(i);
		}

		Collections.shuffle(list);

		return list;
	}

	public abstract Solution execute(Solution s);
	
	public abstract Solution execute(int targetId, Solution[] population);
}
