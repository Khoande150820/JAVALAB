
import java.util.StringTokenizer;

public class Normalizer {

    static String formatOneSpace(String input) {
        StringTokenizer st = new StringTokenizer(input);
        StringBuilder builder = new StringBuilder();
        while (st.hasMoreElements()) {
            builder.append(st.nextToken());
            builder.append(" ");
        }
        return builder.toString().trim();
    }

    static String formatSpecial(String line) {
        line = line.toLowerCase();
        StringBuilder builder = new StringBuilder(line);
        for (int i = 0; i < builder.length(); ++i) {
            char ch = builder.charAt(i);
            if (isSpecialChar(ch) && i + 1 < builder.length()) {
                if (!Character.isWhitespace(builder.charAt(i + 1))) {
                    builder.insert(i + 1, ' ');
                }
                if ((ch == '.' || ch == '?' || ch =='!') && i + 2 < builder.length()) {
                    char ch0 = builder.charAt(i + 2);
                    builder.setCharAt(i + 2, Character.toUpperCase(ch0));
                }
            }
        }
        return builder.toString();
    }

    static String formatNoSpaceBeforeChar(String line) {
        StringBuilder builder = new StringBuilder(line);

        for (int i = 0; i < builder.length(); i++) {
            if(builder.charAt(i) == ' ' && isSpecialChar(builder.charAt(i+1))){
                builder.deleteCharAt(i);
            }
        }
        return builder.toString();
    }

    static boolean isSpecialChar(char ch) {
        return (ch == '.') || (ch == ',') || (ch == ':')|| (ch == '?');
    }
}
