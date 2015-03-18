package mmo.operator.crossover;

import mmo.solution.Solution;
import mmo.util.PseudoRandom;

public class DEExponentialCrossover extends DECrossover {

	protected double cr;
	
	public DEExponentialCrossover(){
		this(0.9);
	}
	
	public DEExponentialCrossover(double cr){
		this.cr = cr;
	}
	
	@Override
	public Solution execute(Solution target, Solution donor) {
		if (target == null || donor == null) {
			throw new IllegalArgumentException("Target or Donor cannot be null");
		}

		Solution trial = (Solution) target.clone();

		int D = trial.getNumberOfBits();
		
		int N = PseudoRandom.randInt(0, D - 1);
		
		int L = 0;
				
		for (int i = 0; i < target.getNumberOfBits(); i++) {
			if (PseudoRandom.randDouble() <= cr && i != (D - 1)) {
				L++;
			}
		}

		for (int i = 0; i < target.getNumberOfBits(); i++) {
			if (i >= N && i <= (N + L - 1)) {
				trial.setValue(i, donor.getValue(i));
			} else {
				trial.setValue(i, target.getValue(i));
			}
		}

		return trial;
	}
}
