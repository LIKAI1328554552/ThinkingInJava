package com.likai.chapter21.pratice;

import java.util.concurrent.TimeUnit;

class InnerThread1 {
    private int countDown = 5 ;
    private Inner inner ;
    private class Inner extends Thread {
        public Inner(String name) {
            super(name);
            start();
        }

        public void run() {
            try {
                while(true) {
                    System.out.println(this);
                    if(-- countDown == 0) {
                        return ;
                    }
                    sleep(10);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public String toString() {
            return getName() + ": " + countDown ;
        }
    }

    public InnerThread1(String name) {
        this.inner = new Inner(name) ;
    }
}
class InnerThread2 {
    private int countDown = 5 ;
    private Thread t ;
    public InnerThread2(String name) {
        t = new Thread(name) {
            public void run() {
                try {
                    while(true) {
                        System.out.println(this);
                        if(-- countDown == 0) {
                            return ;
                        }
                        sleep(10);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public String toString() {
                return getName() + ": " + countDown ;
            }
        } ;
        t.start();
    }
}
class InnerRunable1 {
    private int countDown = 5 ;
    private Inner inner ;
    private class Inner implements Runnable {
        private Thread t ;
        public Inner(String name) {
            t = new Thread(this,name) ;
            t.start();
        }
        @Override
        public void run() {
            try {
                while(true) {
                    System.out.println(this);
                    if(-- countDown == 0) {
                        return;
                    }

                    TimeUnit.MICROSECONDS.sleep(10);
                }
            } catch (Exception e) {
                e.printStackTrace() ;
            }
        }

        public String toString() {
            return t.getName() + ": " + countDown ;
        }
    }

    public InnerRunable1(String name) {
        inner = new Inner(name) ;
    }
}

class InnerRunable2 {
    private int countDown = 5 ;
    private Thread t ;
    public InnerRunable2(String name) {
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true) {
                        System.out.println(this);
                        if(-- countDown == 0) {
                            return;
                        }

                        TimeUnit.MICROSECONDS.sleep(10);
                    }
                } catch (Exception e) {
                    e.printStackTrace() ;
                }
            }

            public String toString() {
                return Thread.currentThread().getName() + ": " + countDown ;
            }
        },name) ;
        t.start();
    }
}

class ThreadMethod {
    private int countDown = 5 ;
    private Thread t ;
    private String name ;
    public ThreadMethod(String name) {
        this.name = name ;
    }
    public void runTask() {
        if(t == null) {
            t = new Thread(name) {
                public void run() {
                    try {
                        while(true) {
                            System.out.println(this);
                            if(-- countDown == 0) {
                                return ;
                            }
                            sleep(10);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                public String toString() {
                    return getName() + ": " + countDown ;
                }
            } ;
            t.start();
        }
    }
}
public class ThreadVariations {
    public static void main(String [] args) {
        new InnerThread1("InnerThread1") ;
        new InnerThread2("InnerThread2") ;
        new InnerRunable1("InnerRunable1") ;
        new InnerRunable2("InnerRunable2") ;
        new ThreadMethod("ThreadMethod").runTask(); ;
    }
}
