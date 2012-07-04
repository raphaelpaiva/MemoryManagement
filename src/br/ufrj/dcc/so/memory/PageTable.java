package br.ufrj.dcc.so.memory;

public class PageTable {
	private Frame[] entry;
	private int totalPagesInMemory;

	public PageTable(int pageCount) {
		super();
		this.entry = new Frame[pageCount];
		totalPagesInMemory = 0;
	}

	public Frame getPageFrame(int pageNum) {
		return entry[pageNum];
	}

	public Frame[] getEntry() {
		return entry;
	}

	public void setEntry(Frame[] entry) {
		this.entry = entry;
	}

	public int getTotalPagesInMemory() {
		return totalPagesInMemory;
	}

	public void setTotalPagesInMemory(int totalPagesInMemory) {
		this.totalPagesInMemory = totalPagesInMemory;
	}
	
	public void setPageFrame(Frame frame, int pageNum) {
		entry[pageNum] = frame;
		totalPagesInMemory++;
	}
	
	public void removePage(int pageNum) {
		entry[pageNum] = null;
		totalPagesInMemory--;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("+--------+--------+\n");
		sb.append("+--Page--+--Addr--+\n");
		sb.append("+--------+--------+\n");
		
		for (int i = 0; i < entry.length; i++) {
			if (entry[i] == null) {
				continue;
			} else {
				String formattedPageNum = String.format("%02d", i);
				String formattedAddr = String.format("%02d", entry[i].getNumber());
				sb.append("+---" + formattedPageNum + "---");
				sb.append("+---" + formattedAddr + "---");
				sb.append("+\n");
			}
		}
		
		return sb.toString();
	}
}
