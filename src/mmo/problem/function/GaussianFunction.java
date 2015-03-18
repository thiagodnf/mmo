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
