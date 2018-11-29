package com.likai.data_structure;

/**
 * Created by likai on 2018/11/20.
 * 有序数组
 */
public class MyOrderArray {

    private int [] array ;

    private int size ;

    public MyOrderArray() {
        this.array = new int [100] ;
        this.size = 0 ;
    }

    public MyOrderArray(int size) {
        this.array = new int[size] ;
        this.size = 0 ;
    }


    /**
     * 有序新增
     * @param value
     */
    public void add(int value) {
        //1.查询大于此值的位置
        int index ;
        //遍历数组 确定要插入的位置
        for (index = 0 ; index < this.size ; index ++) {
            if(this.array[index] > value) {
                break ;
            }
        }
        //2.将从此位置开始的值依次向后移动一位
        System.arraycopy(this.array,index,this.array,index + 1,this.size-index);
        //3.插入此位置中
        this.array[index] = value ;
        //4.size长度增加
        this.size ++ ;
    }

    /**
     * 根据索引取得值
     * @param index
     * @return
     */
    public int get(int index) {
        if(index < 0 || index > this.size) {
            throw new ArrayIndexOutOfBoundsException() ;
        }

        return this.array[index] ;
    }

    /**
     * 根据索引更新元素的值
     * @param index
     * @param newValue
     */
    public void update(int index,int newValue) {
        if(index < 0 || index > this.size) {
            throw new ArrayIndexOutOfBoundsException() ;
        }

        this.array[index] = newValue ;
    }

    /**
     * 根据索引删除元素
     * @param index
     */
    public void remove(int index) {
        if(index < 0 || index > this.size) {
            throw new ArrayIndexOutOfBoundsException() ;
        }

        //1.将数组此位置的值依次向前移动一位
        System.arraycopy(this.array,index,this.array,index - 1,this.size-index);

        //2.size 减 1
        this.size -- ;
    }

    /**
     * 使用二分查找法
     * @param value
     * @return
     */
    public int search(int value) {
        //中间位置
        int mod = 0 ;
        //起始位置
        int low = 0 ;
        //结尾位置
        int pow = this.size ;

        while (true) {
            if(low > pow) {
                mod = -1 ;
                break ;
            } else {
                mod = (low + pow) / 2 ;
                //如果值正好为value
                if(value == this.array[mod]) {
                    break;
                } else {
                    if(value > this.array[mod]) {
                        //当前值大于中间值 查右
                        low = mod + 1 ;
                    } else {
                        //当前值小于中间值 查左
                        pow = mod - 1 ;
                    }
                }
            }
        }


        return mod ;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder() ;
        sb.append("[") ;
        for(int i = 0 ; i < this.size; i ++) {
            sb.append(this.array[i]) ;
            if(i < this.size -1) {
                sb.append(",") ;
            }
        }
        sb.append("]") ;
        return sb.toString() ;
    }


    public static void main(String [] args) {
        MyOrderArray array = new MyOrderArray(10) ;

        array.add(30);
        array.add(10);
        array.add(55);
        array.add(1);

        array.remove(2);


        System.out.println(array);

        System.out.println(array.search(1));
    }
}
