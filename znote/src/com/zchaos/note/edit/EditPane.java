package com.zchaos.note.edit;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class EditPane extends JPanel {
	private String name;

	public EditPane(String name) {
		this.name = name;

		//		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setLayout(new GridLayout(0, 1, 10, 10));
		{
			JTextPane pane = new JTextPane();
			this.add(pane);

			pane.setBackground(Color.BLUE);
		}
		{
			JTextPane pane = new JTextPane();
			this.add(pane);

			pane.setBackground(Color.RED);
		}

		//		this.setLayout(new GridBagLayout());
		//
		//		GridBagConstraints c = new GridBagConstraints();
		//		{
		//			c.fill = GridBagConstraints.VERTICAL;
		//			c.gridx = 0;
		//			c.gridy = 0;
		//			JButton pane = new JButton();
		//			this.add(pane, c);
		//			pane.setBackground(Color.blue);
		//		}
		//		{
		//			c.fill = GridBagConstraints.VERTICAL;
		//			c.gridx = 0;
		//			c.gridy = 1;
		//			c.anchor = GridBagConstraints.PAGE_END;
		//			JTextPane pane = new JTextPane();
		//			this.add(pane, c);
		//			pane.setBackground(Color.red);
		//		}
	}

	public String getName() {
		return this.name;
	}
}
