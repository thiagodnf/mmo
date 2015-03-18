import mmo.metaheuristic.DifferentialEvolution;
import mmo.metaheuristic.Metaheuristic;
import mmo.problem.Problem;
import mmo.problem.function.AckleysFunction;
import mmo.stoppingcriteria.Iterations;
import mmo.util.ExecutionStats;

public class AckleysTest {

	public static void main(String[] args){
		Problem p  = new AckleysFunction(2);
		
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
