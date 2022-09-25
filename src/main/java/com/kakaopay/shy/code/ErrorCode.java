package com.kakaopay.shy.code;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

	PRODUCT_NOT_INPUT("ERROR0001", HttpStatus.NOT_FOUND, "상품코드를 찾을 수 없습니다."),
	INVEST_SOLD_OUT("ERROR0002", HttpStatus.BAD_REQUEST, "SOLD-OUT"),
	INVEST_AMT_ZERO("ERROR0003", HttpStatus.BAD_REQUEST, "투자신청금액을 입력해주세요"),
	INVEST_AMT_OVER("ERROR0004", HttpStatus.BAD_REQUEST, "투자신청금액이 투자가능한 금액보다 큽니다."),
	USER_NOT_FOUND("ERROR0005", HttpStatus.NOT_FOUND, "고객정보가 없습니다."),
	INVEST_NOT_FOUND("ERROR0006", HttpStatus.NOT_FOUND, "투자상품정보가 없습니다."),
	INVEST_INVALID_TERM("ERROR0007", HttpStatus.BAD_REQUEST, "투자 가능한 기간이 아닙니다."),
	PRODUCT_NOT_FOUND("ERROR0008", HttpStatus.NOT_FOUND, "상품이 없습니다."),
	USER_NOT_INPUT("ERROR0009", HttpStatus.NOT_FOUND, "유저정보를 입력해주세요"),
	API_UNKNOWN_ERROR("ERROR9999", HttpStatus.BAD_REQUEST, "알수없는 오류가 발생했습니다.");

	private final String code;
	private final HttpStatus httpStatus;
	private final String message;

	public static ErrorCode getByCode(final String code) {
		for (final ErrorCode e : values()) {
			if (e.code.equals(code))
				return e;
		}
		return ErrorCode.API_UNKNOWN_ERROR;
	}
}
