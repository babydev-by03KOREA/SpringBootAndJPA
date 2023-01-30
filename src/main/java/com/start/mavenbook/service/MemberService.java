package com.start.mavenbook.service;

import com.start.mavenbook.Entity.Member;
import com.start.mavenbook.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional  // 로직을 처리하다가 에러가 발생하면 변경된 데이터를 로직을 수행하기 이전으로 롤백
@RequiredArgsConstructor    // final or @NonNull이 붙은 필드에 생성자를 생성해줌
public class MemberService {
    private final MemberRepository memberRepository;

    public Member saveMember(Member member) {
        validateDuplicateMember(member);
        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member membr) {
        Member findMember = memberRepository.findByEmail(membr.getEmail());
        if (findMember != null) {
            throw new IllegalStateException("이미 기입된 회원입니다!");
        }
    }
}
