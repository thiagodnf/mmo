package mmo.metaheuristic;

import mmo.operator.crossover.BinomialCrossover;
import mmo.operator.crossover.DECrossover;
import mmo.operator.mutation.DEMutation;
import mmo.operator.mutation.DERandTwoMutation;
import mmo.problem.Problem;
import mmo.solution.Solution;

/**
 * Differential Evolution Algorithm's Class <br>
 * Available at http://www.dca.fee.unicamp.br/~lboccato/topico11_14.pdf
 * 
 * @author Thiago Nascimento
 * @since 2013-03-17
 * @version 1.0
 */
public class DifferentialEvolution extends Metaheuristic {

	protected DEMutation mutation;

	protected DECrossover crossover;
	
	public DifferentialEvolution(){
		this.mutation = new DERandTwoMutation();
		this.crossover = new BinomialCrossover();
	}

	@Override
	public Solution solve(Problem p) {

		int n = param.getInt("N", 100);

		Solution[] population = createInitialPopulation(p, n);
		evaluatePopulation(p, population);

		while (!terminationCondition()) {
			for (int i = 0; i < n; i++) {
				Solution target = population[i];

				// Mutation
				Solution donor = mutation.execute(i, population);

				// Crossover
				Solution trial = crossover.execute(target, donor);
				evaluateSolution(p, trial);

				// Selection
				if (trial.getFitness() < target.getFitness()) {
					population[i] = trial;
				}
			}
		}

		return bestElement(population);
	}	
}
