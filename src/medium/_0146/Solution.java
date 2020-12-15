package medium._0146;

import java.util.HashMap;

/**
 * Created by fzy at 21:47 on 2020/12/5.
 */
public class Solution {
    class LRUCache {
        HashMap<Integer, Node> map = new HashMap<>();
        Node head = new Node(-1,-1);
        Node tail = new Node(-1,-1);
        int capacity;
        public LRUCache(int capacity) {
            this.capacity = capacity;
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if(map.containsKey(key)){
                Node node = map.get(key);
                node.next.prev = node.prev;
                node.prev.next = node.next;
                moveToHead(node);
                return node.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if(map.containsKey(key)){
                Node node = map.get(key);
                node.val = value;
                map.put(key,node);
                moveToHead(node);
                return;
            }
            if(map.size()==capacity){
                int k = tail.prev.key;
                tail.prev.prev.next = tail;
                tail.prev = tail.prev.prev;
                map.remove(k);
            }
            Node node = new Node(key,value);
            moveToHead(node);
            map.put(key,node);
        }
        public void moveToHead(Node node){
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }
        public class Node{
            int key,val;
            Node prev,next;
            public Node(int key, int val){
                this.key = key;
                this.val = val;
            }
        }
    }

}
