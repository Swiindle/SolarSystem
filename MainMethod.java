/**
 * This class is where the MainMethod is
 * @author Mark Lim - Lancaster University Year 2 Student
 */
public class MainMethod
{
    public static void main(String args[])
    {
        SolarSystemManager ssm = new SolarSystemManager("SolarObjectData.txt");
        ssm.startData();
        ssm.startAction();
    }
}
