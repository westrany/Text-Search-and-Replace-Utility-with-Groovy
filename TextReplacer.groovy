// Groovy class to search and replace text 
// within all files in a given directory
// .......................................
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
            println "Directory does not exist. Please check path and try again."
            return
    }

        dir.eachFileRecurse(FileType.FILES) { File file ->
            if (file.text.contains(searchText)) {
            replaceTextInFile(file)
            }
        }
    }

    // Function to replace text in a file
    // with error handling and logging
    void replaceTextInFile(File file) {
        println "Processing file: ${file.path}"

        try {
            // Read file contents line by line
            def content = file.text
            def lines = file.readLines()
            int occurrences = 0
            def locations = []

            // Find occurrences of 'searchText' and respective line numbers
            lines.eachWithIndex { line, index -> 
                if (line.contains(searchText)) {
                    occurrences += line.count(searchText)
                    locations << "Line ${index + 1}: ${line}"
                }
            }

            if (occurrences > 0) {
                // Replace all occurrences of 'searchText' with 'replaceText'
                content = content.replaceAll(searchText, replaceText)

                // Create backup of original file
                createBackup(file)

                // Write updated content to the file
                file.text = content

                // Log the number of replacements and where patterns were found
                if (logFilePath) {
                    logModifiedFile(file.path, occurrences, locations)
                }
            }
        } catch (Exception e) {
            // Handle exceptions that occur while processing file
            println "Error processing file: ${file.path}. ${e.message}"

            // Log error message if logging is enabled
            if (logFilePath) {
                logModifiedFile(file.path, 0, [], true, e.message)
            }
        }
    }

    // Function to create a backup of the original file
    void createBackup(File file) {
        File backup = new File(file.path + ".bak")
        backup.text = file.text
    }

    // Function to log modified files and errors
    void logModifiedFile(String filePath, int replacements, boolean isError = false, String errorMessage = "") {
        // Define log file and get current time in readable format
        File logFile = new File(logFilePath)
        def currentTime = new Date().format("dd-MM-yyyy HH:mm:ss")

        // If there was an error during file processing, log error message
        if (isError) {
            logFile << "[${currentTime}] ERROR: Failed to process file: ${filePath}. Reason: ${errorMessage}\n"
        } else {
            //Log successful modifications with number of replacements
            logFile << "[${currentTime}] SUCCESS: Modified file: ${filePath}. Replaced ${replacements} occurrence(s) of '${searchText}'\n"   
        }
    }
}





