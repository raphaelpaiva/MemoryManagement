package br.ufrj.dcc.so.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;

import br.ufrj.dcc.so.memory.Memory;
import br.ufrj.dcc.so.memory.PageTable;
import br.ufrj.dcc.so.thread.Thread;

public class Manager {
	protected SchedulingStrategy strategy;
	protected Memory memory;
	protected Map<Thread, PageTable> pageTables = new HashMap<Thread, PageTable>();
	
	protected int maxPageCount;
	
	public Manager(Memory memory, int maxPageCount, SchedulingStrategy strategy) {
		this.strategy = strategy;
		this.memory = memory;
		this.maxPageCount = maxPageCount;
	}

	public void alloc(Thread thread) {
		pageTables.put(thread, new PageTable(maxPageCount));
	}

	public void request(Thread thread, int pageNum) {
		System.out.println("Thread " + thread + "requested page " + pageNum);
		// TODO Implement LRU Strategy.
	}
}
