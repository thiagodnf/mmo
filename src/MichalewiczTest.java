import mmo.metaheuristic.DifferentialEvolution;
import mmo.metaheuristic.Metaheuristic;
import mmo.problem.Problem;
import mmo.problem.function.MichalewiczFunction;
import mmo.stoppingcriteria.Iterations;
import mmo.util.ExecutionStats;

public class MichalewiczTest {

	public static void main(String[] args){
		// Problem
		Problem p  = new MichalewiczFunction(2);
		
		// Metaheuristic
		Metaheuristic m = new DifferentialEvolution();
		
		//Parameters
		m.addParameter("N", 100);
		
		// Set Stopping Criteria
		m.setStoppingCriteria(new Iterations(1000));
		
		// Run
		ExecutionStats.execute(m, p).printStats();		
	}
}
