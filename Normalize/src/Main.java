
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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


    static PrintWriter getPrintWriter() throws IOException{
        File output = new File("output.txt");
        return new PrintWriter(output);
    }

    // Function to write to output file
    static void writeOutput(String line, PrintWriter pw, boolean isLastLine){
        // If printing the final line, make sure there is no addtion blank line
        if(isLastLine){
            pw.print(line);

        }
        else if(line.length()!=0){
            pw.println(line);
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = getInputFile();
        if (br == null){
            return;
        }

        PrintWriter pw = getPrintWriter();
        String nextLine = br.readLine();
        String line = nextLine;
        boolean isLastLine = (nextLine == null);
        while(!isLastLine){
            System.out.println(line);
            line = Normalizer.formatOneSpace(line);
            line = Normalizer.formatSpecial(line);
            line = Normalizer.formatNoSpaceBeforeSpecialChar(line);
            line = Normalizer.noSpaceBetweenQuotes(line);
            line = Normalizer.firstCharUpper(line);
            nextLine = br.readLine();
            isLastLine = (nextLine == null);
            writeOutput(line, pw, isLastLine);
            line = nextLine;
        }
        pw.close();
        br.close();

    }

}
