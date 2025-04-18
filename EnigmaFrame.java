import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EnigmaFrame extends JFrame {
    private JComboBox<String> rotor1, rotor2, rotor3;
    private JTextField startField;
    private JTextArea inputArea, outputArea;
    private JButton encryptButton, decryptButton;

    public EnigmaFrame() {
        //main window
        setTitle("Enigma GUI");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        //Top Panel
       JPanel topPanel = new JPanel(new GridLayout(2, 6, 10, 5));
       topPanel.add(new JLabel("Inner"));
       rotor1 = new JComboBox<>(new String[] {"1", "2", "3", "4", "5"});
       topPanel.add(rotor1);

       topPanel.add(new JLabel("Middle"));
       rotor2 = new JComboBox<>(new String[] {"1", "2", "3", "4", "5"});
       topPanel.add(rotor2);

       topPanel.add(new JLabel("Outer"));
       rotor3 = new JComboBox<>(new String[] {"1", "2", "3", "4", "5"});
       topPanel.add(rotor3);

    }
}

/*
 You must use the following GUI elements in completing this lab:
 - JComboBox : for selecting the rotor numbers
 - JTextField : for selecting the start of the rotors
 - JTextArea : for providing input to and output from Enigma
 - JButton : for selecting encrypt or decrypt
 - JLabel : for including other text references, such as “Inner” or “Middle”
 */