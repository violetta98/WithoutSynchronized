
class A implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread started working:::" + Thread.currentThread().getName());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread finished working:::" + Thread.currentThread().getName());
    }
}

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new A(), "t1");
        Thread t2 = new Thread(new A(), "t2");
        Thread t3 = new Thread(new A(), "t3");

        t1.start();

        // we start executing 2 thread after 2 sec waiting of 1 thread
        try {
            t1.join(2000); // main thread is waiting thread t1 2 sec
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();


        try {
            t1.join(); // main thread is waiting when t1 will be finished
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t3.start();

        // threads t1, t2, t3 will be finished before program (main thread) will be finished
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads were executed!");

    }

}



