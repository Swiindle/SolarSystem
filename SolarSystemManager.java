import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Random;  // custom

/**
 * This class creates and executes the data of the SolarSystem.
 * @author Mark Lim - Lancaster University Year 2 Student
 */
public class SolarSystemManager
{
    private SolarSystem ss = new SolarSystem(1000,1000);    // The SolarSystem visual engine.
    private Star sun = new Star("Sun",50,"YELLOW");         // there's only one sun
    private String dataFileName;                            // The name of the file

    
    /**
     * Construtor, creates an instance of the SolarSystemManager.
     * @param s The name of the .txt file that contains all the data about the Solar Objects.
     */
    public SolarSystemManager(String s)
    {
        dataFileName = s;
    }
    
    /**
     * Use this function to draw a star.
     * @param The Star that you want to draw.
     */
    private void drawStar(Star s)
    {
        ss.drawSolarObject(s.getDistance(),s.getAngle(),s.getDiameter(),s.getColor());
    }
    
    /**
     * Use this function to draw a SolarBody orbitting another SolarBody.
     * @param a The Parent SolarBody. This object must implement the HasSatelites interface.
     * @param b The Child SolarBody which you want to orbit SolarBody a.
     */
    private void drawObjectInOrbit(SolarBody a, SolarBody b)
    {
        if(HasSatelites.class.isAssignableFrom(a.getClass())) // checks to see if Object A implements the HasSatelites interface
        {
            ss.drawSolarObjectAbout(b.getDistance(),b.getAngle(),b.getDiameter(),b.getColor(),a.getDistance(),a.getAngle());
        }
        else
        {
            System.out.println("Your objects may not be a satelite");
        }
    }
    
    /**
     * Use this function to get an array of the textual information for the user provided .txt file.
     * @param wantedLine The line of the .txt which you would like to read your information.
     * @return An array containing the textual tokens. First element of the array is the Class name. Second element is the name of that object. Third element is the color which you want your planet to be. If the first element of the array is a Moon, the fourt element will be the name of the Planet that the Moon is orbitting.
     */
    private String[] getDataString(int wantedLine)
    {
        String[] array = new String[4];                                 // the array which will store the parameters
        try
        {
            File solarObjecData = new File(dataFileName);               // the file object
            Scanner fileReader = new Scanner(solarObjecData);           // the file reader object
            int lineCount = 0;
            while(fileReader.hasNextLine())
            {
                String stringData = fileReader.nextLine();                // for each line, while there are still lines
                StringTokenizer st = new StringTokenizer(stringData,","); // each token is seperated by a comma
                if(lineCount == wantedLine)                     // searches until the wanted line is found...
                {
                    for(int i = 0 ; st.hasMoreTokens() ; i++) // for each token in the line...
                    {
                        boolean isMoon = true;
                        String token = st.nextToken();
                        if(i == 0)                           // the first token
                        {
                            array[0] = token;
                            if(token.equals("Moon"))
                                isMoon = true;
                            else
                                isMoon = false;
                        }
                        if(i == 1)                          // the second token
                            array[1] = token;
                        if(i == 2 && isMoon == false)       // the third and last token (if planet)
                        {
                            array[2] = token;
                            break;
                        }
                        if(i == 2 && isMoon == true)        // the third token (if moon)
                            array[2] = token;
                        if(i == 3)                          // the fourth token (if moon)
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
     * @param wantedLine The line of the .txt which you would like to read your information.
     * @return An array containing the numerical tokens. First element of the array is the distance (radius) of the object from the center of the model. Second element is the starting angle from the center of the solar system model. Third element is the diameter (size) of the circle drawn. Fourth element is the speed in which the circle moves around the center of the model.
     */
    private double[] getDataNumerical(int wantedLine)
    {
        double[] array = {0,0,0,0};                                     // the array which shall store the parameters
        try
        {
            File solarObjecData = new File(dataFileName);               // the file object
            Scanner fileReader = new Scanner(solarObjecData);           // the file reader object

            int lineCount = 0;
            
            while(fileReader.hasNextLine())                             // for each line, while there are still lines
            {
                String stringData = fileReader.nextLine();
                StringTokenizer st = new StringTokenizer(stringData,",");
                if(lineCount == wantedLine)                         // searches until wanted line is found
                {
                    boolean isMoon = true;
                    for(int i = 0 ; st.hasMoreTokens() ; i++)       // until there are no more tokens in the line
                    {
                        String token = st.nextToken();
                        if(i == 0)                                  // checks to see if first element is a moon...
                        {
                            if(token.equals("Moon"))
                                isMoon = true;
                            else
                                isMoon = false;
                        }
                        if(isMoon == true)                          // if its a moon, all tokens will move up by 1 place.
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
                        if(isMoon == false)                         // if not a moon, all tokens will not move
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
            
            while (fileReader.hasNextLine()) // going through line by line
            {
                String stringData = fileReader.nextLine();
                StringTokenizer st = new StringTokenizer(stringData,",");
                String token = st.nextToken();
                
                if(token.equals("Planet"))              // if the first token is Planet, increment number of Planets
                {
                    array[0]++;
                }
                if(token.equals("Moon"))                // if the second token is Moon, increment number of Moon
                {
                    array[1]++;
                }
                array[2]++;                             // the amount of objects, alternatively, adding moon + planet?
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
     * The algorithm that prepares the data for all SolarBodys in the Solar System Model. Needs to be called before startAction() is called, as the data from this method will be stored under the Star object.
     * Developers may want to change this section if code is to be updated.
     */
    public void startData()
    {
        int[] solarObjectArray = this.numberOfSolarObjects(); // pickup the data from the .txt file
        int numberPlanets = solarObjectArray[0];
        int numberMoons = solarObjectArray[1];
        int totalObjects = solarObjectArray[2];
        int numberPlanetsInstantiated = 0;                  // number of planets already instantiated
        int numberMoonsInstantiated = 0;                    // number of moons already instantiated
    
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
        
        // CUSTOM AREA
        Random rand = new Random();
        int numberAsteroids = 400;
        Asteroid[] a = new Asteroid[numberAsteroids];
        for(int i = 0 ; i < numberAsteroids ; i++)
        {
            double randomDistance = Double.valueOf(rand.nextInt(45) + 95);
            double randomAngle = Double.valueOf(rand.nextInt(361));
            double randomOrbitalVelocity = 0.01 + (0.2 - 0.01) * rand.nextDouble();
                        
            a[i] = new Asteroid("Asteroid" + String.valueOf(i), randomDistance, randomAngle, 1.0, "WHITE", randomOrbitalVelocity);
            sun.addAsteroid(a[i]);
        }
        this.startAction();
    }
    
    /**
     * This method should be called after startData() is called first. This method takes the data that is processed in startData() and does something with it.
     */
    public void startAction()
    {
        while(true)
        {
            /*
             * Itirate through all moons and planets
             */
            this.drawStar(sun);
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
                a.move();
            }
            ss.finishedDrawing();
        }
    }
}
