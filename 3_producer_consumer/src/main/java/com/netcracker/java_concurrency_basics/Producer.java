package com.netcracker.java_concurrency_basics;

class Producer {
    private final Queue<String> queue;
    private final int id;
    private final int msgNum;
    private final Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            doJob();
        }
    });

    Producer(Queue<String> queue, int id, int msgNum) {
        this.queue = queue;
        this.id = id;
        this.msgNum = msgNum;
    }

    private void doJob() {
        for (int i = 0; i < msgNum; i++) {
            try {
                String msg = "PROD" + id + "-" + i;
                queue.offer(msg);
                System.out.println("Sent message: " + msg);
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void start() {
        t.start();
    }
}
