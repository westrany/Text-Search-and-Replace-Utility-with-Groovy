# Text-Search-and-Replace-Utility-with-Groovy  

## Overview  

This project is a Groovy-based text search and replace utility that processes all text files in a given directory and its subdirectories. The program searches for a specific text or pattern and replaces it with a new string as specified by the user. Additionally, it offers options for logging, backup creation, and a simple user interface for ease of use.  

### Features  

1. **Search and Replace:**
    - Takes a directory path, a search pattern, and a replacement string as input.
    - Recursively processes all text files in the directory and its subdirectories, replacing all occurrences of the search pattern with the replacement string.

2. **Optional Logging:**
    - Logs the details of files that were modified and supports saving these logs to a specified file. The log includes start time, errors (if any), end time, pattern found, and its location.
  
3. **File Backup:**
  - Before modifying any file, the program creates a backup of the original file. This allows users to restore the original files if needed.

4. **User Interface (UI):**
    - A simple user interface allows users to specify the input arguments without using the command line. The UI takes the directory path, search text, replacement text, and an optional log file path as inputs.
  
## Requirements  

**Groovy:** Ensure that Groovy is installed and properly set up in your environment.  

You can find an instalation guide [here](https://groovy-lang.org/install.html).

## How to Use  

### The Easy Way: Running with UI    

1. Make a fork of this repository or simply download it.

2. cd inside the repository and use the following command to launch the UI (this is assuming you are running this on terminal or cmd, command might differ if running on Linux):

``` groovy TextReplacerUI``` 

_Alternatively you can also type:_

``` groovy TextReplacerUI.groovy ```

3. The following UI window will pop up.

![image](https://github.com/user-attachments/assets/71fa088f-5741-4a78-b031-fbaf49012e26)

And here's how to fill the 4 fields that show up:  
- **Directory Path:** the path to the directory containing the files you wish to run the program with. I recommend puting your files inside the empty ``` test_files ``` folder included in this repository and putting the path to it, or you can just give the program any directory within your machine.  
- **Original Text:** write whatever text you want to search for.  
- **New Text:** write whatever you want the ``` Original Text ``` to be replaced with.     
- **Optional Log File:** this very much optional field can be used if you want to create and save a log file for this specific run of the program. You can just type what you wish to call said file (e.g.: ``` log_1.txt ```).
  
    - Alternatively: you can type the entire directory if you want it saved somewhere else other than the directory for this repository on your machine (e.g.: ``` C:\User\Documents\log_1.txt ```). **Just make sure to include a name for the file!** Otherwise you will be met with a very lovely error message...
    - Whatever you don't, **don't place the files you want the program to make changes to on the main directory of this repository!** Otherwise the program will change everything that is not inside a zip file - yes, including other code files. And this will mess up a bunch of things and give you a headache, so just take my word for it and put those files on another folder (I left you a pretty empty folder ``` test_files ``` specifically for that) or to another folder somewhere in your machine.

### The Not-So-Easy Way: Running with Terminal/CMD

To do this, you need to use a copy of TextReplacerClass that contains a main block to run the class using command-line arguments. _I initially had this main block commented out on ``` TextReplacerClass.groovy ``` but decided to make a copy of the file with it specifically for terminal use for conveniency of the user. The code is exactly the same in these two, the only difference is the main block added on lines 96 to 112 of ``` TERMINAL_TextReplacerClass.groovy ```._  

1. Open your terminal/cmd in the main folder of this repository (in my case that would be ``` C:\Users\maria\Documents\GitHub\Text-Search-and-Replace-Utility-with-Groovy ```).

2. Type the following command changing the necessary sections to fit your local path and what you want the program to do:  

``` groovy TERMINAL_TextReplacerClass.groovy \path\to\directory "Original Text" "New Text" "\path\to\logfile.txt" ```

A brief explanation of what each of the 4 parameters do can be found in the description of [The Easy Way: Running with UI](#the-easy-way-running-with-ui). **I strongly recommend you reaad it.**   

## Program Flow  

1. The program receives the directory path, search text, and replacement text as input.

2. It recursively traverses the directory and subdirectories, looking for text files.

3. For each file, it searches for the specified text/pattern.

4. If found, the program replaces the text and creates a backup of the original file.

5. The log file (if provided) records details of all modified files.

## Algorithm Choice  

The search and replace operation leverages Groovy's powerful string manipulation and file handling capabilities. By reading each file as a text stream and processing it line by line, the program efficiently handles both small and large files. The use of recursion allows for easy navigation through subdirectories. This design ensures that the utility is lightweight, flexible, and scalable for various directory structures.  

## Logging and Error Handling  

The program logs key details such as start time, end time, errors encountered, and where the pattern was found in the files.  

In case of any errors, such as file access issues, the program catches and logs the error, ensuring it doesn't interrupt the entire search and replace process.  

To check examples of how the program deals with logging, pleace check the respective tests descripbed in ``` Tests.docx ``` and saved in ``` Test Results and Logs.zip ```. 

## Project Structure  

- **TextReplacerClass.groovy:** core logic for search, replace, and logging
- **TextRepalcerUI.groovy:** simple user interface to run the utility
- **TERMINAL_TextReplacerClass:** modified TextReplacerClass.groovy with a main block that lets you run it with terminal/cmd.
- **test.groovy:** a simple one line program to print "Hello, Groovy!". You can use it to test it you have Groovy correctly installed in your machine by running the program on terminal. 
- **README.md:** the file you are reading right now with lots of cool things about this project!
- **AboutGroovy.md:** a brief introduction to Groovy and its uses (if you don't want to google it for yourself).
-  **test_files:** an empty folder that you can use to place your test files inside.
-  **Test Results and Logs.zip:** a zip folder with records of the 10 tests I ran to check if the program was working correctly. The tests were only ran using the UI version since if it runs through the UI it 100% runs just through terminal.
-  **original_test_files.zip:** a zip folder with examples of the test files I used in case you want to use them for yourself (you can always make more by asking ChatGPT to generate some for you, or you can get creative and write them yourself!).
-  **Tests.docx:** a word document I used to write down 10 tests to check my program was working correctly. This file only contains the list of what I did. To check the output of each test yourself, please check the files inside ``` Test Results and Logs.zip ```.

## Development Time

Estimated total time spent learning Groovy and developing this app:  
    - Research: 3 hours  
    - Coding: 6 hours  
    - Testing and Debugging: 3 hours     

## License  

This project is free to use and modify under the MIT license. 


