package org.taskTracker.frontend.commandLineUI;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class CommandLineInputField extends JTextField implements CommandLineFieldProperties {

	private static final long serialVersionUID = 969173717512111274L;
	private int height = -1;
	private int width = -1;

	/*
	 * 
	 * 
	 * 
	 */

	{
		setHeight(20);
	}

	public CommandLineInputField() {
		super();
		initSize();
		this.setMaximumSize(dimension(INFINITE_WIDTH, 30));
		this.setMinimumSize(dimension(0, 10));
	}

	public CommandLineInputField(String text) {
		super(text);
		initSize();
	}

	/*
	 * 
	 * Boundary Properties for JTextField
	 * 
	 */

	@Override
	public void initSize() {
		this.setPreferredSize(dimension(this.width, this.height));
	}

	@Override
	public void initSize(Dimension dimension) {
		this.setPreferredSize(dimension);
	}

	@Override
	public void setHeight(int height) {
		if (height != -1 || height > 0)
			this.height = height;
	}

	@Override
	public void setWidth(int width) {
		if (width != -1 || width > 0)
			this.width = width;
	}

	/*
	 * 
	 * 
	 * 
	 */

	public void submitInput(ActionListener action) {
		this.addActionListener(action);
	}

}
