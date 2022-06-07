package vigenerecipher;

import java.util.Scanner;

public class VigenereCipher {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Encrypt (E) / Decrypt (D): ");
        String choice = scan.nextLine();
        System.out.println("Enter String: ");
        String str = scan.nextLine();
        System.out.println("Enter Key: ");
        String key = scan.nextLine();
        String out = "";
        int keyCount = 0;
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i), k = key.charAt(keyCount % key.length()), cOff = (c >= 'a' ? 'a' : 'A'), kOff = (k >= 'a' ? 'a' : 'A');
            if (!Character.isLetter(c)) {
                out += Character.toString(c);
            } else {
                if (choice.toLowerCase().equals("e")) {
                    out += Character.toString((char) (((c - cOff + k - kOff) % 26) + cOff));
                } else {
                    out += Character.toString((char) ((((c - cOff) - (k - kOff) + 26) % 26) + cOff));
                }
                keyCount++;
            }
        }
        System.out.println(out);
    }
}
