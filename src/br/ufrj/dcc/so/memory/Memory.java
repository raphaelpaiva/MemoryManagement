package br.ufrj.dcc.so.memory;


public class Memory {
	
	private Frame[] frames;
	
	public Memory(int frameCount) {
		super();
		
		frames = new Frame[frameCount];
	}

	public Frame[] getFrames() {
		return frames;
	}

	public void setFrames(Frame[] frames) {
		this.frames = frames;
	}
	
}
