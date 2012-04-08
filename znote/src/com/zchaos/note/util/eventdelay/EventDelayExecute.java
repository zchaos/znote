package com.zchaos.note.util.eventdelay;

/**
 * 需要延迟执行的类，需要实现此接口。当到了延迟时间后，执行此接口的execute方法.
 * @author zhuchx
 */
public interface EventDelayExecute {
	/**
	 * 延迟执行的方法
	 */
	public void execute();
}
