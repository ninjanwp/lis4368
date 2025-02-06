public class SystemPropertiesMethods
{
    public static void getRequirements()
    {
        System.out.println("Developer: Nicholas Pfeffer");
        System.out.println("Program lists system properties.\n");
    }

    public static void listSystemProperties()
    {
        // Use System.getProperty() calls
        // (Property strings can vary by OS/JRE)
        String fileSeparator = System.getProperty("file.separator");
        String classPath = System.getProperty("java.class.path");
        String javaHome = System.getProperty("java.home");
        String javaVendor = System.getProperty("java.vendor");
        String javaVendorUrl = System.getProperty("java.vendor.url");
        String javaVersion = System.getProperty("java.version");
        String jreVersion = System.getProperty("java.runtime.version");
        String osArch = System.getProperty("os.arch");
        String osName = System.getProperty("os.name");
        String osVersion = System.getProperty("os.version");
        String pathSeparator = System.getProperty("path.separator");
        String userDir = System.getProperty("user.dir");
        String userHome = System.getProperty("user.home");
        String userName = System.getProperty("user.name");

        System.out.println("System file path separator: " + fileSeparator);
        System.out.println("Java class path: " + classPath);
        System.out.println("Java installation directory: " + javaHome);
        System.out.println("Java vendor name: " + javaVendor);
        System.out.println("Java vendor URL: " + javaVendorUrl);
        System.out.println("Java version number: " + javaVersion);
        System.out.println("JRE version: " + jreVersion);
        System.out.println("OS architecture: " + osArch);
        System.out.println("OS name: " + osName);
        System.out.println("OS version: " + osVersion);
        System.out.println("Path separator used in java.class.path: " + pathSeparator);
        System.out.println("User working directory: " + userDir);
        System.out.println("User home directory: " + userHome);
        System.out.println("User account name: " + userName);
    }
}
