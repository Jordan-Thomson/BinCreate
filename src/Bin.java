/**
 * A simple class to represent a Bin in a parts department, the bin has an aisle, rack, shelf and location on the shelf
 * these items combined create a bin number.
 */

public class Bin {

    private String aisle;
    private String rack;
    private String shelf;
    private String loc;
    private String binnumber;

    /**
     * standard constructor
     */
    public Bin() {
        aisle = "";
        rack = "";
        shelf = "";
        loc = "";
        binnumber = "";
    }

    /**
     * Constructor containing parameters to create a bin
     * @param aisle The aisle the bin is located in
     * @param rack The rack in the aisle the bin is located in
     * @param shelf The shelf on the rack the bin is located in
     * @param loc The location of the bin on the shelf
     */
    public Bin(String aisle, String rack, String shelf, String loc) {
        this.aisle = aisle;
        this.rack = rack;
        this.shelf = shelf;
        this.loc = loc;
        generateBinNumber();
    }

    /**
     * Setter for the aisle the bin is located in
     * @param aisle The aisle the bin is located in
     */
    public void setAisle(String aisle) {
            this.aisle = aisle;
    }

    /**
     * Setter for the rack in the aisle the bin is located in
     * @param rack The rack in the aisle the bin is located in
     */
    public void setRack(String rack) {
        this.rack = rack;
    }

    /**
     * Setter for the shelf on the rack the bin is located in
     * @param shelf The shelf on the rack the bin is located in
     */
    public void setShelf(String shelf) {
            this.shelf = shelf;
    }

    /**
     * Setter for the location of the bin on the shelf
     * @param loc The location of the bin on the shelf
     */
    public void setLoc(String loc) {
            this.loc = loc;
    }

    /**
     * Method to generate the full bin number
     */
    public void generateBinNumber() {
        binnumber = aisle + rack + shelf + loc;
    }

    /**
     * Method to get the bin number
     * @return String of the bin number
     */
    public String getBinnumber() {
        return binnumber;
    }

    /**
     * Getter for the aisle the bin is located in
     * @return String of the aisle the bin is located in
     */
    public String getAisle() {
        return aisle;
    }

    /**
     * Getter for the location on the shelf the bin is located in
     * @return String of the location on the shelf the bin is located in
     */
    public String getLoc() {
        return loc;
    }

    /**
     * Getter for the rack in the aisle the bin is located in
     * @return String of the rack in the aisle the bin is located in
     */
    public String getRack() {
        return rack;
    }

    /**
     * Getter for the shelf on the rack the bin is located in
     * @return String og the shelf on the rack the bin is located in
     */
    public String getShelf() {
        return shelf;
    }
}
