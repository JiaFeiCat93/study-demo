package com.qetch.interview.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketSaleTest {

	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 50; i++) {
					ticket.sale();
				}
			}
		}, "AA").start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 50; i++) {
					ticket.sale();
				}
			}
		}, "BB").start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 50; i++) {
					ticket.sale();
				}
			}
		}, "CC").start();
	}
}

class Ticket {
	private int number = 30;
	private Lock lock = new ReentrantLock();
	
	public void sale() {
		lock.lock();
		try {
			if (number > 0) {
				System.out.println(Thread.currentThread().getName() + "\t 卖出了第" + (number--) + "张票，还剩下" + number + "张");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}