# Database Schema
Ran out of time before I could implement any database connections but here is a rough outline of what I expected to use:
![DB Schema](https://i.imgur.com/hxrNOBS.png)
***

# Build Instructions

1. Clone the repository by selecting *"Clone or download"* and copy the HTTPS address
2. Install [IntelliJ](https://www.jetbrains.com/help/idea/installation-guide.html) or similar IDE if you have not already
3. (In IntelliJ) go to *`File -> New -> Project from Version Control -> Git`*
4. Paste the repository URL and select *"Clone"*
5. Go to *`Project -> Project Structure -> Project`* and make sure the "Project SDK" is set to **Java 11.0.5** or greater
6. Program should be ready to compile and run

***

# Installation
1. Install Java 11 or higher
    * Detailed instructions can be found on [Oracle's official site](https://docs.oracle.com/en/java/javase/11/install/installation-jdk-microsoft-windows-platforms.html)
2. Navigate to this repository's [releases](https://github.com/kylezinsser/ParkingGarageBackend/releases) and download v0.1 *"ParkingGarage_KyleZinsser.jar"*
3. Open the terminal/command prompt and navigate to the file location
4. Check Java version with `java -version` to make sure you are running version 11 or higher
5. Run the command `java -jar ParkingGarage_KyleZinsser.jar` to execute the program and view the results

## Sample Output:
May not be pretty, but the console displays the resulting garage status. Each parking spot in a row is bracketed with 
sqaure brackets. Small parking spaces contain a single occupied status indicator, compact spaces use two, and large spaces
have three.
* For example, [O] would be a vacant small parking space. [XXX] would be an occupied large space.

![Sample Output](https://i.imgur.com/n2oxhyM.png)