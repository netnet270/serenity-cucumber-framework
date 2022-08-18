package coccoc.AM.common;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class LoadObject {
    static EnvironmentVariables ENV = SystemEnvironmentVariables.createEnvironmentVariables();

    public static String getProperty(String property) {
        String value = "";
        try {
            value = EnvironmentSpecificConfiguration.from(ENV).getProperty(property);
        } catch (Exception e) {
        }
        return value;
    }
}
