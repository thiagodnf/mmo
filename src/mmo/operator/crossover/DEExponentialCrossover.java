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

package mmo.operator.crossover;

import mmo.solution.Solution;
import mmo.util.PseudoRandom;

public class DEExponentialCrossover extends Crossover {

	protected double cr;
	
	public DEExponentialCrossover(double cr){
		this.cr = cr;
	}
	
	@Override
	public Solution[] execute(Solution target, Solution donor) {
		if (target == null || donor == null) {
			throw new IllegalArgumentException("Target or Donor cannot be null");
		}
		
		Solution trial = (Solution) target.clone();

		int D = trial.getNumberOfBits();
		
		int N = PseudoRandom.randInt(0, D - 1);
		
		int L = 0;
				
		for (int i = 0; i < target.getNumberOfBits(); i++) {
			if (PseudoRandom.randDouble() <= cr && i != (D - 1)) {
				L++;
			}
		}

		for (int i = 0; i < target.getNumberOfBits(); i++) {
			if (i >= N && i <= (N + L - 1)) {
				trial.setValue(i, donor.getValue(i));
			} else {
				trial.setValue(i, target.getValue(i));
			}
		}

		return new Solution[] { trial };
	}
}
