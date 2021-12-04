import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final String  MENU = "_".repeat(40)+"\n********  MENU    ********\nls : list content (ls /path/to/folder). \nQ: quite.\n\n "+"_".repeat(40);
    private static final String  QUIT = "Q";
    private static final String  LS = "ls";

    private static int iden = 0;

    public static void main(String[] args) {
        Scanner consoleInput = new Scanner(System.in);
        File file = null;
        String choice = "";
        do{
            System.out.println(MENU);
            System.out.print("Choice: ");
            choice = consoleInput.nextLine();

            if(choice.startsWith("ls ")){
                //extract path
                String path = choice.substring(2).trim(); // ls (space)
                System.out.println("Open: "+path);
                // show tree
                try{
                    file = new File(path);

                    getContent(file);


                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                finally {

                }
            }
            else{
                System.out.println("Choice not recognized !");
            }
        }
        while(!choice.equals(QUIT));

        System.out.println("Quit...");
        consoleInput.close();
    }

    private static void getContent(File file ){

        if (!file.exists()){
            System.out.println("File does not exist!");
        }

        if(file.isFile()){
            System.out.println(""+"-".repeat(iden)+""+" <FILE>: "+file.getName()+ getAccessMode(file));

        }
        if(file.isDirectory()){

            System.out.println(""+"_".repeat(iden)+"|"+" <DIR>: "+file.getName());

            for (File file_: file.listFiles()) {
                 iden ++;
                 getContent(file_);
                 iden --;
            }
        }

    }

    private static String getAccessMode(File file){
        String mode =" [";
        if(file.isHidden()) mode+="Hidden";
        mode += file.canRead() ? "r" : "-";
        mode += file.canWrite() ? "w" : "-";
        mode += file.canExecute() ? "x" : "-";
        return mode+"]";
    }
}
