package project;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import project.repository.JdbcTemplateMemberRepository;
import project.repository.JpaMemberRepository;
import project.repository.MemberRepository;
import project.repository.MemoryMemberRepository;
import project.service.MemberService;

@Configuration
public class SpringConfig {
    
    // private DataSource dataSource;
    
    
    
    // public SpringConfig(DataSource dataSource) {
    //     this.dataSource = dataSource;
    // }
    
    // private EntityManager em;
    
    // @Autowired
    // public SpringConfig(EntityManager em) {
    //     this.em = em;
    // }
    
    private final MemberRepository memberRepository;
    
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    
    @Bean
    public MemberService memberService() {
        // return new MemberService(memberRepository());
        return new MemberService(memberRepository);
    }
    
    // @Bean
    // public MemberRepository memberRepository() {
        // return new MemoryMemberRepository();
        // return new JdbcTemplateMemberRepository(dataSource);
        // return new JpaMemberRepository(em);
        
    // }

}