package br.ufrj.dcc.so.memory;

public class Frame {
	private boolean isFree;
	private int number;

	public Frame(int startAdress) {
		super();
		this.isFree = true;
		this.number = startAdress;
	}

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return "Frame [number=" + number + "]";
	}

}
