package LeetCodeSortingQuestion;

public class J179_Largest_Number {

	public static void main(String[] args) {
		int[] arr = {0,0};
		System.out.println(LargestNum(arr));
	}
	
	public static String LargestNum(int[] arr) {
		//Actually is a sort question, sort by arr[i]'s first number
		//Insert sort
		boolean allZero = true;
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				String jStr = arr[j] + "";
				String jmStr = arr[j - 1] + "";
				String jFStr = jStr+jmStr;
				String jSStr = jmStr + jStr;
				if (Long.parseLong(jFStr) > Long.parseLong(jSStr)) {
					int tem = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = tem;
				} else {
					break;
				}
				
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i:arr) {
			if (i != 0) {
				allZero = false;
			}
			sb.append(i);
		}
		if (allZero == true) {
			return "0";
		}else {
		return sb.toString();
		}
		
	}

}
