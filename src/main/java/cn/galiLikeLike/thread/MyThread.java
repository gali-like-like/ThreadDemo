package cn.galiLikeLike.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyThread extends Thread {
	private Logger logger = LoggerFactory.getLogger(MyThread.class);

	public MyThread(String name) {
		setName(name);
	}
	
	@Override
	public void run() {
		MyTask.sumReentLock();
//		MyTask.sumSynchronized();
	}
}
