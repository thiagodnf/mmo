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
 * DE/Target-to-best/1 Mutation's Class
 * 
 * @author Thiago Nascimento
 * @since 2017-03-17
 * @version 1.0
 */
public class DECurrentToBestOneMutation extends Mutation {
	
	protected double F;

	public DECurrentToBestOneMutation(double F) {
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
		
		// Get the best element at population
		Solution bestSolution = population[0];
		
		for(int i=0;i<population.length;i++){
			if(population[i].getFitness() < bestSolution.getFitness()){
				bestSolution = population[i];
			}
		}		
		
		Solution r1 = population[pos.get(0)];
		Solution r2 = population[pos.get(1)];
		Solution target = population[targetId];
		
		Solution term1 = bestSolution.minus(target).multiply(F);
		Solution term2 = r2.minus(r1).multiply(F);
		
		return target.sum(term1).sum(term2);
	}
}
