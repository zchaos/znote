package com.zchaos.note.service.task;

import java.util.ArrayList;
import java.util.List;

import com.zchaos.note.layout.TaskPane;
import com.zchaos.note.task.TaskExecute;

public class TaskList {
	public static TaskPane taskPane = new TaskPane();

	private static List<TaskExecute> list = new ArrayList<TaskExecute>();

	public static void startTask(TaskExecute task) {
		if (!list.contains(task)) {
			list.add(task);
		}
	}

	public static void endTask(TaskExecute task) {
		list.remove(task);
	}
}