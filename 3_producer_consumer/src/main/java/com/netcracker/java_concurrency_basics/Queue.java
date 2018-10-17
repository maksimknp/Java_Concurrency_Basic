package com.netcracker.java_concurrency_basics;

import java.util.LinkedList;
import java.util.List;

class Queue<E> {
    List<E> queue = new LinkedList<E>();

     E take() throws Exception {
         synchronized (queue) {
             while (queue.size() == 0){
                 queue.wait();
             }

             E data = queue.get(0);
             queue.remove(0);

             return data;
         }
     }

     void offer(E e) throws Exception {
         synchronized (queue) {
             int oldSize = queue.size();
             queue.add(e);
             if(oldSize == 0){
                 queue.notify();
             }
         }
     }
}
