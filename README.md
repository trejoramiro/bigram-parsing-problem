# Bigram Parsing Problem 

Here are a few notes about my approach. 

 * The program expects the input text file to be passed as a command line argument. 
 * I used Intellij IDEA to code and, at times, execute my program.
 * I implemented the test suite using Junit5 and can be executed through an IDE. The Junit5 library will most likely need to be imported. `org.junit.jupiter:junit-jupiter:5.5.0`
 * I implemented the code all in BigramMain.java but in a real-world scenario I would place each class in its respective file. 

## Running the application
 1. Navigate to directory `bigram-parsing-problem\src\project` and run `javac BigramMain.java`
 
 2. Navigate back to directory `bigram-parsing-problem\src` and run `java project.BigramMain <path-to-file-name>` 
    - e.g. This is how I ran a txt file from my Desktop:`java project.BigramMain C:\Users\rtrejo\Desktop\bigrams.txt`
    
 3. I provided an example text file. Run `java project.BigramMain bigrams.txt`

## Prerequisites 

  * Java 8 or higher is needed to compile and run the code.  
  * Junit5 is needed to run the test suite. 
