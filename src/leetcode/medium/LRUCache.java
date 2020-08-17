package leetcode.medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache extends LinkedHashMap<Integer, Integer> {
    int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}


class LRUCacheBEST {

    private final Node[] data;
    private Node head = null;
    private Node tail = null;
    private int size = 0;
    private int capacity ;
    public LRUCacheBEST(int capacity) {
        this.capacity = capacity;
        data = new Node[capacity];
    }

    public int get(int key) {
        Node n = getNode(key);

        //print();

        return n == null ? -1 : n.val;
    }

    private Node getNode(int key) {
        int i = key%capacity;
        Node n = data[i];
        while (n != null) {
            if (n.key == key) {
                break;
            } else {
                n = n.next;
            }
        }
        if (n == null) {
            return null;
        }

        if (n != head) {
            if (n == tail) {
                tail = n.lruNext;
            } else {
                n.lruPre.lruNext = n.lruNext;
            }
            n.lruNext.lruPre = n.lruPre;
            head.lruNext = n;
            n.lruPre = head;
            n.lruNext = null;
            head = n;
        }
        return n;
    }

    public void put(int key, int value) {
        Node n = getNode(key);
        if (n != null) {
            n.val = value;
            return;
        }

        int i = key%capacity;
        if (capacity == size) {
            remove(tail.key);
            if (tail == head) {//when capacity is 1
                tail = head = null;
            } else {
                tail = tail.lruNext;
            }
        }
        n = new Node(key, value, data[i]);

        if (head == null) {
            tail = head = n;
        } else {
            head.lruNext = n;
            n.lruPre = head;
            head = n;
        }

        data[i] = n;
        size++;
        //print();
    }

    void print() {
        Node n = tail;
        while (n != null) {
            System.out.print(n.key + "->");
            n = n.lruNext;
        }

        System.out.print(" | ");
        System.out.print("Tail:" + tail.key);
        System.out.print("Head:" + head.key);
        System.out.print(" | ");

        for (int i = 0; i < capacity; i++) {
            n = data[i];
            while (n != null) {
                System.out.print(n.key + "->");
                n = n.next;
            }
        }

        System.out.println();
    }

    private void remove(int key) {
        //System.out.println("Removing:" + key);
        int i = key%capacity;
        Node n = data[i];
        Node previous = null;
        while (n != null) {
            if (n.key == key) {
                if (previous == null) {
                    data[i] = n.next;
                } else {
                    previous.next = n.next;
                }
                size--;
                break;
            } else {
                previous = n;
                n = n.next;
            }
        }
        //System.out.println("Removed:" + key);
    }

    private class Node {

        int key;
        int val;
        int lruIndex;
        Node next = null;
        Node lruNext = null;
        Node lruPre = null;

        private Node(int key, int val, Node next) {
            this(key, val);
            this.next = next;
        }

        private Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

//LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // returns 1
//cache.put(3, 3);    // evicts key 2
//cache.get(2);       // returns -1 (not found)
//cache.put(4, 4);    // evicts key 1
//cache.get(1);       // returns -1 (not found)
//cache.get(3);       // returns 3
//cache.get(4);       // returns 4