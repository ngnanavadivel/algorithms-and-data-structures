package com.gnanavad.dsa;

import java.util.Comparator;

public class QuickSort {

	// QuickSort API - for arrays of all 7 primitive types
	// in java except boolean.

	public static void sort(byte[] values) {
		QuickSortPrimitives_Byte.sort(values);
	}

	public static void sort(short[] values) {
		QuickSortPrimitives_Short.sort(values);
	}

	public static void sort(int[] values) {
		QuickSortPrimitives_Int.sort(values);
	}

	public static void sort(long[] values) {
		QuickSortPrimitives_Long.sort(values);
	}

	public static void sort(float[] values) {
		QuickSortPrimitives_Float.sort(values);
	}

	public static void sort(double[] values) {
		QuickSortPrimitives_Double.sort(values);
	}

	public static void sort(char[] values) {
		QuickSortPrimitives_Char.sort(values);
	}

	// QuickSort API for arrays of POJOs which doesn't implement Comparable
	// interface.
	// Hence, appropriate Comparator has to be supplied as one of the inputs.
	public static <T> void sort(T[] values, Comparator<? super T> comparator) {
		QuickSortNonPrimitives_ExternalComparator.sort(values, comparator);
	}

	// QuickSort API for arrays of Boxed Types and POJOs that are Comparable.
	public static <T extends Comparable<T>> void sort(T[] values) {
		QuickSortNonPrimitives_ImplicitComparator.sort(values);
	}

	private static void validateInputArray(Object values) {
		if (values == null) {
			throw new IllegalArgumentException("Input array is null.");
		}
	}

	/*
	 * Implementation of QuickSort encapsulated in a class of their own for each
	 * variant of input types.
	 **/

	// Both the NonPrimitive versions of QuickSort shares the same swap() logic
	// and hence the base class.
	private static abstract class QuickSortNonPrimitives {
		protected static <T> void swap(T[] values, int i, int partitionIndex) {
			T tmp = values[i];
			values[i] = values[partitionIndex];
			values[partitionIndex] = tmp;
		}
	}

	private static class QuickSortNonPrimitives_ImplicitComparator extends QuickSortNonPrimitives {

		public static <T extends Comparable<T>> void sort(T[] values) {
			validateInputArray(values);
			quickSort(values, 0, values.length - 1);
		}

		private static <T extends Comparable<T>> void quickSort(T[] values, int start, int end) {
			if (start < end) {
				int partitionIndex = partition(values, start, end);
				quickSort(values, 0, partitionIndex - 1);
				quickSort(values, partitionIndex + 1, end);
			}
		}

		private static <T extends Comparable<T>> int partition(T[] values, int start, int end) {
			T pivot = values[end];
			int partitionIndex = 0;
			for (int i = 0; i < end; ++i) {
				if (values[i] != null) {
					if (((Comparable<T>) values[i]).compareTo(pivot) <= 0) {
						swap(values, i, partitionIndex);
					}
				}
			}
			// swap the pivot.
			swap(values, partitionIndex, end);
			return partitionIndex;
		}

	}

	private static class QuickSortNonPrimitives_ExternalComparator extends QuickSortNonPrimitives {

		public static <T> void sort(T[] values, Comparator<? super T> comparator) {
			validateInputArray(values);
			quickSort(values, 0, values.length - 1, comparator);
		}

		private static <T> void quickSort(T[] values, int start, int end, Comparator<? super T> comparator) {
			if (start < end) {
				int partitionIndex = partition(values, start, end, comparator);
				quickSort(values, 0, partitionIndex - 1, comparator);
				quickSort(values, partitionIndex + 1, end, comparator);
			}
		}

		private static <T> int partition(T[] values, int start, int end, Comparator<? super T> comparator) {
			T pivot = values[end];
			int partitionIndex = 0;
			for (int i = 0; i < end; ++i) {
				if (comparator != null) {
					if (comparator.compare(values[i], pivot) <= 0) {
						swap(values, i, partitionIndex);
					}
				}
			}
			// swap the pivot.
			swap(values, partitionIndex, end);
			return partitionIndex;
		}

	}

	private static class QuickSortPrimitives_Int {

		public static void sort(int[] values) {
			validateInputArray(values);
			quickSort(values, 0, values.length - 1);
		}

		private static void quickSort(int[] values, int start, int end) {
			if (start < end) {
				int partitionIndex = partition(values, start, end);
				quickSort(values, 0, partitionIndex - 1);
				quickSort(values, partitionIndex + 1, end);
			}
		}

		private static int partition(int[] values, int start, int end) {
			int partitionIndex = 0;
			int pivot = values[end];
			for (int i = 0; i < end; i++) {
				// move the small ones to the left of partitionIndex.
				if (values[i] < pivot) {
					swap(values, partitionIndex, i);
					partitionIndex++;
				}
			}
			// swap the pivot.
			swap(values, partitionIndex, end);
			return partitionIndex;
		}

		private static void swap(int[] values, int index1, int index2) {
			int tmp = values[index1];
			values[index1] = values[index2];
			values[index2] = tmp;
		}
	}

	private static class QuickSortPrimitives_Short {

		public static void sort(short[] values) {
			validateInputArray(values);
			quickSort(values, 0, values.length - 1);
		}

		private static void quickSort(short[] values, int start, int end) {
			if (start < end) {
				int partitionIndex = partition(values, start, end);
				quickSort(values, 0, partitionIndex - 1);
				quickSort(values, partitionIndex + 1, end);
			}
		}

