package com.kakaopay.shy.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {

    Y("Y","모집중"),
    N("N","모집 완료");

	private final String status;
	private final String statusText;
}
