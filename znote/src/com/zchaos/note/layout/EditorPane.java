package com.zchaos.note.layout;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;

import com.zchaos.note.edit.EditTextPane;

public class EditorPane extends JTabbedPane {

	private JTextPane work = new EditTextPane("work");
	private JTextPane note = new EditTextPane("note");
	private JTextPane temp = new EditTextPane("temp");

	public EditorPane() {
		super(JTabbedPane.TOP);
		this.setBackground(Color.RED);

		JScrollPane workScroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.addTab(work.getName(), workScroll);
//		workScroll.setRowHeaderView(work);
		workScroll.setViewportView(work);
//		work.setPreferredSize(new Dimension(500, 600));
//		work.setBackground(Color.ORANGE);
//		workScroll.setBackground(Color.RED);

		JScrollPane noteScroll = new JScrollPane();
		this.addTab(note.getName(), noteScroll);
		noteScroll.setViewportView(note);

		JScrollPane tempScroll = new JScrollPane();
		this.addTab(temp.getName(), tempScroll);
		tempScroll.setViewportView(temp);
	}
}
