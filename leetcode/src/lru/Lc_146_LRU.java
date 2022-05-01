/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package lru;

import java.util.HashMap;

/**
 * 在这里编写类的功能描述
 *
 * @author luweiliang
 * @created 2020/4/1
 */
public class Lc_146_LRU {

    class Node{
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, Node> map;
    int mapSize;
    Node head;
    Node tail;


    //HashMpa + 双向链表结构
    public Lc_146_LRU(int mapSize){
        map = new HashMap<>();
        this.mapSize = mapSize;
        this.head = null;
        this.tail = null;
    }
    /**
     * get 操作
     */
    public int get(int key){
        Node node = map.get(key);
        if (node != null) {
            //移动结点到尾部
            moveToTail(node);
            return node.value;
        }
        return -1;
    }

    /**
     * 添加元素
     * 1.元素存在，将元素移动到队尾
     * 2.不存在，判断链表是否满。
     * 如果满，则删除队首元素，放入队尾元素，删除更新哈希表
     * 如果不满，放入队尾元素，更新哈希表
     * @param key
     * @param value
     */
    public void put(int key, int value){
        Node node = map.get(key);
        //不为空
        if (node != null) {
            //更新value
            node.value = value;
            moveToTail(node);
        } else {
            Node newNode = new Node(key, value);
            //链表的容量满，需要删除头结点
            if (map.size() == mapSize) {
                Node delNode = remvoeHead();
                map.remove(delNode.key);
            }
            addNodeToTail(newNode);
            map.put(key, newNode);
        }
    }

    /**
     * 移动结点到尾部
     */
    public void moveToTail(Node node){
        //当前是最后一个结点，不需要处理直接返回
        if (tail == node) return;
        //当前结点是第一个结点，头结点指针指向当前结点的next
        if (head == node) {
            head = node.next;
            head.prev = null;
        } else {
            //双端队列中移除node节点，重新连接node的前后节点，调整双向链表指针
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        //尾结点指向新加的结点
        node.prev = tail;
        node.next = null;
        tail.next = node;
        tail = node;
    }

    /**
     * 删除头结点
     */
    public Node remvoeHead(){
        if (head == null) return head;
        Node res = head;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = res.next;
            head.prev = null;
            res.next = null;
        }
        return res;
    }

    /**
     * 添加到最后一个结点
     */
    public void addNodeToTail(Node newNode) {
        if (newNode == null) return;
        //头结点为空，当前是第一个结点
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            //链接新结点
            tail.next = newNode;
            newNode.prev = tail;
            //更新尾结点指针为新结点
            tail = newNode;
        }
    }

    public static void main(String[] args) {

        Lc_146_LRU cache = new Lc_146_LRU(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));    // 返回  1
        cache.put(3, 3);                     // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));    // 返回 -1 (未找到)
        cache.put(4, 4);                     // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));    // 返回 -1 (未找到)
        System.out.println(cache.get(3));    // 返回  3
        System.out.println(cache.get(4));    // 返回  4

    }
}
