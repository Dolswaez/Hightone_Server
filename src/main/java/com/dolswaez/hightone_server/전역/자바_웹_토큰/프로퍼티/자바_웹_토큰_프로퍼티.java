package com.dolswaez.hightone_server.전역.자바_웹_토큰.프로퍼티;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("jwt")
@Getter @Setter
public class 자바_웹_토큰_프로퍼티 {
    private String secret;
    private Long expiredAt;
}
