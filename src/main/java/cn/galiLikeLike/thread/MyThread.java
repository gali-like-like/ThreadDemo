package cn.galiLikeLike.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyThread extends Thread {
	private Logger logger = LoggerFactory.getLogger(MyThread.class);
	@Override
	public void run() {
		MyTask.sum();
	}
}
