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
}
