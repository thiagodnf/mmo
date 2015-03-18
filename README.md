# MMO

A Free and Open Source Framework for Mono-Objective Optimization Problems

Available Metaheuristics
---
The framework has the following implemented metaheuristics:

- Random Search
- Hill Climbing
- Steepest Ascent Hill-Climbing
- Differential Evolution
- Genetic Algorithm (Working in progress)
- Particle Swarm Optimization (Working in progress)

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

**Mutation**
- DE/Rand/1
- DE/Rand/2
- DE/Target-to-best/1

**Crossover**
- Single Point Crossover
- DE Binomial Crossover
- DE Exponential Crossover

Parameters 
---
You can define the metaheuristic's parameters according to your problem before execution. For example:

```Java
Metaheuristic m = new DifferentialEvolution();
m.addParameter("N", 100);
```

The available parameters are:

**Differential Evolution**

| Parameters   | Description           | Default Value | Recomended Range |
|--------------|-----------------------|---------------|------------------|
| N            | Differential Weight   | 0.5           | [0,1]            |
| CR           | Crossover Probability | 0.8           | [0,1]            |
| NP           | Population Size       | 100           | >=4              |


Motivation
---
This frawework was developed during the course of Topics in Artificial Intelligence at Federal University of Parana, Brazil.



