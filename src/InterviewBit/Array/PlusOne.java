package InterviewBit.Array;

public class PlusOne {
    public int[] plusOne(int[] A) {
        //because A can be invalid initial, so need valid array A
        A = validArr(A);
        int offset = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            int sum = A[i] + offset;
            if (sum > 9) {
                A[i] = 0;
                offset = 1;
            } else {
                A[i] = sum;
                offset = 0;
                break;
            }
        }
        if (offset == 1) {
            int[] res = new int[A.length + 1];
            res[0] = 1;
            return res;
        } else {
            return A;
        }

    }

    public int[] validArr(int[] A) {
        //[0,1,2] -> [1,2]
        //count prefix zero
        int prefix = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                prefix++;
            } else {
                break;
            }
        }

        if (prefix == 0) {
            return A;
        } else {
            int[] res = new int[A.length - prefix];
            for (int i = prefix; i < A.length; i++) {
                res[i - prefix] = A[i];
            }
            return res;
        }

    }
}