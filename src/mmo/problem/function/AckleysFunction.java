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

package mmo.problem.function;

import mmo.solution.Solution;

/**
 * Bi-Dimensional Ackley's Function
 * 
 * Available at http://www.sfu.ca/~ssurjano/ackley.html
 * 
 * @author Thiago Nascimento
 * @since 2015-03-10
 * @version 1.0
 */
public class AckleysFunction extends FunctionsProblem {

	public AckleysFunction(int numberOfVariables) {
		super(numberOfVariables);
	}

	@Override
	public double evaluate(Solution solution) {
		// Recommend values
		double a = 20.0;
		double b = 0.2;
		double c = 2.0 * Math.PI;
		double d = numberOfVariables;

		double sum1 = 0.0;

		for (int i = 0; i < d; i++) {
			sum1 += Math.pow((double) solution.getValue(i), 2.0);
		}

		double sum2 = 0.0;

		for (int i = 0; i < d; i++) {
			sum2 += Math.cos(c * (double) solution.getValue(i));
		}

		double term1 = a * Math.exp(-b * Math.sqrt(sum1 / d));
		double term2 = Math.exp(sum2 / d);
		double term3 = a + Math.exp(1);

		return minimize(-term1 - term2 + term3);
	}
}
