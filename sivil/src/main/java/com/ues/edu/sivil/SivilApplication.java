package com.ues.edu.sivil;

import com.ues.edu.sivil.entities.User;
import com.ues.edu.sivil.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

@SpringBootApplication
@ComponentScan(basePackages = "com.ues.edu.sivil.*")
public class SivilApplication implements CommandLineRunner {
	@Autowired
	public BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepo;

	public static void main(String[] args) {
		SpringApplication.run(SivilApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();

		user.setId(1);
		user.setEmail("admin@siviluesapp.com");
		user.setEnable(true);
		user.setName("Carlos Alexander De Leon");
		user.setPhone("1234567890");
		user.setRole("ROLE_ADMIN");
		user.setPassword(passwordEncoder.encode("admin"));
		user.setProfile("admin.png");
		user.setDate(new Date());
		this.userRepo.save(user);

	}
}
