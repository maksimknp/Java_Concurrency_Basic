package com.netcracker.java_concurrency_basics;

/**
 * Created by Maks on 17.10.2018.
 */
public class ThreadStatesNew {
  public static void main(String[] args) throws Exception {
    Runnable r = new Runnable() {
      @Override
      public void run() {
        // Implement.
      }
    };

    Thread t = new Thread(r);

    System.out.println(t.getState());
  }

}
