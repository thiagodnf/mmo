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

package mmo.metaheuristic;

import java.util.Arrays;

import mmo.operator.crossover.Crossover;
import mmo.operator.mutation.Mutation;
import mmo.operator.replacement.Replacement;
import mmo.operator.selection.Selection;
import mmo.problem.Problem;
import mmo.solution.Solution;
import mmo.stoppingcriteria.Iterations;
import mmo.stoppingcriteria.StoppingCriteria;

public abstract class Metaheuristic {

	protected int iteration = 0;
	
	protected StoppingCriteria stoppingCriteria;
	
	protected Selection selection;

	protected Crossover crossover;

	protected Mutation mutation;
	
	protected Replacement replacement;
	
	public Metaheuristic() {
		this.stoppingCriteria = new Iterations(1000);
	}
	
	protected boolean terminationCondition() {
		iteration++;
		return stoppingCriteria.stop(iteration);
	}
	
	public int getIteration(){
		return iteration;
	}
	
	protected Solution[] createInitialPopulation(Problem p, int populationSize) {
		// Create the new population
		Solution[] population = new Solution[populationSize];

		for (int i = 0; i < populationSize; i++) {
			population[i] = p.generateRandomSolution();
		}

		return population;
	}
	
	protected void evaluatePopulation(Problem p, Solution[] population) {
		// Evaluate each population's individual
		for (int i = 0; i < population.length; i++) {
			evaluateSolution(p, population[i]);
		}
	}
	
	protected void evaluateSolution(Problem p, Solution solution) {
		solution.setFitness(p.evaluate(solution));
	}
	
	protected Solution bestElement(Solution[] population) {
		// Sort all population
		Arrays.sort(population);
		
		// Return the first element that is the best element
		return population[0];
	}	

	public void setStoppingCriteria(StoppingCriteria stoppingCriteria) {
		this.stoppingCriteria = stoppingCriteria;
	}
	
	public Selection getSelectionOperator() {
		return selection;
	}

	public void setSelectionOperator(Selection selection) {
		this.selection = selection;
	}

	public Crossover getCrossoverOperator() {
		return crossover;
	}

	public void setCrossoverOperator(Crossover crossover) {
		this.crossover = crossover;
	}

	public Mutation getMutationOperator() {
		return mutation;
	}

	public void setMutationOperator(Mutation mutation) {
		this.mutation = mutation;
	}

	public Replacement getReplacementOperator() {
		return replacement;
	}

	public void setReplacementOperator(Replacement replacement) {
		this.replacement = replacement;
	}
	
	public abstract Solution solve(Problem p);	
}
