package com.monpro.thread.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

class AtomicIntegerFieldUpdaterThread implements Runnable {

  private static Candidate leader;
  private static Candidate worker;

  private static AtomicIntegerFieldUpdater<Candidate> updater =
      AtomicIntegerFieldUpdater.newUpdater(Candidate.class, "score");

  public static void main(String[] args) throws InterruptedException {
    leader = new Candidate();
    worker = new Candidate();
    AtomicIntegerFieldUpdaterThread updaterThread = new AtomicIntegerFieldUpdaterThread();
    Thread thread1 = new Thread(updaterThread);
    Thread thread2 = new Thread(updaterThread);
    thread1.start();
    thread2.start();
    thread1.join();
    thread2.join();
    System.out.println("leader score: " + leader.score);
    System.out.println("worker score: ");
  }

  @Override
  public void run() {
    for (int i = 0; i < 10000; i++) {
      leader.score += 1;
      updater.getAndIncrement(worker);
    }
  }

  static class Candidate {
    volatile int score;
  }
}
