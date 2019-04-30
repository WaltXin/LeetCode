# Valid Number-Simple Version

```java
//-256, -0.25, 0.54, 234.7, 0, 8

public boolean validNum(String s) {
    if (s == null || s.length() == 0)
        return false;
    
    boolean dot = false;
    boolean beforeNum = false;
    int i = 0;
    if (s.charAt(i) == '-') {
        i++;
    }
    for (; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == '.' && !dot && beforeNum) {
            dot = true;
        } else if (c >= '0' && c <= '9') {
            beforeNum = true;
        } else {
            return false;
        }
    }
    return true;
}
```

