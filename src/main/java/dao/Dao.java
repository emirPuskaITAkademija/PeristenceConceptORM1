package dao;

import java.util.List;

/**
 * Ovaj interfejs definira standard čitanja
 * List<E> elemenata i pisanja liste elemenata u neki medij.
 *
 * <p>
 * Ovaj interfejs će imati apstraktne metode za read i write.
 * </p>
 *
 * @param <E>
 */
public interface Dao<E> {
    /**
     * Ova metoda treba da pročita trajno snimljene objekte tipa E i da nam
     * vrati pročitane elemente u vidu List<E>.
     *
     * @return elements
     */
    public List<E> readElements();

    /**
     * Ova metoda će uzeti elemente koje je dobila kroz parametar funkcije i
     * snimit će elemente u neki medij.
     * <p>
     * Koji medij će se koristiti za snimanje zavisi od konkretne implementacije ove metode.
     *
     * @param elements
     */
    public void writeElements(List<E> elements);

}
