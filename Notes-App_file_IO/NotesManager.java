import java.io.*;
import java.util.Scanner;
public class NotesManager {
    public static void main(String[] args) {
        boolean Continue = true; 
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Welcome to Notes Manager");
            System.out.println("To write Enter  : 1");
            System.out.println("To read enter   : 2");
            System.out.println("To delete enter : 3");
            System.out.println("to exit enter   : 4");

            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    WriteToFile(scanner);
                    break;

                case "2":
                    readFromFile(scanner);
                    break;

                case "3":
                    deleteFile(scanner);
                    break;

                case "4":
                    Continue=false;
                    System.out.println("Goodbye!");
                    scanner.close();
                    break;
                    
        }
    } while (Continue);
    
    }
    public static void WriteToFile(Scanner scanner){
        
        System.out.println("Enter the file Name :");
        String file_Name = scanner.nextLine();
        System.out.println("Enter the Content :");
        String Content = scanner.nextLine();

        String filePath = "C:\\Users\\Mradu\\Desktop\\" + file_Name + ".txt";
        
        try{
        BufferedWriter bw = new BufferedWriter(
            new FileWriter(filePath));
            bw.write(Content);
            bw.close();
        }catch(IOException e){
            System.out.println(e);
        }
    } 
    public static void readFromFile(Scanner scanner){
        
        System.out.println("Enter the file Name to Display :");
        String file_Name = scanner.nextLine();
        
        String filePath = "C:\\Users\\Mradu\\Desktop\\" + file_Name + ".txt";
        
        try{
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            
            String s;
            while ((s = br.readLine()) != null) {
                System.out.println("---Your Notes---\n");
                System.out.println(s);
                System.out.println("\n----------------\n");
            }
            br.close();
        }catch(IOException e){
            System.out.println(e);
        }
    } 

    public static void deleteFile(Scanner scanner) {

    System.out.println("Enter the file Name to delete:");
    String file_Name = scanner.nextLine();

    String filePath = "C:\\Users\\mradu\\Desktop\\" + file_Name + ".txt";

    File file = new File(filePath);

    if (file.exists()) {
        if (file.delete()) {
            System.out.println("File deleted successfully!");
            System.out.println();
        } else {
            System.out.println("Failed to delete the file.");
            System.out.println();
        }
    } else {
        System.out.println("File does not exist.");
        System.out.println();
    }
}

}

