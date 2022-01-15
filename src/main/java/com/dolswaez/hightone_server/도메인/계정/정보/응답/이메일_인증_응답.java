package com.dolswaez.hightone_server.도메인.계정.정보.응답;

import com.fasterxml.jackson.annotation.JsonProperty;

public record 이메일_인증_응답(
        @JsonProperty("emailToken") String 이메일_토큰
) {}
