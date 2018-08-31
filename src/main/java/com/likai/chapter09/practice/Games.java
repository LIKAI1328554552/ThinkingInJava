package com.likai.chapter09.practice;

/**
 * Created by likai on 2018/08/26.
 */
interface Game {
    public boolean moves() ;
}
interface GameFactory {
    public Game getGame() ;
}

class Checkers implements Game {
    private int moves ;
    private static final int MOVES = 3 ;
    private Checkers() {

    }

    @Override
    public boolean moves() {
        System.out.println("Checkers move " + this.moves);
        return ++ this.moves != MOVES ;
    }

    public static GameFactory factory() {
        return new GameFactory() {
            @Override
            public Game getGame() {
                return new Checkers();
            }
        } ;
    }
}

class Chess implements Game {
    private int moves ;
    private static final int MOVES = 4 ;
    private Chess() {

    }

    @Override
    public boolean moves() {
        System.out.println("Chess move " + this.moves);
        return ++ this.moves != MOVES;
    }

    public static GameFactory factory() {
        return new GameFactory() {
            @Override
            public Game getGame() {
                return new Chess();
            }
        } ;
    }
}
public class Games {
    public static void playGame(GameFactory factory) {
        Game game = factory.getGame() ;
        while (game.moves()) {

        }
    }

    public static void main(String [] args) {
        Games.playGame(Checkers.factory());
        Games.playGame(Chess.factory());
    }
}
