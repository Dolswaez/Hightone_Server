package com.dolswaez.hightone_server.도메인.계정.서비스;

import com.dolswaez.hightone_server.도메인.계정.정보.데이터_전달_객체.로그인_정보;
import com.dolswaez.hightone_server.도메인.계정.정보.데이터_전달_객체.로그인_토큰;
import com.dolswaez.hightone_server.도메인.계정.정보.데이터_전달_객체.회원가입_정보;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Random;

@Service
public class 더미_유저_서비스 implements 유저_서비스 {
    @Override
    public void 인증메일_보내기(String 이메일) {
        System.out.println("인증메일을 보냈습니다! 이메일 : " + 이메일);
    }

    @Override
    public String 인증코드_확인(String 코드) {
        String 문자열 = "인증코드 " +
                코드 + "는 이메일 test@high.tone 의 인증코드입니다!\n" +
                "이메일 test@high.tone 의 인증이 완료되었습니다!\n" +
                "이메일 토큰 x5a84" + 코드 + " 가 생성되었습니다!";
        System.out.println(문자열);
        return "x5a84" + 코드;
    }

    @Override
    public Long 회원가입(회원가입_정보 정보) {
        StringBuilder 문자열 = new StringBuilder("회원가입 요청이 들어왔습니다!\n");
        Long 인덱스 = new Random().nextLong();
        문자열.append("이름 : ").append(정보.이름()).append('\n')
                .append("아이디 : ").append(정보.아이디()).append('\n')
                .append("암호화된_비밀번호 : ").append(정보.암호화된_비밀번호()).append('\n')
                .append("이메일 : ").append(정보.이메일()).append('\n')
                .append("학교 : ").append(정보.학교()).append('\n')
                .append("학년 : ").append(정보.학년()).append('\n')
                .append("반 : ").append(정보.반()).append('\n')
                .append("번호 : ").append(정보.번호()).append('\n').append('\n');
        문자열.append("회원가입에 성공하였습니다! 인덱스 : ").append(인덱스);
        System.out.println(문자열);
        return 인덱스;
    }

    @Override
    public String 비밀번호_암호화(String 비밀번호) {
        String 문자열 = "비밀번호 " + 비밀번호 + " 를 암호화합니다!\n" +
                "암호화된 비밀번호 : " + 비밀번호.toUpperCase(Locale.ROOT);
        System.out.println(문자열);
        return 비밀번호.toUpperCase(Locale.ROOT);
    }

    @Override
    public 로그인_토큰 로그인(로그인_정보 정보) {
        String 문자열 = "로그인을 시도합니다!\n" +
                "아이디 : " + 정보.아이디() + '\n' +
                "비밀번호 : " + 정보.비밀번호() + '\n' +
                "로그인에 성공하였습니다!\n" +
                "로그인 토큰 : " + "log4j-LVeltEn\n" +
                "재발급 토큰 : " + "reload-log5J";
        System.out.println(문자열);
        return new 로그인_토큰("log4j-LVeltEn", "reload-log5J");
    }
}
