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

public class RouletteWheelSelection extends Selection{

	protected int doRouletteWheel(double[] probability, double sumProbability) {
		int j = 0;
		double p = probability[j];
		double r = PseudoRandom.randDouble(0.0, sumProbability);

		while (p < r) {
			j = j + 1;
			p = p + probability[j];
		}

		return j;
	}
	
	@Override
	public Solution execute(Solution[] population) {
		double sumProbability = 0.0;
		double[] probability = new double[population.length];

		// Sum all population's fitness
		for (int i = 0; i < population.length; i++) {
			sumProbability += Math.abs(population[i].getFitness());
		}

		// Normalize the probability
		for (int i = 0; i < population.length; i++) {
			probability[i] = Math.abs(population[i].getFitness()) / sumProbability;
		}

		return population[doRouletteWheel(probability, 1.0)].clone();
	}
}
