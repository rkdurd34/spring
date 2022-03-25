package helllo.core.member;

public class MemberServiceImpl implements MemberService{
    // 추상화에만 의존해야하는데 구현체에도 의존중  -> DIP 위반...

    // 이제는 memberRepository의 추상에만 의존!!! 구현체는 appconfig에서 설정
    // 배우는 자기의 대사만 읽고 외우면 되고 누구와 연기를 하게 될지는 공연기획자(appconfig)가 설정해주는거임
    // 생성자만 만들어줬으므로 누가 들어올지 전혀 모름...!
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
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
}
