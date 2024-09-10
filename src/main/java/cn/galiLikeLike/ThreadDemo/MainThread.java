package cn.galiLikeLike.ThreadDemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.galiLikeLike.thread.MyCaller;
import cn.galiLikeLike.thread.MyRunnable;
import cn.galiLikeLike.thread.MyThread;

public class MainThread {
	private  static Logger logger = LoggerFactory.getLogger(MainThread.class);
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		MyThread thread = new MyThread();
		Thread thread2 = new Thread(new MyRunnable());
		FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyCaller());
		Thread thread3 = new Thread(futureTask);
		thread3.start();
		thread2.setDaemon(true);
		thread.start();
		thread2.start();
		thread.join();
		thread2.join();
		thread3.join();
//		Integer resultInteger = futureTask.get();
		logger.info("sum:{},hashcode:{}",futureTask.get(),futureTask.get().hashCode());
		//		ExecutorService service = Executors.newCachedThreadPool();
//		service.execute(new MyRunnable());
//		Future<Void> future = service.submit(new MyCaller());
//		future.get(2, TimeUnit.SECONDS);
//		service.shutdown();
		System.exit(0);
	}
}
