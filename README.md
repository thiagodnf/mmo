# MMO

A Free and Open Source Framework for Mono-Objective Optimization Problems

Available Metaheuristics
---
The framework has the following implemented metaheuristics:

- Random Search
- Hill Climbing
- Steepest Ascent Hill-Climbing
- Differential Evolution
- Genetic Algorithm

Encoded Problems
---
To testing the metaheuristics, the following problems were encoded:

- One Max Problem
- Knapsack Problem
- Ackleys Function
- Two-dimensional Gaussian Function
- Michalewicz Function
- Rosenbrock Function

Operators
--
The framework has the following operators:

**Selection**
- Roulette Wheel
- Binary Tournament

**Mutation**
- DE/rand/1
- DE/rand/2
- DE/current-to-best/1
- Bit Flip Mutation
- Swap Mutation

**Crossover**
- Single Point Crossover
- DE Binomial
- DE Exponential

**Replacement**
- Elitism
- Replace All

Parameters 
---
You can define the metaheuristic's parameters according to your problem before execution. The parameters
should be defined on operator. For example

```Java
Metaheuristic m = new DifferentialEvolution(100);
// Set Stopping Criteria
m.setStoppingCriteria(new Iterations(1000));
```

where 100 is a population size and 1000 is the max iterations

How to use
---
A example how to use MMO is:

```Java
public class GATest {

	public static void main(String[] args) {
		// Problem
		KnapsackProblem p = new KnapsackProblem(8);

		// Load instance
		p.setValue(new double[] { 3, 3, 2, 4, 2, 3, 5, 2 });
		p.setWeight(new double[] { 5, 4, 7, 8, 4, 4, 6, 8 });
		p.setMaxWeight(25);
		
		// Metaheuristic
		Metaheuristic m = new GeneticAlgorithm(100);
				
		// Set Stopping Criteria
		m.setStoppingCriteria(new Iterations(1000));

		// Run
		ExecutionStats.execute(m, p).printStats();		
	}
}
```

The result is:

```
Algorithm: GeneticAlgorithm
Problem: KnapsackProblem
Execution time (ms): 423.0
Best Solution Found: [1, 1, 0, 0, 1, 1, 1, 0]
Best Value: -16.0
```

Motivation
---
This frawework was developed during the course of Topics in Artificial Intelligence at Federal University of Parana, Brazil.



