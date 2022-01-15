package com.dolswaez.hightone_server.도메인.계정.정보.요청;

import com.fasterxml.jackson.annotation.JsonProperty;

public record 인증_메일_송신_요청(
        @JsonProperty("email") String 이메일
) {}
