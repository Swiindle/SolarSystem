public class Planet extends SolarBody
{
    private double orbitalVelocity;
    
    public Planet(double dis, double a, double dia, String c, double v)
    {
        super(dis,a,dia,c);
        orbitalVelocity = v;
    }
    
    public void move()
    {
        this.setAngle(this.getAngle() + orbitalVelocity);
        if(this.getAngle() > 360)
        {
            this.setAngle(0);
        }
    }
}

