package mmo.operator.crossover;

import mmo.solution.Solution;
import mmo.util.PseudoRandom;

public class BinomialCrossover extends DECrossover {

	protected double cr;
	
	public BinomialCrossover(){
		this(0.9);
	}
	
	public BinomialCrossover(double cr){
		this.cr = cr;
	}
	
	@Override
	public Solution execute(Solution target, Solution donor) {
		if (target == null || donor == null) {
			throw new IllegalArgumentException("Target or Donor cannot be null");
		}

		Solution trial = (Solution) target.clone();

		for (int i = 0; i < target.getNumberOfBits(); i++) {
			if (PseudoRandom.randDouble() <= cr) {
				trial.setValue(i, donor.getValue(i));
			} else {
				trial.setValue(i, target.getValue(i));
			}
		}

		return trial;
	}
}
