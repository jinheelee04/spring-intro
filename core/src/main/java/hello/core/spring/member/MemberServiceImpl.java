package hello.core.spring.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("memberService2")
public class MemberServiceImpl implements MemberService {

//    private final MemberRepository memberRepository = new MemoryMemberRepository(); // DIP위반
    private final MemberRepository memberRepository;
    
    @Autowired // 의존관계 자동 주입, ac.getBean(MemberRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
    
    // 테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
