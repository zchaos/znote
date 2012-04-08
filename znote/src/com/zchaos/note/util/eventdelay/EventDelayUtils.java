package com.zchaos.note.util.eventdelay;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventDelayUtils {
	/**
	 * 当我们需要输入的内容能够自动保存时，会设置当多少秒（如5秒）没有输入数据，会自动保存当前输入的内容。此方法能够完成此功能
	 * 调用方式为：
	 * <code>
	 *   class DelayEventExecuteImpl extends JTextPane implements DelayEventExecute{
	 *     private DelayEventListener listener = DelayEventUtils.delay(this,5000);
	 *     public DelayEventExecuteImpl(){
	 *       this.addKeyListener(new KeyListener() {
			   @Override
			   public void keyReleased(KeyEvent e) {
			     listener.active();
			   }
			   @Override
			   public void keyPressed(KeyEvent e) {
			   }
			   @Override
			   public void keyTyped(KeyEvent e) {
			   }
		     });
	 *     }
	 *     @Override
	 *     public void execute(){
	 *       //TODO ...
	 *     }
	 *   }
	 * </code>
	 * @param delay
	 * @param time
	 * @return
	 */
	public static EventDelayListener delay(EventDelayExecute delay, long time) {
		return new EventDelayImpl(delay, time);
	}
}
