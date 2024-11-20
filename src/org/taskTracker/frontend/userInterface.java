package org.taskTracker.frontend;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.taskTracker.frontend.commandLineUI.CommandLineInputField;
import org.taskTracker.frontend.commandLineUI.CommandLineOutputField;
import org.taskTracker.frontend.controller.ControllerTextComponent;
import org.taskTracker.frontend.mainframe.Frame;

public class userInterface {

	Frame mainFrame;
	CommandLineInputField inputField;
	CommandLineOutputField scrollableOutputField;
		
		
    public userInterface(){
        mainFrame = new Frame();
        
        JPanel panel = new JPanel();
        BoxLayout box = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(box);
        
        inputField = new CommandLineInputField("This is Input Field");
        scrollableOutputField = new CommandLineOutputField();
        
        ControllerTextComponent controller = new ControllerTextComponent(inputField, scrollableOutputField.getField());
        
        panel.add(scrollableOutputField);
        panel.add(inputField);
        
        mainFrame.add(panel);
        mainFrame.pack();
    }



}
