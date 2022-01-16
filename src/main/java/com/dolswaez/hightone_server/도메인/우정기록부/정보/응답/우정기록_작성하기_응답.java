package com.dolswaez.hightone_server.도메인.우정기록부.정보.응답;

import com.dolswaez.hightone_server.도메인.우정기록부.정보.종류.성격_종류;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record 우정기록_작성하기_응답(
        @JsonProperty("idx") Long 인덱스,
        @JsonProperty("name") String 작성자_이름,
        @JsonProperty("personalityList") List<성격_종류> 성격_리스트,
        @JsonProperty("chs") String 친학수,
        @JsonProperty("ngh") String 내꼭해
) {}
