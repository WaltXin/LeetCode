# Find the common ancestor\(contains parents node\)

```java
//Find the common ancestor, the node has parent and child
class Node {
    Node parent;
    Node child;
}

public Node findCommonAncestor(Node n1, Node n2) {
    int l1 = getLength(n1);
    int l2 = getLength(n2);
    int diff = Math.abs(l1 - l2);
    if (diff > 0) {
        if (l1 > l2) {
            n1 = move(n1, diff);
        } else {
            n2 = move(n2, diff);
        }
    }
    while (n1 != null) {
        if (n1 == n2) {
            return n1;
        }
        n1 = n1.parent;
        n2 = n2.parent;
    }
    return null;
}

private Node move(Node n1, int diff) {
    Node temp = n1;
    while (diff > 0) {
        temp = temp.parent;
    }
    return temp;
}
```

