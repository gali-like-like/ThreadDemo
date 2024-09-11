package cn.galiLikeLike.thread;

import java.util.concurrent.Callable;

public class MyCaller implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		// TODO 这是唯一一个能执行有返回的线程方法
		return 	MyTask.sumReentLock();
//		return MyTask.sumSynchronized();
	}
}
