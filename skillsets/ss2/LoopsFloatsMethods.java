public class LoopsFloatsMethods
{
    public static void getRequirements()
    {
        System.out.println("Developer: Nicholas Pfeffer");
        System.out.println("Program loops through array of floats.");
        System.out.println("Use following values: 1.0, 2.1, 3.2, 4.3, 5.4");
        System.out.println("Use following loop structures: for, enhanced for, while, do...while.\n");
    }

    public static void showLoops()
    {
        float[] values = { 1.0f, 2.1f, 3.2f, 4.3f, 5.4f };

        // for loop
        System.out.println("for loop:");
        for (int i = 0; i < values.length; i++)
        {
            System.out.println(values[i]);
        }

        // enhanced for loop
        System.out.println("\nEnhanced for loop:");
        for (float val : values)
        {
            System.out.println(val);
        }

        // while loop
        System.out.println("\nwhile loop:");
        int index = 0;
        while (index < values.length)
        {
            System.out.println(values[index]);
            index++;
        }

        // do...while loop
        System.out.println("\ndo...while loop:");
        int j = 0;
        do
        {
            System.out.println(values[j]);
            j++;
        }
        while (j < values.length);
    }
}
