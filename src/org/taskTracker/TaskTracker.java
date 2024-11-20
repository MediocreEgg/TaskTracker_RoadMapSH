package org.taskTracker;

import javax.swing.SwingUtilities;

import org.taskTracker.frontend.userInterface;

public class TaskTracker {

	public static void main(String[] args) {
    	SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				userInterface frame = new userInterface();
			}
    		
    	});
	}
}
