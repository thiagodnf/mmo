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
import mmo.metaheuristic.population.DifferentialEvolution;
import mmo.problem.Problem;
import mmo.problem.function.AckleysFunction;
import mmo.stoppingcriteria.Iterations;
import mmo.util.ExecutionStats;

public class DETest {

	public static void main(String[] args) {
		Problem p  = new AckleysFunction(2);
		
		// Metaheuristic
		Metaheuristic m = new DifferentialEvolution(100);
		
		// Set Stopping Criteria
		m.setStoppingCriteria(new Iterations(1000));
				
		// Run
		ExecutionStats.execute(m, p).printStats();		
	}
}
