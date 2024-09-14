// Groovy class to search and replace text 
// within all files in a given directory
// .......................................
// Author: Maria Fitas

import groovy.io.FileType

class TextReplacerClass { // Changed class name to avoid conflict with filename
    String directoryPath
    String searchText
    String replaceText
    String logFilePath

    // Constructor
    TextReplacerClass(String directoryPath, String searchText, String replaceText, String logFilePath = null) {
        this.directoryPath = directoryPath
        this.searchText = searchText
        this.replaceText = replaceText
        this.logFilePath = logFilePath
    }

    // Main function to start the search and replace process
    void processFiles() {
        File dir = new File(directoryPath)
        if (!dir.exists()) {
            println "Directory does not exist. Please check path and try again."
            return
        }

        dir.eachFileRecurse(FileType.FILES) { File file ->
            println "Found file: ${file.path}"
            println "File content: ${file.text}"  // Debug to check file content

            if (file.text.toLowerCase().contains(searchText.toLowerCase())) {
                replaceTextInFile(file)
            } else {
                println "No matches found in file: ${file.path}"
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
                if (line.toLowerCase().contains(searchText.toLowerCase())) {  // Case-insensitive match
                    occurrences += line.count(searchText)
                    locations << "Line ${index + 1}: ${line}"
                }
            }

            if (occurrences > 0) {
                content = content.replaceAll("(?i)" + searchText, replaceText)  // Case-insensitive replacement
                createBackup(file)
                file.text = content

                if (logFilePath) {
                    logModifiedFile(file.path, occurrences, locations)
                }
            }
        } catch (Exception e) {
            println "Error processing file: ${file.path}. ${e.message}"
            e.printStackTrace()
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
    void logModifiedFile(String filePath, int replacements, List<String> locations, boolean isError = false, String errorMessage = "") {
        File logFile = new File(logFilePath)
        def currentTime = new Date().format("dd-MM-yyyy HH:mm:ss")

        if (isError) {
            logFile << "[${currentTime}] ERROR: Failed to process file: ${filePath}. Reason: ${errorMessage}\n"
        } else {
            logFile << "[${currentTime}] SUCCESS: Modified file: ${filePath}. Replaced ${replacements} occurrence(s) of '${searchText}' at ${locations.join(", ")}\n"
        }
    }
}

// Main block to run the class using command-line arguments
// remove comments to run this in terminal

/* if (args.length < 3) {
    println "Usage: groovy TextReplacer.groovy <directoryPath> <searchText> <replaceText> [<logFilePath>]"
    System.exit(1)
}

def directoryPath = args[0]
def searchText = args[1]
def replaceText = args[2]
def logFilePath = args.length > 3 ? args[3] : null

println "Creating TextReplacer instance..."
TextReplacer replacer = new TextReplacer(directoryPath, searchText, replaceText, logFilePath)
println "Processing files..."
replacer.processFiles()
println "Program finished." */
