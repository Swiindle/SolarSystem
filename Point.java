/**
 * Representation of a location in space.
 * @author Mark Lim - Lancaster University Year 2 Student
 */
public abstract class Point
{
    double distance;
    double angle;
    
    public Point(double a, double d)
    {
        angle = a;
        distance = d;
    }
    
    /**
     * Returns the distance from the centre of the Universe.
     * @return distance from the centre of the Universe
     */
    public double getDistance()
    {
        return distance;
    }
    
    /**
     * Returns the angle of orbit.
     * @return angle of orbit.
     */
    public double getAngle()
    {
        return angle;
    }
    
    /**
     *
     */
    public void setDistance(double d)
    {
        distance = d;
    }
    
    /**
     *
     */
    public void setAngle(double a)
    {
        angle = a;
    }
}
