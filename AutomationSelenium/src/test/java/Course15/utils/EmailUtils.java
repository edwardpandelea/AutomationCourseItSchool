package Course15.utils;

/**
 * Clasă utilitară pentru generarea de adrese de email aleatorii.
 * Este folosită în teste automate atunci când trebuie creat un cont nou
 * și nu vrem să folosim aceeași adresă de email de două ori.
 */
public class EmailUtils {

    /**
     * Generează o adresă de email aleatorie în format:
     *  - 5 litere mici (a-z)
     *  - 5 cifre (0-9)
     *  - sufixul "@email.com"
     *
     * @return adresa de email generată, de exemplu "abcde12345@email.com"
     */
    public static String randomEmail() {

        // ---------------------------
        // Generăm partea cu litere
        // ---------------------------
        String letters = "";
        for (int i = 0; i < 5; i++) {
            /*
             * 'a' în Java are codul ASCII 97
             * 'b' -> 98, ..., 'z' -> 122
             * Math.random() * 26 -> număr aleator între 0 și 25
             * 'a' + acel număr -> cod între 97 și 122 (litere a-z)
             * (char) -> convertește codul numeric în caracter
             */
            letters += (char) ('a' + Math.random() * 26);
        }

        // ---------------------------
        // Generăm partea cu cifre
        // ---------------------------
        String digits = "";
        for (int i = 0; i < 5; i++) {
            /*
             * Math.random() * 10 -> număr aleator între 0 și 9.999...
             * (int) -> ia doar partea întreagă (0 până la 9)
             */
            digits += (int) (Math.random() * 10);
        }

        // ---------------------------
        // Construcția finală a email-ului
        // ---------------------------
        return letters + digits + "@email.com";
    }
}