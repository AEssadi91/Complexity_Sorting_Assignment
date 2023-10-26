package ShapeManagement;
import java.util.Comparator;
import java.util.List;
import java.io.File;
import com.teamsonia.*;
import java.util.Arrays;
import com.teamsonia.Shape;

public class ShapeManger {
   public static void main(String[] args) throws Exception {

        String fileName = null;
        String metric = null;
        char sortType = ' ';
        
           
            for (int i = 0; i < args.length; i++) {
                String arg = args[i];

                if (arg.charAt(0) == '-') {
                    switch (arg.charAt(1)) {
                        case 'f':
                            fileName = arg.substring(2);
                            break;
                        case 't':
                            metric = arg.substring(2);
                            break;
                        case 's':
                            sortType = arg.charAt(2);
                            break;
                        default:
                            System.out.println("Invalid argument: " + arg);

                            return;
                    }
                }
            }
      

        if (fileName == null || metric == null || sortType == ' ') {
            System.out.println("Error: Missing arguments.");
            return;
        }

        if (!new File(fileName).exists()) {
            System.out.println("File not found: " + fileName);
            return;
        }

        List<Shape> shapes = ShapeFileReader.readShapesFromFile(fileName);

        Comparator<Shape> comparator;
        switch (metric) {
            case "v":
                comparator = Comparator.comparingDouble(Shape::getVolume);
                break;
            case "a":
                comparator = Comparator.comparingDouble(Shape::getBaseArea);
                break;
            default:
                System.out.println("Invalid metric choice!");
                return;
        }

        Shape[] shapesArray = shapes.toArray(new Shape[0]);
        long startTime, endTime, elapsedTime;

        switch (sortType) {
                case 'b':
                    startTime = System.currentTimeMillis();
                    shapesArray = UtilitySort.bubbleSort(shapesArray, comparator);
                    endTime = System.currentTimeMillis();
                    System.out.println("You are using BubbleSort");
                    break;
                case 'i':
                    startTime = System.currentTimeMillis();
                    shapesArray = UtilitySort.insertionSort(shapesArray, comparator);
                    endTime = System.currentTimeMillis();
                    System.out.println("You are using InsertionSort");
                    break;
                case 's':
                    startTime = System.currentTimeMillis();
                    shapesArray = UtilitySort.selectionSort(shapesArray, comparator);
                    endTime = System.currentTimeMillis();
                    System.out.println("You are using SelectionSort");
                    break;
                case 'm':
                    startTime = System.currentTimeMillis();
                    shapesArray = UtilitySort.mergeSort(shapesArray, comparator);
                    endTime = System.currentTimeMillis();
                    System.out.println("You are using MergeSort");
                    break;
                case 'q':
                    startTime = System.currentTimeMillis();
                    shapesArray = UtilitySort.quickSort(shapesArray, comparator);
                    endTime = System.currentTimeMillis();
                    System.out.println("You are using QuickSort");
                    break;
                case 'z':
                    startTime = System.currentTimeMillis();
                    shapesArray = UtilitySort.radixSort(shapesArray, shapesArray.length, comparator);
                    endTime = System.currentTimeMillis();
                    System.out.println("You are using RadixSort");
                    break;
                default:
                    System.out.println("Invalid sorting choice!");
                    return;
            }

        elapsedTime = endTime - startTime;
        System.out.println("Time taken for sorting: " + elapsedTime + " milliseconds");


        int length = shapesArray.length;
        int firstIndex = 0;
        int lastIndex = length - 1;
        int thousandthIndex = 999;

        System.out.println("First sorted value: " + shapesArray[firstIndex]);
        System.out.println("Last sorted value: " + shapesArray[lastIndex]);

        for (int i = thousandthIndex; i < length; i += 1000) {
            System.out.println("Value at index " + i + ": " + shapesArray[i]);
        }

    }

    

}

                
                
                
                
                