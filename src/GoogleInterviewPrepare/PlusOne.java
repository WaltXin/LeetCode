package GoogleInterviewPrepare;

public class PlusOne {
    public int[] solution(int[] arr) {

        //valid arr [0,1,9] -> [1,9]
        int zeroIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeroIndex++;
            } else {
                break;
            }
        }
        if (zeroIndex > 0) {
            int[] arr1 = new int[arr.length - zeroIndex];
            for (int i = zeroIndex; i < arr.length; i++) {
                arr1[i - zeroIndex] = arr[i];
            }
            arr = arr1;
        }
        //calculate
        int index = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int sum = arr[i] + index;
            if (sum > 9) {
                index = 1;
                arr[i] = 0;
            } else {
                index = 0;
                arr[i] = sum;
                break;
            }
        }
        //[9,9]
        if (index == 1) {
            int[] res = new int[arr.length + 1];
            res[0] = 1;
            return res;
        } else {
            return arr;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,9,9};
        int[] arr1 = {0,0,1,9};
        int[] res = new PlusOne().solution(arr1);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
