import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SolarSystemManager
{
    private SolarSystem ss = new SolarSystem(500,500);
    private String dataFileName;
    
    /**
     * Construtor, creates an instance of the SolarSystemManager and runs the procedural method, go().
     * @param The name of the .txt file that contains all the data about the Solar Objects.
     */
    public SolarSystemManager(String s)
    {
        dataFileName = s;
        this.go();
    }
    
    /**
     * Use this function to draw a planet orbiting around the star. Combines drawSolarObject() method from SolarSystem class.
     * @param The Star object that you want the planet to orbit
     * @param The Planet object that you want to orbit the star
     */
    private void drawPlanetOrbitStar(Star s, Planet p)
    {
        ss.drawSolarObject(s.getDistance(),s.getAngle(),s.getDiameter(),s.getColor());
        ss.drawSolarObject(p.getDistance(),p.getAngle(),p.getDiameter(),p.getColor());
    }
    
    /**
     * Use this function to draw a moon oribiting around a planet. Uses a drawSolarObject() method from SolarSystem class.
     * @param The Planet object that you want the moon to orbit.
     * @param The Moon object that you want to orbit the planet.
     */
    private void drawMoonOrbitPlanet(Planet p, Moon m)
    {
        ss.drawSolarObjectAbout(m.getDistance(),m.getAngle(),m.getDiameter(),m.getColor(),p.getDistance(),p.getAngle());
    }
    
    /**
     * Use this function to get an array of the textual information for the user provided .txt file.
     * @param The line of the .txt which you would like to read your information.
     * @return An array containing the textual tokens. First element of the array is the Class name. Second element is the name of that object. Third element is the color which you want your planet to be.
     */
    private String[] getDataString(int wantedLine)
    {
        String[] array = new String[4];
        try
        {
            File solarObjecData = new File(dataFileName);               // the file object
            Scanner fileReader = new Scanner(solarObjecData);           // the file reader object
            int lineCount = 0;
            while(fileReader.hasNextLine())
            {
                String stringData = fileReader.nextLine();
                System.out.println("Line: " + stringData);
                StringTokenizer st = new StringTokenizer(stringData,",");
                if(lineCount == wantedLine)
                {
                    for(int i = 0 ; st.hasMoreTokens() ; i++)
                    {
                        boolean isMoon = true;
                        String token = st.nextToken();
                        System.out.println("Token :'" + token + "', #Token in line: " + i + ", #Tokens in total: " + st.countTokens());
                        if(i == 0)
                        {
                            array[0] = token;
                            if(token.equals("Moon"))
                            {
                                isMoon = true;
                            }
                            else
                            {
                                isMoon = false;
                            }
                        }
                        if(i == 1)
                        {
                            array[2] = token;
                        }
                        if(i == 2 && isMoon == false)
                        {
                            array[1] = token;
                            break;
                        }
                        if(i == 2 && isMoon == true)
                        {
                            array[1] = token;
                        }
                        if(i == 3)
                        {
                            array[3] = token;
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
     * Use this function to get an array of the numerical tokens from the user provided .txt file.
     * @param The line of the .txt which you would like to read your information.
     * @return An array containing the numerical tokens. First element of the array is the distance (radius) of the object from the center of the model. Second element is the starting angle from the center of the solar system model. Third element is the diameter (size) of the circle drawn. Fourth element is the speed in which the circle moves around the center of the model.
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
                System.out.println("Line: " + stringData);
                StringTokenizer st = new StringTokenizer(stringData,",");
                if(lineCount == wantedLine)
                {
                    for(int i = 0 ; st.hasMoreTokens() ; i++)
                    {
                        boolean isMoon = true;
                        String token = st.nextToken();
                        //System.out.println("Token :'" + token + "', #Token in line: " + i + ", #Tokens in total: " + st.countTokens());
                        if(i == 0)
                        {
                            if(token.equals("Moon"))
                            {
                                isMoon = true;
                            }
                            else
                            {
                                isMoon = false;
                            }
                        }
                        if(isMoon == true)
                        {
                            if(i == 4)
                            {
                                array[0] = Double.valueOf(token);
                            }
                            if(i == 5)
                            {
                                array[1] = Double.valueOf(token);
                            }
                            if(i == 6)
                            {
                                array[2] = Double.valueOf(token);
                            }
                            if(i == 7)
                            {
                                array[3] = Double.valueOf(token);
                                break;
                            }
                        }
                        else
                        {
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
        System.out.println("Distance: " + array[0] + ", Angle: " + array[1] + ", Diameter: " + array[2] + ", OrbitalVelocity: " + array[3]);
        return array;
    }
    
    /**
     * This method returns an array of the number of planets, number of moons and the total amount of lines.
     * @return An array containing numerical information about the planets. The first array element contains the number of planets. The second array element contains the number of moons. The third array element contains the total number of objects in the .txt file (or in other words the number of lines).
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
     * This method is first called when the SolarSystemManager is instantiated. Programmers can change this section of the code to their liking.
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
        int totalObjects = solarObjectArray[2];
        int numberPlanetsInstantiated = 0;
        int numberMoonsInstantiated = 0;
        
        /*
         * As the program now knows how many objects and what objects, it shall now instantiate it
         */
        Star sun = new Star("Sun",50,"YELLOW");         // there's only one sun
        Planet planet[] = new Planet[numberPlanets];    // the number of planets is fixed but depends on the the .txt file
        Moon moon[] = new Moon[numberMoons];            // the number of moons is fixed but depends on the the .txt file
        
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
                moon[numberMoonsInstantiated] = new Moon(wordArguments[1],numberArguments[0],numberArguments[1],numberArguments[2],wordArguments[2],numberArguments[3]);
                for(int j = 0 ; j < numberPlanets ; j++)
                {
                    if(wordArguments[3].equals(planet[j].getName()))
                    {
                        planet[j].addMoon(moon[numberMoonsInstantiated]);
                    }
                }
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
