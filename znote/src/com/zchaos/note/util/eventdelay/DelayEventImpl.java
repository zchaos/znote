package com.zchaos.note.util.eventdelay;

import java.util.Timer;
import java.util.TimerTask;

public class DelayEventImpl implements DelayEventListener {
	private long delayTime = 0;
	private long previewActiveTime = 0;

	private DelayEventExecute eventDelay;

	private Object lockObject = new Object();

	public DelayEventImpl(DelayEventExecute eventDelay, long delayTime) {
		this.eventDelay = eventDelay;
		this.delayTime = delayTime;
	}

	private void cycle(long time) {
		if (time <= 0) {
			return;
		}

		new Timer().schedule(new DelayTimerTask(), time + 1);
	}

	@Override
	public void active() {
		this.previewActiveTime = System.currentTimeMillis();
		if (this.delayTime > 0) {
			cycle(this.delayTime + 1);
		}
	}

	class DelayTimerTask extends TimerTask {
		@Override
		public void run() {
			synchronized (lockObject) {
				if (previewActiveTime == 0) {
					return;
				}
				long now = System.currentTimeMillis();
				long minus = now - previewActiveTime - delayTime;
				if (minus >= 0) {
					eventDelay.execute();
					previewActiveTime = 0;
				} else {
					cycle(minus * -1);
				}
			}
		}
	}
}
