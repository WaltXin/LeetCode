package LeetCode;

public class J66_Plus_One {
    public int[] plusOne(int[] arr) {
        int offset = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int value = arr[i] + offset;
            if (value > 9) {
                arr[i] = 0;
                offset = 1;
            } else {
                arr[i] = value;
                offset = 0;
                break;
            }
        }
        if (offset == 1) {
            arr = new int[arr.length + 1];
            arr[0] = 1;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {9,9,9,9};
        int[] res = new J66_Plus_One().plusOne(arr);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
