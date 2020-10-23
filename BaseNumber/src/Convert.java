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
    
    public static long convertBinToDec() {
        String bin = Validate.getBinary();
        long result = 0;
        int index = 0;
        for (int i = bin.length() - 1; i >= 0; i--) {
            result += Math.pow(bin.charAt(i), index);
            System.out.println(result + "=" + bin.charAt(i) + "^" + index);
        }

        return result;
    }
}
