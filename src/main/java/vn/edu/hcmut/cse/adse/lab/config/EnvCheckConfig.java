package vn.edu.hcmut.cse.adse.lab.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import jakarta.annotation.PostConstruct;

@Configuration
public class EnvCheckConfig {

    private static final Logger logger = LoggerFactory.getLogger(EnvCheckConfig.class);

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${spring.datasource.username}")
    private String datasourceUsername;

    @PostConstruct
    public void checkEnvVariables() {
        logger.info("===========================================");
        logger.info("ENV CHECK - Datasource URL: {}", datasourceUrl);
        logger.info("ENV CHECK - Datasource Username: {}", datasourceUsername);
        logger.info("===========================================");
        
        if (datasourceUrl.contains("${") || datasourceUsername.contains("${")) {
            logger.error("WARNING: .env file NOT loaded! Variables still contain placeholders.");
        } else {
            logger.info("SUCCESS: .env file loaded correctly!");
        }
    }
}
