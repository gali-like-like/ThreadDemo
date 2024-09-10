package cn.galiLikeLike.thread;

public class MyRunnable implements Runnable {
	@Override
	public void run() {
		MyTask.sum();
	}
}
