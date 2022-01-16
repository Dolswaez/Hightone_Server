package com.dolswaez.hightone_server.도메인.우정기록부.정보.응답;

import com.fasterxml.jackson.annotation.JsonProperty;

public record 우정기록부_코드_생성하기_응답(
        @JsonProperty("code") String 식별코드
) {}
