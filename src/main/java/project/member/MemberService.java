package project.member;

/**
 * MemberService
 */
public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

}
