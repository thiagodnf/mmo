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

package mmo.util;

import java.util.Date;

import mmo.metaheuristic.Metaheuristic;
import mmo.problem.Problem;
import mmo.solution.Solution;

public class ExecutionStats {
	
	public double executionTime;

	public Problem p;

	public Metaheuristic m;

	public Solution bestSolution;

	public static ExecutionStats execute(Metaheuristic m, Problem p) {
		ExecutionStats ets = new ExecutionStats();
		ets.p = p;
		ets.m = m;		
		double startTime = (new Date()).getTime();
		ets.bestSolution = m.solve(p);
		ets.executionTime = (new Date()).getTime() - startTime;
		return ets;
	}

	public void printStats() {
		System.out.println("Algorithm: " + m.getClass().getSimpleName());
		System.out.println("Problem: " + p.getClass().getSimpleName());
		System.out.println("Execution time (ms): " + executionTime);
		System.out.println("Best Solution Found: " + bestSolution);
		System.out.println("Best Value: " + p.evaluate(bestSolution));
	}
}
