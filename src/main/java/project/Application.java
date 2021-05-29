package project;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import project.member.Grade;
import project.member.Member;
import project.member.MemberService;

// @SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // SpringApplication.run(Application.class, args);
        // AppConfig appConfig = new AppConfig();
        // MemberService memberService = appConfig.memberService();
        
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService =  applicationContext.getBean("memberService", MemberService.class);
        
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        
        Member findMember  = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}