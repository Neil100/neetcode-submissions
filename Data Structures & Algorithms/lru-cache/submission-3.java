class LRUCache {
    int cap;
    Map<Integer, ListNode> map;
    ListNode head, tail;
    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            moveNodeToEnd(map.get(key));
            return map.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(!map.containsKey(key) && map.size()==cap) {
            System.out.println(key);
            ListNode lRU = getLRUNode();
            map.remove(lRU.key);

            removeNode(lRU);

            System.out.println(map.size());
            System.out.println(lRU.val);
        }

        if(map.containsKey(key)) {
                ListNode node = map.get(key);
                node.val = value;
                moveNodeToEnd(node);
        } else {
                ListNode node = new ListNode(value, key);
                map.put(key, node);

                addNodeToEnd(node);
        }
    }

    ListNode getLRUNode() {
        return head.next;
    }

    void moveNodeToEnd(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = tail;
        tail.prev.next = node;
        node.prev = tail.prev;
        tail.prev = node;
    }

    void addNodeToEnd(ListNode node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }

    void removeNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}


class ListNode {
    int val, key;
    ListNode next;
    ListNode prev;

    ListNode(int num, int k) {
        val = num;
        key = k;
        next = null;
        prev = null;
    }
}