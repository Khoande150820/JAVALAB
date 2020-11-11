
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Main {
    static String formatQuote(String line){
        int countQuote = 0;
        StringBuilder sb = new StringBuilder(line);
        for (int i = 0; i< sb.length();i++){
            if (sb.charAt(i) == '"'){
                countQuote++;
                if(countQuote%2==1){
                    if(i>0 && !Character.isWhitespace(sb.charAt(i-1))){
                        sb.insert(i, ' ');
                        i++;
                    } if(i+1<sb.length()&& Character.isWhitespace(sb.charAt(i+1))){
                        sb.deleteCharAt(i+1);
                    }
                } else{
                    if (!Character.isWhitespace(sb.charAt(i+1))){
                        sb.insert(i+1, ' ');
                    }
                    if(Character.isWhitespace(sb.charAt(i-1))){
                        sb.deleteCharAt(i-1);
                    } 
                }
            }
        } return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        FileReader in = new FileReader("input.txt");
        BufferedReader br = new BufferedReader(in);
        String line;
        while((line = br.readLine())!=null){
            System.out.println(formatQuote(line));
        }
    }
    
}
