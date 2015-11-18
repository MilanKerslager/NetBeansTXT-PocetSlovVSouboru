// Spočtěte počet slov v souboru.
// Slova jsou ohraničena mezerami a novým řádkem.

package pocetslovvsouboru;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PocetSlovVSouboru {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("d:/pokus.txt"));
            String radek;
            int pocetslov = 0;
            while ((radek = br.readLine()) != null) {
                
                boolean zacaloslovo = false;
                for (int i=0; i<radek.length(); i++) {
                    // hledáme začátek slova
                    if (radek.charAt(i) != ' ') {
                        // nové slovo se započte jen na prvním písmenu slova
                        if (zacaloslovo == false) {
                            zacaloslovo = true;
                            pocetslov++;
                        }
                    } else {
                        // je mezera -> umožníme příchod nového slova
                        zacaloslovo = false;
                    }
                }
                System.out.println(radek);
            }
            br.close();
            System.out.println("Počet slov v souboru: "+pocetslov);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PocetSlovVSouboru.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PocetSlovVSouboru.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
