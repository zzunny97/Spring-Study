package project.discount;

import project.member.Member;

/**
 * DiscountPolicy
 */
public interface DiscountPolicy {

    // @return : price that will be discounted
    int discount(Member member, int price);
}
