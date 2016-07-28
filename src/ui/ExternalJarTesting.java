
package ui;

import org.apache.commons.codec.language.Metaphone;

public class ExternalJarTesting {
    public static void main(String[] args) {
        Metaphone mph = new Metaphone();
        System.out.println(mph.encode("eraser"));
        System.out.println(mph.encode("ERRazzer"));
    }
}
