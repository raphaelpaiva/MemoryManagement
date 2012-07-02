package br.ufrj.dcc.so;

import java.util.ArrayList;
import java.util.List;

import br.ufrj.dcc.so.thread.Thread;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		List<Thread> threads = new ArrayList<Thread>();
		
		while(true) {
			Thread thread = new Thread();
			threads.add(thread);
			System.out.println(">>> Created thread " + thread);
			
			
			java.lang.Thread.sleep(5000);
		}
	}
}
