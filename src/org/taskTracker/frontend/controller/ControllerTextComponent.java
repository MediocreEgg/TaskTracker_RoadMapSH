package org.taskTracker.frontend.controller;

import javax.swing.JTextArea;

import org.taskTracker.backend.commands.CommandProcessor;
import org.taskTracker.frontend.commandLineUI.CommandLineInputField;

public class ControllerTextComponent {

	private CommandLineInputField clif;
	private JTextArea clof;

	public ControllerTextComponent(CommandLineInputField clif, JTextArea clof) {
		this.clif = clif;
		this.clof = clof;

		clif.submitInput(event -> {
			String commandInput = clif.getText();
			clof.append("CommandRequest::"+clif.getText() + "\n");
			CommandProcessor.process(commandInput);
			clif.setText("");
		});

	}

}
