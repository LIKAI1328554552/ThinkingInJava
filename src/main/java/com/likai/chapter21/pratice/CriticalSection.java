package com.likai.chapter21.pratice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class Pair {
    private int x ;
    private int y ;

    public class PairValuesNotEqualException extends RuntimeException {

        public PairValuesNotEqualException() {
            super("Pair values not equal: " + Pair.this);
        }

    }
    public Pair(int x,int y) {
        this.x = x ;
        this.y = y ;
    }

    public Pair() {
        this(0,0) ;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incrementX() {
        this.x ++ ;
    }

    public void incrementY() {
        this.y ++ ;
    }

    public String toString() {
        return "x:" + this.x + ",y:" + this.y ;
    }

    public void checkState() {
        if (x != y) {
            throw new PairValuesNotEqualException() ;
        }
    }
}

abstract class PairManager {
    AtomicInteger checkCounter = new AtomicInteger(0) ;
    protected Pair p = new Pair() ;
    private List<Pair> storage = Collections.synchronizedList(new ArrayList<Pair>()) ;
    public synchronized Pair getPair() {
        return new Pair(p.getX(),p.getY()) ;
    }

    protected void store(Pair p) {
        storage.add(p) ;
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (Exception e) {

        }
    }

    public abstract void increment() ;
}

class PairManager1 extends PairManager {

    @Override
    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}

class PairManager2 extends PairManager {

    @Override
    public void increment() {
        Pair temp ;
        synchronized (this) {
            p.incrementX();
            p.incrementY();
            temp = getPair() ;
        }

        store(temp);
    }
}

class PairManipulator implements Runnable {

    private PairManager pm ;

    public PairManipulator(PairManager pm) {
        this.pm = pm ;
    }
    @Override
    public void run() {
        while (true) {
            pm.increment();
        }
    }

    public String toString() {
        return "Pair:" + pm.getPair() + " checkCounter= " + pm.checkCounter.get() ;
    }
}

class PairChecker implements Runnable {
    private PairManager pm ;
    public PairChecker(PairManager pm) {
        this.pm = pm ;
    }

    @Override
    public void run() {
        while (true) {
            pm.checkCounter.incrementAndGet() ;
            pm.getPair().checkState();
        }
    }
}

public class CriticalSection {
    static void testApproaches(PairManager pm1,PairManager pm2) {
        ExecutorService exec = Executors.newCachedThreadPool() ;
        PairManipulator pmm1 = new PairManipulator(pm1) ;
        PairManipulator pmm2 = new PairManipulator(pm2) ;
        PairChecker pc1 = new PairChecker(pm1) ;
        PairChecker pc2 = new PairChecker(pm2) ;
        exec.execute(pmm1);
        exec.execute(pmm2);
        exec.execute(pc1);
        exec.execute(pc2);

        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (Exception e) {
            System.out.println("Sleep interrupted");
        }

        System.out.println("pmm1:" + pmm1 + "\npmm2:" + pmm2);
        System.exit(0);
    }

    public static void main(String [] args) {
        PairManager pairManager1 = new PairManager1();
        PairManager pairManager2 = new PairManager2();
        testApproaches(pairManager1,pairManager2);
    }
}
