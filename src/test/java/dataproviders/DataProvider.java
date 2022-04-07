package dataproviders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class DataProvider {
    public static Iterator<String[]> Users() {
        List<String[]> testCases = new ArrayList<>();
        String[] data = null;
        String cvsSplitBy = ";";
        try {
            Scanner scanner = new Scanner(new File("resources/userCredentials.csv"));
            while (scanner.hasNextLine()) {
                data = scanner.nextLine().split(cvsSplitBy);
                testCases.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return testCases.iterator();
    }
    public static List<String[]> Products() {
        List<String[]> testCases = new ArrayList<>();
        String[] data = null;
        String cvsSplitBy = ";";
        try {
            Scanner scanner = new Scanner(new File("resources/products.csv"));
            while (scanner.hasNextLine()) {
                data = scanner.nextLine().split(cvsSplitBy);
                testCases.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return testCases;
    }
}
