package br.ufrj.dcc.so.memory;


public class Memory {
	private Frame[] frames;

	public Memory(int frameCount) {
		super();
		this.frames = new Frame[frameCount];
		
		for (int i = 0; i < frameCount; i++) {
			frames[i] = new Frame(i);
		}
	}

	public Frame[] getFrames() {
		return frames;
	}

	public Frame getFrame(int position) {
		return frames[position];
	}
}
