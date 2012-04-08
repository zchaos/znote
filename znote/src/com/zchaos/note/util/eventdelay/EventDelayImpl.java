package com.zchaos.note.util.eventdelay;

import java.util.Timer;
import java.util.TimerTask;

import com.zchaos.note.service.task.TaskList;
import com.zchaos.note.task.TaskExecute;

public class EventDelayImpl implements EventDelayListener, TaskExecute {
	private long delayTime = 0;
	private long previewActiveTime = 0;

	private EventDelayExecute eventDelay;

	private Object lockObject = new Object();

	public EventDelayImpl(EventDelayExecute eventDelay, long delayTime) {
		this.eventDelay = eventDelay;
		this.delayTime = delayTime;
	}

	private void cycle(long time) {
		if (time <= 0) {
			return;
		}
		TaskList.startTask(this);
		new Timer().schedule(new DelayTimerTask(this), time + 1);
	}

	@Override
	public void notifyEvent() {
		this.previewActiveTime = System.currentTimeMillis();
		if (this.delayTime > 0) {
			cycle(this.delayTime + 1);
		}
	}

	class DelayTimerTask extends TimerTask {
		private EventDelayImpl delay;

		public DelayTimerTask(EventDelayImpl delay) {
			this.delay = delay;
		}

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
					TaskList.endTask(this.delay);
				} else {
					cycle(minus * -1);
				}
			}
		}
	}
}
