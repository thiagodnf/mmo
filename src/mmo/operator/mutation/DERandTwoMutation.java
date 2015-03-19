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
 * DE/rand/2 Mutation's Class
 * 
 * @author Thiago Nascimento
 * @since 2017-03-17
 * @version 1.0
 */
public class DERandTwoMutation extends Mutation {
	
	protected double F;

	public DERandTwoMutation(double F) {
		this.F = F;
	}
	
	@Override
	public Solution execute(Solution s) {
		// No use
		return null;
	}
	
	@Override
	public Solution execute(int targetId, Solution[] population) {
		if (population == null || population.length < 6) {
			throw new IllegalArgumentException("The population cannot be null or < 6");
		}
		
		List<Integer> pos = getRandomPositions(population.length);
		
		//Remove target solution's id
		pos.remove(new Integer(targetId));		
		
		// Get Solutions
		Solution r1 = population[pos.get(0)];
		Solution r2 = population[pos.get(1)];
		Solution r3 = population[pos.get(2)];
		Solution r4 = population[pos.get(3)];
		Solution r5 = population[pos.get(4)];
		
		Solution term1 = r3.minus(r2).multiply(F);
		Solution term2 = r5.minus(r4).multiply(F);
		
		return r1.sum(term1).sum(term2);		
	}
}
