public class MainMethod
{
    public static void main(String args[])
    {
        SolarSystemManager ssm = new SolarSystemManager("SolarObjectData.txt");
        ssm.startData();
        ssm.startAction();
    }
}
