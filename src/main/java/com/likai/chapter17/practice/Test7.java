package com.likai.chapter17.practice;

import java.util.*;

class SlowMap17<K,V> implements Map<K,V> {

    private List<K> keys = new ArrayList<K>();
    private List<V> values = new ArrayList<V>() ;

    private EntrySet entries = new EntrySet() ;

    private Set<K> keySet = new KeySet<K>() ;


    @Override
    public int size() {
        return this.keys.size();
    }

    @Override
    public boolean isEmpty() {
        return this.entrySet().isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.keys.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.values.contains(value);
    }

    @Override
    public V get(Object key) {
        if(!this.keys.contains(key)) {
            return null;
        } else {
            return this.values.get(this.keys.indexOf(key)) ;
        }
    }

    @Override
    public V put(K key, V value) {
        V oldValue = get(key) ;
        //如果此key存在 那么则更新原有的
        if(this.keys.contains(key)) {
          this.values.set(this.keys.indexOf(key),value) ;
        } else {
            //如果不存在那么添加新的
            this.keys.add(key) ;
            this.values.add(value) ;
        }
        return oldValue;
    }

    @Override
    public V remove(Object key) {
        V oldValue = get(key) ;
        if (oldValue == null) {
            return null ;
        } else {
            int index = this.keys.indexOf(key) ;
            this.keys.remove(index) ;
            this.values.remove(index) ;
            return oldValue ;
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        //遍历Map 依次插入到SlowMap17中
        for (Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
            this.put(entry.getKey(),entry.getValue()) ;
        }
    }

    @Override
    public void clear() {
        this.keys.clear();
        this.values.clear();
    }

    @Override
    public Set<K> keySet() {
        return this.keySet;
    }

    @Override
    public Collection<V> values() {
        return this.values;
    }

    private class EntrySet extends AbstractSet<Map.Entry<K,V>> {

        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new Iterator<Entry<K, V>>() {

                //索引从-1开始
                private int index = -1 ;

                /**
                 * 如果index小于Map的大小
                 * @return
                 */
                @Override
                public boolean hasNext() {
                    return index < keys.size() - 1;
                }

                /**
                 * 如果要创建自己的Map 必须要实现Map.Entry接口
                 * @return
                 */
                @Override
                public Entry<K, V> next() {
                    int i = ++ index ;
                    return new MapEntry(keys.get(i),values.get(i)) ;
                }


                @Override
                public void remove() {
                    keys.remove(index) ;
                    values.remove(index) ;
                    index -- ;
                }
            };
        }

        /**
         * 返回的大小为Map的大小(内部类 可以直接使用外部类的属性)
         * @return
         */
        @Override
        public int size() {
            return keys.size();
        }
    }

    /**
     * 用来给Map entrySet 方法返回的set创建对象
     * @param <K>
     * @param <V>
     */
    private class MapEntry<K,V> implements Map.Entry<K,V>{

        private K key ;
        private V value ;
        public MapEntry() {
            super();
        }

        public MapEntry(K key,V value) {
            System.out.println("11111" + key + "," + value);
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

        @Override
        public String toString() {
            return "MapEntry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return this.entries;
    }

    private class KeySet<K> extends AbstractSet<K> {
        //索引从-1开始
        private int index = -1 ;

        @Override
        public Iterator<K> iterator() {
            return new Iterator<K>() {
                @Override
                public boolean hasNext() {
                    return index < keys.size() - 1;
                }

                @Override
                public K next() {
                    int i = ++ index  ;
                    return (K) keys.get(i);
                }

                @Override
                public void remove() {
                    keys.remove(index) ;
                    index -- ;
                }
            };
        }

        @Override
        public int size() {
            return keys.size();
        }
    }

    @Override
    public String toString() {
        return this.entrySet().toString();
    }
}
public class Test7 {

    public static void main(String [] args) {
        SlowMap17<String,String> map = new SlowMap17<String, String>() ;
        map.put("likai","shuai") ;
        map.put("lixinyi","chou") ;

        Map<String,String> text = new HashMap<String,String>() ;
        text.put("likai1","shuai") ;
        text.put("lixinyi1","chou") ;

        map.putAll(text);

        System.out.println(map);

        System.out.println(map.get("likai"));

        System.out.println(map.entrySet());

        System.out.println(map.keySet());
        System.out.println(map.values());

        System.out.println(map.isEmpty());
        System.out.println(map.size());
        System.out.println(map.containsKey("likai1"));
        System.out.println(map.containsValue("chou"));

        System.out.println(map.remove("likai"));

        System.out.println(map.size());

        System.out.println("1111111111111111111111");

        Set<Map.Entry<String, String>> entries1 = map.entrySet();
        System.out.println(entries1.size());

        System.out.println("1111111111111111111111");

        System.out.println(map.entrySet());

        Set<Map.Entry<String, String>> entries = map.entrySet();
        Iterator<Map.Entry<String, String>> iter = entries.iterator() ;
        while(iter.hasNext()) {
            Map.Entry<String,String> entry = iter.next() ;
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }
}
