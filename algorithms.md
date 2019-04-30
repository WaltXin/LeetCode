# Split an array into two equal Sum subarrays

```java
//{4, 1, 2, 3} -> {4,1}  {2,3}
public void splitTwoEqualSumSubArray(int[] arr) {
    //get presum from left to right;
    int[] presum = new int[arr.length];
    presum[0] = arr[0];
    for (int i = 1; i < arr.length; i++) {
        presum[i] = arr[i] + presum[i - 1];
    }
    //from right to left check if exist sub array match 
    //arr[0, i - 1] == arr[i, length - 1]
    int sum = 0;
    int splitPoint = -1;
    for (int i = arr.length - 1; i > 0; i--) {
        sum += arr[i];
        if (sum == presum[i - 1]) {
            splitPoint = i - 1;
        }
    }
    if (splitPoint == -1) {
        return;
    }
       
    //[0, splitpoint] is left subarray
    //[splitpoint, arr.length - 1] is right subarray
    int[] left = Arrays.copyOfRange(arr, 0, splitPoint + 1);
    int[] right = Arrays.copyOfRange(arr, splitPoint + 1, arr.length);
   
}
```



