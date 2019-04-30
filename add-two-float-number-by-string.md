# Add two float number by string

```java
//3.045 + 2.99 = 6.035

public String addFloat(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }

        //get a's decimal and b's decimal
        int aDecimal =  getDecimal(a);
        int bDecimal =  getDecimal(b);
        int diff = Math.abs(aDecimal - bDecimal);
        if (aDecimal == 0) {
            a += ".";
        }
        if (bDecimal == 0) {
            b += ".";
        }
        int i = a.length() - 1;
        int j = b.length() - 1;
        if (aDecimal > bDecimal) {
            j += diff;
        }
        if (bDecimal > aDecimal) {
            i += diff;
        }
        int carry = 0;

        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int v1 = 0;
            int v2 = 0;
            if (i >= 0) {
                if (i <= a.length() - 1) {
                    if (a.charAt(i) != '.') {
                        v1 = a.charAt(i) - '0';
                    } else {
                        sb.append(".");
                        i--;
                        j--;
                        continue;
                    }
                }
                i--;
            }
            if (j >= 0) {
                if (j <= b.length() - 1) {
                    v2 = b.charAt(j) - '0';
                }
                j--;
            }
            int sum = v1 + v2 + carry;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            sb.append(sum);
        }
        if (carry == 1) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }

    private int getDecimal(String a) {
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(a.length() - 1 - i) == '.') {
                return i;
            }
        }
        return 0;
    }
```

