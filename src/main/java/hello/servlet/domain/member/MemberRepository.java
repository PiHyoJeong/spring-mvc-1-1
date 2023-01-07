package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 동시성 문제가 고려되어 있지 않음. 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
public class MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; //id 하나씩 증가

    //싱글톤으로 생성 (spring 을 사용하지 않아 일단 싱글톤으로 생성)
    private static final MemberRepository instance = new MemberRepository();

    //무조건 getInstance 로 조회해야함
    public static MemberRepository getInstance(){
        return instance;
    }

    //싱글톤으로 생성 시 private 로 생성자를 막아햐 한다 (아무나 생성하지 못하게)
    private MemberRepository() {
    }

    //저장
    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    //id 조회
    public Member findById(Long id){
        return store.get(id);
    }

    //store 모든 값을 꺼내 새로운 ArrayList 에 담아 return. store value 를 건드리고싶지 않아 이렇게 작성
    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    //테스트 위해 clear store
    public void clearStore(){
        store.clear();
    }
}
