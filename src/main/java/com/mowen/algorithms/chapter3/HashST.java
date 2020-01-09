package com.mowen.algorithms.chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mowen on 4/17/16.
 * 第五种 散列表
 * 用散列函数将被查找的键转化为数组的一个索引，然后用拉链法或线性探索法去处理碰撞冲突.
 * 查找和插入理论上接近常数
 *
 * 空间和时间上需要做出平衡，一般比会比红黑树快很多。但具体还是要看哈希函数的计算效率，还有无法像查找树支持有序
 * 散列表实现的难度:
 * 良好的散列函数
 * 难以支持有序性
 *
 * 拉链法 vs 线性探索法
 * 线性探索法对删除操作难度较大
 * 线性探索法必须必要的时候扩容
 * 具体场景还要具体分析
 */
public class HashST<Key, Value> {
    private int N;  //键值对总数
    private int M;  //散列表大小
    private SequentialSearchST<Key, Value>[] st;

    public HashST() {
        this(997);
    }
    public HashST(int M) {
        this.M = M;
        st =  (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0;i < M; i++) {
            st[i] = new SequentialSearchST<Key, Value>();
        }
    }
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }
    public Value get(Key key){
        return st[hash(key)].get(key);
    }
    public void put(Key key, Value value) {
        st[hash(key)].put(key, value);
    }

    public Iterable<Key> keys() {
        List<Key> list = new ArrayList<Key>();
        for (int i = 0; i < M; i++) {
            for(Key key : st[i].keys()) {
                list.add(key);
            }
        }
        return list;
    }

    public void print() {
        for (int i = 0; i < M; i++) {
            for(Key key : st[i].keys()) {
                System.out.print(key + ":" + get(key) + " ");
            }
        }
        System.out.println();
    }
}
