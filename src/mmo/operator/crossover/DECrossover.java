package mmo.operator.crossover;

import mmo.solution.Solution;

public abstract class DECrossover extends Crossover{

	public abstract Solution execute(Solution target, Solution donor);
}
