// Groovy class to search and replace text 
// within all files in a given directory
// Author: Maria Fitas

import groovy.io.FileType

class TextReplacer {
    String directoryPath
    String searchText
    String replaceText
    String logFilePath

    // Constructor
    TextReplacer(String directoryPath, String searchText, String replaceText, String logFilePath = null) {
        this.directoryPath = directoryPath
        this.searchText = searchText
        this.replaceText = replaceText
        this.logFilePath = logFilePath
    }

    // Main function to start the search and replace process
    void processFiles(){
        File dir = new File(directoryPath)
        if (!dir.exists()) {
            println "Directory does not exists. Please check path and try again."
            return
    }

        dir.eachFileRecurse(FileType.FILES) { File file ->
            if (file.text.contains(searchText)) {
            replaceTextInFile(file)
            }
        }
    }

    // Function to replace text in a file
    void replaceTextInFile(File file) {
        println "Processing file: ${file.path}"
        def content = file.text.replaceAll(searchText, replaceText)

        // Create backup
        createBackup(file)

        // Write updated content to file
        file.text = content

        // Log if necessary
        if (logFilePath) {
            logModifiedFile(file.path)
        }
    }

    // Function to create a backup of the original file
    void createBackup(File file) {
        File backup = new File(file.path + ".bak")
        backup.text = file.text
    }

    // Function to log modified files
    void logModifiedFile(String filePath) {
        File logFile = new File(logFilePath)
        logFile << "Modified: ${filePath}\n"
    }
}

