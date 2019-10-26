import java.util.ArrayList;

/**
 * This class provides a graphical user interface to a model of the solar system
 * @author Mark Lim - Lancaster University Year 2 Student
 */
public class Star extends SolarBody implements HasSatelites<Planet>
{
    private ArrayList<Planet> planets = new ArrayList<Planet>();
    private ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>(); // custom
    
    public Star(String n, double dia, String c)
    {
        super(n,0,0,dia,c);
    }
    
    /**
     *
     */
    public void addSatelite(Planet p)
    {
        System.out.println("The " + p.getName() + " is now orbiting the " + this.getName());
        planets.add(p);
    }
    
    /**
     *
     */
    public ArrayList<Planet> getSatelites()
    {
        return planets;
    }
    
    /**
     * CUSTOM USER
     */
    public void addAsteroid(Asteroid a)
    {
        asteroids.add(a);
    }
    
    /**
     * CUSTOM USER
     */
    public ArrayList<Asteroid> getAsteroids()
    {
        return asteroids;
    }

}
