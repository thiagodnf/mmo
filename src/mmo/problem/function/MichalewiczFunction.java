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
