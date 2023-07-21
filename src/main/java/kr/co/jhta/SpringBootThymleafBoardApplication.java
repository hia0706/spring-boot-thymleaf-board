package kr.co.jhta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootThymleafBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootThymleafBoardApplication.class, args);
    }

}
