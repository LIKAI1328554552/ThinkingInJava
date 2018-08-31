package com.likai.chapter06.practice;

/**
 * Created by likai on 2018/08/09.
 */
public class ConnectionManager {
    static int count = 3 ;
    static Connection [] connections = new Connection[3] ;
    {
        for (Connection connection : connections) {
            connection = Connection.createInstance() ;
        }
    }

    public static Connection getConnection() {
        if(count > 0) {
            return connections[-- count] ;
        } else {
            System.out.println("没有更多的Connection实例了");
            return null ;
        }
    }

    public static void main(String [] args) {
        for(int i = 0 ; i < 4; i ++) {
            ConnectionManager.getConnection() ;
        }
    }
}
