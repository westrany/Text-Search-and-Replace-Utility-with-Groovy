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
    void replaceTextInFile(File file) {
        println "Processing file: ${file.path}"

        try {
            def content = file.text
            def lines = file.readLines()
            int occurrences = 0
            def locations = []

            lines.eachWithIndex { line, index ->
                if (line.contains(searchText)) {
                    occurrences += line.count(searchText)
                    locations << "Line ${index + 1}: ${line}"
                }
            }

            if (occurrences > 0) {
                content = content.replaceAll(searchText, replaceText)
                createBackup(file)
                file.text = content
                if (logFilePath) {
                    logModifiedFile(file.path, occurrences, locations)
                }
            }
        } catch (Exception e) {
            println "Error processing file: ${file.path}. ${e.message}"
            if (logFilePath) {
                logModifiedFile(file.path, 0, [], true, e.message)
            }
        }
    }

    void createBackup(File file) {
        File backup = new File(file.path + ".bak")
        backup.text = file.text
    }

// Function to log modified files and errors
void logModifiedFile(String filePath, int replacements, List<String> locations, boolean isError = false, String errorMessage = "") {
    // Define log file and get current time in readable format
    File logFile = new File(logFilePath)
    def currentTime = new Date().format("dd-MM-yyyy HH:mm:ss")

    // If there was an error during file processing, log error message
    if (isError) {
        logFile << "[${currentTime}] ERROR: Failed to process file: ${filePath}. Reason: ${errorMessage}\n"
    } else {
        //Log successful modifications with number of replacements
        logFile << "[${currentTime}] SUCCESS: Modified file: ${filePath}. Replaced ${replacements} occurrence(s) of '${searchText}' at ${locations.join(", ")}\n"   
    }
}

    // Add a main method for command-line execution
    static void main(String[] args) {
        if (args.length < 3) {
            println "Usage: groovy TextReplacer.groovy <directory> <searchText> <replaceText> [logFile]"
            return
        }

        String directoryPath = args[0]
        String searchText = args[1]
        String replaceText = args[2]
        String logFilePath = args.length > 3 ? args[3] : null

        TextReplacer replacer = new TextReplacer(directoryPath, searchText, replaceText, logFilePath)
        replacer.processFiles()
    }
}
