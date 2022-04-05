public class Task implements Runnable{
    //this is a threadgroup  - grouping multiple threads in a single object, in this way, we can resume, suspend, or interrupt
    //a group of threads by a single method call.

    //a thread group represents a set of threads.

    @Override
    public void run() {
        Thread t = Thread.currentThread();

        System.out.println("name : " + t.getName() + ", isDaemon: " + t.isDaemon());

        //any new thread created from daemon thread is also daemon.
        Thread t2 = new Thread("T2");
        System.out.println("Thread spawned from a daemon thread");
        System.out.println("name : " + t2.getName() + ", isDaemon: " + t2.isDaemon());
    }
}
