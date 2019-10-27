/**
 * Representation of a location in space.
 * Abstract class, meant to be extended by objects that have an associated location.
 * @author Mark Lim - Lancaster University Year 2 Student
 */
public abstract class Point
{
    double distance;
    double angle;
    
    /**
     * Constructor.
     * @param a The orbital angle of the Point
     * @param d The distance of the Point from the cetre of the Universe.
     */
    public Point(double a, double d)
    {
        angle = a;
        distance = d;
    }
    
    /**
     * Sets the distance of the Point from the center of the Universe.
     * @param d The distance of the Point from the cener of the Universe.
     */
    public void setDistance(double d)
    {
        distance = d;
    }
    
    /**
     * Sets the angle of the Point in its orbit.
     * @param a The angle of the Point in its current orbit.
     */
    public void setAngle(double a)
    {
        angle = a;
    }
    
    /**
     * Returns the distance of the Point from the centre of the Universe.
     * @return The distance from the centre of the Universe
     */
    public double getDistance()
    {
        return distance;
    }
    
    /**
     * Returns the angle of the angle in its current orbit.
     * @return the angle of orbit.
     */
    public double getAngle()
    {
        return angle;
    }
}
