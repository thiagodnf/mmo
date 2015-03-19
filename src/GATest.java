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

import mmo.metaheuristic.Metaheuristic;
import mmo.metaheuristic.population.GeneticAlgorithm;
import mmo.problem.binary.KnapsackProblem;
import mmo.stoppingcriteria.Iterations;
import mmo.util.ExecutionStats;


public class GATest {

	public static void main(String[] args) {
		// Problem
		KnapsackProblem p = new KnapsackProblem(8);

		// Load instance
		p.setValue(new double[] { 3, 3, 2, 4, 2, 3, 5, 2 });
		p.setWeight(new double[] { 5, 4, 7, 8, 4, 4, 6, 8 });
		p.setMaxWeight(25);
		
		// Metaheuristic
		Metaheuristic m = new GeneticAlgorithm(100);
				
		// Set Stopping Criteria
		m.setStoppingCriteria(new Iterations(1000));

		// Run
		ExecutionStats.execute(m, p).printStats();		
	}
}
