package com.inca.thread.step13;

public class Test {
	/**
	* <p>食堂打饭</p>
	 *
	 * @author hanchao 2018/3/31 21:13
	 **/
	public static void main(String[] args) throws InterruptedException {
	    //101班的学生
	    Thread[] students101 = new Thread[5];
	    for (int i = 0; i < 20; i++) {
	        //前10个同学都在耐心的等待打饭
	        if (i < 10) {
	            new Thread(new Student("打饭学生" + i, SemaphoreDemo.semaphore, 0)).start();
	        } else if (i >= 10 && i < 15) {//这5个学生没有耐心打饭，只会等1000毫秒
	            new Thread(new Student("泡面学生" + i, SemaphoreDemo.semaphore, 1)).start();
	        } else {//这5个学生没有耐心打饭
	            students101[i - 15] = new Thread(new Student("聚餐学生" + i, SemaphoreDemo.semaphore, 2));
	            students101[i - 15].start();
	        }
	    }
	    //
	    Thread.sleep(5000);
	    for (int i = 0; i < 5; i++) {
	        students101[i].interrupt();
	    }
	}
}
