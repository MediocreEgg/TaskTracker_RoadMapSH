package org.taskTracker.frontend.commandLineUI;

import java.awt.Dimension;

public interface CommandLineFieldProperties {
	int INFINITE_WIDTH = -1;
	int INFINITE_HEIGHT = -1;
	
	default Dimension dimension(int width, int height) {
		return new Dimension(width, height);
	}
	
	void initSize(Dimension dimension);
	void initSize();
	void setHeight(int height);
	void setWidth(int width);
}
