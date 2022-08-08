package elone.hoo.mande;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Main Application
 * @author Elone Hoo <huchengyea@163.com>
 * @SpringBootApplication set main class and scan packages
 * @EnableScheduling enable scheduled tasks
 */
@SpringBootApplication
@EnableScheduling
public class Mande {

    public static void main(String[] args) {
        SpringApplication.run(Mande.class, args);
    }

}
