package com.likai.chapter08.practice;

import com.likai.chapter08.RandomDoubles;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by likai on 2018/08/22.
 */
public class AdaptedRandomDoubles extends RandomDoubles implements Readable{
    private int count ;

    public AdaptedRandomDoubles(int count) {
        this.count = count ;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if(count -- == 0) {
            return -1 ;
        }

        String result = Double.toString(next()) + " " ;
        cb.append(result) ;
        return result.length() ;
    }

    public static void main(String [] args) {
        Scanner scanner = new Scanner(new AdaptedRandomDoubles(10)) ;
        while (scanner.hasNext()) {
            System.out.println(scanner.nextDouble() + " ");
        }
    }
}
