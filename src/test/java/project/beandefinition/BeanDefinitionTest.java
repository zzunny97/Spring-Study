package project.beandefinition;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import project.AppConfig;

public class BeanDefinitionTest {
    
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    
    @Test
    @DisplayName("빈 설정 메타정보 확인")
    public void findApplicationBean() {
        String[] beanDefinitionNames =  ac.getBeanDefinitionNames();
        for(String beandefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beandefinitionName);
            
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beandefinitionName = " + beandefinitionName + " beanDefinition = " + beanDefinition);
            }
        }
    }
}