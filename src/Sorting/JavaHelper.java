package Sorting;

import java.util.Random;

public class JavaHelper {
	public static <E> void printArray(E[] inputArray) {
		for (E element:inputArray) {
			System.out.printf("%s ", element);
		}
		System.out.println();
	}

	public static void printArray(int[] inputArray) {
		for (int element:inputArray) {
			System.out.printf("%s ", element);
		}
		System.out.println();
	}
	
	public static int[] arrayGenerator(int number, int rangeL, int rangeR) {
		int[] arr = new int[number];
		Random random = new Random();
		for (int i = 0; i < number; i++) {
			int randomNum = random.nextInt((rangeR - rangeL) + 1) + rangeL;
			arr[i] = randomNum;
		}
		return arr;
	}
	
}
