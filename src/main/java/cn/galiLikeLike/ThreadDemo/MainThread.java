package cn.galiLikeLike.ThreadDemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.galiLikeLike.thread.MyCaller;
import cn.galiLikeLike.thread.MyRunnable;
import cn.galiLikeLike.thread.MyTask;
import cn.galiLikeLike.thread.MyThread;
public class MainThread {
	//启动类,分别通过不同的方式创建了三个线程，启动了三个线程
	private  static Logger logger = LoggerFactory.getLogger(MainThread.class);
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		for(int i = 0;i<10;i++) {
			MyThread thread1 = new MyThread("thread-1");
			Thread thread2 = new Thread(new MyRunnable(),"thread-2");
			FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyCaller());
			Thread thread3 = new Thread(futureTask,"thread-3");
			thread1.start();
			thread2.start();
			thread3.start();

			thread1.join();
			thread2.join();
			thread3.join();
			logger.info("第{}次 sum:{}",i,MyTask.getSum());	
		}
		//futureTask.get() 方法返回的当时线程执行完毕时的结果
//		logger.info("sum:{},hashcode:{}",futureTask.get(),futureTask.get().hashCode());
			
	}
}
