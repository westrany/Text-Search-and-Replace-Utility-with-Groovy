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
        frame.setSize(500, 300)  // Adjust frame size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
        frame.setLayout(new GridBagLayout())  // Using GridBagLayout for label-input alignment
        GridBagConstraints gbc = new GridBagConstraints()
        gbc.insets = new Insets(10, 10, 10, 10)
        gbc.fill = GridBagConstraints.HORIZONTAL

        // Create and add components
        JLabel dirLabel = new JLabel("Directory Path:")
        JTextField dirField = new JTextField(20)  // 20 column width for input fields
        dirField.setPreferredSize(new Dimension(250, 30))

        JLabel originalTextLabel = new JLabel("Original Text:")
        JTextField originalTextField = new JTextField(20)
        originalTextField.setPreferredSize(new Dimension(250, 30))

        JLabel newTextLabel = new JLabel("New Text:")
        JTextField newTextField = new JTextField(20)
        newTextField.setPreferredSize(new Dimension(250, 30))

        JLabel logFileLabel = new JLabel("Log File Path (Optional):")
        JTextField logFileField = new JTextField(20)
        logFileField.setPreferredSize(new Dimension(250, 30))

        // Add labels and fields in pairs
        gbc.gridx = 0
        gbc.gridy = 0
        frame.add(dirLabel, gbc)
        gbc.gridx = 1
        frame.add(dirField, gbc)

        gbc.gridx = 0
        gbc.gridy = 1
        frame.add(originalTextLabel, gbc)
        gbc.gridx = 1
        frame.add(originalTextField, gbc)

        gbc.gridx = 0
        gbc.gridy = 2
        frame.add(newTextLabel, gbc)
        gbc.gridx = 1
        frame.add(newTextField, gbc)

        gbc.gridx = 0
        gbc.gridy = 3
        frame.add(logFileLabel, gbc)
        gbc.gridx = 1
        frame.add(logFileField, gbc)

        // Fix the button size
        JButton runButton = new JButton("Run")
        gbc.gridx = 0
        gbc.gridy = 4
        gbc.gridwidth = 2
        gbc.fill = GridBagConstraints.NONE  // Disable horizontal fill for button
        gbc.anchor = GridBagConstraints.CENTER  // Center the button
        runButton.setPreferredSize(new Dimension(120, 40))  // Set button size (keep height at 40)
        frame.add(runButton, gbc)

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
