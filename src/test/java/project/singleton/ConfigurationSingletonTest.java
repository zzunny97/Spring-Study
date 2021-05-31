package project.singleton;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import project.AppConfig;
import project.member.MemberRepository;
import project.member.MemberServiceImpl;
import project.order.OrderServiceImpl;

public class ConfigurationSingletonTest {
    
    @Test
    public void configurationTest() {
        
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        
        MemberServiceImpl memberServiceImpl =  ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderServiceImpl = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);
        
        MemberRepository memberRepository1 =  memberServiceImpl.getMemberRepository();
        MemberRepository memberRepository2 = orderServiceImpl.getMemberRepository();
        
        // 세개 다 똑같음 (분명히 각각 new로 인스턴스를 생성했지만, @Configuration에서는 싱글톤을 자동으로 관리해줌)
        // @bean만 사용해도 스프링 빈으로 등록되지만, 싱글톤을 보장하지 않는다.
        Assertions.assertThat(memberRepository1).isSameAs(memberRepository2);
        Assertions.assertThat(memberRepository1).isSameAs(memberRepository);
        
    }
}