package in.ineuron.main;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumerThread {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		int maxSize = 10;

		Producer producer = new Producer(queue, maxSize);
		Consumer consumer = new Consumer(queue);

		Thread producerthread = new Thread(producer);
		Thread consumerThread = new Thread(consumer);
		producerthread.start();
		consumerThread.start();

	}

}

class Producer implements Runnable {
	private Queue<Integer> queue;
	private int maxSize;

	public Producer(Queue<Integer> queue, int maxSize) {
		this.queue = queue;
		this.maxSize = maxSize;
	}

	@Override
	public void run() {
		Random random = new Random();
		while (true) {

			synchronized (queue) {
				while (queue.size() == maxSize) {
					System.out.println("Queue is full, waiting...");
					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				int num = random.nextInt(5);
				queue.add(num);
				System.out.println("Producer : " + num);
				queue.notifyAll();

			}
		}
	}
}

class Consumer implements Runnable {

	private Queue<Integer> queue;

	public Consumer(Queue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {

		while (true) {
			synchronized (queue) {
				while (queue.isEmpty()) {

					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				int sum = 0;
				while (!queue.isEmpty()) {
					sum += queue.poll();
				}
				System.out.println("Consumer : " + sum);
				queue.notifyAll();
			}
		}

	}

}