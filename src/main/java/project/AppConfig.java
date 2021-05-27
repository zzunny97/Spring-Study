package project;


import project.discount.DiscountPolicy;
import project.discount.FixDiscountPolicy;
import project.discount.RateDiscountPolicy;
import project.member.MemberRepository;
import project.member.MemberService;
import project.member.MemberServiceImpl;
import project.member.MemoryMemberRepository;
import project.order.OrderService;
import project.order.OrderServiceImpl;

public class AppConfig {
    
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    
    
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    
    public DiscountPolicy discountPolicy() {
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}