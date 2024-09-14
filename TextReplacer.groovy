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
    void logModifiedFile(String filePath, int replacements, boolean isError = false, String errorMessage = "") {
        // Define log file and get current time in readable format
        File logFile = new File(logFilePath)
        def currentTime = new Date().format("dd-MM-yyyy HH:mm:ss")

        // If there was an error during file processing, log error message
        if (isError) {
            logFile << "[${currentTime}] ERROR: Failed to process file: ${filePath}. Reason: ${errorMessage}\n"
        } else {
            //Log successful modifications with number of replacements
            logFile << "[${currentTime}] SUCCESS: Modified file: ${filePath}. Replace ${replacements} occurrence(s) of '${searchText}'\n"   
        }
    }
}




// Main block to run the program
if (args.length < 3) {
    println "Usage: groovy TextReplacer.groovy <directoryPath> <searchText> <replaceText> [<logFilePath>]"
    System.exit(1)
}

String directoryPath = args[0]
String searchText = args[1]
String replaceText = args[2]
String logFilePath = args.lenght > 3 ? args[3] : null

TextReplacer replacer = new TextReplacer(directoryPath, searchText, replaceText, logFilePath)
replacer.processFiles()





