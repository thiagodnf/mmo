package mmo.util;

import java.util.Date;

import mmo.metaheuristic.Metaheuristic;
import mmo.problem.Problem;
import mmo.solution.Solution;

public class ExecutionStats {
	
	public double executionTime;

	public Problem p;

	public Metaheuristic m;

	public Solution bestSolution;

	public static ExecutionStats execute(Metaheuristic m, Problem p) {
		ExecutionStats ets = new ExecutionStats();
		ets.p = p;
		ets.m = m;		
		double startTime = (new Date()).getTime();
		ets.bestSolution = m.solve(p);
		ets.executionTime = (new Date()).getTime() - startTime;
		return ets;
	}

	public void printStats() {
		System.out.println("Algorithm: " + m.getClass().getSimpleName());
		System.out.println("Problem: " + p.getClass().getSimpleName());
		System.out.println("Execution time (ms): " + executionTime);
		System.out.println("Best Solution Found: " + bestSolution);
		System.out.println("Best Value: " + p.evaluate(bestSolution));
	}
}
