public class SolarSystemManager
{
    private SolarSystem ss = new SolarSystem(500,500);
    private Star sun = new Star(0,0,50,"YELLOW");
    private Planet earth = new Planet(150,0,10,"BLUE",0.5);
    private Moon moon = new Moon(20,0,5,"WHITE",4);
    
    public void go()
    {
        Star sun = new Star(0,0,50,"YELLOW");
        Planet earth = new Planet(150,0,10,"BLUE",0.5);
        Moon moon = new Moon(20,0,5,"WHITE",4);
        
        ss.drawSolarObject(0,0,30,"YELLOW");
        ss.finishedDrawing();
        
        while(true)
        {
            planetOrbitStar(sun,earth);
            moonOrbitPlanet(earth,moon);
            
            
            earth.move();
            moon.move();
            
            ss.finishedDrawing();
        }
    }
    
    private void planetOrbitStar(Star s, Planet p)
    {
        ss.drawSolarObject(s.getDistance(),s.getAngle(),s.getDiameter(),s.getColor());
        ss.drawSolarObject(p.getDistance(),p.getAngle(),p.getDiameter(),p.getColor());
    }
    
    private void moonOrbitPlanet(Planet p, Moon m)
    {
        ss.drawSolarObjectAbout(m.getDistance(),m.getAngle(),m.getDiameter(),m.getColor(),p.getDistance(),p.getAngle());
    }
}
