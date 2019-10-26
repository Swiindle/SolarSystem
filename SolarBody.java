/**
 * This class provides a graphical user interface to a model of the solar system
 * @author Mark Lim - Lancaster University Year 2 Student
 */
public abstract class SolarBody extends Point
{
    private String name;
    private double diameter;
    private String color;
    
    /**
     *
     */
    public SolarBody(String n, double dis, double a, double dia, String c)
    {
        super(a,dis);
        name = n;
        diameter = dia;
        color = c;
    }
    
    /**
     *
     */
    public double getDistance()
    {
        return distance;
    }
    
    /**
     *
     */
    public double getAngle()
    {
        return angle;
    }
    
    /**
     *
     */
    public String getName()
    {
        return name;
    }
    
    /**
     *
     */

    public double getDiameter()
    {
        return diameter;
    }
    
    /**
     *
     */
    public String getColor()
    {
        return color;
    }
    
    /**
     *
     */
    public void setName(String n)
    {
        name = n;
    }
    
    /**
     *
     */
    public void setDiameter(double d)
    {
        diameter = d;
    }
    
    /**
     *
     */
    public void setColor(String c)
    {
        color = c;
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
