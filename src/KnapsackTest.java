import mmo.metaheuristic.HillClimbing;
import mmo.metaheuristic.Metaheuristic;
import mmo.problem.binary.KnapsackProblem;
import mmo.stoppingcriteria.Iterations;
import mmo.util.ExecutionStats;

public class KnapsackTest {

	public static void main(String[] args) {
		// Problem
		KnapsackProblem p = new KnapsackProblem(8);

		// Load instance
		p.setValue(new double[]{3,3,2,4,2,3,5,2});
		p.setWeight(new double[]{5,4,7,8,4,4,6,8});
		p.setMaxWeight(25);
		
		// Metaheuristic
		Metaheuristic m = new HillClimbing();
				
		// Set Stopping Criteria
		m.setStoppingCriteria(new Iterations(10000));

		// Run
		ExecutionStats.execute(m, p).printStats();		
	}
}
