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

    public static List<String[]> ProductsList() {
        return ReadCSV("products.csv");
    }

    public static List<String> ProductsNames() {
        List<String> names = new ArrayList<String>();
        ProductsList().forEach(x -> names.add(x[1]));
        return names;
    }

    public static List<String[]> UsersList() {
        return ReadCSV("userCredentials.csv");
    }

    public static List<String[]> ReadCSV(String csvName) {
        List<String[]> testCases = new ArrayList<>();
        String[] data = null;
        String cvsSplitBy = ";";
        try {
            Scanner scanner = new Scanner(new File(String.format("resources/%s", csvName)));
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
