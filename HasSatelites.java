import java.util.ArrayList;
/**
 * This class provides a graphical user interface to a model of the solar system
 * @author Mark Lim - Lancaster University Year 2 Student
 */
interface HasSatelites<E>
{
    public void addSatelite(E e);
    public ArrayList<E> getSatelites();
}
