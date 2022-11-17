package com.doggy.member;

import com.doggy.auth.ApplicationUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 회원 등록, 조회, 수정(이름, 비밀번호), 삭제
    public Integer saveMember(Member member) {
        String rawPassword = member.getPassword();
        String encodePassword = passwordEncoder.encode(rawPassword);
        member.updateMember(member.getUsername(), encodePassword);
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
    public List<ApplicationUser> getApplicationUsers() {
        List<Member> members = memberRepository.findAll();

        List<ApplicationUser> applicationUsers = members.stream()
                .map(member -> new ApplicationUser(
                        member.getUsername(),
                        member.getPassword(),
                        member.getUserRole().getSimpleGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                )).collect(Collectors.toList());
        return applicationUsers;

    }
}
