package com.dolswaez.hightone_server.도메인.우정기록부.정보.응답;

import com.dolswaez.hightone_server.도메인.우정기록부.정보.정보_전달_객체.우정기록_정보;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record 우정기록부_조회하기_응답(
        @JsonProperty("idx") Long 인덱스,
        @JsonProperty("authorIdx") Long 게시자_인덱스,
        @JsonProperty("friendlyRecords") List<우정기록_정보> 우정기록_리스트
) {}
