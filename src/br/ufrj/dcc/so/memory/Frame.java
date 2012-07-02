package br.ufrj.dcc.so.memory;

public class Frame {
	private Page page;

	public Frame(Page page) {
		super();
		this.page = page;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	
}
