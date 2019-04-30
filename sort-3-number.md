# sort 3 number

```java
public int[] sortThreeNum(int[] arr) {
    //sort index 0 with index 1
    //sort index 1 with index 2
    //sort index 0 with index 1
    if (arr[0] > arr[1]) {
        swap(arr, 0, 1);
    }
    if (arr[1] > arr[2]) {
        swap(arr, 1, 2);
    }
    if (arr[0] > arr[1]) {
        swap(arr, 0, 1);
    }
    return arr;
}

private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
```

