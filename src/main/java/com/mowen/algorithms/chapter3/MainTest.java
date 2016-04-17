package com.mowen.algorithms.chapter3;

/**
 * Created by mowen on 4/16/16.
 */
public class MainTest {

    public static void main(String[] args) {
//        SequentialSearchST<String, String> sequentialSearchST = new SequentialSearchST<>();
//        sequentialSearchST.put("A", "AA");
//        sequentialSearchST.put("C", "CA");
//        sequentialSearchST.put("B", "BA");
//        System.out.println(sequentialSearchST.get("C"));
//        sequentialSearchST.print();

//        BinarySearchST<String, String> binarySearchST = new BinarySearchST<>(10);
//        binarySearchST.put("A", "AA");
//        binarySearchST.put("C", "CA");
//        binarySearchST.put("B", "BA");
//        System.out.println(binarySearchST.get("C"));
//        binarySearchST.print();

        BST<String, String> bst = new BST<>();
        bst.put("A", "AA");
        bst.put("C", "CA");
        bst.put("B", "BA");
        System.out.println(bst.get("C"));
        bst.print();

//        RedBlackBST<String, String> redBlackBST = new RedBlackBST<>();
//        redBlackBST.put("A", "AA");
//        redBlackBST.put("C", "CA");
//        redBlackBST.put("B", "BA");
//        System.out.println(redBlackBST.get("C"));
//        redBlackBST.print();

//        HashST<String, String> hashST = new HashST<>();
//        hashST.put("A", "AA");
//        hashST.put("C", "CA");
//        hashST.put("B", "BA");
//        System.out.println(hashST.get("C"));
//        hashST.print();
    }
}
