package com.teamsonia;
import com.teamsonia.Shape;
import java.util.Arrays;
import java.util.Comparator;

public class UtilitySort {

public static Shape[] bubbleSort(Shape[] array, Comparator<Shape> comparator) {	        int n = array.length;
	        boolean swapped; 

	        for (int i = 0; i < n - 1; i++) {
	            swapped = false;
	            
	            for (int j = 0; j < n - i - 1; j++) {
	                if (array[j].getVolume() > array[j + 1].getVolume()) {
	                    
	                    Shape temp = array[j];
	                    array[j] = array[j + 1];
	                    array[j + 1] = temp;
	                    swapped = true;
	                }
	            }

	            if (!swapped) {
	                break;
	            }
	        }
	        
	        return array;  
	    }
	    
	    public static Shape[] insertionSort(Shape[] array, Comparator<Shape> comparator) {
	        int n = array.length;
	        for (int i = 1; i < n; ++i) {
	            Shape key = array[i];
	            double keyVolume = key.getVolume();

	            int j = i - 1;

	            while (j >= 0 && array[j].getVolume() > keyVolume) {
	                array[j + 1] = array[j];
	                j = j - 1;
	            }
	            array[j + 1] = key;
	        }
	        return array;
	    }
	    
	    public static Shape[] selectionSort(Shape[] array, Comparator<Shape> comparator) {
	        int n = array.length;

	        for (int i = 0; i < n - 1; i++) {
	            int minIdx = i;
	            for (int j = i + 1; j < n; j++) {
	                if (array[j].getVolume() < array[minIdx].getVolume()) {
	                    minIdx = j;
	                }
	            }

	            Shape temp = array[minIdx];
	            array[minIdx] = array[i];
	            array[i] = temp;
	        }
	        return array;
	        
	        
	    }
	    public static Shape[] mergeSort(Shape[] array, Comparator<Shape> comparator) {
	        if (array.length <= 1) {
	            return array; 
	        }

	        int mid = array.length / 2;
	        Shape[] left = new Shape[mid];
	        Shape[] right = new Shape[array.length - mid];

	        System.arraycopy(array, 0, left, 0, mid);
	        System.arraycopy(array, mid, right, 0, array.length - mid);

	        left = mergeSort(left, comparator);
	        right = mergeSort(right, comparator);

	        return merge(left, right, comparator);
	    }

	    private static Shape[] merge(Shape[] left, Shape[] right, Comparator<Shape> comparator) {
	        Shape[] merged = new Shape[left.length + right.length];
	        int i = 0, j = 0, k = 0;

	        while (i < left.length && j < right.length) {
	            if (left[i].getVolume() <= right[j].getVolume()) {
	                merged[k++] = left[i++];
	            } else {
	                merged[k++] = right[j++];
	            }
	        }

	        while (i < left.length) {
	            merged[k++] = left[i++];
	        }

	        while (j < right.length) {
	            merged[k++] = right[j++];
	        }

	        return merged;
	    }

	public static Shape[] quickSort(Shape[] array, Comparator<Shape> comparator) {
		quickSort(array, 0, array.length - 1, comparator);
		return array;
	}

	private static void quickSort(Shape[] array, int low, int high, Comparator<Shape> comparator) {
		if (low < high) {
			int pivotIndex = partition(array, low, high);

			quickSort(array, low, pivotIndex, comparator);
			quickSort(array, pivotIndex + 1, high, comparator);
		}
	}

	    private static int partition(Shape[] array, int low, int high) {
	        Shape pivot = array[low];
	        int left = low;
	        int right = high;

	        while (true) {
	            while (array[left].getVolume() < pivot.getVolume() && left < high) {
	                left++;
	            }

	            while (array[right].getVolume() > pivot.getVolume() && right > low) {
	                right--;
	            }

	            if (left < right) {
	                Shape temp = array[left];
	                array[left] = array[right];
	                array[right] = temp;
	            } else {
	                return right;
	            }
	        }
	    }
	    
	    static double getMaxVolume(Shape arr[], int n) {
	        double mx = arr[0].getVolume();
	        for (int i = 1; i < n; i++)
	            if (arr[i].getVolume() > mx)
	                mx = arr[i].getVolume();
	        return mx;
	    }

	    static void countingSort(Shape arr[], int n, int exp) {
	        Shape output[] = new Shape[n]; 
	        int count[] = new int[10];
	        Arrays.fill(count, 0);

	        for (int i = 0; i < n; i++)
	            count[(int)(arr[i].getVolume() * exp) % 10]++;

	        for (int i = 1; i < 10; i++)
	            count[i] += count[i - 1];

	        for (int i = n - 1; i >= 0; i--) {
	            output[count[(int)(arr[i].getVolume() * exp) % 10] - 1] = arr[i];
	            count[(int)(arr[i].getVolume() * exp) % 10]--;
	        }

	        for (int i = 0; i < n; i++)
	            arr[i] = output[i];
	    }

	    public static Shape[] radixSort(Shape arr[], int n, Comparator<Shape> comparator) {

	        double m = getMaxVolume(arr, n);

	        int digits = (int)Math.ceil(Math.log10(m + 1));

	        int exp = (int)Math.pow(10, digits);

	        for (int i = 1; i <= exp; i *= 10)
	            countingSort(arr, n, i);

	        return arr;
	    }

	    public static void main(String[] args) {
	        Shape[] array = {/* ... populate with shape objects ... */};
	        int n = array.length;
	        radixSort(array, n, null);
	        System.out.println(Arrays.toString(array));
	    }
	    
	    
}
	
	


