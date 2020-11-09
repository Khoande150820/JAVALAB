
import java.util.StringTokenizer;

public class Normalize {

    // Format only one space between character
    static String formatOneSpace(String input) {
        StringTokenizer st = new StringTokenizer(input);
        StringBuilder builder = new StringBuilder();

        // Separate all elements in StringTokenizer by one space only
        while (st.hasMoreElements()) {
            builder.append(st.nextToken());
            builder.append(" ");
        }
        return builder.toString().trim();
    }

    static String formatOneSpaceAfterSpecialChar(String line){
        StringBuilder builder = new StringBuilder(line);
        for (int i = 0; i < builder.length(); i++) {
            if(isSpecialChar(builder.charAt(i)) && i+1<builder.length()){
                if(!Character.isWhitespace(builder.charAt(i+1))){
                    builder.insert(i + 1, ' ');
                }
            }
        }
        return builder.toString();
    }
    
    // Capitalize neccesary character
    static String formatCase(String line) {
        line = line.toLowerCase();
        StringBuilder builder = new StringBuilder(line);

        // Iterate over each character in the line
        for (int i = 0; i < builder.length(); ++i) {
            char ch = builder.charAt(i);

            // if the special character is not at the end of the line
            if (isSpecialChar(ch) && i + 1 < builder.length()) {

                // The first character after a dot, question mark and exclamation mark must be Uppercase
                if ((ch == '.') && i + 2 < builder.length()) {
                    char ch0 = builder.charAt(i + 2);
                    builder.setCharAt(i + 2, Character.toUpperCase(ch0));
                }
            }
        }
        return builder.toString();
    }

    // Delete any space before comma, colon and dot
    static String formatNoSpaceBeforeSpecialChar(String line) {
        StringBuilder builder = new StringBuilder(line);

        // Iterate over every character in the builder
        for (int i = 0; i < builder.length(); i++) {
            // If character is a special character then delete any whitespace before it
            if (Character.isWhitespace(builder.charAt(i)) && isSpecialChar(builder.charAt(i + 1))) {
                builder.deleteCharAt(i);
            }
            
        }
        return builder.toString();
    }

    // return true if char is dot, comma or colon
    static boolean isSpecialChar(char ch) {
        return (ch == '.') || (ch == ',') || (ch == ':');
    }

    // return true if line is empty
    static boolean isEmptyLine(String line) {
        return line.length() == 0;
    }

    static String formatQuotes(String line) {
        int countQuote = 0;
        StringBuilder builder = new StringBuilder(line);
        
        // iterate over every char in the line
        for (int i = 0; i < builder.length(); i++) {
            // if quotes mark is found, increase countQuot
            if(builder.charAt(i) == '"'){
                countQuote ++;
                // quotes sign is begin quotes if countQuote is odd, else is end quotes
                if(countQuote%2 == 1){
                    // Make sure there is white space before begin quotes
                    if(i>0){
                        if(!Character.isWhitespace(builder.charAt(i-1))){
                            builder.insert(i, ' ');
                            i++;
                        }
                    }
                    // Make sure there is no space after begin quotes
                    if(i+1<builder.length()){
                        if(Character.isWhitespace(builder.charAt(i+1))){
                            builder.deleteCharAt(i+1);
                        }
                    }
                } else {
                    // Make sure there is one space after end quotes
                    if(i+1<builder.length()){
                        if(!Character.isWhitespace(builder.charAt(i+1))){
                            builder.insert(i+1, ' ');
                        }
                    }
                    // Make sure there is no space before end quotes
                    if (Character.isWhitespace(builder.charAt(i-1))){
                        builder.deleteCharAt(i-1);
                    }
                }
            }
        }

        return builder.toString().trim();
    }

    static String addLastDot(String line) {
        if (isEmptyLine(line)) {
            return line;
        } else {
            if (line.endsWith(".")) {
                return line;
            } else {
                return line + ".";
            }
        }
    }

    static String formatFirstCharUpperCase(String line) {
        if (!isEmptyLine(line)) {
            line = line.substring(0, 1).toUpperCase() + line.substring(1);
            return line;
        }
        return line;
    }
}
