import mmo.metaheuristic.HillClimbing;
import mmo.metaheuristic.Metaheuristic;
import mmo.problem.Problem;
import mmo.problem.binary.OneMaxProblem;
import mmo.stoppingcriteria.Iterations;
import mmo.util.ExecutionStats;

public class OneMaxTest {

	public static void main(String[] args){
		Problem p  = new OneMaxProblem(2000);
		
		Metaheuristic m = new HillClimbing();
		
		// Set Stopping Criteria
		m.setStoppingCriteria(new Iterations(1000));
				
		// Run
		ExecutionStats.execute(m, p).printStats();			
	}
}
