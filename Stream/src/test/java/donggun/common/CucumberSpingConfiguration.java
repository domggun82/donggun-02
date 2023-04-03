package donggun.common;

import donggun.StreamApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { StreamApplication.class })
public class CucumberSpingConfiguration {}
