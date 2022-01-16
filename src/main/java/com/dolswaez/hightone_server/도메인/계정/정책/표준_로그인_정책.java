package com.dolswaez.hightone_server.도메인.계정.정책;

import com.dolswaez.hightone_server.도메인.계정.레포지토리.유저_레포지토리;
import com.dolswaez.hightone_server.도메인.계정.예외.아이디를_찾을_수_없을_경우_발생하는_예외;
import com.dolswaez.hightone_server.도메인.계정.정보.정보_전달_객체.로그인_정보;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class 표준_로그인_정책 implements 로그인_정책{
    private final 유저_레포지토리 유저_레포지토리;

    @Override
    public void 정책확인(로그인_정보 정보) {
        String 아이디 = 정보.아이디();
        if(!유저_레포지토리.existsBy아이디(아이디)) throw new 아이디를_찾을_수_없을_경우_발생하는_예외(아이디);
    }
}
