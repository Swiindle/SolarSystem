public class Star
{
    private double distance;
    private double angle;
    private double diameter;
    private String color;
    // private Planet[] p; # of associated planets 
    
    public Star(double dis, double a, double dia, String c)
    {
        distance = dis;
        angle = a;
        diameter = dia;
        color = c;
    }
    
    // instance variable stuff
    
    public double getDistance()
    {
        return distance;
    }
    public double getAngle()
    {
        return angle;
    }
    public double getDiameter()
    {
        return diameter;
    }
    public String getColor()
    {
        return color;
    }
    
    public void setDistance(double d)
    {
        distance = d;
    }
    public void setAngle(double a)
    {
        angle = a;
    }
    public void setDiameter(double d)
    {
        diameter = d;
    }
    public void setColor(String c)
    {
        color = c;
    }
}
