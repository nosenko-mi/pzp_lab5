package com.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class FileController {

    private FileController(){};

    public static void saveData(String fileName, String result){
        writeToFile(fileName, result);
    }

    public static void saveData(String fileName, Double resultDistance, Integer resultAmount){
        String str = String.format("%d %.3f", resultAmount, resultDistance);
        writeToFile(fileName, str);
    }

    public static ArrayList<Dot> loadData(String fileName){
        ArrayList<Double> arrayList = new ArrayList<>();
        File file = new File(fileName);
        // read data
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String text;
            while ((text = reader.readLine()) != null) {
//                split "1.1 0.1"
                String[] parts = text.split(" ");
                for (String part : parts) {
                    arrayList.add(Double.parseDouble(part));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.printf("File %s not found ", fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // check input size
        // first value of arrayList is an amount of dots
        int size = arrayList.get(0).intValue();
        if (size != (arrayList.size() - 1) / 2) return null;

        // create dots and add them to result
        ArrayList<Dot> dotList = new ArrayList<Dot>(size);
        for (int i = 1; i < arrayList.size(); i += 2){
            dotList.add(new Dot(arrayList.get(i), arrayList.get(i + 1)));
        }
        return dotList;
    }

    private static void writeToFile(String fileName, String str){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.printf("File %s not found ", fileName);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error occurred while writing to a file");
        }
    }
}
