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
    private String[] getDataString(int wantedLine)
    {
        String[] array = new String[3];
        try
        {
            File solarObjecData = new File(dataFileName);               // the file object
            Scanner fileReader = new Scanner(solarObjecData);           // the file reader object
            int lineCount = 0;
            while(fileReader.hasNextLine())
            {
                String stringData = fileReader.nextLine();
                //System.out.println("Line: " + stringData);
                StringTokenizer st = new StringTokenizer(stringData,",");
                if(lineCount == wantedLine)
                {
                    for(int i = 0 ; st.hasMoreTokens() ; i++)
                    {
                        String token = st.nextToken();
                        //System.out.println("Token :'" + token + "', #Token in line: " + i + ", #Tokens in total: " + st.countTokens());
                        if(i == 0)
                        {
                            array[0] = token;
                        }
                        if(i == 1)
                        {
                            array[1] = token;
                        }
                        if(i == 2)
                        {
                            array[2] = token;
                            break;
                        }
                    }
                    break;
                }
                else
                {
                    lineCount++;
                }
            }
            fileReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("you may not have a SolarObjectData.txt");
        }
        System.out.println("Class name: " + array[0] + ", Object name: " + array[1] + ", Object color: " + array[2]);
        return array;
    }
    
    /**
     *
     */
    private double[] getDataNumerical(int wantedLine)
    {
        double[] array = {0,0,0,0};
        try
        {
            File solarObjecData = new File(dataFileName);               // the file object
            Scanner fileReader = new Scanner(solarObjecData);           // the file reader object

            int lineCount = 0;
            
            while(fileReader.hasNextLine())
            {
                String stringData = fileReader.nextLine();
                //System.out.println("Line: " + stringData);
                StringTokenizer st = new StringTokenizer(stringData,",");
                if(lineCount == wantedLine)
                {
                    for(int i = 0 ; st.hasMoreTokens() ; i++)
                    {
                        String token = st.nextToken();
                        //System.out.println("Token :'" + token + "', #Token in line: " + i + ", #Tokens in total: " + st.countTokens());
                        if(i == 3)
                        {
                            array[0] = Double.valueOf(token);
                        }
                        if(i == 4)
                        {
                            array[1] = Double.valueOf(token);
                        }
                        if(i == 5)
                        {
                            array[2] = Double.valueOf(token);
                        }
                        if(i == 6)
                        {
                            array[3] = Double.valueOf(token);
                            break;
                        }
                    }
                    break;
                }
                else
                {
                    lineCount++;
                }
            }
            fileReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("you may not have a SolarObjectData.txt");
        }
        System.out.println("Distance: " + array[0] + ", Angle: " + array[1] + ", Diameter: " + array[2] + ", OrbitalVelocity" + array[3]);
        return array;
    }
    
    /**
     * This method returns an array integer containing the number of planets, the number of moons and the total number of objects.
     * It does this by reading a user provided text document and counting the number of lines, planets and moons.
     */
    public int[] numberOfSolarObjects()
    {
        int[] array = {0,0,0}; // first number is the number of planets, second number is the number of moons, third number is the total objects
        try
        {
            File solarObjecData = new File(dataFileName);               // the file object
            Scanner fileReader = new Scanner(solarObjecData);           // the file reader object
            
            while (fileReader.hasNextLine()) // going through
            {
                String stringData = fileReader.nextLine();
                //System.out.println("Line: " + stringData);
                StringTokenizer st = new StringTokenizer(stringData,",");
                for(int i = 0 ; st.hasMoreTokens() ; i++)
                {
                    String token = st.nextToken();
                    //System.out.println("Token :'" + token + "', #Token in line: " + i + ", #Tokens in total: " + st.countTokens());
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
            fileReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("you may not have a SolarObjectData.txt");
        }
        //System.out.println("the data file has " + array[2]+ " lines.");
        //System.out.println("#Planets: " + array[0] + ", #Moons: " + array[1] + ", #SolarObjects: " + array[2]);
        return array;
    }
    
    /**
     * This is a fairly complex method, has been documented so that it is easy to follow
     */
    public void go()
    {
        // DATA SECTION//
        /*
         * Here are the variables that this method will need
         */
        int[] solarObjectArray = this.numberOfSolarObjects();
        int numberPlanets = solarObjectArray[0];
        int numberMoons = solarObjectArray[1];
        int numberPlanetsInstantiated = 0;
        int numberMoonsInstantiated = 0;
        int totalObjects = solarObjectArray[2];
        
        /*
         * As the program now knows how many objects and what objects, it shall now instantiate it
         */
        Star sun = new Star("Sun",50,"YELLOW");         // there's only one sun
        Planet planet[] = new Planet[numberPlanets];    // the number of planets is fixed but depends on the the file
        Moon moon[] = new Moon[numberMoons];            // the number of moons is fixed but depends on the the file
        
        for(int i = 0 ; i < totalObjects ; i++)
        {
            //System.out.println("///Object#: " + i + " now getting word arguments///");
            String[] wordArguments = this.getDataString(i);
            //System.out.println("///Object#: " + i + " now getting numerical arguments///");
            double[] numberArguments = this.getDataNumerical(i);
            if(wordArguments[0].equals("Planet"))
            {
                planet[numberPlanetsInstantiated] = new Planet(wordArguments[1],numberArguments[0],numberArguments[1],numberArguments[2],wordArguments[2],numberArguments[3]);
                numberPlanetsInstantiated++;
            }
            if(wordArguments[0].equals("Moon"))
            {
                System.out.println(i);
                moon[numberMoonsInstantiated] = new Moon(wordArguments[1],numberArguments[0],numberArguments[1],numberArguments[2],wordArguments[2],numberArguments[3]);
                numberMoonsInstantiated++;
            }
        }
    
        /*
         * Adding planets to sun's orbit, and adding moons to planet's orbit

        
        for(int i = 0 ; i < numberPlanets ; i++)
        {
            sun.addPlanet(planet[i]);
            for(int j = 0 ; j < numberMoons ; j++) //need to know how many moons a planet has
            {
                planet[i].addMoon(moon[j]);
            }
        }         */
        // ACTION SECTION //
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
