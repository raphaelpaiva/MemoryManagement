package br.ufrj.dcc.so.memory;

public class Frame {
	private boolean isFree;
	private int startAdress;

	public Frame(int startAdress) {
		super();
		this.isFree = true;
		this.startAdress = startAdress;
	}

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	public int getStartAdress() {
		return startAdress;
	}

	@Override
	public String toString() {
		return "Frame [startAdress=" + startAdress + "]";
	}

}
