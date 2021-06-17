package project.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import project.AppConfig;

/**
 * MemberServiceTest
 */
class MemberServiceTest {

    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();

    @Test
    void join() {
        System.out.println("MemberService join test");
        Member member = new Member(1L, "memberA", Grade.VIP);

        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        System.out.println(member);
        System.out.println(findMember);
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}
