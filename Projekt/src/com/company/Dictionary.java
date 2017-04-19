package com.company;


import java.util.*;

public class Dictionary<K, V> implements Mappable<K, V> {

    TreeSet<Entry<K,V>> entries;
    Comparator<? super K> comparator;

    public Dictionary() {
        entries = new TreeSet<>();
    }

    public Dictionary(Comparator<? super K> comparator) {
        this.entries = new TreeSet<>();
        this.comparator = comparator;
    }

    @Override
    public void put(K key, V value) {
        entries.add(new Entry<>(key, value));
    }

    @Override
    public V get(K key) {

        Iterator<Entry<K, V>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Entry<K, V> next = iterator.next();
            if(key.equals(next.getKey())) {
                return next.getValue();
            }
        }
        return null;

    }



    @Override
    public boolean contains(K key) {
        Iterator<Entry<K, V>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Entry<K, V> next = iterator.next();
            if(key.equals(next.getKey())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return entries.isEmpty();
    }

    @Override
    public int size() {
        return entries.size();
    }

}



interface Mappable<K , V> {

    void put(K key, V value);

    V get(K key);

    boolean contains(K key);

    boolean isEmpty();

    int size();

}

class Entry<K, V> implements Comparable<K> {
    private K key;
    private V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public int compareTo(K o) {
        //TODO
        return 0;
    }
}


