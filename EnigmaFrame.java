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
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //top panel
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        // rotor1
        topPanel.add(new JLabel("Inner"));
        rotor1 = new JComboBox<>(new String[] {"1", "2", "3", "4", "5"});
        topPanel.add(rotor1);

        //rotor2
        topPanel.add(new JLabel("Middle"));
        rotor2 = new JComboBox<>(new String[] {"1", "2", "3", "4", "5"});
        topPanel.add(rotor2);

        //rotor3
        topPanel.add(new JLabel("Out"));
        rotor3 = new JComboBox<>(new String[] {"1", "2", "3", "4", "5"});
        topPanel.add(rotor3);

        //starting positions
        topPanel.add(new JLabel("Initial Positions"));
        startField = new JTextField(3);
        topPanel.add(startField);

        //encrypt & decrypt buttons
        encryptButton = new JButton("Encrypt");
        decryptButton = new JButton("Decrypt");
        topPanel.add(encryptButton);
        topPanel.add(decryptButton);

        add(topPanel, BorderLayout.NORTH);

        //center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2, 1, 10, 10));

        //input panel
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(new JLabel("Input"), BorderLayout.NORTH);
        inputArea = new JTextArea(5, 40);
        inputPanel.add(new JScrollPane(inputArea), BorderLayout.CENTER);
        centerPanel.add(inputPanel);

        //output panel
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.add(new JLabel("Output"), BorderLayout.NORTH);
        outputArea = new JTextArea(5, 40);
        outputArea.setEditable(false);
        outputPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);
        centerPanel.add(outputPanel);

        add(centerPanel, BorderLayout.CENTER);

        //button listeners
        encryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                runEnigma(true);
            }
        });

        decryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                runEnigma(false);
            }
        });
    }

    private void runEnigma (boolean encryptMode) {
        int id1 = Integer.parseInt((String) rotor1.getSelectedItem());
        int id2 = Integer.parseInt((String) rotor2.getSelectedItem());
        int id3 = Integer.parseInt((String) rotor3.getSelectedItem());
        String start = startField.getText().toUpperCase();
        String message = inputArea.getText().toUpperCase();

        if (start.length() != 3) {
            outputArea.setText("Start must be 3 letters.");
            return;
        }

        Enigma machine = new Enigma(id1, id2, id3, start);
        String result;
        if (encryptMode) {
            result = machine.encrypt(message);
        } else {
            result = machine.decrypt(message);
        }
        outputArea.setText(result);
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