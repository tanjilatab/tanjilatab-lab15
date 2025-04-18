import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EnigmaFrame extends JFrame {
    private JComboBox<String> rotor1, rotor2, rotor3;
    private JTextField startField;
    private JTextArea inputArea, outputArea;
    private JButton encryptButton, decryptButton;

    public EnigmaFrame() {
        setTitle("Enigma GUI");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }
}
