import java.util.ArrayList;

public class Planet extends SolarBody
{
    private double orbitalVelocity;
    private ArrayList<Moon> moons = new ArrayList<Moon>();
    
    public Planet(String n, double dis, double a, double dia, String c, double v)
    {
        super(n,dis,a,dia,c);
        orbitalVelocity = v;
    }
    
    /**
     *
     */
    public void addMoon(Moon m)
    {
        System.out.println("The " + m.getName() + " is now orbiting the " + this.getName());
        moons.add(m);
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

