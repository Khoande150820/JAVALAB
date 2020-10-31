
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    static BufferedReader getInputFile() {
        
            try {
                FileReader fr = new FileReader("input.txt");
                return new BufferedReader(fr);
            } catch (FileNotFoundException e) {
                System.err.println("No file is found");
                return null;
            }
        
    }
    
    static PrintWriter writeToFile() throws IOException{
        File output = new File("output.txt");
        return new PrintWriter(output);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = getInputFile();
        PrintWriter pw = writeToFile();
        String line ;
        while((line = br.readLine()) != null){
            System.out.println(line);
            line = Normalizer.formatOneSpace(line);
            line = Normalizer.formatSpecial(line);
            line = Normalizer.formatNoSpaceBeforeChar(line);
            pw.println(line);
            
        }
        pw.close();
        br.close();

    }

}
