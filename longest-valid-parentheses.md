---
description: "'(())()(()'\_return one valid parentheses with least deletion."
---

# Longest Valid Parentheses

```java
public String validParentheses(String s) {
    if (s == null || s.length() == 0)
        return s;
    
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == '(') {
            stack.push(i);
        } else {
            if (stack.isEmpty() || s.charAt(stack.peek()) != '(') {
                stack.push(i);
            } else {
                stack.pop();
            }
        }
    }
    if (stack.isEmpty()) {
        return s;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = s.length() - 1; i >= 0; i--) {
        if (stack.isEmpty() || stack.peek() != i) {
            sb.insert(0, s.charAt(i));
        } else {
            stack.pop();
        }
    }
    return sb.toString();
}
```

