package practical.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main class of this application written in Java/Spring Boot.
 *
 * <p>
 * It loads all the services used to execute CRUD operations on the database via RESTful APIs
 * </p>
 *
 * @author jacksmchan
 */
@SpringBootApplication
public class SpringBootPurchasesApplication {
  
  /**
   * main method is the entry point of this application.
   * 
   * @param args   the array of input strings from command line
   */
  public static void main(String[] args) {
    SpringApplication.run(SpringBootPurchasesApplication.class, args);
  }
}
