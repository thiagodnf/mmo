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
 * Rosenbrock's Function Class
 * 
 * Available at http://www.dca.fee.unicamp.br/~lboccato/topico11_14.pdf
 * 
 * @author Thiago Nascimento
 * @since 2015-03-17
 * @version 1.0
 */
public class RosenbrockFunction extends FunctionsProblem {

	public RosenbrockFunction(int numberOfVariables) {
		super(numberOfVariables);
	}

	@Override
	public double evaluate(Solution solution) {
		// Recommend values
		double a = 1;
		double b = 100;

		double x = (double) solution.getValue(0);
		double y = (double) solution.getValue(1);

		double term1 = Math.pow(a - x, 2.0);
		double term2 = b * Math.pow(y - Math.pow(x, 2.0), 2.0);

		return minimize(term1 + term2);
	}
}
