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
 * Michalewicz's Function
 * 
 * Available at http://www.dca.fee.unicamp.br/~lboccato/topico11_14.pdf
 * 
 * @author Thiago Nascimento
 * @since 2015-03-17
 * @version 1.0
 */
public class MichalewiczFunction extends FunctionsProblem {

	public MichalewiczFunction(int numberOfVariables) {
		super(numberOfVariables);
	}

	@Override
	public double evaluate(Solution solution) {
		// Recommend values
		double n = numberOfVariables;
		double m = 10;
		double s = 0;

		for (int i = 1; i <= n; i++) {
			double xi = (double) solution.getValue(i-1);
			double term1 = Math.sin(xi);
			double term2 = Math.pow(Math.sin(i * Math.pow(xi, 2.0) / Math.PI), 2.0 * m);
			s += term1 * term2;
		}

		return minimize(-s);
	}
}
