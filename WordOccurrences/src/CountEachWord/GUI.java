package CountEachWord;
/**
 * This class represents a GUI application for counting the occurrences of each word in a text file.
 * It extends the JFrame class and contains a JTextArea for displaying the results and a JButton for
 * triggering the counting process. The class also includes methods for reading the text file, counting
 * the occurrences of each word, and displaying the results in the JTextArea.
 *
 * @author Nick Zambri
 * @version 1.1
 * @since 2023-04-26
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class GUI extends JFrame implements ActionListener {
    private JTextArea inputArea;
    private JTextArea outputArea;

    public GUI() {
        super("Word Occurrences");

        // Set up the input panel
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Enter text:"));

        inputArea = new JTextArea(10, 30);
        JScrollPane inputScrollPane = new JScrollPane(inputArea);
        inputPanel.add(inputScrollPane, BorderLayout.CENTER);

        JButton countButton = new JButton("Count");
        countButton.addActionListener(this);
        inputPanel.add(countButton, BorderLayout.SOUTH);

        // Set up the output panel
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.setBorder(BorderFactory.createTitledBorder("Occurrences:"));

        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        JScrollPane outputScrollPane = new JScrollPane(outputArea);
        outputPanel.add(outputScrollPane, BorderLayout.CENTER);

        // Add the panels to the frame
        Container contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.add(inputPanel);
        contentPane.add(outputPanel);

        // Set up the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Count")) {
            String input = inputArea.getText();
            Map<String, Integer> wordCounts = WordOccurrences.countWords(input);
            outputArea.setText("");
            for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                outputArea.append(entry.getKey() + ": " + entry.getValue() + "\n");
            }
        }
    }

    public static void main(String[] args) {
        new GUI();
    }
}
