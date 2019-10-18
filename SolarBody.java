public abstract class SolarBody
{
    private String name;
    private double distance;
    private double angle;
    private double diameter;
    private String color;
    
    /**
     *
     */
    public SolarBody(String n, double dis, double a, double dia, String c)
    {
        name = n;
        distance = dis;
        angle = a;
        diameter = dia;
        color = c;
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
}
