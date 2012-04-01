package com.zchaos.note.util.eventdelay;

public class EventDelayUtils {
	public static EventDelay delay(EventDelayListener delay, long time) {
		return new EventDelayImpl(delay, time);
	}
}
