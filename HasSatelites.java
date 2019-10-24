import java.util.ArrayList;
/**
 * So that programmers can 'mark' Objects that have Satelites
 */
interface HasSatelites<E>
{
    public void addSatelites(E e);
    public ArrayList<E> getSatelites();
}
