
package ShapeManagement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import com.teamsonia.*;

public class ShapeManger {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Which file do you want to sort?");
        System.out.println("1. polyfor1");
        System.out.println("2. polyfor3");
        System.out.println("3. polyfor5");
        int fileChoice = scanner.nextInt(); 

        String fileName = "";
        switch (fileChoice) {
        case 1:
        	fileName = "polyfor1.txt";
        	break;
        case 2:
        	fileName = "polyfor3.txt";
        	break;
        case 3:
        	fileName = "polyfor5.txt";
        	break;
        default:
        	System.out.println("Invalid choice");
        	return;
        }

        List<Shape> shapes = ShapeFileReader.readShapesFromFile("resources/" + fileName);

        System.out.println("By which metric do you want to sort?");
        System.out.println("1. Volume");
        System.out.println("2. Base Area");
        int metricChoice = scanner.nextInt();

        Comparator<Shape> comparator;
        switch (metricChoice) {
            case 1:
                comparator = Comparator.comparingDouble(Shape::getVolume);
                break;
            case 2:
                comparator = Comparator.comparingDouble(Shape::getBaseArea);
                break;
            default:
                System.out.println("Invalid metric choice!");
                return;
        }

        Shape[] shapesArray = shapes.toArray(new Shape[0]);

        System.out.println("Which sorting method do you want to use:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Insertion Sort");
        System.out.println("3. Selection Sort");
        System.out.println("4. Merge Sort");
        System.out.println("5. Quick Sort");
        System.out.println("6. Radix Sort");

        int sortChoice = scanner.nextInt();

        switch (sortChoice) {
            case 1:
                shapesArray = UtilitySort.bubbleSort(shapesArray);
                System.out.println("You are using BubbleSort");
                break;
            case 2:
                shapesArray = UtilitySort.insertionSort(shapesArray);
                System.out.println("You are using InsertionSort");
                break;
            case 3:
                shapesArray = UtilitySort.selectionSort(shapesArray);
                System.out.println("You are using SelectionSort");
                break;
            case 4:
                shapesArray = UtilitySort.mergeSort(shapesArray);
                System.out.println("You are using MergeSort");
                break;
            case 5:
                shapesArray = UtilitySort.quickSort(shapesArray);
                System.out.println("You are using QuickSort");
                break;
            case 6:
                shapesArray = UtilitySort.radixSort(shapesArray, shapesArray.length);
                System.out.println("You are using RadixSort");
                break;
            default:
                System.out.println("Invalid sorting choice!");
                return;
        }

        System.out.println("Shapes after sorting:");
        for (Shape shape : shapesArray) {
            System.out.println(shape);
        }

        scanner.close();
        return;
    }
}


