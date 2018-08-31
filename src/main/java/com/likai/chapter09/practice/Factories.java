package com.likai.chapter09.practice;

/**
 * Created by likai on 2018/08/26.
 */
interface Service {
    public void method1() ;
    public void method2() ;
}

interface ServiceFactory {
    public Service getService() ;
}
class Impl1Service implements Service {

    private Impl1Service() {

    }

    @Override
    public void method1() {
        System.out.println("Impl1Service method1()");
    }

    @Override
    public void method2() {
        System.out.println("Impl1Service method2()");
    }

    public static ServiceFactory factory() {
        return new ServiceFactory() {
            @Override
            public Service getService() {
                return new Impl1Service();
            }
        } ;
    }
}
class Impl2Service implements Service {

    @Override
    public void method1() {
        System.out.println("Impl2Service method1()");
    }

    @Override
    public void method2() {
        System.out.println("Impl2Service method2()");
    }

    public static ServiceFactory factory() {
        return new ServiceFactory() {
            @Override
            public Service getService() {
                return new Impl2Service();
            }
        } ;
    }
}
public class Factories {

    public static void serviceConsumer(ServiceFactory factory) {
        Service service = factory.getService() ;
        service.method1();
        service.method2();
    }

    public static void main(String [] args) {
        Factories.serviceConsumer(Impl1Service.factory());
        Factories.serviceConsumer(Impl2Service.factory());
    }
}
