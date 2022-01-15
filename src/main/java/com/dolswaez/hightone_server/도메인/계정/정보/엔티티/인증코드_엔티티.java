package com.dolswaez.hightone_server.도메인.계정.정보.엔티티;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("auth_code")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class 인증코드_엔티티 {
    @Id
    String 인증코드;
    String 이메일;
}
