package com.zchaos.note.edit;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextPane;

import com.zchaos.note.util.eventdelay.EventDelay;
import com.zchaos.note.util.eventdelay.EventDelayListener;
import com.zchaos.note.util.eventdelay.EventDelayUtils;

public class EditTextPane extends JTextPane implements EventDelayListener {
	private String path = "/yunio/tnote";
	private String tpath = "/yunio/tnote/.zbak";

	private String name;

	private File file;

	private EventDelay delay;

	public EditTextPane(String name) {
		this.name = name;
		this.file = ensureFileExist(path + "/" + name + ".txt");
		this.delay = EventDelayUtils.delay(this, 5000);

		this.setText(readFile(this.file));
		this.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				delay.active();
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
	}

	private File ensureFileExist(String fpath) {
		File file = new File(fpath);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return file;
	}

	public String getName() {
		return this.name;
	}

	public String getTextContent() {
		return this.getText();
	}

	@Override
	public void execute() {
		String content = getTextContent();
		writeFile(getTempFile(), content);
		writeFile(this.file, content);
	}

	private File getTempFile() {
		Date date = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
		String dir = format1.format(date);

		SimpleDateFormat format2 = new SimpleDateFormat("HHmmss");
		String fname = format2.format(date);
		return ensureFileExist(tpath + "/" + this.getName() + "/" + dir + "/" + fname);
	}

	private void writeFile(File file, String content) {
		try {
			FileOutputStream out = new FileOutputStream(file);
			try {
				OutputStreamWriter w = new OutputStreamWriter(out, "UTF-8");
				try {
					w.write(content);
				} finally {
					w.close();
				}
			} finally {
				out.close();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private String readFile(File file) {
		try {
			FileInputStream in = new FileInputStream(file);
			try {
				InputStreamReader r = new InputStreamReader(in, "UTF-8");
				try {
					StringWriter w = new StringWriter();
					copy(r, w);
					return w.toString();
				} finally {
					r.close();
				}
			} finally {
				in.close();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static final int DEFAULT_BUFFER_SIZE = 1024 * 4;

	public static long copy(Reader input, Writer output) throws IOException {
		char[] buffer = new char[DEFAULT_BUFFER_SIZE];
		long count = 0;
		int n = 0;
		while (-1 != (n = input.read(buffer))) {
			output.write(buffer, 0, n);
			count += n;
		}
		return count;
	}
}
