package mmo.metaheuristic;

import mmo.problem.Problem;
import mmo.solution.Solution;

/**
 * Hill Climbing Algorithm
 * 
 * @author Thiago Nascimento
 * @since 2015-03-17
 * @version 1.0
 */
public class HillClimbing extends Metaheuristic {

	@Override
	public Solution solve(Problem p) {
		Solution s = p.generateRandomSolution();

		while (!terminationCondition()) {
			Solution r = tweak(p, copy(s));

			if (p.evaluate(r) < p.evaluate(s)) {
				s = r;
			}
		}

		return s;
	}

	protected Solution tweak(Problem p, Solution s) {
		return p.generateNeighborhoodSolution(s);
	}

	protected Solution copy(Solution s) {
		return s.clone();
	}
}
