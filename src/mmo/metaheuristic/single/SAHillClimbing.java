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

package mmo.metaheuristic.single;

import mmo.problem.Problem;
import mmo.solution.Solution;

/**
 * Steepest Ascent Hill-Climbing
 * 
 * @author Thiago Nascimento
 * @since 2015-03-17
 * @version 1.0
 */
public class SAHillClimbing extends HillClimbing {
	
	protected int desiredTweaks;
	
	public SAHillClimbing(int desiredTweaks){
		this.desiredTweaks = desiredTweaks;
	}

	@Override
	public Solution solve(Problem p) {
		Solution s = p.generateRandomSolution();
		
		while (!terminationCondition()) {
			Solution r = tweak(p, copy(s));

			for (int i = 0; i < desiredTweaks - 1; i++) {
				Solution w = tweak(p, copy(s));
				if (p.evaluate(w) < p.evaluate(r)) {
					r = w;
				}
			}

			if (p.evaluate(r) < p.evaluate(s)) {
				s = r;
			}
		}

		return s;
	}
}
