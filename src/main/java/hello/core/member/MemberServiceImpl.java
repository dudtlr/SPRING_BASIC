package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 인터페이스에도 의존하고 구현체에도 의존한다 => dip 위배 => 순수 자바로 커버 못한다 => 뭔가가 필요 => 스프링!!!!

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return  memberRepository.findById(memberId);
    }
}
