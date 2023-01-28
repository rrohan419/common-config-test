package com.mb.common.constant;

public class ApiConstant {

	private ApiConstant() {
		throw new IllegalStateException("Constant class.can't instatiate");
	}

	public static final String AUTHORIZATION = "authorization";
	public static final String BEARER = "Bearer ";

	public static final String JWT_SIGN_KEY = "jwt.sign.key";
	public static final String INVITATION_EXPIRY_TIME = "invitation.expiry.secs";

	public static final String CLAIMS_SUB = "sub";
	public static final String EVENT_ID = "eventId";
}
