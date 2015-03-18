package mmo.metaheuristic;

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

	@Override
	public Solution solve(Problem p) {
		Solution s = p.generateRandomSolution();
		
		// Number of tweaks desired to sample the gradient
		int n = param.getInt("desired_tweaks", 5);

		while (!terminationCondition()) {
			Solution r = tweak(p, copy(s));

			for (int i = 0; i < n - 1; i++) {
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
