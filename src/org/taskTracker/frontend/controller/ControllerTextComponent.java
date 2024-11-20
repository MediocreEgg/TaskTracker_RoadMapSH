package org.taskTracker.frontend.controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import org.taskTracker.backend.commands.CommandProcessor;
import org.taskTracker.backend.pojo.TaskPOJO;
import org.taskTracker.backend.pojo.TaskStatus;
import org.taskTracker.backend.warehouse.DataHolder;
import org.taskTracker.frontend.commandLineUI.CommandLineInputField;

/*
 * 	FORMAT FOR PRINTING TASK
 * 
---------------------------- TASK ---------------------------
| ID:      #                                                |
| NAME:    "..."                                            |
| DATE:    "MMMM DD, YYYY"                                  |
| STATUS:  [DONE | NOTDONE | INPROGRESS]                    |
-------------------------------------------------------------
 * 
 * 
 */
public class ControllerTextComponent {

	private CommandLineInputField clif;
	private JTextArea clof;

	public ControllerTextComponent(CommandLineInputField clif, JTextArea clof) {
		this.clif = clif;
		this.clof = clof;

		clif.submitInput(event -> {
			String rawInput = clif.getText();
			clof.append("> " + clif.getText() + "\n");

			if (!rawInput.isBlank() && !rawInput.isEmpty())
				response(CommandProcessor.process(rawInput));

			clif.setText("");
		});
	}

	private void response(int responseCode) {
		switch (responseCode) {
		case -1: break;
		case 110:
			clof.setText("");
			break;
		case 510:
			clof.append(asciiDisplayFormat(DataHolder.INSTANCE.getTask(DataHolder.getRecentUID())));
			break;
		case 520:
			clof.append("");
			break;
		case 530:
			clof.append("");
			break;
		default: {
			System.err.println("Critical Error! Missing Report Code");
			JOptionPane.showMessageDialog(null, "Missing Response. (" + responseCode + ")", "Critical Error!",
					JOptionPane.ERROR_MESSAGE);
		}
			;
		}
	}

	private String asciiDisplayFormat(TaskPOJO pojo) {
		return String.format("""
				---------------------------- TASK ---------------------------
				| ID:\t%d
				| NAME:\t%s
				| DATE:\t%s
				| STATUS:\t%s
				---------------------------------------------------------------\n""", 
				pojo.getId(), pojo.getTaskName(), pojo.getDate(), pojo.getStatus());
	}
}
