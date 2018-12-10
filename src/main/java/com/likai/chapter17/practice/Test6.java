package com.likai.chapter17.practice;

import com.likai.chapter07.practice.C;

import java.util.*;

class SlowMap<K,V> extends AbstractMap<K,V> {

    private List<K> keys = new ArrayList<K>() ;
    private List<V> values = new ArrayList<V>() ;

    public V put(K key,V value) {
        //如果key已经存在 那么则为替换
        //自己的思路 问题:调用get方式会遍历keys数组 和 获取对应两个list中的对象
        /*if(get(key) != null) {
            values.set(keys.indexOf(key),value) ;
        } else {
            keys.add(key) ;
            values.add(value) ;
        }*/
        //仅仅遍历keys数组
        V result = get(key) ;
        if(!keys.contains(key)) {
            keys.add(key) ;
            values.add(value) ;

        } else {
            values.set(keys.indexOf(key),value) ;
        }
        return result ;
    }


    public V get(Object key) {
        //如果key不存在
        if(!keys.contains(key)) {
            return null ;
        }
        //返回keys list中 对应的 values list中 元素
        return values.get(keys.indexOf(key)) ;
    }


    /**
     * 重写entrySet 如果要创建自己的Map 必须要实现Map.Entry接口
     * @return
     */
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K,V>> set = new HashSet<Entry<K, V>>() ;
        Iterator<K> ik = keys.iterator() ;
        Iterator<V> iv = values.iterator() ;

        while (ik.hasNext()) {
            set.add(new MapEntry<K,V>(ik.next(),iv.next())) ;
        }
        return set;
    }
}

/**
 * 用来给Map entrySet 方法返回的set创建对象
 * @param <K>
 * @param <V>
 */
class MapEntry<K,V> implements Map.Entry<K,V>{

    private K key ;
    private V value ;
    public MapEntry() {
        super();
    }

    public MapEntry(K key,V value) {
        this.key = key ;
        this.value = value ;
    }
    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public V getValue() {
        return this.value;
    }

    @Override
    public V setValue(V value) {
        V result = value ;
        this.value = value ;
        return result ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapEntry<?, ?> mapEntry = (MapEntry<?, ?>) o;
        return Objects.equals(key, mapEntry.key) &&
                Objects.equals(value, mapEntry.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}

public class Test6 {
    public static void main(String [] args) {
        SlowMap<String,String> slowMap = new SlowMap<>() ;
        slowMap.put("likai","shuai") ;
        slowMap.put("lixinyi","chou") ;
        slowMap.put("lili","keai") ;

        System.out.println(slowMap.get("likai"));

        Set<Map.Entry<String, String>> set = slowMap.entrySet() ;
        Iterator<Map.Entry<String,String>> iter = set.iterator() ;
        //详解 插入数据到slowMap 是有序保存的 但是向set Map.Entry<K,V> 插入数据时 是使用的无序的hashSet
        while(iter.hasNext()) {
            MapEntry<String,String> entry = (MapEntry<String, String>) iter.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }


        Map<String,String> map = new HashMap<String,String>() ;
        map.put("likai","shuai") ;
        map.put("lixinyi","chou") ;
        map.put("lili","keai") ;

        System.out.println(map.get("likai"));

        Set<Map.Entry<String, String>> entries = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey());
            System.out.println(next.getValue());

        }
    }
}
