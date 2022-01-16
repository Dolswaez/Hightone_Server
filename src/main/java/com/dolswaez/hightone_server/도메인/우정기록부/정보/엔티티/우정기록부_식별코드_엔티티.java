package com.dolswaez.hightone_server.도메인.우정기록부.정보.엔티티;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("friendly_record_code")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class 우정기록부_식별코드_엔티티 {
    @Id
    String 식별코드;
    String 아이디;
}
