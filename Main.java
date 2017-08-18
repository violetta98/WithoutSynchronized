
class Counter {

    private int c = 0;

    public void inc() {
        c++;
    }

    public void dec() {
        c--;
    }

    public int getC() {
        return c;
    }

    @Override
    public String toString() {
        return String.valueOf(c);
    }
}

class Thread1 extends Thread {
    Counter c;

    @Override
    public void run() {
        c.inc();
    }

    public void setC(Counter c) {
        this.c = c;
    }
}

class Thread2 extends Thread {
    Counter c;

    @Override
    public void run() {
        c.dec();
    }

    public void setC(Counter c) {
        this.c = c;
    }
}

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread1 t1 = new Thread1();
        t1.setC(counter);
        t1.start();

        Thread2 t2 = new Thread2();
        t2.setC(counter);
        t2.start();

        System.out.println(counter); // 0 -1 1 т.к. мы не знаем какой поток сработает раньше

    }

}



