package vn.edu.hcmut.cse.adse.lab.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class DotenvConfig implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        Path envPath = Paths.get(".env");
        
        if (!Files.exists(envPath)) {
            System.out.println("WARNING: .env file not found at " + envPath.toAbsolutePath());
            return;
        }

        try {
            Map<String, Object> envVars = new HashMap<>();
            Files.lines(envPath).forEach(line -> {
                line = line.trim();
                if (!line.isEmpty() && !line.startsWith("#") && line.contains("=")) {
                    int idx = line.indexOf("=");
                    String key = line.substring(0, idx).trim();
                    String value = line.substring(idx + 1).trim();
                    envVars.put(key, value);
                    System.out.println("Loaded from .env: " + key + " = " + (key.contains("PASSWORD") ? "****" : value));
                }
            });
            
            environment.getPropertySources().addFirst(new MapPropertySource("dotenv", envVars));
            System.out.println("SUCCESS: .env file loaded with " + envVars.size() + " variables!");
            
        } catch (IOException e) {
            System.err.println("ERROR reading .env file: " + e.getMessage());
        }
    }
}
