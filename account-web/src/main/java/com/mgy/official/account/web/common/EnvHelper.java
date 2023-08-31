package com.mgy.official.account.web.common;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EnvHelper implements EnvironmentAware {

    private static Environment ENVIRONMENT;

    @Override
    public void setEnvironment(Environment environment) {
        ENVIRONMENT = environment;
    }

    public static String getEnv(){
        return ENVIRONMENT.getProperty("env");
    }
}
