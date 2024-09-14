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


