package com.likai.chapter07.practice;

/**
 * Created by likai on 2018/08/11.
 */
class Game {
    public Game(int i) {
        System.out.println("Game 构造器");
    }
}

class BoardGame extends Game{
    public BoardGame(int i) {
        super(i);
        System.out.println("BoardGame 构造器");
    }
}

public class Chess extends BoardGame{
    public Chess() {
        super(11);
        System.out.println("Chess 构造器");
    }
    public static void main(String [] args) {
        Chess chess = new Chess() ;
    }
}
