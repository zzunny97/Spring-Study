package project.order;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import project.AppConfig;
import project.member.Grade;
import project.member.Member;
import project.member.MemberService;

public class OrderServiceTest {
    
    MemberService memberService;
    OrderService orderService;
    
    @Before
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }
    
    @Test
    public void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
        
    }
}