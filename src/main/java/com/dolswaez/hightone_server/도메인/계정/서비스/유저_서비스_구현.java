package com.dolswaez.hightone_server.도메인.계정.서비스;

import com.dolswaez.hightone_server.도메인.계정.레포지토리.유저_레포지토리;
import com.dolswaez.hightone_server.도메인.계정.예외.비밀번호를_찾을_수_없을_떄_발생하는_예외;
import com.dolswaez.hightone_server.도메인.계정.유틸.로그인_토큰_유틸;
import com.dolswaez.hightone_server.도메인.계정.유틸.이메일_토큰_유틸;
import com.dolswaez.hightone_server.도메인.계정.유틸.재발급_토큰_유틸;
import com.dolswaez.hightone_server.도메인.계정.정보.정보_전달_객체.로그인_정보;
import com.dolswaez.hightone_server.도메인.계정.정보.정보_전달_객체.로그인_토큰;
import com.dolswaez.hightone_server.도메인.계정.정보.정보_전달_객체.회원가입_정보;
import com.dolswaez.hightone_server.도메인.계정.정보.엔티티.유저_엔티티;
import com.dolswaez.hightone_server.도메인.계정.정책.로그인_정책;
import com.dolswaez.hightone_server.도메인.계정.정책.회원가입_정책;
import com.dolswaez.hightone_server.인프라.메일.서비스.메일_송신_서비스;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class 유저_서비스_구현 implements 유저_서비스{
    private static final String 인증메일_제목 = "[우정기록부] 짜잔! 인증코드가 도착했어요!";
    private static final String 인증메일_내용_위치 = "인증코드_안내_메일_페이지";

    private final 메일_송신_서비스 메일_송신_서비스;
    private final 인증코드_관리_서비스 인증코드_관리_서비스;

    private final PasswordEncoder 비밀번호_인코더;
    private final 유저_레포지토리 유저_레포지토리;

    private final 이메일_토큰_유틸 이메일_토큰_유틸;
    private final 로그인_토큰_유틸 로그인_토큰_유틸;
    private final 재발급_토큰_유틸 재발급_토큰_유틸;

    private final 회원가입_정책 회원가입_정책;
    private final 로그인_정책 로그인_정책;

    @Override
    public void 인증메일_보내기(String 이메일) {
        String 인증코드 = 인증코드_관리_서비스.인증코드_생성하기(이메일);
        Map<String, String> 이메일_모델값 = new HashMap<>();
        이메일_모델값.put("code", 인증코드);
        메일_송신_서비스.메일_보내기(이메일, 인증메일_제목, 인증메일_내용_위치, 이메일_모델값);
    }

    @Override
    public String 인증코드_확인하기(String 코드) {
        String 이메일 = 인증코드_관리_서비스.인증코드로_이메일_가져오기(코드);
        return 이메일로_토큰_만들기(이메일);
    }

    private String 이메일로_토큰_만들기(String 이메일) {
        return 이메일_토큰_유틸.토큰_인코딩(이메일);
    }

    @Override
    public Long 회원가입(회원가입_정보 정보) {
        회원가입_정책.정책확인(정보);
        String 이메일 = 이메일_토큰_유틸.토큰_디코딩(정보.이메일());
        유저_엔티티 엔티티 = new 유저_엔티티(
                0L, 정보.이름(),
                정보.아이디(), 정보.암호화된_비밀번호(), 이메일,
                정보.학교이름(), 정보.학교(), 정보.학년(), 정보.반(), 정보.번호()
        );
        return 유저_레포지토리.save(엔티티).get인덱스();
    }

    @Override
    public String 비밀번호_암호화(String 비밀번호) {
        return 비밀번호_인코더.encode(비밀번호);
    }

    @Override
    public 로그인_토큰 로그인(로그인_정보 정보) {
        로그인_정책.정책확인(정보);
        유저_엔티티 엔티티 = 유저_레포지토리.getBy아이디(정보.아이디());
        if(!비밀번호_인코더.matches(정보.비밀번호(), 엔티티.get암호화된_비밀번호()))
            throw new 비밀번호를_찾을_수_없을_떄_발생하는_예외(정보.비밀번호());
        return 엔티티로_로그인_토큰_생성하기(엔티티);
    }

    private 로그인_토큰 엔티티로_로그인_토큰_생성하기(유저_엔티티 엔티티) {
        String 로그인_토큰 = 로그인_토큰_유틸.토큰_인코딩(엔티티.get아이디());
        String 재발급_토큰 = 재발급_토큰_유틸.토큰_인코딩(엔티티.get아이디());
        return new 로그인_토큰(로그인_토큰, 재발급_토큰);
    }
}
