package com.dolswaez.hightone_server.도메인.우정기록부.정보.요청;

import com.dolswaez.hightone_server.도메인.우정기록부.정보.종류.성격_종류;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Size;
import java.util.List;

public record 우정기록부_작성하기_요청(
        @JsonProperty("writerName") String 작성자_이름,
        @Size(min = 1, max = 3)
        @JsonProperty("personalityList") List<성격_종류> 성격_리스트,
        @JsonProperty("chs") String 친학수,
        @JsonProperty("ngh") String 내꼭해
) {}
