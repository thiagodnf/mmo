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

import java.util.List;

import mmo.solution.Solution;

/**
 * DE/rand/p Mutation's Class
 * 
 * @author Thiago Nascimento
 * @since 2017-03-17
 * @version 1.0
 */
public class DERandOneMutation extends Mutation {
	
	/** Scales the influence of the set of pairs of solutions
	 *  selected to calculate the mutation value */
	protected double F;
	
	public DERandOneMutation(double F) {
		this.F = F;
	}
	
	@Override
	public Solution execute(Solution s) {
		// No use
		return null;
	}
	
	@Override
	public Solution execute(int targetId, Solution[] population) {
		if (population == null || population.length < 4) {
			throw new IllegalArgumentException("The population cannot be null or < 4");
		}
		
		List<Integer> pos = getRandomPositions(population.length);
		
		//Remove target solution's id
		pos.remove(new Integer(targetId));		
		
		Solution r1 = population[pos.get(0)];
		Solution r2 = population[pos.get(1)];
		Solution r3 = population[pos.get(2)];		

		return r2.minus(r3).multiply(F).sum(r1);
	}
}
