
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*this class is used for create the file with user inputs
and write the content into the file by allowing
user input data, at last print the file data*/
public class NoteKeeper {
  
   public static void main(String[] args) throws IOException, ClassNotFoundException {
       Scanner scanner = new Scanner(System.in);
       System.out.println("Enter the Directory Name: ");
       String directory=scanner.next();
       System.out.println("Enter file name with .txt extension");
       String filename = scanner.next();
       /*i'm calling createAndWriteContentFile method by passiing directory and filename is used for create the file and write the content into the file */
       createAndWriteContentFile(directory, filename);
/* i'm calling readAndPrintFile method by passiing directory and filename for reda the whole file data and print
into the console*/
       readAndPrintFile(directory, filename);
      
      
   }
  
  
  
   public static void createAndWriteContentFile(String directory, String filename) throws IOException{
       File file = new File(directory+"\\"+filename);
       if (file.createNewFile()){
       System.out.println("File is created!");
       }else{
       System.out.println("File already exists.");
       }
      
       /*String str = "File Handling in Java using "+
" FileWriter and FileReader"; */
      
       Scanner scanner = new Scanner(System.in);
       System.out.println("Enter Data: ");
       String str=scanner.nextLine();
  
// attach a file to FileWriter
FileWriter fw=new FileWriter(file);
  
// read character wise from string and write
// into FileWriter
for (int i = 0; i < str.length(); i++)
fw.write(str.charAt(i));
  
// System.out.println("Writing successful");
//close the file
fw.close();
  
   }
  
  
   public static void readAndPrintFile(String directory, String filename) throws IOException{
       // variable declaration
int ch;
  
File file = new File(directory+"\\"+filename);
  
// check if File exists or not
FileReader fr=null;
try
{
fr = new FileReader(file);
}
catch (FileNotFoundException fe)
{
System.out.println("File not found");
}
  
System.out.println("File Data: ");
// read from FileReader till the end of file
while ((ch=fr.read())!=-1)
System.out.print((char)ch);
  
// close the file
fr.close();
   }

}