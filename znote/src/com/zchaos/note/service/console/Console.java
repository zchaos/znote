package com.zchaos.note.service.console;

import com.zchaos.note.layout.ConsolePane;

public class Console {
	public static ConsolePane consolePane = new ConsolePane();

	public static void out(Object obj) {
		consolePane.append(obj);
	}
}
