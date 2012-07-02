package br.ufrj.dcc.so.manager;

public class Manager {
	protected SchedulingStrategy strategy;
	
	public Manager(SchedulingStrategy strategy) {
		this.strategy = strategy;
	}
}
