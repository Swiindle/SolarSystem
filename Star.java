import java.util.ArrayList;

public class Star extends SolarBody
{
    private ArrayList<Planet> planets = new ArrayList<Planet>();
    
    public Star(String n, double dia, String c)
    {
        super(n,0,0,dia,c);
    }
    
    /**
     *
     */
    public void addPlanet(Planet p)
    {
        System.out.println("The " + p.getName() + " is now orbiting the " + this.getName());
        planets.add(p);
    }
    
    /**
     *
     */
    public int numberPlanets()
    {
        int number = planets.size();
        return number;
    }
    
    public ArrayList<Planet> getPlanets()
    {
        return planets;
    }
}
