package mmo.problem;

import mmo.solution.Solution;


public abstract class Problem {
	
	public double minimize(double value){
		return value;
	}
	
	public double maximize(double value){
		return -value;
	}

	public abstract double evaluate(Solution s);
	
	public abstract Solution generateRandomSolution();
	
	public abstract Solution generateNeighborhoodSolution(Solution s);
}
