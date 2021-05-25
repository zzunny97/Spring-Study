package project.order;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import project.member.Grade;
import project.member.Member;
import project.member.MemberService;
import project.member.MemberServiceImpl;

public class OrderServiceTest {
    
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();
    
    @Test
    public void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
        
    }
}