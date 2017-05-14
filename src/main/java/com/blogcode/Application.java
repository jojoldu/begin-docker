package com.blogcode;

import com.blogcode.member.Member;
import com.blogcode.member.MemberRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	private MemberRepository memberRepository;

	public Application(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@GetMapping("/members")
	public List<Member> getMembers(){
		return memberRepository.findAll();
	}
}
