/**
 * Created by andrea on 02/09/15.
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FileManager {





    public static boolean fileExists (File file){
        return file.exists();
    }
    public static String [] manageStrings () {
        String fileName = "";
        File file = new File(fileName);



        String currentLine = null;
        String[] arr;
        arr = new String[0];
        try {
            FileReader fileReader = null;
            do {





                if (fileExists(file)) {
                    System.out.println("signature file exists, will proceed the scan");
                    fileReader = new FileReader(fileName);
                }

                else if (!(fileExists(file))) {
                    System.out.println("signature file doesn't exists, scan interrupted until correct file path is given");
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Enter a file name: ");

                    fileName = scanner.nextLine();
                    file = new File(fileName);
                    fileReader = new FileReader(fileName);
                }


                // Always wrap FileReader in BufferedReader.
                BufferedReader bufferedReader = new BufferedReader(fileReader);
            }  while (!fileExists(file));
            Scanner sc = new Scanner(new File(fileName));
            List<String> lines = new ArrayList<String>();
            while (sc.hasNextLine()) {
                lines.add(sc.nextLine());
            }

            arr = lines.toArray(arr);
            int zz = arr.length;
            for (int i =0;i<zz-1;++i)
                System.out.println(arr[i]);
        } catch (FileNotFoundException fx) {
            fx.printStackTrace();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return arr;
    }


}





