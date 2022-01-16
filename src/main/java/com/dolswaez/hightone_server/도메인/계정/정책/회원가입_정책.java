package com.dolswaez.hightone_server.도메인.계정.정책;

import com.dolswaez.hightone_server.도메인.계정.정보.정보_전달_객체.회원가입_정보;

public interface 회원가입_정책 {
    void 정책확인(회원가입_정보 정보);
}
