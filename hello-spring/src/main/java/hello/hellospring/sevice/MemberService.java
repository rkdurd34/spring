package hello.hellospring.sevice;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {


    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //        회원가입
    public  Long join(Member member){

        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();

    }
    // 이거는 주로 extract method 해서 따로 해서 15번째줄에 실행시키는 방향으로 진행 ctrl+t -> extractmethod
    private void validateDuplicateMember(Member member) {
        // command option v 자동으로 참조변수타입 세팅
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        // Optional 메서드 다양하게 사
//        // result.orElseGet -> 값이 있으면 꺼내고 없으면 동작 선언
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니");
//        });

        // 어차피 반환 타입은 optional이니까 바로 적용!
        memberRepository.findByName(member.getName())
                .ifPresent(m->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    // 전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    // 특정회원 조회
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
