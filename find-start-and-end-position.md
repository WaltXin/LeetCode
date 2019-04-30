# Find Start and End position

```text
Input: [[A, B], [D, A], [E, D], [B, C]]  start:E End: E
```

```java
public void findStartAndEndPos(String[][] posArr) {
    //build two map startMap, endMap
    Map<String, String> startMap = new HashMap<>();
    Map<String, String> endMap = new HashMap<>();
    for (int i = 0; i < posArr.length; i++) {
        String start = posArr[i][0];
        String end = posArr[i][1];
        endMap.put(start, end);
        startMap.put(end, start);
    }
    
    //find the start
    String start = posArr[0][1];
    while (startMap.containsKey(start)) {
        start = startMap.get(start);
    }
    
    String end = posArr[0][0];
    while(endMap.containsKey(end)) {
        end = endMap.get(end);
    }
}
```

