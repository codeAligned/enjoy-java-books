package net.jcip.examples;

import java.io.File;
import java.util.concurrent.BlockingQueue;

public class Indexer implements Runnable {

	private final BlockingQueue<File> queue;

	public Indexer(BlockingQueue<File> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			while (true) {
				if (1 == 2) {
					break;
				} else {
					indexFile(queue.take());
				}
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	private void indexFile(File take) {

	}
}
