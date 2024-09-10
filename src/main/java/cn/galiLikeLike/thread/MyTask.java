package cn.galiLikeLike.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyTask {
	private static Logger logger = LoggerFactory.getLogger(MyTask.class);
	private static Integer sum = 0;
	public static void printNum() {
		for(int i = 0;i<10;i++) {
			sum+=i;
			logger.info("current sum:{}",sum);
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		logger.info("sum:{}",sum);
	}
	
	
	synchronized public static Integer sum() {
		for(int i = 0;i<10;i++) {
			sum+=i;
			logger.info("current sum:{}",sum);
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		logger.info("sum:{},hashcode:{}",sum,sum.hashCode());
		return sum;
	}
}
