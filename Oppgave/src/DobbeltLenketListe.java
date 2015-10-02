/**
 * Created by Adrian on 02/10/2015.
 */
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;

public class DobbeltLenketListe<T> implements Liste<T>
{

    private static final class Node<T>   // en indre nodeklasse
    {
        // instansvariabler
        private T verdi;
        private Node<T> forrige, neste;

        // konstruktør
        private Node(T verdi, Node<T> forrige, Node<T> neste)
        {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }
    }

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int antallEndringer;   // antall endringer i listen

    // hjelpemetode
    private Node<T> finnNode(int indeks)
    {
        Node<T> n;
        if(indeks < antall/2) {
            n = hode;
            for(int i = 0; i < indeks; i++) {
                n = n.neste;
            }
            return n;
        } else {
            n = hale;
            for(int i = antall-1; i > indeks; i--) {
                n = n.forrige;
            }
            return n;
        }
    }

    // konstruktør
    public DobbeltLenketListe()
    {
        hode = hale = null;
        antall = 0;
        antallEndringer = 0;
    }

    // konstruktør
    public DobbeltLenketListe(T[] a)
    {
        Objects.requireNonNull(a, "Tabellen a er null!");
        Node<T> forrige = hode = hale = new Node<>(a[0], null, null);
        antall++;
        for(int i = 1; i < a.length; i++) {
            if(a[i] == null) {
                continue;
            }
            Node n = new Node(a[i], forrige, null);
            hale = forrige = forrige.neste = n;
            antall++;
        }
    }

    @Override
    public int antall()
    {
        return antall;
    }

    @Override
    public boolean tom()
    {
        return antall == 0;
    }

    @Override
    public boolean leggInn(T verdi)
    {
        Objects.requireNonNull(verdi, "Verdien er null!");
        Node<T> n = new Node<>(verdi, null, null);
        if(antall == 0) {
            hode = n;
            hale = n;
            antallEndringer = ++antall;
            return true;
        } else {
            hale.neste = n;
            n.forrige = hale;
            hale = n;
            antall++;
            antallEndringer++;
            return true;
        }
    }

    @Override
    public void leggInn(int indeks, T verdi)
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public boolean inneholder(T verdi)
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public T hent(int indeks)
    {
        indeksKontroll(indeks, false);
        return finnNode(indeks).verdi;
    }

    @Override
    public int indeksTil(T verdi)
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public T oppdater(int indeks, T nyverdi)
    {
        indeksKontroll(indeks, false);
        Objects.requireNonNull(nyverdi);
        Node<T> n = finnNode(indeks);
        Node<T> ny = new Node<>(nyverdi, null, null);
        ny.forrige = n.forrige;
        ny.neste = n.neste;
        if(n.neste == null) {
            n.forrige.neste = ny;
        } else if(n.forrige == null) {
            n.neste.forrige = ny;
        } else {
            n.neste.forrige = ny;
            n.forrige.neste = ny;
        }
        antallEndringer++;
        return n.verdi;
    }

    @Override
    public boolean fjern(T verdi)
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public T fjern(int indeks)
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public void nullstill()
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        Node<T> n = hode;

        while(n != null) {
            if(n.neste == null) {
                s.append(n.verdi.toString());
                n = n.neste;
            } else {
                s.append(n.verdi.toString());
                s.append(", ");
                n = n.neste;
            }
        }
        return "["+s.toString()+"]";
    }

    public String omvendtString() {
        StringBuilder s = new StringBuilder();
        Node<T> n = hale;

        while(n != null) {
            if(n.forrige == null) {
                s.append(n.verdi.toString());
                n = n.forrige;
            } else {
                s.append(n.verdi.toString());
                s.append(", ");
                n = n.forrige;
            }
        }
        return "["+s.toString()+"]";
    }

    @Override
    public Iterator<T> iterator()
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    public Iterator<T> iterator(int indeks)
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    private class DobbeltLenketListeIterator implements Iterator<T>
    {
        private Node<T> denne;
        private boolean fjernOK;
        private int forventetAntallEndringer;

        private DobbeltLenketListeIterator()
        {
            denne = hode;     // denne starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            forventetAntallEndringer = antallEndringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks)
        {
            throw new UnsupportedOperationException("Ikke laget ennå!");
        }

        @Override
        public boolean hasNext()
        {
            return denne != null;  // denne koden skal ikke endres!
        }

        @Override
        public T next()
        {
            throw new UnsupportedOperationException("Ikke laget ennå!");
        }

        @Override
        public void remove()
        {
            throw new UnsupportedOperationException("Ikke laget ennå!");
        }

    } // DobbeltLenketListeIterator



} // DobbeltLenketListe
