package mmo.metaheuristic;

import java.util.Arrays;

import mmo.problem.Problem;
import mmo.solution.Solution;
import mmo.stoppingcriteria.Iterations;
import mmo.stoppingcriteria.StoppingCriteria;
import mmo.util.ParameterSet;

public abstract class Metaheuristic {

	/** Metaheuristc's Parameters */
	protected ParameterSet param;
	
	protected int iteration = 0;
	
	protected StoppingCriteria stoppingCriteria;
	
	public Metaheuristic() {
		this.stoppingCriteria = new Iterations(1000);
		this.param = new ParameterSet();
	}
	
	protected boolean terminationCondition() {
		iteration++;
		return stoppingCriteria.stop(iteration);
	}
	
	public int getIteration(){
		return iteration;
	}
	
	protected Solution[] createInitialPopulation(Problem p, int sizeOfPopulation) {
		// Create the new population
		Solution[] population = new Solution[sizeOfPopulation];

		for (int i = 0; i < sizeOfPopulation; i++) {
			population[i] = p.generateRandomSolution();
		}

		return population;
	}
	
	protected void evaluatePopulation(Problem p, Solution[] population) {
		// Evaluate each population's individual
		for (int i = 0; i < population.length; i++) {
			evaluateSolution(p, population[i]);
		}
	}
	
	protected void evaluateSolution(Problem p, Solution solution) {
		solution.setFitness(p.evaluate(solution));
	}
	
	protected Solution bestElement(Solution[] population) {
		// Sort all population
		Arrays.sort(population);
		
		// Return the first element that is the best element
		return population[0];
	}	

	/**
	 * Add new parameters that will be used by algorithm
	 * 
	 * @param name Name of parameter
	 * @param value Value of parameter
	 */
	public void addParameter(String name, Object value) {
		this.param.add(name, value);
	}
	
	public void setStoppingCriteria(StoppingCriteria stoppingCriteria) {
		this.stoppingCriteria = stoppingCriteria;
	}
	
	public abstract Solution solve(Problem p);
}
