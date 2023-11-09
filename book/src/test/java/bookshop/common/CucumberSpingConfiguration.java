package bookshop.common;

import bookshop.BookApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { BookApplication.class })
public class CucumberSpingConfiguration {}
