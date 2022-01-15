package com.dolswaez.hightone_server.인프라.메일.서비스;

import java.util.Map;

public interface 메일_송신_서비스 {
    void 메일_보내기(String 이메일, String 인증메일_제목, String 인증메일_내용_위치, Map<String, String> 이메일_모델값);
}
