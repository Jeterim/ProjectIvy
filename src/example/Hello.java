
package example;

import org.apache.commons.lang.WordUtils;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.*;

public class Hello {
    public static void main(String[] args) throws FileNotFoundException {
        String  message = "hello ivy !";
        System.out.println("standard message : " + message);
        System.out.println("capitalized by " + WordUtils.class.getName() 
                                + " : " + WordUtils.capitalizeFully(message));
        
        int monmax = 0;
        try {
            
            CSVReader reader = new CSVReader(new FileReader("data.csv")); 
            List<String[]> myEntries = reader.readAll();
            for(String[] entry : myEntries) {
                for (int i = 0; i < entry.length; i++) {
                    int nbread = Integer.parseInt(entry[i]);
                    if(nbread > monmax){
                        monmax = nbread;
                    }
                    System.out.println("Nombre lu : " + nbread);
                }

            }
            System.out.println("Nombre max : " + monmax);
        }
        catch(IOException e){
            System.out.println("Probleme de lecture du fichier csv" + e);
        }

    }
}
        