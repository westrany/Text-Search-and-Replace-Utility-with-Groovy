// Groovy class to create a simple UI
// for the TextReplacer class
// .......................................
// Author: Maria Fitas

import javax.swing.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class TextReplacerUI {

    static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Text Replacer")
        frame.setSize(400, 300)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS))

        // Create and add components
        frame.add(new JLabel("Directory Path:"))
        JTextField dirField = new JTextField()
        frame.add(dirField)

        frame.add(new JLabel("Original Text:"))
        JTextField originalTextField = new JTextField()
        frame.add(originalTextField)

        frame.add(new JLabel("New Text:"))
        JTextField newTextField = new JTextField()
        frame.add(newTextField)

        frame.add(new JLabel("Log File Path (Optional):"))
        JTextField logFileField = new JTextField()
        frame.add(logFileField)

        JButton runButton = new JButton("Run")
        frame.add(runButton)

        // Action listener for the button
        runButton.addActionListener(new ActionListener() {
            @Override
            void actionPerformed(ActionEvent e) {
                String directory = dirField.getText()
                String originalText = originalTextField.getText()
                String newText = newTextField.getText()
                String logFile = logFileField.getText()

                // Validate inputs
                if (directory.isEmpty() || originalText.isEmpty() || newText.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill out all required fields.", "Error", JOptionPane.ERROR_MESSAGE)
                    return
                }

                // Create TextReplacer instance and start processing
                TextReplacer replacer = new TextReplacer(directory, originalText, newText, logFile)
                replacer.processFiles()
                
                JOptionPane.showMessageDialog(frame, "Text replacement completed.", "Success", JOptionPane.INFORMATION_MESSAGE)
            }
        })

        // Display the frame
        frame.setVisible(true)
    }
}
