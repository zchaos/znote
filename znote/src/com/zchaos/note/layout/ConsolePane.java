package com.zchaos.note.layout;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JTextPane;

public class ConsolePane extends JTextPane {

	private static int SIZE = 1000;
	public List<String> list = new ArrayList<String>(SIZE);

	public ConsolePane() {
	}

	public void append(Object obj) {
		if (obj == null) {
			return;
		}
		String str = obj.toString();
		if (list.size() == SIZE) {
			list.remove(0);
		}

		list.add(formatNowDate() + "  " + str);

		this.setText(list2Str());
	}

	private String formatNowDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
		return format.format(new Date());
	}

	private String list2Str() {
		StringWriter w = new StringWriter(SIZE * 20);
		for (int i = 0, size = list.size(); i < size; i++) {
			w.write(list.get(i));
			w.write("\r\n");
		}
		return w.toString();
	}
}
