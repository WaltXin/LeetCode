package LeetCode;

public class J108_Covert_Sorted_Array_To_BinarySearchTree {
    public TreeNode sortedArrayToBST(int[] arr) {
        if (arr.length == 0) return null;
        return toTree(arr, 0, arr.length - 1);
    }

    public TreeNode toTree(int[] arr, int begin, int end) {
        if (begin > end) return null;
        int mid = (begin + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = toTree(arr, 0, mid - 1);
        node.right = toTree(arr, mid + 1, end);
        return node;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        TreeNode tree = new J108_Covert_Sorted_Array_To_BinarySearchTree().sortedArrayToBST(arr);
        System.out.println();
    }
}
