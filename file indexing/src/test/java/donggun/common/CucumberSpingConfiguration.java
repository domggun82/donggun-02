package donggun.common;

import donggun.FileIndexingApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { FileIndexingApplication.class })
public class CucumberSpingConfiguration {}
