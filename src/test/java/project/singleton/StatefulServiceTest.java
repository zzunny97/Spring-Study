package project.singleton;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {
    
    @Test
    public void statefulServiceTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);
        
        // Thread A: A 사용자 10000원 주문
        statefulService1.order("userA", 10000);
        // Thread B: B 사용자 20000원 주문
        statefulService2.order("userB", 20000);
        
        // ThreadA: 사용자 A가 주문 금액 조회
        int price = statefulService1.getPrice();

        Assertions.assertThat(statefulService1).isEqualTo(statefulService2);
        Assertions.assertThat(price).isNotSameAs(10000);
        Assertions.assertThat(price).isSameAs(20000);
    }
    
    static class TestConfig {
        
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}