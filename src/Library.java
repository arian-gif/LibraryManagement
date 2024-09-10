import java.util.*;
import java.io.*;

interface LibraryItem{//hi
    String getTitle();
    String getAuthor();
    int getPages();
    String getType();
    boolean isAvailable();

}
class AbstractLibraryItem implements LibraryItem{
    private String title;
    private String author;
    private int pages;
    private String type;
    private boolean available;
    

    public AbstractLibraryItem(String title, String author,int pages,String type) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.type = type;
        this.available = true;//starts true
        
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    
    public int getPages(){
        return pages;
    }
    
    public String getType(){
        return type;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrowItem() {
        if (available) {
            available = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is not available.");
        }
    }

    public void returnItem() {
        available = true;
        System.out.println(title + " has been returned.");
    }

}
public class Library{
    public static void main(String []args){

        List<AbstractLibraryItem> manager = new ArrayList<AbstractLibraryItem>();
        try{
            File myFile = new File("C:\\Users\\16473\\Desktop\\library\\LibraryManagement\\src\\books.txt"); 
            Scanner myFileReader = new Scanner(myFile); 

            while(myFileReader.hasNextLine()){
                String comma = myFileReader.nextLine();
                String [] data = comma.split(",");
                if(data.length==4){
                    String name = data[0];
                    String author = data[1];
                    int pages = Integer.parseInt(data[2]);
                    String type = data[3];
                    AbstractLibraryItem books = new AbstractLibraryItem(name, author, pages, type);
                    manager.add(books);
                }

            }
            myFileReader.close();
            System.out.println("hi");

        }
        catch (FileNotFoundException e) {
            System.out.println("in the catch");
            System.out.println("Error:");
             System.out.println("Your file does not exist");
          } // end catch

    }
}
