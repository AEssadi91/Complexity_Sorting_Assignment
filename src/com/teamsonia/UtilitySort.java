package com.teamsonia;

import java.util.Arrays;

public class UtilitySort {

	    public static Shape[] bubbleSort(Shape[] shapes) {
	        int n = shapes.length;
	        boolean swapped;
	        
	        for (int i = 0; i < n - 1; i++) {
	            swapped = false;
	            
	            for (int j = 0; j < n - i - 1; j++) {
	                if (shapes[j].getVolume() > shapes[j + 1].getVolume()) {
	                    
	                    Shape temp = shapes[j];
	                    shapes[j] = shapes[j + 1];
	                    shapes[j + 1] = temp;
	                    swapped = true;
	                }
	            }

	            if (!swapped) {
	                break;
	            }
	        }
	        
	        return shapes;  
	    }
	    
	    public static Shape[] insertionSort(Shape[] shapes) {
	        int n = shapes.length;
	        for (int i = 1; i < n; ++i) {
	            Shape key = shapes[i];
	            double keyVolume = key.getVolume();

	            int j = i - 1;

	            while (j >= 0 && shapes[j].getVolume() > keyVolume) {
	                shapes[j + 1] = shapes[j];
	                j = j - 1;
	            }
	            shapes[j + 1] = key;
	        }
	        return shapes;
	    }
	    
	    public static Shape[] selectionSort(Shape[] shapes) {
	        int n = shapes.length;

	        for (int i = 0; i < n - 1; i++) {
	            int minIdx = i;
	            for (int j = i + 1; j < n; j++) {
	                if (shapes[j].getVolume() < shapes[minIdx].getVolume()) {
	                    minIdx = j;
	                }
	            }

	            Shape temp = shapes[minIdx];
	            shapes[minIdx] = shapes[i];
	            shapes[i] = temp;
	        }
	        return shapes;
	        
	        
	    }
	    public static Shape[] mergeSort(Shape[] shapes) {
	        if (shapes.length <= 1) {
	            return shapes; 
	        }

	        int mid = shapes.length / 2;
	        Shape[] left = new Shape[mid];
	        Shape[] right = new Shape[shapes.length - mid];

	        System.arraycopy(shapes, 0, left, 0, mid);
	        System.arraycopy(shapes, mid, right, 0, shapes.length - mid);

	        left = mergeSort(left);
	        right = mergeSort(right);

	        return merge(left, right);
	    }

	    private static Shape[] merge(Shape[] left, Shape[] right) {
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

	    public static Shape[] quickSort(Shape[] shapes) {
	        quickSort(shapes, 0, shapes.length - 1);
	        return shapes;
	    }

	    private static void quickSort(Shape[] shapes, int low, int high) {
	        if (low < high) {
	            int pivotIndex = partition(shapes, low, high);

	            quickSort(shapes, low, pivotIndex);
	            quickSort(shapes, pivotIndex + 1, high);
	        }
	    }

	    private static int partition(Shape[] shapes, int low, int high) {
	        Shape pivot = shapes[low];
	        int left = low;
	        int right = high;

	        while (true) {
	            while (shapes[left].getVolume() < pivot.getVolume() && left < high) {
	                left++;
	            }

	            while (shapes[right].getVolume() > pivot.getVolume() && right > low) {
	                right--;
	            }

	            if (left < right) {
	                Shape temp = shapes[left];
	                shapes[left] = shapes[right];
	                shapes[right] = temp;
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

	    public static Shape[] radixSort(Shape arr[], int n) {

	        double m = getMaxVolume(arr, n);

	        int digits = (int)Math.ceil(Math.log10(m + 1));

	        int exp = (int)Math.pow(10, digits);

	        for (int i = 1; i <= exp; i *= 10)
	            countingSort(arr, n, i);

	        return arr;
	    }

	    public static void main(String[] args) {
	        Shape[] shapes = {/* ... populate with shape objects ... */};
	        int n = shapes.length;
	        radixSort(shapes, n);
	        System.out.println(Arrays.toString(shapes));
	    }
	    
	    
}
	
	


