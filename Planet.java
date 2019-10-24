import java.util.ArrayList;

public class Planet extends SolarBody implements Moves,HasSatelites<Moon>
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
    public void addSatelites(Moon m)
    {
        System.out.println("The " + m.getName() + " is now orbiting the " + this.getName());
        moons.add(m);
    }
    
    /**
     *
     */
    public ArrayList<Moon> getSatelites()
    {
        return moons;
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

