package com.netcracker.java_concurrency_basics;

class Consumer {
    private final Queue<String> queue;
    private final int id;
    private final Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            doJob();
        }
    });

    Consumer(Queue<String> queue, int id) {
        this.queue = queue;
        this.id = id;
    }

    private void doJob() {
        try {
            while (true) {
                String msg = queue.take();
                Thread.sleep(10);
                System.out.println("CONS" + id + " received message: " + msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {
        t.start();
    }
}
