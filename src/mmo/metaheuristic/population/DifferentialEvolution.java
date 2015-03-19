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

import mmo.operator.crossover.DEBinomialCrossover;
import mmo.operator.mutation.DERandOneMutation;
import mmo.problem.Problem;
import mmo.solution.Solution;

/**
 * Differential Evolution Algorithm's Class 
 * <br>
 * Available at http://www.dca.fee.unicamp.br/~lboccato/topico11_14.pdf
 * 
 * @author Thiago Nascimento
 * @since 2013-03-17
 * @version 1.0
 */
public class DifferentialEvolution extends PopulationBased {

	protected int populationSize;
	
	public DifferentialEvolution(int populationSize) {
		this.populationSize = populationSize;
		this.mutation = new DERandOneMutation(0.5);
		this.crossover = new DEBinomialCrossover(0.8);
	}

	@Override
	public Solution solve(Problem p) {

		Solution[] population = createInitialPopulation(p, populationSize);
		evaluatePopulation(p, population);

		while (!terminationCondition()) {
			for (int i = 0; i < populationSize; i++) {
				Solution target = population[i];

				// Mutation
				Solution donor = mutation.execute(i, population);

				// Crossover
				Solution trial = crossover.execute(target, donor)[0];
				evaluateSolution(p, trial);

				// Selection
				if (trial.getFitness() < target.getFitness()) {
					population[i] = trial;
				}
			}
		}

		return bestElement(population);
	}	
}
