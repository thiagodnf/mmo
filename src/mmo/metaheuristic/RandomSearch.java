package mmo.metaheuristic;

import mmo.problem.Problem;
import mmo.solution.Solution;

/**
 * Random Search Algorithm
 * 
 * @author Thiago Nascimento
 * @since 2015-03-17
 * @version 1.0
 */
public class RandomSearch extends Metaheuristic {

	@Override
	public Solution solve(Problem p) {
		Solution bestSolution = p.generateRandomSolution();

		while (!terminationCondition()) {
			Solution newSolution = p.generateRandomSolution();

			if (p.evaluate(newSolution) < p.evaluate(bestSolution)) {
				bestSolution = newSolution;
			}
		}

		return bestSolution;
	}
}
