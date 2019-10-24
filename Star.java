import java.util.ArrayList;

public class Star extends SolarBody implements HasSatelites<Planet>
{
    private ArrayList<Planet> planets = new ArrayList<Planet>();
    
    public Star(String n, double dia, String c)
    {
        super(n,0,0,dia,c);
    }
    
    /**
     *
     */
    public void addSatelites(Planet p)
    {
        System.out.println("The " + p.getName() + " is now orbiting the " + this.getName());
        planets.add(p);
    }
    
    /**
     *
     */
    public ArrayList<Planet> getSatelites()
    {
        return planets;
    }
}
