package lc146;

public class LRUCache {
    Node dummyHead;
    Node dummyTail;
    int size;
    int limit;
    Map<Integer,Node> map;

    public LRUCache(int capacity) {
        this.limit = capacity;
        this.size = 0;
        this.dummyHead = new Node();
        this.dummyTail = new Node();
        this.map = new HashMap<>();
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node cur = map.get(key);
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;

        cur.next = dummyHead.next;
        dummyHead.next.pre = cur;
        cur.pre = dummyHead;
        dummyHead.next = cur;

        return cur.value;
    }
    
    public void put(int key, int value) {
        Node cur;
        if(map.containsKey(key)){
            cur = map.get(key);
            cur.value = value;
            cur.pre.next = cur.next;
            cur.next.pre = cur.pre;
        }else{
            cur = new Node();
            cur.value = value;
            cur.key = key;
            size++;
        }

        map.put(key,cur);

        cur.next = dummyHead.next;
        dummyHead.next.pre = cur;
        cur.pre = dummyHead;
        dummyHead.next = cur;

        if(size > limit){
            Node realTail = dummyTail.pre;
            realTail.pre.next = dummyTail;
            dummyTail.pre = realTail.pre;
            map.remove(realTail.key);
            realTail.next = null;
            realTail.pre = null;
            size--;
        }
    }

    class Node{
        Node pre;
        Node next;
        int value;
        int key;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */