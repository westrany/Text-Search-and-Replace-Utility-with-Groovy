// Groovy class to create a simple UI
// for the TextReplacer class
// .......................................
// Author: Maria Fitas

import javax.swing.*
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class TextReplacerUI {

    static void main(String[] args) {
        // Apply a modern look and feel
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel")

        // Create the main frame
        JFrame frame = new JFrame("Text Replacer")
        frame.setSize(500, 400)  // Keep the frame size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS))

        // Create and add components
        JLabel dirLabel = new JLabel("Directory Path:")
        JTextField dirField = new JTextField(30)
        dirField.setMaximumSize(new Dimension(400, 30))  // Set larger size for the text field

        JLabel originalTextLabel = new JLabel("Original Text:")
        JTextField originalTextField = new JTextField(30)
        originalTextField.setMaximumSize(new Dimension(400, 30))  // Set larger size for the text field

        JLabel newTextLabel = new JLabel("New Text:")
        JTextField newTextField = new JTextField(30)
        newTextField.setMaximumSize(new Dimension(400, 30))  // Set larger size for the text field

        JLabel logFileLabel = new JLabel("Log File Path (Optional):")
        JTextField logFileField = new JTextField(30)
        logFileField.setMaximumSize(new Dimension(400, 30))  // Set larger size for the text field

        JButton runButton = new JButton("Run")
        runButton.setPreferredSize(new Dimension(150, 40))  // Make the button larger
        runButton.setAlignmentX(Component.CENTER_ALIGNMENT)  // Center the button

        // Centering everything vertically with glue
        frame.add(Box.createVerticalGlue())  // Top space
        frame.add(dirLabel)
        dirLabel.setAlignmentX(Component.CENTER_ALIGNMENT)  // Center the label
        frame.add(dirField)
        frame.add(Box.createVerticalStrut(10))  // Add space between components
        frame.add(originalTextLabel)
        originalTextLabel.setAlignmentX(Component.CENTER_ALIGNMENT)  // Center the label
        frame.add(originalTextField)
        frame.add(Box.createVerticalStrut(10))
        frame.add(newTextLabel)
        newTextLabel.setAlignmentX(Component.CENTER_ALIGNMENT)  // Center the label
        frame.add(newTextField)
        frame.add(Box.createVerticalStrut(10))
        frame.add(logFileLabel)
        logFileLabel.setAlignmentX(Component.CENTER_ALIGNMENT)  // Center the label
        frame.add(logFileField)
        frame.add(Box.createVerticalStrut(20))  // Larger space before the button
        frame.add(runButton)
        frame.add(Box.createVerticalGlue())  // Bottom space

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



