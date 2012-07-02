package br.ufrj.dcc.so.memory;

public class PageTable {
	private int[] entry;

	public PageTable(int pageCount) {
		super();
		this.entry = new int[pageCount];
	}

	public int getPageMemoryAddress(int pageNum) {
		return entry[pageNum];
	}
	
}
