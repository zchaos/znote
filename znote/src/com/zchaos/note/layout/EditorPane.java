package com.zchaos.note.layout;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import com.zchaos.note.edit.EditTextPane;

public class EditorPane extends JTabbedPane {

	private EditTextPane diary = new EditTextPane("diary");
	private EditTextPane work = new EditTextPane("work");
	private EditTextPane note = new EditTextPane("note");
	private EditTextPane temp = new EditTextPane("temp");

	public EditorPane() {
		super(JTabbedPane.TOP);
		this.setBackground(Color.RED);

		addTab(diary);
		addTab(work);
		addTab(note);
		addTab(temp);
	}

	private void addTab(EditTextPane pane) {
		JScrollPane scroll = new JScrollPane();
		this.addTab(pane.getName(), scroll);
		scroll.setViewportView(pane);
	}
}
