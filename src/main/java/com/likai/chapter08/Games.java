package com.likai.chapter08;

/**
 * Created by likai on 2018/08/22.
 */
interface Game {
    public boolean move() ;
}
interface GameFactory {
    public Game getGame() ;
}

class Checkers implements Game {
    private int moves = 0 ;
    private static final int MOVES = 3 ;

    @Override
    public boolean move() {
        System.out.println("Checkers move " + this.moves);
        return ++ moves != MOVES;
    }
}

class Chess implements Game {
    private int moves = 0 ;
    private static final int MOVES = 4 ;

    @Override
    public boolean move() {
        System.out.println("Chess move " + this.moves);
        return ++ moves != MOVES;
    }
}

class GameInstanceFactory {
    public static Game getInstance(String name) {
        if("checkers".equals(name)) {
            return new Checkers() ;
        } else {
            return new Chess() ;
        }
    }
}

public class Games {

    public static void main(String [] args) {
        Game game = GameInstanceFactory.getInstance("chess") ;
        while (game.move()) ;
    }
}
