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
 * Gaussian Bidimensional's Function Class 
 * 
 * Available at http://www2.ic.uff.br/~aconci/G-LoG.PDF
 * 
 * @author Thiago Nascimento
 * @since 2015-03-10
 * @version 1.0
 */
public class GaussianFunction extends FunctionsProblem {

	public GaussianFunction(int numberOfVariables) {
		super(numberOfVariables);
	}

	@Override
	public double evaluate(Solution solution) {
		// Standard Deviation
		double o = 1;
		double o2 = Math.pow(o, 2.0);

		double x = (double) solution.getValue(0);
		double y = (double) solution.getValue(1);
		double x2 = Math.pow(x, 2.0);
		double y2 = Math.pow(y, 2.0);

		// Define the minus symbol because the objective is maximize the
		// function
		return maximize((1.0 / (2.0 * Math.PI * o2)) * Math .exp(-((x2 + y2) / (2.0 * o2))));
	}
}
