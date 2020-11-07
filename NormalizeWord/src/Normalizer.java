
import java.util.StringTokenizer;

public class Normalizer {

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

    static String formatCase(String line) {
        line = line.toLowerCase();
        StringBuilder builder = new StringBuilder(line);

        // Iterate over each character in the line
        for (int i = 0; i < builder.length(); ++i) {
            char ch = builder.charAt(i);

            // if the special character is not at the end of the line
            if (isSpecialChar(ch) && i + 1 < builder.length()) {
                // Insert a space after special character
                if (!Character.isWhitespace(builder.charAt(i + 1))) {
                    builder.insert(i + 1, ' ');
                }
                // The first character after a dot, question mark and exclamation mark must be Uppercase
                if ((ch == '.') && i + 2 < builder.length()) {
                    char ch0 = builder.charAt(i + 2);
                    builder.setCharAt(i + 2, Character.toUpperCase(ch0));
                }
            }
        }
        return builder.toString();
    }

    static String formatNoSpaceBeforeSpecialChar(String line) {
        StringBuilder builder = new StringBuilder(line);

        // Iterate over every character in the builder
        for (int i = 0; i < builder.length(); i++) {
            // If character is a special character then delete any whitespace before it
            if (builder.charAt(i) == ' ' && isSpecialChar(builder.charAt(i + 1))) {
                builder.deleteCharAt(i);
            }
        }
        return builder.toString();
    }

    static boolean isSpecialChar(char ch) {
        return (ch == '.') || (ch == ',');
    }

    static boolean isEmptyLine(String line) {
        return line.length() == 0;
    }

    static String formatQuotes(String line) {
        int countQuote = 0;
        StringBuilder builder = new StringBuilder(line);

        for (int i = 0; i < builder.length(); i++) {
            if(builder.charAt(i) == '"'){
                countQuote ++;
                if(countQuote%2 == 1){
                    if(i>0){
                        if(!Character.isWhitespace(builder.charAt(i-1))){
                            builder.insert(i, ' ');
                            i++;
                        }
                    }
                    if(i+1<builder.length()){
                        if(Character.isWhitespace(builder.charAt(i+1))){
                            builder.deleteCharAt(i+1);
                        }
                    }
                } else {
                    if(i+1<builder.length()){
                        if(!Character.isWhitespace(builder.charAt(i+1))){
                            builder.insert(i+1, ' ');
                        }
                    }
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
