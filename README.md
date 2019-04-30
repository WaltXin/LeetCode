# LRU-Simply Version

```text
class LRU {
    void put(String k, int v);
    int getLast();
    void get(String s);
}
```

```java
class LRU {
    class Node {
        int val;
        Node prev;
        Node next;
        Node(int val) {
            this.val = val;
            prev = null;
            next = null;
        }
    }

    Node last;
    Map<String, Node> map;
    LRU() {
        last = null;
        map = new HashMap<>();
    }

    public void put(String s, int val) {
        Node curr = null;
        if (map.containsKey(s)) {
            curr = map.get(s);
            if (curr != last)
                moveToLast(curr);
            curr.val = val;
            //move curr into head;

        } else {
            curr = new Node(val);
            if (last == null) {
                //if first time need init
                last = curr;
            } else {
                curr.next = last;
                last.prev = curr;
                last = curr;
            }
        }
        map.put(s, curr);
    }

    public int get(String s) {
        if (map.containsKey(s)) {
            int val = map.get(s).val;
            moveToLast(map.get(s));
            return val;
        } else {
            return -1;
        }
    }

    public int getLast() {
        return map.get(last).val;
    }

    public void moveToLast(Node node) {
        if (node != last) {
            if (node.next == null) {
                node.prev.next = null;
            } else {

                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            node.prev = null;
            node.next = last;
            last.prev = node;
            last = last.prev;
        }
    }

    public static void main(String[] args) {
        LRU cache = new LRU();
        cache.put("2", 1);

        cache.put("1", 2);
        cache.printHelper();
        cache.put("2", 2);
        cache.put("4", 1);

        cache.get("1");
        System.out.println(cache.get("2"));
    }
}

```

