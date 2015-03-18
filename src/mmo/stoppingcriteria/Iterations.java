package mmo.stoppingcriteria;


public class Iterations extends StoppingCriteria {

	protected int maxIterations;

	public Iterations(int maxIterations) {
		this.maxIterations = maxIterations;
	}

	@Override
	public boolean stop(int iteration) {
		return iteration > maxIterations;
	}
}
