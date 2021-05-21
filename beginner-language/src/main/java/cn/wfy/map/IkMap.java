package cn.wfy.map;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class IkMap<K, V> implements Map<K, V>, Cloneable, Serializable {

    K key;

    V val;

    public IkMap() {
    }

    public IkMap(K key, V val) {
        this.key = key;
        this.val = val;
    }


    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean containsKey(Object key) {
        return false;
    }

    public boolean containsValue(Object value) {
        return false;
    }

    public V get(Object key) {
        if (key == this.key) {
            return this.val;
        }
        return null;
    }

    public V put(K key, V value) {
        this.key = key;
        this.val = value;
        return null;
    }

    public V remove(Object key) {
        return null;
    }

    public void putAll(Map<? extends K, ? extends V> m) {

    }

    public void clear() {

    }

    public Set<K> keySet() {
        return null;
    }

    public Collection<V> values() {
        return null;
    }

    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}



