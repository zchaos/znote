package com.zchaos.note.layout;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import com.zchaos.note.edit.EditPane;

public class EditorPane extends JTabbedPane {

	private EditPane diary = new EditPane("diary");
	private EditPane work = new EditPane("work");
	private EditPane note = new EditPane("note");
	private EditPane temp = new EditPane("temp");

	public EditorPane() {
		super(JTabbedPane.TOP);
		this.setBackground(Color.RED);

		addTab(diary);
		addTab(work);
		addTab(note);
		addTab(temp);
	}

	private void addTab(EditPane pane) {
		JScrollPane scroll = new JScrollPane();
		this.addTab(pane.getName(), scroll);
		scroll.setViewportView(pane);

		Dimension d = new Dimension(scroll.getWidth(), 100);
		pane.setPreferredSize(d);
	}
}
