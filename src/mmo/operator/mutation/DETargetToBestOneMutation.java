package mmo.operator.mutation;

import java.util.List;

import mmo.solution.Solution;

/**
 * DE/Target-to-best/1 Mutation's Class
 * 
 * @author Thiago Nascimento
 * @since 2017-03-17
 * @version 1.0
 */
public class DETargetToBestOneMutation extends DEMutation {
	
	@Override
	public Solution execute(int targetId, Solution[] population) {
		if (population == null || population.length < 6) {
			throw new IllegalArgumentException("The population cannot be null or < 6");
		}
		
		List<Integer> pos = getRandomPositions(population.length);
		
		//Remove target solution's id
		pos.remove(new Integer(targetId));
		
		// Get the best element at population
		Solution bestSolution = population[0];
		
		for(int i=0;i<population.length;i++){
			if(population[i].getFitness() < bestSolution.getFitness()){
				bestSolution = population[i];
			}
		}		
		
		// Get Solutions
		Solution r1 = population[pos.get(0)];
		Solution r2 = population[pos.get(1)];
		Solution target = population[targetId];
		
		return sum(target, sum(mult(f, minus(bestSolution, target)), mult(f, minus(r2, r1))));
	}
}
