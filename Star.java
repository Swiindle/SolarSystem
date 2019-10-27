import java.util.ArrayList;

/**
 * This class represents a star in the solar system. It currently stores planets orbitting it.
 * @author Mark Lim - Lancaster University Year 2 Student
 */
public class Star extends SolarBody implements HasSatelites<Planet>
{
    private ArrayList<Planet> planets = new ArrayList<Planet>();
    private ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>(); // custom
    
    
    /**
     * Constructor.
     * @param n The name of the star.
     * @param dia The diameter of the star.
     * @param c The color of the star.
     */
    public Star(String n, double dia, String c)
    {
        super(n,0,0,dia,c);
    }
    
    /**
     * Adds a satelite of type Planet to the ArrayList.
     * @param p The planet.
     */
    public void addSatelite(Planet p)
    {
        System.out.println("The " + p.getName() + " is now orbiting the " + this.getName());
        planets.add(p);
    }
    
    /**
     * Returns the ArrayList containing Planets.
     * @return ArrayList containing Planets.
     */
    public ArrayList<Planet> getSatelites()
    {
        return planets;
    }
    
    /**
     * CUSTOM USER: adds an asteroid to the arraylist.
     * @param a The asteroid.
     */
    public void addAsteroid(Asteroid a)
    {
        asteroids.add(a);
    }
    
    /**
     * CUSTOM USER: returns the arraylist of asteroids.
     * @return The ArrayList of Asteroids
     */
    public ArrayList<Asteroid> getAsteroids()
    {
        return asteroids;
    }

}
