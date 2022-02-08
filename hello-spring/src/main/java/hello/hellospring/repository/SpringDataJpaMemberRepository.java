package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
// Member 도메인에 long 타입 id, 다중 상속!!!
// 구현체를 자동으로 만들어줌
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long> ,MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}
