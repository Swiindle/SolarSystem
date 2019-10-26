import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Random;  // custom

/**
 * This class provides a graphical user interface to a model of the solar system
 * @author Mark Lim - Lancaster University Year 2 Student
 */
public class SolarSystemManager
{
    private SolarSystem ss = new SolarSystem(1000,1000);
    private Star sun = new Star("Sun",50,"YELLOW");         // there's only one sun
    private String dataFileName;

    
    /**
     * Construtor, creates an instance of the SolarSystemManager.
     * @param The name of the .txt file that contains all the data about the Solar Objects.
     */
    public SolarSystemManager(String s)
    {
        dataFileName = s;
    }
    
    /**
     * Use this function to draw a star.
     * @param The Star object that you want the planet to orbit
     */
    private void drawStar(Star s)
    {
        ss.drawSolarObject(s.getDistance(),s.getAngle(),s.getDiameter(),s.getColor());
    }
    
    /**
     * Use this function to draw a planet orbiting around the star. Combines drawSolarObject() method from SolarSystem class.
     * @param The Star object that you want the planet to orbit
     * @param The Planet object that you want to orbit the star
     */
    private void drawObjectInOrbit(SolarBody a, SolarBody b)
    {
        if(HasSatelites.class.isAssignableFrom(a.getClass())) // checks to see if Object A implemetns the HasSatelites interface
        {
            ss.drawSolarObjectAbout(b.getDistance(),b.getAngle(),b.getDiameter(),b.getColor(),a.getDiameter(),a.getAngle());
        }
        else
        {
            System.out.println("Your objects may not be a satelite");
        }
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
                //System.out.println("Line: " + stringData);
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
                            array[0] = token;
                            if(token.equals("Moon"))
                                isMoon = true;
                            else
                                isMoon = false;
                        }
                        if(i == 1)
                            array[1] = token;
                        if(i == 2 && isMoon == false)
                        {
                            array[2] = token;
                            break;
                        }
                        if(i == 2 && isMoon == true)
                            array[2] = token;
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
        //System.out.println("Class name: " + array[0] + ", Object name: " + array[1] + ", Object color: " + array[2]);
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
                //System.out.println("Line: " + stringData);
                StringTokenizer st = new StringTokenizer(stringData,",");
                if(lineCount == wantedLine)
                {
                    boolean isMoon = true;
                    for(int i = 0 ; st.hasMoreTokens() ; i++)
                    {
                        String token = st.nextToken();
                        //System.out.println("Token :'" + token + "', #Token in line: " + i + ", #Tokens in total: " + st.countTokens());
                        if(i == 0)
                        {
                            if(token.equals("Moon"))
                                isMoon = true;
                            else
                                isMoon = false;
                        }
                        if(isMoon == true)
                        {
                            if(i == 4)
                                array[0] = Double.valueOf(token);
                            if(i == 5)
                                array[1] = Double.valueOf(token);
                            if(i == 6)
                                array[2] = Double.valueOf(token);
                            if(i == 7)
                            {
                                array[3] = Double.valueOf(token);
                                break;
                            }
                        }
                        if(isMoon == false)
                        {
                            if(i == 3)
                                array[0] = Double.valueOf(token);
                            if(i == 4)
                                array[1] = Double.valueOf(token);
                            if(i == 5)
                                array[2] = Double.valueOf(token);
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
        //System.out.println("Distance: " + array[0] + ", Angle: " + array[1] + ", Diameter: " + array[2] + ", OrbitalVelocity: " + array[3]);
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
        //System.out.println("the data file has " + array[2] + " lines.");
        //System.out.println("#Planets: " + array[0] + ", #Moons: " + array[1] + ", #SolarObjects: " + array[2]);
        return array;
    }
    
    /**
     * This method is first called when the SolarSystemManager is instantiated. Programmers can change this section of the code to their liking.
     */
    public void startData()
    {
        // DATA SECTION//
        /*
         * Here are the variables that this method will need
         */
        int[] solarObjectArray = this.numberOfSolarObjects(); // pickup the data from the .txt file
        int numberPlanets = solarObjectArray[0];
        int numberMoons = solarObjectArray[1];
        int totalObjects = solarObjectArray[2];
        int numberPlanetsInstantiated = 0;
        int numberMoonsInstantiated = 0;
    
        Planet planet[] = new Planet[numberPlanets];    // the number of planets is fixed but depends on the the .txt file
        Moon moon[] = new Moon[numberMoons];            // the number of moons is fixed but depends on the the .txt file
        
        for(int i = 0 ; i < totalObjects ; i++)
        {
            String[] wordArguments = this.getDataString(i); // pickup the String data from .txt file
            double[] numberArguments = this.getDataNumerical(i); // pickup the numerical dat from .txt file
            
            if(wordArguments[0].equals("Planet"))               // create planet if .txt file says planet
            {
                planet[numberPlanetsInstantiated] = new Planet(wordArguments[1],numberArguments[0],numberArguments[1],numberArguments[2],wordArguments[2],numberArguments[3]);
                sun.addSatelite(planet[numberPlanetsInstantiated]);
                numberPlanetsInstantiated++;
            }
            
            if(wordArguments[0].equals("Moon"))                 // create moon if .txt file says moon
            {
                moon[numberMoonsInstantiated] = new Moon(wordArguments[1],numberArguments[0],numberArguments[1],numberArguments[2],wordArguments[2],numberArguments[3]);
                for(int j = 0 ; j < numberPlanetsInstantiated ; j++)
                {
                    if(wordArguments[3].equals(planet[j].getName()))
                    {
                        planet[j].addSatelite(moon[numberMoonsInstantiated]);
                    }
                }
                numberMoonsInstantiated++;
            }
        }
        
        // CUSTOM
        Random rand = new Random();
        int numberAsteroids = 400;
        Asteroid[] a = new Asteroid[numberAsteroids];
        for(int i = 0 ; i < numberAsteroids ; i++)
        {
            double randomDistance = Double.valueOf(rand.nextInt(87) + 90);
            double randomAngle = Double.valueOf(rand.nextInt(361));
            double randomOrbitalVelocity = rand.nextDouble();


            a[i] = new Asteroid("Asteroid" + String.valueOf(i), randomDistance, randomAngle, 0.5, "#6b6b6b", randomOrbitalVelocity);
            sun.addAsteroid(a[i]);
        }
        
        this.startAction();
    }
    
    public void startAction()
    {
        // ACTION SECTION //
        /*
         * The system has now finished its data processing and will now show the solar system in progress!
         */
        while(true)
        {
            /*
             * Itirate through all moons and planets
             */
            for(Planet p : sun.getSatelites())
            {
                this.drawObjectInOrbit(sun,p); // sun, orbiting planet 1 - write a for loop for all planets
                p.move();
                for(Moon m : p.getSatelites())
                {
                    this.drawObjectInOrbit(p,m); // orbiting
                    m.move();
                }
            }
            // custom object
            for(Asteroid a : sun.getAsteroids())
            {
                this.drawObjectInOrbit(sun,a);
            }
            ss.finishedDrawing();
        }
    }
}
