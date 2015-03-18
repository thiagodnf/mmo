package mmo.operator.mutation;

import java.util.List;

import mmo.solution.Solution;

/**
 * DE/rand/2 Mutation's Class
 * 
 * @author Thiago Nascimento
 * @since 2017-03-17
 * @version 1.0
 */
public class DERandTwoMutation extends DEMutation {
	
	@Override
	public Solution execute(int targetId, Solution[] population) {
		if (population == null || population.length < 6) {
			throw new IllegalArgumentException("The population cannot be null or < 6");
		}
		
		List<Integer> pos = getRandomPositions(population.length);
		
		//Remove target solution's id
		pos.remove(new Integer(targetId));		
		
		// Get Solutions
		Solution r1 = population[pos.get(0)];
		Solution r2 = population[pos.get(1)];
		Solution r3 = population[pos.get(2)];
		Solution r4 = population[pos.get(3)];
		Solution r5 = population[pos.get(4)];
		
		return sum(r1, sum(mult(f, minus(r3, r2)), mult(f, minus(r5, r4))));
	}
}
