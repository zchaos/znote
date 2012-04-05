package com.zchaos.note.util.eventdelay;

/**
 * 监听延迟执行的事件，当触发了延迟执行事件后，调用此接口的active方法
 * @author zhuchx
 */
public interface DelayEventListener {
	public void active();
}
