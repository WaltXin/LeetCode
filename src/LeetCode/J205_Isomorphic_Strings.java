package LeetCode;

import java.util.*;

public class J205_Isomorphic_Strings {
	
	public boolean isIsomorphic(String s, String t) {
		if (s == null || s.length() <= 1) return true;
		Map<Character, Character> map = new HashMap<Character,Character>();
		
		for (int i = 0; i < s.length(); i++) {
			char a = s.charAt(i);
			char b = t.charAt(i);
			if (map.containsKey(a)) {
				if (map.get(a).equals(b)) {
					continue;
				} else {
					return false;
				}
			} else {
				if (!map.containsKey(b)) {
					map.put(a, b);
				} else {
					return false;
				}
			}
		}
        return true;
    }
}
