package com.domedo.domedouser.web;

import com.domedo.domedouser.web.config.SharedConfigRef;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Arpit Srivastava <a> mailTo: iarpitsrivastava06@gmail.com</a>
 */
@EnableConfigurationProperties
@EnableJpaRepositories(basePackages = "com.domedo.domedouser.*")
@EntityScan(basePackages = "com.domedo.domedouser.*")
@ComponentScan(basePackages = {"com.domedo.domedouser.*"})
@Import({SharedConfigRef.class})
@SpringBootApplication
public class DomedoUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(DomedoUserApplication.class, args);
	}

}
