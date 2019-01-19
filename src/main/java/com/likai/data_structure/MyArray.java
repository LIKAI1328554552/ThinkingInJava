package com.likai.data_structure;

import com.likai.util.Range;

import java.util.Calendar;
import java.util.Random;

/**
 * Created by likai on 2018/11/09.
 * 自定义集合
 */
public class MyArray {
    private long [] array ;
    //数组实际长度
    private int size ;

    public MyArray() {
        super();
        this.array = new long[50] ;
    }

    public MyArray(int size) {
        super();
        this.array = new long[size] ;
    }

    /**
     * 添加方法
     * @param value 要添加的值
     */
    public void add(int value) {
        this.array[this.size] = value ;
        this.size ++ ;
    }

    /**
     * 根据索引位置插入值
     * @param index 索引位置
     * @param value 值
     */
    public void add(int index,int value) {
        if (index < 0 || index >= this.array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        //此位置后的元素依次向后移动一位
        for(int i = this.size ; i >= index; i --){
            this.array[i+1] = this.array[i];
        }
        this.array[index] = value;
        this.size ++;
    }

    public void orderAdd(int value) {

        int i ;
        //遍历数组 确定要插入的位置
        for (i = 0 ; i < this.size ; i ++) {
            if(this.array[i] > value) {
                break ;
            }
        }

        // 将后面的元素依次向后移动一位
        for (int j = this.size ; j >= i ; j--) {
            this.array[j + 1] = this.array[j] ;
        }

        this.array[i] = value ;

        this.size ++ ;

    }

    public int search(int value) {
        int x = 0 ;

        //遍历数组
        for (int i = 0 ; i < this.size ; i ++) {
            if(this.array[i] == value) {
                x = i ;
                break ;
            }
        }
        return x ;
    }

    /**
     * 根据索引取得值
     * @param index 索引值
     * @return
     */
    public long get(int index) {
        if (index >= this.size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return this.array[index] ;
    }

    /**
     * 根据索引 删除值
     * @param index 索引值
     */
    public void remove(int index) {
        if (index >= this.size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        //将此数组后面的元素依次向前移动一位
        for(int i = index ; i < this.size ; i ++) {
            this.array[i] = this.array[i + 1] ;
        }

        this.size -- ;

    }

    /**
     * 根据索引更新此位置的值
     * @param index 索引值
     * @param newValue 新的值
     */
    public void update(int index , int newValue) {
        if (index >= this.size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        this.array[index] = newValue ;
    }

    public String toString() {
        StringBuilder result = new StringBuilder() ;
        result.append("[") ;

        for(int i = 0 ; i < this.size; i ++) {
            result.append(this.array[i]) ;
            if(i < this.size - 1) {
                result.append(",") ;
            }
        }

        result.append("]") ;
        return result.toString() ;
    }


    public static void main(String [] args) {
        /*MyArray array = new MyArray();
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(7);
        array.add(8);
        array.add(9);
        array.add(22);
        array.add(33);
        array.add(44);
        array.add(55);
        array.add(66);
        array.add(77);


        System.out.println(array);

        array.orderAdd(6);

        System.out.println(array);

        System.out.println(array.search2(3));
*/
        MyArray array = new MyArray(10000) ;

        Random r = new Random(47) ;

        for(int i = 0 ; i < 9998; i ++) {
            array.orderAdd(r.nextInt(10000000));
        }

        array.orderAdd(66666);

        System.out.println(array);


        System.out.println(array.search(66666));

    }
}
