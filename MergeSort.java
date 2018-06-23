package com.gnanavad.compilerete.demo;

import java.util.Arrays;

public class MergeSort {
	public static void sort(int[] values) {
		_mergeSort(values);
		System.out.println(Arrays.toString(values));
	}

	private static void _mergeSort(int[] values) {
		if (values.length == 1) {
			return;
		}
		int halfSize = values.length / 2;

		int[] left = new int[halfSize];
		for (int l = 0; l < left.length; ++l) {
			left[l] = values[l];
		}

		int[] right = new int[values.length - halfSize];
		for (int r = 0; r < right.length; ++r) {
			right[r] = values[halfSize + r];
		}

		_mergeSort(left);
		_mergeSort(right);

		_merge(values, left, right);
	}

	private static void _merge(int[] values, int[] left, int[] right) {
		int leftIndex = 0, rightIndex = 0, sortedIndex = 0;
		int leftSize = left.length;
		int rightSize = right.length;
		while (leftIndex < leftSize && rightIndex < rightSize) {
			if (left[leftIndex] < right[rightIndex]) {
				values[sortedIndex] = left[leftIndex];
				leftIndex++;
			} else {
				values[sortedIndex] = right[rightIndex];
				rightIndex++;
			}
			sortedIndex++;
		}

		while (leftIndex < leftSize) {
			values[sortedIndex] = left[leftIndex];
			leftIndex++;
			sortedIndex++;
		}

		while (rightIndex < rightSize) {
			values[sortedIndex] = right[rightIndex];
			rightIndex++;
			sortedIndex++;
		}
	}

	public static void main(String[] args) {
		int[] values = new int[] { 10, 4, 8, 2, 6, 1, 0, 5, 3, 7, 9 };
		MergeSort.sort(values);
	}
}
