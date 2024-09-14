// Groovy class to create a simple UI
// for TextReplacerClass
// .......................................
// Author: Maria Fitas

import TextReplacerClass

import javax.swing.*
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class TextReplacerUI {

    static void main(String[] args) {
        // Apply a modern look and feel
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel")
        } catch (Exception e) {
            e.printStackTrace()
        }

        // Create the main frame
        JFrame frame = new JFrame("Text Replacer")
        frame.setSize(500, 300)  // Adjust frame size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
        frame.setLayout(new GridBagLayout())  // Using GridBagLayout for label-input alignment
        GridBagConstraints gbc = new GridBagConstraints()
        gbc.insets = new Insets(10, 10, 10, 10)
        gbc.fill = GridBagConstraints.HORIZONTAL
        
        // Set a light background color for the entire frame
        frame.getContentPane().setBackground(new Color(230, 240, 255))

        // Create and add components with updated styling
        Font labelFont = new Font("SansSerif", Font.BOLD, 14)
        Font smallFont = new Font("SansSerif", Font.PLAIN, 10)
        
        // Directory Path
        JLabel dirLabel = new JLabel("Directory Path:")
        dirLabel.setFont(labelFont)
        JTextField dirField = new JTextField(20)
        dirField.setPreferredSize(new Dimension(250, 30))
        
        // Original Text
        JLabel originalTextLabel = new JLabel("Original Text:")
        originalTextLabel.setFont(labelFont)
        JTextField originalTextField = new JTextField(20)
        originalTextField.setPreferredSize(new Dimension(250, 30))
        
        // New Text
        JLabel newTextLabel = new JLabel("New Text:")
        newTextLabel.setFont(labelFont)
        JTextField newTextField = new JTextField(20)
        newTextField.setPreferredSize(new Dimension(250, 30))
        
        // Log File Path with smaller text
        JLabel logFileLabel = new JLabel("<html>Log File Path<br><font size='2'>(Optional, include filename e.g., log.txt)</font></html>")
        logFileLabel.setFont(labelFont)
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
        gbc.anchor = GridBagConstraints.WEST
        frame.add(logFileLabel, gbc)
        
        gbc.gridx = 1
        gbc.gridy = 3
        gbc.anchor = GridBagConstraints.EAST
        frame.add(logFileField, gbc)
        
        // Fix the button size
        JButton runButton = new JButton("Run")
        runButton.setFont(new Font("SansSerif", Font.BOLD, 14))
        runButton.setBackground(new Color(100, 150, 255))  // Blue background for button
        runButton.setForeground(Color.WHITE)  // White text for button
        runButton.setPreferredSize(new Dimension(120, 40))  // Set button size
        
        gbc.gridx = 0
        gbc.gridy = 4
        gbc.gridwidth = 2
        gbc.anchor = GridBagConstraints.CENTER  // Center the button
        gbc.fill = GridBagConstraints.NONE
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

                // Create TextReplacerClass instance and start processing
                TextReplacerClass replacer = new TextReplacerClass(directory, originalText, newText, logFile)
                replacer.processFiles()

                JOptionPane.showMessageDialog(frame, "Text replacement completed.", "Success", JOptionPane.INFORMATION_MESSAGE)
            }
        })
        
        // Display the frame
        frame.setVisible(true)
    }
}
