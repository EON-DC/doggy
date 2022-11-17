package com.doggy.member;

import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원 등록, 조회, 수정(이름, 비밀번호), 삭제
    public Integer saveMember(Member member) {
        memberRepository.save(member);
        return member.getId();
    }

    public Member selectMember(Integer memberId){
        Member findMember = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalStateException("잘못된 회원 Id"));
        return findMember;
    }

    public Integer updateMember(Integer memberId, String username, String password){
        Member findMember = selectMember(memberId);
        findMember.updateMember(username, password);
        return memberId;
    }

    public Integer deleteMember(Integer memberId) {
        Member findMember = selectMember(memberId);
        memberRepository.delete(findMember);
        return memberId;
    }
    
}
