package com.dolswaez.hightone_server.도메인.계정.정책;

import com.dolswaez.hightone_server.도메인.계정.레포지토리.유저_레포지토리;
import com.dolswaez.hightone_server.도메인.계정.예외.이메일_정책을_위반했을_때_발생하는_예외;
import com.dolswaez.hightone_server.도메인.계정.예외.이미_아이디가_존재할_때_발생하는_예외;
import com.dolswaez.hightone_server.도메인.계정.예외.이미_이메일이_존재할_때_발생하는_예외;
import com.dolswaez.hightone_server.도메인.계정.유틸.이메일_토큰_유틸;
import com.dolswaez.hightone_server.도메인.계정.정보.정보_전달_객체.회원가입_정보;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class 표준_회원가입_정책 implements 회원가입_정책 {
    private static final String 이메일_정규식 = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
    private final 유저_레포지토리 유저_레포지토리;
    private final 이메일_토큰_유틸 이메일_토큰_유틸;

    @Override
    public void 정책확인(회원가입_정보 정보) {
        String 이메일 = 이메일_토큰_유틸.토큰_디코딩(정보.이메일());
        if(유저_레포지토리.existsBy아이디(정보.아이디())) throw new 이미_아이디가_존재할_때_발생하는_예외(정보.아이디());
        if(유저_레포지토리.existsBy이메일(이메일)) throw new 이미_이메일이_존재할_때_발생하는_예외(이메일);
        if(!이메일.matches(이메일_정규식)) throw new 이메일_정책을_위반했을_때_발생하는_예외(정보.이메일());
    }
}
