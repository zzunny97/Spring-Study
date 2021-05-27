package project.member;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import project.AppConfig;

public class MemberServiceTest {
    
    MemberService memberService;
    
    @Before
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
    
    @Test
    public void join() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);
        
        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        
        // then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
