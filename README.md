Mark Lim  2019 - Lancaster University Project
# SolarSystem - A java project

## User Guide:
1. Write down the list of SolarObjects you wish to add to the solar system into the .txt file provided. (See below for further instructions)
2. Open a terminal or console and set path to the directory of the SolarSystem.
3. Type: 
```
java MainMethod
```
4. Watch!

## Programmer Guide (to making Custom Objects):
1. If the Custom Object is a Solar Object, extend the SolarObject abstract class
2. If the Custom Object can move, implement the Move interface.
3. If the Custom Object has Satelites, implement the HasSatelites interface.
4. Custom Objects are currently not supported in the .txt file, although you are free to update the methods in the SolarSystemManager class.

## How to use the SolarObjectData.txt File:
- Each line should contain information about one Solar Object in the model
- Should be written as such: Text,Text,Text,Number,Number,Number,Number (Or if you're more familiar with Java primitive types: String, String, String, String, double, double, double, double)
- Text 1: The type of planet class, currently only supports "Planet" and "Moon" class
- Text 2: The user provided name of the Object: E.g "Earth or Titan" 
- Text 3: The color in which the planet should be drawn.
- Text 4: *If* the Object is a moon, the user provided name of the Planet that the Moon should orbit.
- Number 1: The distance (radius) from the centre of the Universe
- Number 2: The starting angle of rotation of the object, on that object's current orbit.
- Number 3: The diameter of the object drawn.
- Number 4: The orbital speed in which the Solar Object travels around its orbit.
