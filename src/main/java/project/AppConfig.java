package project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import project.discount.DiscountPolicy;
import project.discount.FixDiscountPolicy;
import project.member.MemberRepository;
import project.member.MemberService;
import project.member.MemberServiceImpl;
import project.member.MemoryMemberRepository;
import project.order.OrderService;
import project.order.OrderServiceImpl;

/**
 * AppConfig
 */
@Configuration
public class AppConfig {

	@Bean
	public MemberService memberService() {
		System.out.println("call AppConfig.memberService");
		return new MemberServiceImpl(memberRepository());
	}

	@Bean
	public OrderService orderService() {
		System.out.println("call AppConfig.orderService");
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}

	@Bean
	public MemberRepository memberRepository() {
		System.out.println("call AppConfig.memberRepository");
		return new MemoryMemberRepository();
	}

	@Bean
	public DiscountPolicy discountPolicy() {
		return new FixDiscountPolicy();
	}
}
