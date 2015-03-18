package mmo.operator.mutation;

import java.util.List;

import mmo.solution.Solution;

/**
 * DE/rand/1 Mutation's Class
 * 
 * @author Thiago Nascimento
 * @since 2017-03-17
 * @version 1.0
 */
public class DERandOneMutation extends DEMutation {
	
	@Override
	public Solution execute(int targetId, Solution[] population) {
		if (population == null || population.length < 4) {
			throw new IllegalArgumentException("The population cannot be null or < 4");
		}
		
		List<Integer> pos = getRandomPositions(population.length);
		
		//Remove target solution's id
		pos.remove(new Integer(targetId));		
		
		// Get Solutions
		Solution r1 = population[pos.get(0)];
		Solution r2 = population[pos.get(1)];
		Solution r3 = population[pos.get(2)];		

		return sum(r1, mult(f, minus(r2, r3)));		
	}
}
