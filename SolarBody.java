/**
 * This abstract class contains the definitions of what makes a SolarBody.
 * Extends the Point class.
 * @author Mark Lim - Lancaster University Year 2 Student
 */
public abstract class SolarBody extends Point
{
    private String name;            // the name of the SolarBody may be useful to a developer
    private double diameter;
    private String color;
    
    /**
     * Constructor.
     * @param n The Name of the SolarBody
     * @param dis The Distance of the Solar Body from the centre of the Universe.
     * @param a The orbital of the SolarBody.
     * @param dia The diameter of the SolarBody.
     * @param c The colour of this SolarBody, as a string. Case insentive. <p>One of: BLACK, BLUE, CYAN, DARK_GRAY, GRAY, GREEN, LIGHT_GRAY,
     * MAGENTA, ORANGE, PINK, RED, WHITE, YELLOW. Alternatively, a 24 bit hexadecimal string representation of an RGB colour is also accepted, e.g. "#FF0000"</p>
     */
    public SolarBody(String n, double dis, double a, double dia, String c)
    {
        super(a,dis);
        name = n;
        diameter = dia;
        color = c;
    }
    
    /**
     * Returns the distance of the SolarBody from the centre of the Universe.
     * @return The distance of the SolarBody from the centre of the Universe.
     */
    public double getDistance()
    {
        return distance;
    }
    
    /**
     * Returns the angle of the SolarBody in its current orbit.
     * @return the angle of orbit of the SolarBody.
     */
    public double getAngle()
    {
        return angle;
    }
    
    /**
     * Returns the name of the SolarBody.
     * @return The name of the SolarBody.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Returns the diameter of the SolarBody.
     * @return The diameter of the SolarBody.
     */
    public double getDiameter()
    {
        return diameter;
    }
    
    /**
     * Returns the color of the SolarBody.
     * @return The color of the SolarBody.
     */
    public String getColor()
    {
        return color;
    }
    
    /**
     * Sets the name of the SolarBody.
     * @param n The name of the SolarBody.
     */
    public void setName(String n)
    {
        name = n;
    }
    
    /**
     * Sets the distance of the SolarBody from the center of the Universe.
     * @param d The distance of the SolarBody from the cener of the Universe.
     */
    public void setDistance(double d)
    {
        distance = d;
    }
    
    /**
     * Sets the angle of the SolarBody in its orbit.
     * @param a The angle of the object in its current orbit.
     */
    public void setAngle(double a)
    {
        angle = a;
    }
    
    /**
     * Sets the diameter of the SolarBody.
     * @param d The diameter of the SolarBody.
     */
    public void setDiameter(double d)
    {
        diameter = d;
    }
    
    /**
     * Sets the color of the object.
     * @param c The colour of this object, as a string. Case insentive.
     * <p> One of: BLACK, BLUE, CYAN, DARK_GRAY, GRAY, GREEN, LIGHT_GRAY,
     * MAGENTA, ORANGE, PINK, RED, WHITE, YELLOW. Alternatively, a 24 bit hexadecimal string representation of an RGB colour is also accepted, e.g. "#FF0000"</p>
     */
    public void setColor(String c)
    {
        color = c;
    }
}
