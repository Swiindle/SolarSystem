import java.util.ArrayList;
/**
 * This interface should be used if an object has satelites orbitting it, E.g the Sun.
 * @author Mark Lim - Lancaster University Year 2 Student
 */
interface HasSatelites<E>
{
    /**
     * Adds a satelite to the ArrayList of Type E.
     * @param e The satelite object that shall be added to the parent SolarBody orbit.
     */
    public void addSatelite(E e);
    /**
     * Returns an ArrayList of all the satelites orbitting the object.
     * @return The ArrayList.
     */
    public ArrayList<E> getSatelites();
}
