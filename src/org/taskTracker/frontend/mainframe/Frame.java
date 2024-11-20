package org.taskTracker.frontend.mainframe;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Frame extends JFrame implements Iframe{

	private static final long serialVersionUID = 3495824182818664026L;

    /*
     *
     *  CONSTRUCTORS
     *
     */

	public Frame(){
        super();
        this.setTitle(TITLE);
        init();
    }

    /*
     *
     *
     *
     */

	private void init(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        this.setVisible(true);
    }

    /*
     *
     *
     *
     */
	
}
