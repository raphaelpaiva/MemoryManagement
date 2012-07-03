package br.ufrj.dcc.so.manager;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import br.ufrj.dcc.so.memory.Frame;
import br.ufrj.dcc.so.memory.Memory;
import br.ufrj.dcc.so.memory.PageTable;
import br.ufrj.dcc.so.thread.Thread;

public class Manager {
	protected Memory memory;
	protected Map<Thread, PageTable> pageTables;
	protected Map<Thread, Queue<Integer>> requestQueues;
	protected int maxPageCount;
	
	public Manager(Memory memory, int maxPageCount) {
		this.memory = memory;
		this.maxPageCount = maxPageCount;
		
		pageTables = new HashMap<Thread, PageTable>();
		requestQueues = new HashMap<Thread, Queue<Integer>>();
	}

	public void alloc(Thread thread) {
		pageTables.put(thread, new PageTable(maxPageCount));
		requestQueues.put(thread, new LinkedList<Integer>());
	}

	public void request(Thread thread, int pageNum) {
		System.out.println(thread + " requested page " + pageNum);
		
		PageTable pageTable = pageTables.get(thread);
		Queue<Integer> queue = requestQueues.get(thread);
		
		Frame pageFrame = pageTable.getPageFrame(pageNum);
		
		if (pageFrame == null) {
			if (pageTable.getTotalPagesInMemory() < 3) {
				try {
					Frame nextFreeFrame = getNextFreeFrame();
					nextFreeFrame.setFree(false);
					pageTable.setPageFrame(nextFreeFrame, pageNum);
					
					queue.add(pageNum);
					
					System.out.println("Page " + pageNum + " for " + thread + " brought to memory in " + nextFreeFrame);
				} catch (OutOfMemoryException e) {
					System.out.println("Out of Memory!");
				}
			} else {
				Integer lruPageNumber = queue.remove();
				System.out.println(">>> lruPageNumber: " + lruPageNumber);
				
				Frame usedFrame = pageTable.getPageFrame(lruPageNumber);
				pageTable.removePage(lruPageNumber);
				pageTable.setPageFrame(usedFrame, pageNum);
				
				queue.add(pageNum);
				
				System.out.println("Page " + pageNum + " for " + thread + " brought to memory in " + usedFrame + ", replacing Page " +  lruPageNumber );
			}
		} else {
			queue.remove(pageNum);
			queue.add(pageNum);
			System.out.println("Page " + pageNum + " for " + thread + " already in memory");
		}
		
	}
	
	private Frame getNextFreeFrame() throws OutOfMemoryException {
		for (Frame frame : memory.getFrames()) {
			if (frame.isFree()) {
				return frame;
			}
		}
		
		throw new OutOfMemoryException();
	}
}
