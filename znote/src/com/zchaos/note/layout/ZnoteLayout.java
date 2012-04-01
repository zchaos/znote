package com.zchaos.note.layout;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

public class ZnoteLayout {
	private Container container;

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
				TreePane treePane = new TreePane();
				leftScrollPane.setRowHeaderView(treePane);
				leftScrollPane.setBackground(Color.RED);
			}

			/**
			 * 设置右边显示的内容
			 * |-split
			 *   |-scroll
			 *     |-list
			 *   |-tabbed
			 *     |-scroll
			 *       |-text
			 *     |-scroll
			 *       |-text
			 */
			JSplitPane verticaSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true);
			horizontalSplitPane.setRightComponent(verticaSplitPane);

			JScrollPane topScrollPane = new JScrollPane();
			verticaSplitPane.setTopComponent(topScrollPane);
			{
				ListPane listPane = new ListPane();
				topScrollPane.setRowHeaderView(listPane);
				topScrollPane.setBackground(Color.RED);
			}

			EditorPane editorPane = new EditorPane();
			verticaSplitPane.setBottomComponent(editorPane);
		}
	}
}
