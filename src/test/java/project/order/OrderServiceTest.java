package project.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import project.AppConfig;
import project.member.Grade;
import project.member.Member;
import project.member.MemberService;

/**
 * OrderServiceTest
 */
class OrderServiceTest {

    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
    OrderService orderService = appConfig.orderService();

    @Test
    void creatOrder() {
        System.out.println("OrderServiceTest.creatOrder");
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.creatOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}