		private static int partition(short[] values, int start, int end) {
			int partitionIndex = 0;
			short pivot = values[end];
			for (int i = 0; i < end; i++) {
				// move the small ones to the left of partitionIndex.
				if (values[i] < pivot) {
					swap(values, partitionIndex, i);
					partitionIndex++;
				}
			}
			// swap the pivot.
			swap(values, partitionIndex, end);
			return partitionIndex;
		}

		private static void swap(short[] values, int index1, int index2) {
			short tmp = values[index1];
			values[index1] = values[index2];
			values[index2] = tmp;
		}
	}

	private static class QuickSortPrimitives_Float {

		public static void sort(float[] values) {
			validateInputArray(values);
			quickSort(values, 0, values.length - 1);

		}

		private static void quickSort(float[] values, int start, int end) {
			if (start < end) {
				int partitionIndex = partition(values, start, end);
				quickSort(values, 0, partitionIndex - 1);
				quickSort(values, partitionIndex + 1, end);
			}
		}

		private static int partition(float[] values, int start, int end) {
			int partitionIndex = 0;
			float pivot = values[end];
			for (int i = 0; i < end; i++) {
				// move the small ones to the left of partitionIndex.
				if (values[i] < pivot) {
					swap(values, partitionIndex, i);
					partitionIndex++;
				}
			}
			// swap the pivot.
			swap(values, partitionIndex, end);
			return partitionIndex;
		}

		private static void swap(float[] values, int index1, int index2) {
			float tmp = values[index1];
			values[index1] = values[index2];
			values[index2] = tmp;
		}
	}

	private static class QuickSortPrimitives_Double {

		public static void sort(double[] values) {
			validateInputArray(values);
			quickSort(values, 0, values.length - 1);

		}

		private static void quickSort(double[] values, int start, int end) {
			if (start < end) {
				int partitionIndex = partition(values, start, end);
				quickSort(values, 0, partitionIndex - 1);
				quickSort(values, partitionIndex + 1, end);
			}
		}

		private static int partition(double[] values, int start, int end) {
			int partitionIndex = 0;
			double pivot = values[end];
			for (int i = 0; i < end; i++) {
				// move the small ones to the left of partitionIndex.
				if (values[i] < pivot) {
					swap(values, partitionIndex, i);
					partitionIndex++;
				}
			}
			// swap the pivot.
			swap(values, partitionIndex, end);
			return partitionIndex;
		}

		private static void swap(double[] values, int index1, int index2) {
			double tmp = values[index1];
			values[index1] = values[index2];
			values[index2] = tmp;
		}
	}

	private static class QuickSortPrimitives_Char {

		public static void sort(char[] values) {
			validateInputArray(values);
			quickSort(values, 0, values.length - 1);

		}

		private static void quickSort(char[] values, int start, int end) {
			if (start < end) {
				int partitionIndex = partition(values, start, end);
				quickSort(values, 0, partitionIndex - 1);
				quickSort(values, partitionIndex + 1, end);
			}
		}

		private static int partition(char[] values, int start, int end) {
			int partitionIndex = 0;
			double pivot = values[end];
			for (int i = 0; i < end; i++) {
				// move the small ones to the left of partitionIndex.
				if (values[i] < pivot) {
					swap(values, partitionIndex, i);
					partitionIndex++;
				}
			}
			// swap the pivot.
			swap(values, partitionIndex, end);
			return partitionIndex;
		}

		private static void swap(char[] values, int index1, int index2) {
			char tmp = values[index1];
			values[index1] = values[index2];
			values[index2] = tmp;
		}
	}

	private static class QuickSortPrimitives_Byte {

		public static void sort(byte[] values) {
			validateInputArray(values);
			quickSort(values, 0, values.length - 1);

		}

		private static void quickSort(byte[] values, int start, int end) {
			if (start < end) {
				int partitionIndex = partition(values, start, end);
				quickSort(values, 0, partitionIndex - 1);
				quickSort(values, partitionIndex + 1, end);
			}
		}

		private static int partition(byte[] values, int start, int end) {
			int partitionIndex = 0;
			byte pivot = values[end];
			for (int i = 0; i < end; i++) {
				// move the small ones to the left of partitionIndex.
				if (values[i] < pivot) {
					swap(values, partitionIndex, i);
					partitionIndex++;
				}
			}
			// swap the pivot.
			swap(values, partitionIndex, end);
			return partitionIndex;
		}

		private static void swap(byte[] values, int index1, int index2) {
			byte tmp = values[index1];
			values[index1] = values[index2];
			values[index2] = tmp;
		}
	}

	private static class QuickSortPrimitives_Long {

		public static void sort(long[] values) {
			validateInputArray(values);
			quickSort(values, 0, values.length - 1);
		}

		private static void quickSort(long[] values, int start, int end) {
			if (start < end) {
				int partitionIndex = partition(values, start, end);
				quickSort(values, 0, partitionIndex - 1);
				quickSort(values, partitionIndex + 1, end);
			}
		}

		private static int partition(long[] values, int start, int end) {
			int partitionIndex = 0;
			double pivot = values[end];
			for (int i = 0; i < end; i++) {
				// move the small ones to the left of partitionIndex.
				if (values[i] < pivot) {
					swap(values, partitionIndex, i);
					partitionIndex++;
				}
			}
			// swap the pivot.
			swap(values, partitionIndex, end);
			return partitionIndex;
		}

		private static void swap(long[] values, int index1, int index2) {
			long tmp = values[index1];
			values[index1] = values[index2];
			values[index2] = tmp;
		}
	}

}
