import java.util.ArrayList;

/**
 * This class represents a planet in the SolarSystem. It implements the moves class because it is moving and the HasSatelites, because currently moons orbit it.
 * @author Mark Lim - Lancaster University Year 2 Student
 */
public class Planet extends SolarBody implements Moves,HasSatelites<Moon>
{
    private double orbitalVelocity;
    private ArrayList<Moon> moons = new ArrayList<Moon>();
    
    /**
     * Constructor.
     * @param n The name of the Planet.
     * @param dis The distance of the Planet from the centre of the Universe.
     * @param a The orbital angle of the Planet.
     * @param dia The diameter of the Planet.
     * @param c The color of the Planet.
     * @param v The orbital velocity of the Planet.
     */
    public Planet(String n, double dis, double a, double dia, String c, double v)
    {
        super(n,dis,a,dia,c);
        orbitalVelocity = v;
    }
    
    /**
     * Adds a satelite of type Moon to the ArrayList.
     * @param m The moon.
     */
    public void addSatelite(Moon m)
    {
        System.out.println("The " + m.getName() + " is now orbiting the " + this.getName());
        moons.add(m);
    }
    
    /**
     * Returns the ArrayList containing Moons.
     * @return ArrayList containing Moons.
     */
    public ArrayList<Moon> getSatelites()
    {
        return moons;
    }
    
    /**
     * Gives the ability for the planet to move in the solar system, by increasing the angle based on the orbitalVelocity set.
     */
    public void move()
    {
        this.setAngle(this.getAngle() + orbitalVelocity);
        if(this.getAngle() > 360)
        {
            this.setAngle(0);
        }
    }
}

