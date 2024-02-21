package Files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MyFiles {
    Scanner kScan = new Scanner(System.in);
    String fileName = "myFile";
    File myFileObj;

    public MyFiles() {
        FilesCreator();
        Write();
        ReadFromFile();
    }

    private void FilesCreator() {
        myFileObj = new File(fileName);
        try {
            if (myFileObj.createNewFile()) {
                System.out.println(fileName + " has been created");
            } else {
                System.out.println(fileName + " already exists");
            }
        } catch (IOException e) {
            System.out.println("File could not be created");
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    private void Write2File() {
        try {
            FileWriter myWriterObj = new FileWriter(fileName, true);
            System.out.println("Enter text here: ");
            myWriterObj.write(kScan.nextLine());
            //kScan.nextLine();
            myWriterObj.close();
            System.out.println("You wrote to " + fileName);
        } catch (IOException e) {
            System.out.println("Could not write to file " + fileName);
        }
    }

    private void Overwrite2File() {
        try {
            FileWriter myWriterObj = new FileWriter(fileName, false);
            System.out.println("Enter text to overwrite here: ");
            myWriterObj.write(kScan.nextLine());
            //kScan.nextLine();
            myWriterObj.close();
        } catch (IOException e) {
            System.out.println("Could not overwrite fo file " + fileName);
        }
    }

    private void Write() {
        System.out.println("Choose an option: \n" +
                "1. Write new text in file \n" +
                "2. Overwrite existing text in file");
        int option = kScan.nextInt();
        kScan.nextLine();
        try {
            if (option == 1) {
                Write2File();
            } else if (option == 2) {
                Overwrite2File();
            }
        } catch (Exception e) {
            System.out.println("Please try again");
        }
    }

    private void ReadFromFile() {
        try {
            Scanner rScan = new Scanner(myFileObj);
            while (rScan.hasNextLine()) {
                System.out.println(rScan.hasNext());
            }
        } catch (Exception e) {
            System.out.println("Could not read file");
        }
    }
}