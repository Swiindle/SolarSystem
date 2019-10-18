import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SolarSystemManager
{
    private SolarSystem ss = new SolarSystem(500,500);
    private String dataFileName;
    
    public SolarSystemManager(String s)
    {
        dataFileName = s;
        this.go();
    }
    
    /**
     *
     */
    private void drawPlanetOrbitStar(Star s, Planet p)
    {
        ss.drawSolarObject(s.getDistance(),s.getAngle(),s.getDiameter(),s.getColor());
        ss.drawSolarObject(p.getDistance(),p.getAngle(),p.getDiameter(),p.getColor());
    }
    
    /**
     *
     */
    private void drawMoonOrbitPlanet(Planet p, Moon m)
    {
        ss.drawSolarObjectAbout(m.getDistance(),m.getAngle(),m.getDiameter(),m.getColor(),p.getDistance(),p.getAngle());
    }
    
    /**
     *
     */
    private String[] getDataString(int i)
    {
        String[] data = new String[3];
         
         
         
        return data;
    }
    
    /**
     *
     */
     private double[] getDataNumerical(int i)
     {
         double[] data = {1,1,1};
         
         
         return data;
     }
    
    /**
     *
     */
    public int[] numberOfSolarObjects()
    {
        /*
         * In order to detect/create the Solar Objects, the program will read from a user provided text file
         */
        int[] array = {0,0,0};
        
        try
        {
            File solarObjecData = new File(dataFileName);           // the file object
            Scanner fileReader = new Scanner(solarObjecData);        // the file reader object
            
            while (fileReader.hasNextLine())
            {
                String stringData = fileReader.nextLine();
                //stringData.useDelimiter("//");
                System.out.println("Line: " + stringData);
                StringTokenizer st = new StringTokenizer(stringData,",");
                for(int i = 0 ; st.hasMoreTokens() ; i++)
                {
                    String token = st.nextToken();
                    System.out.println("Token :'" + token + "', #Token in line: " + i + ", #Tokens in total: " + st.countTokens());
                    if(token.equals("Planet"))
                    {
                        array[0]++;
                    }
                    if(token.equals("Moon"))
                    {
                        array[1]++;
                    }
                }
                array[2]++;
            }
            //System.out.println("the data file has " + totalObjects + " lines.");
            fileReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("you may not have a SolarObjectData.txt");
        }
        return array;
    }
    
    /**
     * This is a fairly complex method, has been documented so that it is easy to follow
     */
    public void go()
    {
        /*
         * Here are the variables that this method will need
         */
        int[] solarObjectArray = this.numberOfSolarObjects();
        int numberPlanets = solarObjectArray[0];
        int numberMoons = solarObjectArray[1];
        int totalObjects = solarObjectArray[2];
        System.out.println("Number planets: " + numberPlanets + ", Number moons: " + numberMoons);
        
        /*
         * As the program now knows how many objects and what objects, it shall now instantiate it
         */
        Star sun = new Star("Sun",50,"YELLOW");         // there's only one sun
        Planet planet[] = new Planet[numberPlanets];    // the number of planets is fixed but depends on the the file
        Moon moon[] = new Moon[numberMoons];            // the number of moons is fixed but depends on the the file
        
        for(int i = 0 ; i < numberPlanets ; i++)
        {
            String[] wordArguments = this.getDataString(i);
            double[] numberArguments = this.getDataNumerical(i);
            //planet[i] = new Planet(wordArguments[0],numberArguments[1],);
        }
        planet[0] = new Planet("Earth",50,0,10,"BLUE",1);   // can i theoratical return an object, let the object point to the reference
        moon[0] = new Moon("Moon",20,0,5,"WHITE",1);    // passed by method, e.g file reading method returns object
    
        /*
         * Adding planets to sun's orbit, and adding moons to planet's orbit
         */
        
        for(int i = 0 ; i < numberPlanets ; i++)
        {
            sun.addPlanet(planet[i]);
            for(int j = 0 ; j < numberMoons ; j++) //need to know how many moons a planet has
            {
                planet[i].addMoon(moon[j]);
            }
        }
        
        /*
         * The system has now finished its data processing and will now show the solar system in progress!
         */
        while(true)
        {
            /*
             * if planet is in arraylist of sun, draw planet orbit star
             * if moon is in arraylist of planet, draw moon orbit planet
             * this.drawPlanetOrbitStar(sun,sunArray[1])
             * this.drawMoonOrbitMoon(moon,
             */
            
            /*
             * Itirate through all moons and planets
             */
            for(int i = 0 ; i < numberPlanets; i++)
            {
                this.drawPlanetOrbitStar(sun,planet[i]); // sun, orbiting planet 1 - write a for loop for all planets
                planet[i].move();
                for(int j = 0 ; i < numberMoons; j++)
                {
                    //this.drawMoonOrbitPlanet(planet[i],moon[j]); // orbiting
                    //moon[j].move();
                }
            }
            ss.finishedDrawing();
        }
    }
}
