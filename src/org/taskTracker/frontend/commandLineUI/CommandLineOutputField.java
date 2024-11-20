package org.taskTracker.frontend.commandLineUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CommandLineOutputField extends JScrollPane implements CommandLineFieldProperties{
	
	private static final long serialVersionUID = -7610990829054851208L;
	private JTextArea outputField;
	private int height = -1;
	private int width = -1;
	
	/*
	 * 
	 * 
	 * 
	 */
	
	public CommandLineOutputField() {
		super(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		initSize();
		initTextArea();
	}

	/*
	 * 
	 * 
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
		
	void initTextArea() {
		outputField = new JTextArea();
		outputField.setWrapStyleWord(true);
		outputField.setLineWrap(true);
		outputField.setEditable(false);
		
		this.setViewportView(outputField);
	}
	
	/*
	 * 
	 * 
	 * 
	 */
	
	public JTextArea getField() {
		return this.outputField;
	}

}
