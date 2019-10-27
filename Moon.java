/**
 * This class represents a Moon in the SolarSystem. It implements the moves class because it is moving.
 * @author Mark Lim - Lancaster University Year 2 Student
 */

public class Moon extends SolarBody implements Moves
{
    private double orbitalVelocity;
    
    /**
     * Constructor.
     * @param n The name of the Moon.
     * @param dis The distance of the Moon from the centre of the Universe.
     * @param a The orbital angle of the Moon.
     * @param dia The diameter of the Moon.
     * @param c The color of the Moon.
     * @param v The orbital velocity of the Moon.
     */
    public Moon(String n, double dis, double a, double dia, String c, double v)
    {
        super(n,dis,a,dia,c);
        orbitalVelocity = v;
    }
    /**
     * Gives the ability for the Moon to move in the solar system, by increasing the angle based on the orbitalVelocity set.
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

