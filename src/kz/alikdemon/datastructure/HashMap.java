package kz.alikdemon.datastructure;

/**
 * @Author: alikdemon
 * @Date: 1/14/19, Mon
 */
public class HashMap<K, V> {
    private Entry<K, V>[] buckets;
    private static final int INITIAL_CAPACITY = 1 << 4; // 16

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public HashMap() {
        buckets = new Entry[INITIAL_CAPACITY];
    }

    public void put(K key, V value) {
        if (key == null)
            return;

        int hash = hash(key);
        Entry<K, V> newEntry = new Entry<K, V>(key, value, null);

        if (buckets[hash] == null) {
            buckets[hash] = newEntry;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = buckets[hash];

            while (current != null) {
                if (current.key.equals(key)) {
                    if (previous == null) {
                        newEntry.next = current.next;
                        buckets[hash] = newEntry;
                        return;
                    } else {
                        newEntry.next = current.next;
                        previous.next = newEntry;
                        return;
                    }
                }
                previous = current;
                current = current.next;
            }
            previous.next = newEntry;
        }
    }

    public V get(K key) {
        int hash = hash(key);
        if (buckets[hash] == null) {
            return null;
        } else {
            Entry<K, V> temp = buckets[hash];
            while (temp != null) {
                if (temp.key.equals(key))
                    return temp.value;
                temp = temp.next;
            }
            return null;
        }
    }

    public boolean remove(K key) {
        int hash = hash(key);

        if (buckets[hash] == null) {
            return false;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = buckets[hash];
            while (current != null) {
                if (current.key.equals(key)) {
                    if (previous == null) {
                        buckets[hash] = buckets[hash].next;
                        return true;
                    } else {
                        previous.next = current.next;
                        return true;
                    }
                }
                previous = current;
                current = current.next;
            }
            return false;
        }
    }

    private int hash(K key) {
        return (INITIAL_CAPACITY - 1) & Math.abs(key.hashCode());
    }
}
