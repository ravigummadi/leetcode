package com.general;

/**
 * User: huangd
 * Date: 3/28/13
 * Time: 3:13 PM
 */
public class Element {
    private Integer hSize = 0;
    private Integer oSize = 0;

    public void H() throws InterruptedException {
        synchronized (hSize) {
            if (hSize == 0 || oSize == 0) {
                hSize += 1;
                hSize.wait();
            } else {
                hSize.notify();
                hSize -= 1;
                synchronized (oSize) {
                    oSize.notify();
                    oSize -= 1;
                }
                System.out.println("H2O");
            }
        }
    }

    public void O() throws InterruptedException {
        synchronized (oSize) {
            if (hSize < 2) {
                oSize += 1;
                oSize.wait();
            } else {
                synchronized (hSize) {
                    hSize.notify();
                    hSize.notify();
                    hSize -= 2;
                }
                System.out.println("H2O");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Element element = new Element();
        for (int i = 0; i < 10; ++i) {
            new ThreadElement(element, ThreadType.O).start();
        }
        Thread.sleep(1000);
        for (int i = 0; i < 20; ++i) {
            new ThreadElement(element, ThreadType.H).start();
        }
    }
}


class ThreadElement extends Thread {

    private Element element;
    private ThreadType threadType;

    public ThreadElement(Element element, ThreadType threadType){
        this.element = element;
        this.threadType = threadType;
    }
    @Override
    public void run() {
        if(threadType == ThreadType.H){
            System.out.println("Thread: " + Thread.currentThread().getName() + " H");
            try {
                element.H();
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }else if(threadType == ThreadType.O){
            System.out.println("Thread: "+Thread.currentThread().getName()+" O");
            try {
                element.O();
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
}


enum ThreadType {
    H, O;
}