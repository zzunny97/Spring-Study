package project.scan;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import project.AutoAppConfig;
import project.member.MemberService;

public class AutoAppConfigTest {
    
    @Test
    public void basicScan() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        
        MemberService memberService = ac.getBean(MemberService.class);
        
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }
}