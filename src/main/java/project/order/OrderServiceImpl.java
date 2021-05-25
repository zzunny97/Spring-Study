package project.order;

import project.discount.DiscountPolicy;
import project.discount.FixDiscountPolicy;
import project.member.Member;
import project.member.MemberRepository;
import project.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    
    
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice,  discountPrice);
    }
}