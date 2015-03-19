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

package mmo.operator.replacement;

import java.util.Arrays;

import mmo.solution.Solution;

public class ElitismReplacement extends Replacement {
	
	protected int n_elitism;
	
	public ElitismReplacement(int n_elitism){
		this.n_elitism = n_elitism;
	}

	@Override
	public Solution[] execute(Solution[] population, Solution[] offspring) {
	
		Solution[] newPopulation = new Solution[population.length];
		
		int index = 0;
		
		// Copy best individuals the previous population
		
		Arrays.sort(population);
		
		for (int i = 0; i < n_elitism; i++) {
			newPopulation[index++] = population[i].clone();
		}
		
		// Copy the best offspring
		
		Arrays.sort(offspring);
		
		for (int i = 0; i < offspring.length - n_elitism; i++) {
			newPopulation[index++] = offspring[i];
		}		
		
		return newPopulation;
	}

}
