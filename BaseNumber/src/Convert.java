/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Khoa
 */
public class Convert {

    public static long convertBinToDec(String bin) {
        long result = 0;
        int base = 2;
        for (int i = bin.length() - 1; i >= 0; i--) {
            result += base * (bin.charAt(i) - 48);
            base = base * 2;
//            System.out.println(result + "=" + bin.charAt(i) + "^" + index);
        }

        return result;
    }

    public static String convertDecToBin(long dec) {
        String result;
        StringBuilder sb = new StringBuilder();
        while (dec > 0) {
            if (dec % 2 == 0) {
                sb.append('0');
//                System.out.println(sb.toString());
            } else {
                sb.append('1');
//                System.out.println(sb.toString());
            }
            dec = (dec - dec % 2) / 2;
            
        }
        result = sb.reverse().toString();
        return result;
    }

    public static long convertHexToDec(String hex) {
        long result = 0;
        int base = 1;

        // Extracting character as digits starting from last char
        for (int i = hex.length() - 1; i >= 0; i--) {
            if (hex.charAt(i) >= '0' && hex.charAt(i) <= '9') {
                result += (hex.charAt(i) - 48) * base;
            } else {
                result += (hex.charAt(i) - 55) * base;
            }
            base *= 16;
        }
        return result;
    }

    public static String convertDecToHex(long dec) {
        String result;
        StringBuilder sb = new StringBuilder();

        while (dec > 0) {
            // if remaining is greater than 10, append character to result, else append the remaining number to result
            if (dec % 16 > 10) {
                sb.append(dec % 16 + 48);
            } else {
                sb.append(dec % 16 + 55);
            }
            dec = (dec - dec % 16) / 16;
        }

        result = sb.reverse().toString();
        return result;
    }
}
