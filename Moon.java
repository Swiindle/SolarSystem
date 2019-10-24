public class Moon extends SolarBody implements Moves
{
    private double orbitalVelocity;
    
    public Moon(String n, double dis, double a, double dia, String c, double v)
    {
        super(n,dis,a,dia,c);
        orbitalVelocity = v;
    }
    
    /**
     *
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

