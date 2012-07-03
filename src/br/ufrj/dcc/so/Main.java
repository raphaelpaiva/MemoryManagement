package br.ufrj.dcc.so;

import br.ufrj.dcc.so.manager.Manager;
import br.ufrj.dcc.so.memory.Memory;
import br.ufrj.dcc.so.thread.Thread;

public class Main {
	private static final int VERY_LONG_TIME = 1000000;
	private static final int MAX_THREAD_COUNT = 10;
	private static final int MAX_PAGE_COUNT = 50;
	private static final int FRAME_COUNT = 64;
	private static final int THREAD_CREATION_INTERVAL = 5000;

	public static void main(String[] args) throws InterruptedException {
		Memory memory = new Memory(FRAME_COUNT);
		Manager manager = new Manager(memory, MAX_PAGE_COUNT);
		
		for (int i = 0; i < MAX_THREAD_COUNT; i++) {
			Thread thread = new Thread(manager, MAX_PAGE_COUNT);
			thread.start();
			
			java.lang.Thread.sleep(THREAD_CREATION_INTERVAL);
		}
		
		while (true) {
			java.lang.Thread.sleep(VERY_LONG_TIME);
		}
	}
}
