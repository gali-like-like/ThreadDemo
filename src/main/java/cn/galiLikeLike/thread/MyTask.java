package cn.galiLikeLike.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyTask {
	private static Logger logger = LoggerFactory.getLogger(MyTask.class);
	private static Integer sum = 0;
	private static ReentrantLock lock = new ReentrantLock(true);
	public static void printNum() {
		//线程不安全
		for(int i = 0;i<10;i++) {
			sum+=i;
//			logger.info("current sum:{}",sum);
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		logger.info("total sum:{}",sum);
	}
	
	
	synchronized public static Integer sumSynchronized() {
		//synchronized 保证原子性
		for(int i = 0;i<10;i++) {
			sum+=i;
//			logger.info("current sum:{}",sum);
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		logger.info("total sum:{}",sum);
		return sum;
	}
	
	public static Integer sumReentLock() {
		//ReentrantLock 保证原子性
		try {
			Long start = System.currentTimeMillis();
			lock.tryLock(5, TimeUnit.SECONDS);
			Long end = System.currentTimeMillis();
			logger.info("阻塞等待时间:{}ms",end-start);
			for(int i = 0;i<10;i++) {
				sum+=i;
//				logger.info("current sum:{}",sum);
				Thread.currentThread().sleep(100);
			}
			logger.info("total sum:{}",sum);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(lock.isHeldByCurrentThread()) {
				lock.unlock();
			}
		}
		return sum;
	}
	
	public static Integer getSum() {
		return sum;
	}
}
