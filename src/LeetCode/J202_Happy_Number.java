package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class J202_Happy_Number {
	public static void main(String[] args) {
		int num = 81;
		System.out.println(solution(num));

	}
	
	/*
	 * 4.33%  Very low
	 * **/
	public static boolean solution(int num) {
		Set set = new HashSet();
		while (num > 1) {
			String s = num + "";
			int tem = 0;
			for (int i = 0; i < s.length(); i++) {
				int in = Integer.parseInt(s.charAt(i) +"");
				tem += Math.pow(in, 2);
			}
			
			if(set.contains(tem)) return false;
			set.add(tem);
			//System.out.println(tem);
			num = tem;
		}
		return true;
	}
	


}

