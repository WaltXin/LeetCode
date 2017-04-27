package LeetArray;

import java.util.HashMap;
import java.util.Map;

public class J169_Majority_Elements {

	public static void main(String[] args) {
		int[] arr = {2,2,8,8,8,2,2,};
		System.out.println(easySolution(arr));
	}
	
	public static int solution(int[] nums) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for (int i : nums) {
			if (!map.containsKey(i)) {
				map.put(i, 1);
			} else {
				map.put(i, map.get(i) + 1);
			}
		}
		int max = 0;
		int key = 0;
		for (int i : nums) {
			if (map.get(i) > max) {
				max = map.get(i);
				key = i;
			}
		}
		if (max > nums.length / 2) {
			return key;
		} else {
			return -1;	
		}
	}
	
	public static int easySolution(int[] arr) {
		
		int num = arr[0];
		int count = 1;
		
		for (int i = 1; i < arr.length; i++) {
			if (count == 0) {
				count++;
				num = arr[i];
			} else if (num == arr[i]) {
				count++;
			} else count--;
		}
		return num;
		
	}

}
