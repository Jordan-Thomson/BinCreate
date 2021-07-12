import javax.swing.*;
import java.awt.*;

/**
 * The Gui for accepting inputs for the bin creation process.
 */

public class InputForm extends Component {
    private JTextField startAisle;
    private JTextField startRack;
    private JTextField startShelf;
    private JComboBox<String> startLoc;
    private JTextField endRack;
    private JTextField endShelf;
    private JComboBox<String> endLoc;
    private JButton generateButton;
    private JLabel startLabel;
    private JLabel endLabel;
    private JLabel aisleLabel;
    private JLabel rackLabel;
    private JLabel shelfLabel;
    private JLabel locLabel;
    private JPanel panel;
    private JComboBox<String> zoneCombo;
    private JLabel zoneLabel;
    private BinList bl;

    /**
     * Constructor for the GUI
     */
    public InputForm() {
        bl = new BinList();
        generateButton.addActionListener(e -> {
            if (/*bl.isNumeric(startAisle.getText()) && */bl.isNumeric(startRack.getText()) && bl.isNumeric(startShelf.getText()) &&
                    bl.isNumeric(endRack.getText()) && bl.isNumeric(endShelf.getText()) && startRack.getText().compareTo(endRack.getText()) <= 0 &&
                    startShelf.getText().compareTo(endShelf.getText()) <= 0 &&
                    String.valueOf(startLoc.getItemAt(startLoc.getSelectedIndex())).compareTo(String.valueOf(endLoc.getItemAt(endLoc.getSelectedIndex()))) <= 0) { // if the input is ok
                bl.generateBins(startAisle.getText(),startRack.getText(),startShelf.getText(),String.valueOf(startLoc.getItemAt(startLoc.getSelectedIndex())),
                        endRack.getText(),endShelf.getText(),String.valueOf(endLoc.getItemAt(endLoc.getSelectedIndex())),
                        String.valueOf(zoneCombo.getItemAt(zoneCombo.getSelectedIndex())));
                JOptionPane.showMessageDialog(this,"File " + BinList.getFilename() + " created.","File created",JOptionPane.INFORMATION_MESSAGE);
                bl = new BinList(); // reset for new list.
            }
            else { // if any of the data had an incorrect input.
                JOptionPane.showMessageDialog(this, "Input error","Batch Details",JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    /**
     * main method to display the GUI
     * @param args None required.
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("InputForm");
        frame.setContentPane(new InputForm().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
