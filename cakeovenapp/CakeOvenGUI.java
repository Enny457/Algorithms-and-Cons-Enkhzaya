package cakeovenapp;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
/**
 * GUI for managing a Cake Oven.
 * Allows adding, removing, peeking, and displaying cakes.
 */
public class CakeOvenGUI extends JFrame {
    private static final int FIELD_WIDTH = 10;
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 400;
    
    private CakeOven oven = new CakeOven();

   private JTextField nameField = new JTextField(FIELD_WIDTH);
    private JTextField weightField = new JTextField(FIELD_WIDTH);
    private JTextField dateField = new JTextField(FIELD_WIDTH); // YYYY-MM-DD
    private JTextArea outputArea = new JTextArea(10, 30);

    public CakeOvenGUI() {
        setTitle("Cake Oven Application");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Cake Name:"));
        add(nameField);

        add(new JLabel("Weight (g):"));
        add(weightField);

        add(new JLabel("Best Before Date (YYYY-MM-DD):"));
        add(dateField);

        JButton addButton = new JButton("Add Cake");
        JButton removeButton = new JButton("Remove Cake");
        JButton peekButton = new JButton("Peek Cake");
        JButton displayButton = new JButton("Display All");
        JButton exitButton = new JButton("Exit");

        add(addButton);
        add(removeButton);
        add(peekButton);
        add(displayButton);
        add(exitButton);

        outputArea.setEditable(false);
        add(new JScrollPane(outputArea));

        // Button Actions
        addButton.addActionListener(e -> addCake());
        removeButton.addActionListener(e -> removeCake());
        peekButton.addActionListener(e -> peekCake());
        displayButton.addActionListener(e -> displayCakes());
        exitButton.addActionListener(e -> System.exit(0));

        setVisible(true);
    }
/**
 * Adds a cake to the oven after validating user input.
 */
    private void addCake() {
        String name = nameField.getText().trim();
        String weightText = weightField.getText().trim();
        String dateText = dateField.getText().trim();

        if (name.isEmpty() || weightText.isEmpty() || dateText.isEmpty()) {
            showMessage("Please fill in all fields.");
            return;
        }

        try {
            int weight = Integer.parseInt(weightText);
            if (weight <= 0) {
                showMessage("Weight must be positive.");
                return;
            }

            LocalDate bestBefore = LocalDate.parse(dateText);
            LocalDate maxDate = LocalDate.now().plusWeeks(2);
            if (bestBefore.isAfter(maxDate)) {
                showMessage("Best before date must be within 2 weeks from now.");
                return;
            }

            Cake cake = new Cake(name, weight, bestBefore);
            if (oven.isFull()) {
                showMessage("Oven is full! Cannot add more cakes.");
            } else {
                oven.addCake(cake);
                showMessage("Cake added: " + cake.getName());
            }

        } catch (NumberFormatException ex) {
            showMessage("Weight must be a number.");
        } catch (DateTimeParseException ex) {
            showMessage("Date format must be YYYY-MM-DD.");
        }
    }

    private void removeCake() {
        if (oven.isEmpty()) {
            showMessage("Oven is empty.");
        } else {
            Cake removed = oven.removeCake();
            showMessage("Removed: " + removed.getName());
        }
    }

    private void peekCake() {
        if (oven.isEmpty()) {
            showMessage("There are no cakes in the oven.");
        } else {
            Cake peeked = oven.peekCake();
            showMessage("First cake: " + peeked.getName());
        }
    }

    private void displayCakes() {
        if (oven.isEmpty()) {
            showMessage("Oven is empty.");
        } else {
            StringBuilder sb = new StringBuilder("Cakes in oven:\n");
            for (Cake c : oven.getCakes()) {
                sb.append(c).append("\n");
            }
            outputArea.setText(sb.toString());
        }
    }

    private void showMessage(String msg) {
        outputArea.setText(msg);
    }
}
