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

package mmo.metaheuristic.population;

import mmo.operator.crossover.SinglePointCrossover;
import mmo.operator.mutation.BitFlipMutation;
import mmo.operator.replacement.ElitismReplacement;
import mmo.operator.selection.RouletteWheelSelection;
import mmo.problem.Problem;
import mmo.solution.Solution;

public class GeneticAlgorithm extends PopulationBased {
	
	protected int populationSize;

	public GeneticAlgorithm(int populationSize) {
		this.populationSize = populationSize;
		this.selection = new RouletteWheelSelection();
		this.crossover = new SinglePointCrossover(0.8);
		this.mutation = new BitFlipMutation(0.005);
		this.replacement = new ElitismReplacement(2);
	}

	@Override
	public Solution solve(Problem p) {

		Solution[] population = createInitialPopulation(p, populationSize);
		evaluatePopulation(p, population);

		while (!terminationCondition()) {
			// Selection
			Solution[] parents = doSelection(population);

			// Crossover
			Solution[] offspring = doCrossover(parents);

			// Mutation
			offspring = doMutation(offspring);

			// Replacement
			population = doReplacement(population, offspring);

			evaluatePopulation(p, population);
		}

		return bestElement(population);
	}

	protected Solution[] doSelection(Solution[] population) {
		Solution[] parents = new Solution[population.length];

		for (int i = 0; i < parents.length; i++) {
			parents[i] = selection.execute(population);
		}

		return parents;
	}
	
	/**
	 * Get a parents solutions and return a offspring solutions
	 * 
	 * @param parents Solutions that will be crossovered
	 * @return a new offspring solutions
	 */
	protected Solution[] doCrossover(Solution[] parents){
		Solution[] offspring = new Solution[parents.length];

		// Generate children by two consecutive parents
		for (int i = 0; i < parents.length; i += 2) {
			Solution[] childrens = null;

			// If the population size has odd solution, the crossover will be made with
			// the first and the last solution
			if (i + 1 == parents.length) {
				childrens = crossover.execute(parents[i], parents[0]);
			} else {
				childrens = crossover.execute(parents[i], parents[i + 1]);
			}

			// Two parents always generate two offspring
			if (childrens == null || childrens.length != 2) {
				throw new IllegalArgumentException(	"The offspring cannot be null or different of two");
			}

			offspring[i] = childrens[0];

			if (i + 1 != parents.length) {
				offspring[i + 1] = childrens[1];
			}
		}

		return offspring;
	}
	
	protected Solution[] doMutation(Solution[] offspring) {
		for (int i = 0; i < offspring.length; i++) {
			offspring[i] = mutation.execute(offspring[i]);
		}
		
		return offspring;
	}
	
	protected Solution[] doReplacement(Solution[] population, Solution[] offspring){
		return replacement.execute(population,offspring);
	}

}
