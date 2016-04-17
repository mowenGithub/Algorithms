package com.mowen.algorithms.chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mowen on 4/16/16.
 * 第一种 基于无序链表的 顺序查找
 * 查找时间复杂度度平均 N/2 ,最坏N， 插入时间复杂度N
 */
public class SequentialSearchST<Key, Value> {
    private Node first;

    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this .next = next;
        }
    }

    public void put(Key key, Value val) {
        for(Node x = first; x != null; x = x.next) {
            if(key.equals(x.key)) {
                x.val = val;
                return;
            }
        }

        first = new Node(key, val, first);
    }

    public Value get(Key key) {
        for(Node x = first; x != null; x = x.next) {
            if(key.equals(x.key)) {
                return x.val;
            }
        }
        return null;
    }

    public void print() {
        for(Node x = first; x != null; x = x.next) {
            System.out.print(x.key + ":" + x.val + " ");
        }
        System.out.println();
    }


    public Iterable<Key> keys()  {
        List<Key> list = new ArrayList<Key>();
        for (Node x = first; x != null; x = x.next)
            list.add(x.key);
        return list;
    }
}
