import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Adrian on 02/10/2015.
 */
public class Main {
    public static void main(String... args) {
        /*String[] s = {};//{"Ole", null, "Per", "Kari", null};
        DobbeltLenketListe<String> liste = new DobbeltLenketListe<>(s);
        System.out.println(liste.antall() + " " + liste.tom());
        liste.leggInn("test");
        liste.leggInn(0, "test1");
        System.out.println(liste.toString());
        System.out.println(liste.omvendtString());
        System.out.println(liste.antall());*/


        DobbeltLenketListe<String> liste =
                new DobbeltLenketListe<>(new String[]
                        {"Birger","Lars","Anders","Bodil","Kari","Per","Berit"});

        liste.fjernHvis(navn -> navn.charAt(0) == 'B'); // fjerner navn som starter med B

        System.out.println(liste + " " + liste.omvendtString());

        // Utskrift: [Lars, Anders, Kari, Per] [Per, Kari, Anders, Lars]

        /*DobbeltLenketListe<String> liste = new DobbeltLenketListe<>();

        String[] navn = {"Lars","Anders","Bodil","Kari","Per","Berit"};
        for (String s : navn) liste.leggInn(s);
        System.out.println(liste.toString());

        Iterator<String> i = liste.iterator();
        System.out.print(i.next() + " "); // skriver ut første verdi
        i.forEachRemaining(s -> System.out.print(s + " ")); // tar med resten

        /*String[] navn = {"Lars","Anders","Bodil","Kari","Per","Berit"};
        Liste<String> liste = new DobbeltLenketListe<>(navn);

        liste.forEach(null);

        /*String[] a = new String[1000000];
        for(int i = 0; i < a.length; i++) {
            a[i] = "Derp";
        }

        long tid = System.currentTimeMillis();
        DobbeltLenketListe<String> liste = new DobbeltLenketListe<>(a);
        liste.nullstill();
        System.out.println(System.currentTimeMillis() - tid);

        /*DobbeltLenketListe<Integer> liste = new DobbeltLenketListe<>();

        System.out.println(liste.toString() + " " + liste.omvendtString());

        for (int i = 1; i <= 3; i++)
        {
            liste.leggInn(i);
            System.out.println(liste.toString() + " " + liste.omvendtString());
        }

        System.out.println(liste.omvendtString());*/
    }
}
