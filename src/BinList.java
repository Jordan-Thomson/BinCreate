import com.opencsv.CSVWriter;
import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A class to generate numerous bin numbers and export it to a csv file. A bin has 4 components, an aisle, a rack, a shelf
 * and a location on the shelf. These items combined create the bin number. The format of each of these are 2 numbers each
 * apart from the location which is a letter from A to Z - an example bin (the first bin) is 010101A. The bin numbers that
 * are generated are then output to a csv file so that they can be imported into another application.
 */

public class BinList extends JFrame {

    private ArrayList<Bin> binNumbers;
    private ArrayList<String[]> dataLines;
    private static String filename;

    /**
     * Constructor for the BinList
     */
    public BinList() {
        binNumbers = new ArrayList<>();
        filename="";
    }

    /**
     * Method to check if a string is numeric
     * @param str the String to check
     * @return boolean value - true if numeric, false otherwise
     */
    public boolean isNumeric(String str) {
        try {
            double num = Double.parseDouble(str);
            return num > 0 && num <= 99;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Method to check if a string contains only alpha characters
     * @param name The string to check
     * @return boolean value - true if only alpha characters, false otherwise
     */
    public boolean isAlpha(String name) {
        return name.matches("[A-Z]");
    }

    /**
     * fixes the length of a string adding a '0' to the front if only 1 in length
     * @param str String to be modified
     * @return String of the modified parameter.
     */
    public String setLength(String str) {
        if (str.length() == 1) {
            return "0" + str;
        }
        return str;
    }

    /**
     * Method to generate all the bin numbers in a range
     * @param startAisle String of the starting aisle
     * @param startRack String of the starting rack
     * @param startShelf String of the starting shelf
     * @param startLoc String of the starting location
     * @param endRack String of the ending rack
     * @param endShelf String of the ending shelf
     * @param endLoc String of the ending location
     * @param zone String of a zone that the entire bin belongs to.
     */
    public void generateBins(String startAisle, String startRack, String startShelf, String startLoc, String endRack, String endShelf, String endLoc,String zone) {

        for (int i = 0; i <= Integer.parseInt(endRack) - Integer.parseInt(startRack); i++) {
            String rack = setLength(String.valueOf(Integer.parseInt(startRack) + i));
            for (int j = 0; j <= Integer.parseInt(endShelf)- Integer.parseInt(startShelf); j++){
                String shelf = setLength(String.valueOf(Integer.parseInt(startShelf) + j));
                for (int k = 0; k <= endLoc.charAt(0) - startLoc.charAt(0); k++){
                    Bin bin = new Bin();
                    bin.setLoc(Character.toString((char) (startLoc.charAt(0)+k)));
                    bin.setShelf(shelf);
                    bin.setRack(rack);
                    bin.setAisle(setLength(startAisle));
                    bin.generateBinNumber();
                    binNumbers.add(bin);
                }
            }
        }

        filename = binNumbers.get(0).getBinnumber() + "_to_" + binNumbers.get(binNumbers.size()-1).getBinnumber() + ".csv";
        generateOutputDate(zone);
        writeToCSVFile();
    }

    /**
     * Method to convert all the bins into a format to output to a csv.
     * @param zone String of the zone for all the bins being created.
     */
    public void generateOutputDate(String zone) {
        dataLines = new ArrayList<>();
        dataLines.add(new String[]
                {"Bin Number","Name","Zone","Part"});
        for(Bin dusty : binNumbers) {
            dataLines.add(new String[]
                    {dusty.getBinnumber(),"Bin Location: " + dusty.getBinnumber(),zone,""});
        }
    }

    /**
     * Method to write the data to a csv file.
     */
    public void writeToCSVFile() {
        File file = new File(filename);

        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            writer.writeAll(dataLines);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to get the filename that was crated.
     * @return String of the filename.
     */
    public static String getFilename() {
        return filename;
    }

}
