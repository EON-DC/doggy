package com.doggy;

import com.doggy.auth.ApplicationUserRole;
import com.doggy.member.Member;
import com.doggy.member.MemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class EonApplication {

	public static void main(String[] args) {
		SpringApplication.run(EonApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			memberRepository.save(new Member("park", passwordEncoder.encode("1234"), ApplicationUserRole.USER));
			memberRepository.save(new Member("lee", passwordEncoder.encode("1234"), ApplicationUserRole.ADMIN));
		};
	}
}
