package project.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import project.discount.DiscountPolicy;
import project.member.Member;
import project.member.MemberRepository;

/**
 * OrderServiceImpl
 */
@Component
public class OrderServiceImpl implements OrderService {

    private final DiscountPolicy discountPolicy;
    private final MemberRepository memberRepository;

    // For test : ConfigurationSingletonTest.java
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order creatOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

}
