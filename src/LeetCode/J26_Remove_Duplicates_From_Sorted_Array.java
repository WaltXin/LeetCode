package LeetCode;

public class J26_Remove_Duplicates_From_Sorted_Array {
    public int removeDuplicate(int[] arr) {
        if (arr.length == 0) return 0;

        int currInt = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != currInt) {
                currInt = arr[i];
                //swap arr[i] and arr[count] if i != count
                if (i != count) {
                    int tem = arr[i];
                    arr[i] = arr[count];
                    arr[count] = tem;
                }
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr1 = {0,1,2};
        int[] arr2 = {0,1,1,2};
        int[] arr3 = {0,0,1,1,1,2,2,2};
        System.out.println(new J26_Remove_Duplicates_From_Sorted_Array().removeDuplicate(arr1));
        System.out.println(new J26_Remove_Duplicates_From_Sorted_Array().removeDuplicate(arr2));
        System.out.println(new J26_Remove_Duplicates_From_Sorted_Array().removeDuplicate(arr3));
    }
}
