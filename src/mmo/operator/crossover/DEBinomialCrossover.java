package mmo.operator.crossover;

import mmo.solution.Solution;
import mmo.util.PseudoRandom;

public class DEBinomialCrossover extends DECrossover {

	protected double cr;
	
	public DEBinomialCrossover(){
		this(0.9);
	}
	
	public DEBinomialCrossover(double cr){
		this.cr = cr;
	}
	
	@Override
	public Solution execute(Solution target, Solution donor) {
		if (target == null || donor == null) {
			throw new IllegalArgumentException("Target or Donor cannot be null");
		}

		Solution trial = (Solution) target.clone();

		int iRand = PseudoRandom.randInt(0, trial.getNumberOfBits() - 1);
		
		for (int i = 0; i < target.getNumberOfBits(); i++) {
			if (PseudoRandom.randDouble() <= cr || i == iRand) {
				trial.setValue(i, donor.getValue(i));
			} else {
				trial.setValue(i, target.getValue(i));
			}
		}

		return trial;
	}
}
