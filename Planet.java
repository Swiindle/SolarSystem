public class Planet
{
    private double distance;
    private double angle;
    private double diameter;
    private String color;
    private double orbitalVelocity;
    // private Moon[] m; #number of associated Moons
    
    public Planet(double dis, double a, double dia, String c, double v)
    {
        distance = dis;
        angle = a;
        diameter = dia;
        color = c;
        orbitalVelocity = v;
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
    
    // Other stuff
    
    public void move()
    {
        this.setAngle(this.getAngle() + orbitalVelocity);
        if(this.getAngle() > 360)
        {
            this.setAngle(0);
        }
    }
}

