package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    //싱글톤
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach //테스트 끝날때마다 실행
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save(){
        //given 주어졌을 때
        Member member = new Member("hello", 20);

        //when 실행했을 때
        Member savedMember = memberRepository.save(member);

        //then 이 결과가 나와야해
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll(){
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> result = memberRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertEquals(result.size(), 2);
        assertThat(result).contains(member1, member2);
    }
}