package coccoc.AM.common;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

import java.io.File;

public class LoadObject {
    public static String osName = System.getProperty("os.name");
    public static String workingDr = System.getProperty("user.dir");
    public static String platWin = "windows", platMac = "mac";
    static EnvironmentVariables ENV = SystemEnvironmentVariables.createEnvironmentVariables();

    public static String getProperty(String property) {
        String value = "";
        try {
            value = EnvironmentSpecificConfiguration.from(ENV).getProperty(property);
        } catch (Exception e) {
        }
        return value;
    }

    public static String getPathFile(String folderFile) {
        String path = null;
        if (osName.toLowerCase().contains(platWin)) {
            path = String.format(workingDr + "\\src\\test\\resources\\testdata\\%s", folderFile + "\\");

        } else if (osName.toLowerCase().contains(platMac)) {
            path = String.format(workingDr + "/src/test/resources/testdata/%s", folderFile + "/");

        } else {
            System.out.println("not found OS get pathFile downloaded");
        }
        return path;
    }
}
