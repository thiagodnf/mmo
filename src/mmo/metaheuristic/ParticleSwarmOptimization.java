package mmo.metaheuristic;

import mmo.problem.Problem;
import mmo.solution.Solution;
import mmo.util.PseudoRandom;

/**
 * Particle Swarm Optimization Algorithm
 * 
 * @author Thiago Nascimento
 * @since 2015-03-17
 * @version 1.0
 */
public class ParticleSwarmOptimization extends Metaheuristic {

	@Override
	public Solution solve(Problem p) {

		int n = 10;

		Solution[] x = new Solution[n];
		Solution[] pBest = new Solution[n];
		double[] v = new double[n];
		
		for (int i = 0; i < n; i++) {
			x[i] = p.generateRandomSolution();
			v[i] = PseudoRandom.randDouble();
		}
		System.out.println(x);
		while (!terminationCondition()) {
			for (int i = 0; i < n; i++) {
				double rand = PseudoRandom.randDouble();
			}
		}

		return bestElement(x);
	}
}
