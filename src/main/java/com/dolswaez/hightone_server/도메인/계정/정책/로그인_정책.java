package com.dolswaez.hightone_server.도메인.계정.정책;

import com.dolswaez.hightone_server.도메인.계정.정보.데이터_전달_객체.로그인_정보;

public interface 로그인_정책 {
    void 정책확인(로그인_정보 정보);
}
