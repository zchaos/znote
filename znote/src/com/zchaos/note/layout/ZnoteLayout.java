package com.zchaos.note.layout;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import com.zchaos.note.service.console.Console;
import com.zchaos.note.service.task.TaskList;

public class ZnoteLayout {
	private Container container;

	private TreePane treePane = new TreePane();

	private ListPane listPane = new ListPane();

	private EditorPane editorPane = new EditorPane();

	private Console console = new Console();

	private TaskList taskList = new TaskList();

	private ConsolePane consolePane = console.consolePane;

	private TaskPane taskPane = taskList.taskPane;

	public ZnoteLayout(Container container) {
		this.container = container;
	}

	public void initLayout() {

		JSplitPane horizontalSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true);
		this.container.add(horizontalSplitPane);
		{
			/**
			 * 设置左边的树形显示框
			 * |-scroll
			 *   |-treePane
			 */
			JScrollPane leftScrollPane = new JScrollPane();
			horizontalSplitPane.setLeftComponent(leftScrollPane);
			{
				leftScrollPane.setRowHeaderView(treePane);
				leftScrollPane.setBackground(Color.RED);
			}

			/**
			 * 设置右边显示的内容
			 * |-split
			 *   |-scroll
			 *     |-list
			 *   |-split
			 *     |-tabbed
			 *       |-scroll
			 *         |-text
			 *       |-scroll
			 *         |-text
			 *     |-scroll
			 *       |-text
			 */
			JSplitPane verticaSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true);
			horizontalSplitPane.setRightComponent(verticaSplitPane);

			/**
			 * 设置list
			 */
			JScrollPane topScrollPane = new JScrollPane();
			verticaSplitPane.setTopComponent(topScrollPane);
			{
				topScrollPane.setRowHeaderView(listPane);
				topScrollPane.setBackground(Color.RED);
			}

			/**
			 * 设置下面的内容,包括编辑区域和控制台区域
			 */
			JSplitPane bottomVerticalSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true);
			verticaSplitPane.setBottomComponent(bottomVerticalSplitPane);

			bottomVerticalSplitPane.setTopComponent(editorPane);
			/**
			 * 设置控制台区域
			 */
			JScrollPane consoleScrollPane = new JScrollPane();
			bottomVerticalSplitPane.setBottomComponent(consoleScrollPane);
			consoleScrollPane.setViewportView(consolePane);

		}
	}
}
