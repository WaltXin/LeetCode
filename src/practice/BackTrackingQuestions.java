package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTrackingQuestions {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        List<Integer> curr = new ArrayList<>();

        dfs(nums, visited, curr, res);

        return res;
    }
    public void dfs(int[] nums, boolean[] visited, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() >= nums.length) {
            List<Integer> copyArr = new ArrayList<Integer>(curr);
            res.add(copyArr);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == false) {
                curr.add(nums[i]);
                visited[i] = true;
                dfs(nums, visited, curr, res);
                //clean visited information
                visited[i] = false;
                //remove last one
                curr.remove(curr.size() - 1);
            }
        }
    }

    public String getPermutation(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        boolean[] visited = new boolean[n];

        dfs(nums, visited, k, curr, res);

        List<Integer> resList = res.get(res.size() - 1);
        StringBuilder sb = new StringBuilder();
        for (int i : resList) {
            sb.append(i);
        }
        return sb.toString();

    }

    public void dfs(int[] nums, boolean[] visited, int k, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() >= nums.length || res.size() > k) {
            List<Integer> currCopy = new ArrayList<Integer>(curr);
            res.add(currCopy);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                curr.add(nums[i]);
                dfs(nums, visited, k, curr, res);
                visited[i] = false;
                curr.remove(curr.size() - 1);
            }
        }
    }

    /**
     *
     * Combination
     * */

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        dfs(res, curr, candidates, target, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> curr, int[] candidates, int target, int index) {
        if (target <= 0) {
            if (target == 0) {
                List<Integer> currCopy = new ArrayList<Integer>(curr);
                res.add(currCopy);
            }
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            curr.add(candidates[i]);
            System.out.println(++index);
            System.out.println(i + 1);
            dfs(res, curr, candidates, target - candidates[i], i + 1);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        //String s = new BackTrackingQuestions().getPermutation(3,3);
        //System.out.println(s);
        int[] arr = {10,1,2,7,6,1,5};
        new BackTrackingQuestions().combinationSum2(arr, 8);
    }
}
