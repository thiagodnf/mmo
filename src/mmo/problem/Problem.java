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

package mmo.problem;

import mmo.solution.Solution;


public abstract class Problem {
	
	public double minimize(double value){
		return value;
	}
	
	public double maximize(double value){
		return -value;
	}

	public abstract double evaluate(Solution s);
	
	public abstract Solution generateRandomSolution();
	
	public abstract Solution generateNeighborhoodSolution(Solution s);
}
