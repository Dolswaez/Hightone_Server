package com.dolswaez.hightone_server.도메인.계정.정보.응답;

import com.dolswaez.hightone_server.도메인.계정.정보.종류.학교종류;
import com.fasterxml.jackson.annotation.JsonProperty;

public record 회원가입_응답(
        @JsonProperty("index") Long 인덱스,
        @JsonProperty("name") String 이름,
        @JsonProperty("id") String 아이디,
        @JsonProperty("encryptedPassword") String 암호화된_비밀번호,
        @JsonProperty("email") String 이메일,
        @JsonProperty("schoolType") 학교종류 학교,
        @JsonProperty("grade") Integer 학년,
        @JsonProperty("class") Integer 반,
        @JsonProperty("number") Integer 번호
) {}
