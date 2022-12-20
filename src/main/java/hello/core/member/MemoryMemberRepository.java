package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long,Member> store = new HashMap<>(); // 저장소만들기


    @Override
    public void save(Member member) {
    store.put(member.getId(),member);  //저장소에 아이디 넣기
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId); // 저장소에서 아이디찾기
    }
}
