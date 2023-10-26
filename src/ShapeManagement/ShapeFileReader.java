package ShapeManagement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.teamsonia.*;



public class ShapeFileReader {
public static List<Shape> readShapesFromFile(String fileName) throws Exception {
    String resourcesPath = "resources/";
    File file = new File(resourcesPath + fileName);
    List<Shape> shapes = new ArrayList<>();

    if (!file.exists()) {
        throw new Exception("File not found: " + fileName);
    }

    try (Scanner scanner = new Scanner(file)) {
        if (!scanner.hasNextInt()) {
            throw new Exception("The first item in the file should be the number of shapes");
        }

        int numberOfShapes = scanner.nextInt();

        for (int i = 0; i < numberOfShapes; i++) {
            if (!scanner.hasNext()) {
                throw new Exception("Not enough data in the file for " + numberOfShapes + " shapes");
            }

            String type = scanner.next();

            if (!scanner.hasNextDouble()) {
                throw new Exception("Height expected as a double after shape type");
            }

            double height = scanner.nextDouble();

            if (!scanner.hasNextDouble()) {
                throw new Exception("Second parameter expected as a double after height");
            }

            double other = scanner.nextDouble();

            switch (type) {
                case "Cylinder":
                    shapes.add(new Cylinder(height, other));
                    break;
                case "Cone":
                    shapes.add(new Cone(height, other));
                    break;
                case "OctagonalPrism":
                    shapes.add(new OctagonalPrism(height, other));
                    break;
                case "PentagonalPrism":
                    shapes.add(new PentagonalPrism(height, other));
                    break;
                case "Pyramid":
                    shapes.add(new Pyramid(height, other));
                    break;
                case "SquarePrism":
                    shapes.add(new SquarePrism(height, other));
                    break;
                case "TriangularPrism":
                    shapes.add(new TriangularPrism(height, other));
                    break;

                default:
                    throw new Exception("Unknown shape type: " + type);
            }
            
        }

        scanner.close();
        return shapes;
    }
}


}
