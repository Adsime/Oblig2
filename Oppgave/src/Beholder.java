/**
 * Created by Adrian on 02/10/2015.
 */
import java.util.*;
import java.util.function.Predicate;

public interface Beholder<T> extends Iterable<T>  // ny versjon
{
    public boolean leggInn(T t);       // legger inn t i beholderen
    public boolean inneholder(T t);    // sjekker om den inneholder t
    public boolean fjern(T t);         // fjerner t fra beholderen
    public int antall();               // returnerer antallet i beholderen
    public boolean tom();              // sjekker om beholderen er tom
    public void nullstill();           // t�mmer beholderen
    public Iterator<T> iterator();     // returnerer en iterator

    default boolean fjernHvis(Predicate<? super T> p)  // betingelsesfjerning
    {
        Objects.requireNonNull(p);                       // kaster unntak

        boolean fjernet = false;
        for (Iterator<T> i = iterator(); i.hasNext(); )  // l�kke
        {
            if (p.test(i.next()))                          // betingelsen
            {
                i.remove(); fjernet = true;                  // fjerner
            }
        }
        return fjernet;
    }

} // grensesnitt Beholder