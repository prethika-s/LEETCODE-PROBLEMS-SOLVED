public class Node {
    public int val ;
    public Node next;
    public Node(int val){
        this.val = val;
    }
    public Node(int val , Node next){
        this.val = val;
        this.next = next;
    }
}
class Skiplist {
 private Node[] buckets;
    private int size;
    private int cap;
    private static final int Capacity = 8;
    private static final double Lower_Limit = 0.25;
    private static final double Upper_Limit = 0.75;
    public Skiplist() {
         this.size = 0;
        this.cap = Capacity;
        this.buckets = new Node[cap];
    }
    
    public boolean search(int key) {
         for (int i = 0; i < cap; i++) {
            if (contain(i, key)) {
                return true;
            }
        }
        return false;
    }
    
    public void add(int key) {
        int i = 0;
        while (i < cap) {
            if (!contain(i, key)) {
                break;
            }
            i++;
        }
        if (i == cap) {
            return;
        }
        if (buckets[i] == null) {
            buckets[i] = new Node(key);
            size++;
            if ((double) size / cap > Upper_Limit) {
                resize(2 * cap);
            }
            return;
        }
        if (buckets[i].val > key) { // if element at the head greater to the given key so add at head.
            buckets[i] = new Node(key, buckets[i]);
            size++;
            if ((double) size / cap > Upper_Limit) {
                resize(2 * cap);
            }
            return;
        }
        Node head = buckets[i];
        Node temp = new Node(key);
        while (head.next != null) {
            if (head.next.val > key) {
                break;
            }
            head = head.next;
        }
        temp.next = head.next;
        head.next = temp;
        size++;
        if ((double) size / cap > Upper_Limit) {
            resize(2 * cap);
        }
        return;
    }

    
   public boolean erase(int key) {
        int i = cap - 1;
        while (i >= 0) {
            if (contain(i, key)) {
                break;
            }
            i--;
        }
        if(i  == -1)return false;
        Node head = buckets[i];
        Node prev = null;
        while (head != null) {
            if (head.val == key) {
                if (prev == null) {
                    buckets[i] = buckets[i].next;
                } else {
                    prev.next = head.next;
                }
                size--;
                if ((double) size / cap < Lower_Limit && cap > Capacity) {
                    resize(cap / 2);
                }
                return true;
            }
            prev = head;
            head = head.next;
        }
        return false;
    }

     private boolean contain(int idx, int key) {
        Node head = buckets[idx];
        while (head != null) {
            if (head.val == key) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
    private void resize(int newcap) {
        int oldcap = cap;
        Node[] oldbucket = buckets;
        cap = newcap;
        buckets = new Node[cap];
        size = 0;
        for (int i = 0; i < oldcap; i++) {
            Node head = oldbucket[i];
            while (head != null) {
                add(head.val);
                head = head.next;
            }
        }
        return;
    }

}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */