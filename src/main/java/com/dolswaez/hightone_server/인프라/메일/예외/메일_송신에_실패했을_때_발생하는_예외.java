package com.dolswaez.hightone_server.인프라.메일.예외;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class 메일_송신에_실패했을_때_발생하는_예외 extends RuntimeException {
    public 메일_송신에_실패했을_때_발생하는_예외(String message) {
        super(message);
    }
    public 메일_송신에_실패했을_때_발생하는_예외(Throwable cause) {
        super(cause);
    }
}
