
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
    static void writeOutput(String line, PrintWriter pw, String nextLine){
        // If printing the final line, make sure there is no addtion blank line
        if(nextLine == null){
            pw.print(line);
        }
        // If the line is not empty then write to file
        else if(line.length()!= 0){
            pw.println(line);
        } 

    }


    public static void main(String[] args) throws IOException {
        // Step 1: setup input and output
        BufferedReader br = getInputFile();
        if (br == null){
            return;
        }

        PrintWriter pw = getPrintWriter();

        // Step 2: normalize the text
        String nextLine = br.readLine();
        String line = nextLine;
        boolean isLastLine = (nextLine == null);


        // while last line has not been reach, normalize the text
        while(nextLine!=null){
            line = Normalizer.formatOneSpace(line);
            line = Normalizer.formatCase(line);
            line = Normalizer.formatNoSpaceBeforeSpecialChar(line);
            line = Normalizer.formatQuotes(line);
            line = Normalizer.formatFirstCharUpperCase(line);
            line = Normalizer.addLastDot(line);
            nextLine = br.readLine();
            isLastLine = (nextLine == null);
            writeOutput(line, pw, nextLine);
            line = nextLine;
        }
        System.out.println("Normalize successfully......");
        pw.close();
        br.close();

    }

}
