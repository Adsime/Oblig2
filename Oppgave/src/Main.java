/**
 * Created by Adrian on 02/10/2015.
 */
public class Main {
    public static void main(String... args) {
        String[] s = {"Ole", null, "Per", "Kari", null};
        DobbeltLenketListe<String> liste = new DobbeltLenketListe<>(s);
        System.out.println(liste.antall() + " " + liste.tom());
        liste.leggInn("Petter");
        System.out.println(liste.toString());
        System.out.println(liste.omvendtString());
        System.out.println(liste.hent(1));
        System.out.println(liste.oppdater(0, "Fatih"));
        System.out.println(liste.toString());
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
