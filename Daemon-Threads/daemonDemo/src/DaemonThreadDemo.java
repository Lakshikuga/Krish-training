public class DaemonThreadDemo {

    public static void main(String args[]) throws InterruptedException{

        //main thread is a non daemon thread
        String name = Thread.currentThread().getName();
        boolean isDaemon = Thread.currentThread().isDaemon();

        System.out.println("name : " +name + ", isDaemon: " + isDaemon);

        //Any new thread spawned from main is also non-daemon or user thread as shown below
        Runnable task = new Task(); //this is a threadgroup

        Thread t1 = new Thread(task, "T1"); //Constructor - Thread(ThreadGroup, String)
        System.out.println("Thread spawned from main thread");
        System.out.println("name : " + t1.getName() + ", isDaemon: " + t1.isDaemon());

        //though you can make a daemon thread by calling setDaemon() before starting the thread as shown below

        t1.setDaemon(true);
        t1.start();
        //after starting the thread, the run() method will execute.

        //lets wait for T1 to finish
        //join() method waits for a thread to die. In other words, it causes the currently running threads
        //to stop executing until the thread it joins with completes the task.
        t1.join();

        System.out.println(Thread.currentThread().getName()); //so this implies that the main thread will wait until T1 exits.
        //Main will exit after T1 completes execution.
    }
}
