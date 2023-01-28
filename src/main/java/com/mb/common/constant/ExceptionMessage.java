package com.mb.common.constant;

public class ExceptionMessage {

	private ExceptionMessage() {
		throw new IllegalStateException("Constant class.can't instatiate");
	}

	// REST TEMPLATE
	public static final String INTERNAL_SERVER_ERROR = "internal.server.error";
	public static final String INVALID_REQUEST_BODY = "invalid.request.body";
	public static final String BAD_REQUEST = "bad.request";

	// COMMON
	public static final String TIME_CONVERSION_ERROR = "time.conversion.error";

	// TOKEN
	public static final String INVALID_TOKEN = "invalid.token";

	// POWER_UP
	public static final String POWER_UP_NOT_FOUND = "power.up.not.found";
	public static final String POWER_UP_PACK_NOT_FOUND = "power.up.pack.not.found";
	public static final String POWER_UP_IS_NOT_READY = "power.up.is.not.ready";

	// EXCERCISE
	public static final String EXCERCISE_ALREADY_STARTED = "excercise.already.started";
	public static final String EXCERCISE_NOT_FOUND = "excercise.not.found";
	public static final String MAX_RESPONSE_LIMIT_REACHED = "max.response.limit.reached";

	// USER
	public static final String USER_NOT_FOUND = "user.not.found";
	public static final String USER_ALREADY_EXISTS = "user.already.exists";

	// COMPANY
	public static final String COMPANY_NOT_FOUND = "company.not.found";

	// MODULE
	public static final String MODULE_NOT_FOUND = "module.not.found";
	public static final String MODULE_RESPONSE_NOT_FOUND = "module.response.not.found";
	public static final String MODULE_STEP_NOT_FOUND = "module.step.not.found";

	// INVITATIONS
	public static final String EVENT_ALREADY_SCHEDULED = "event.already.scheduled";
	public static final String CALENDAR_EVENT_NOT_FOUND = "calendar.event.not.found";

	// PLUGINS
	public static final String PLUGIN_NOT_FOUND = "plugin.not.found";
	public static final String PLUGIN_SESSION_ALREADY_SCHEDULED = "plugin.session.already.scheduled";
	public static final String PLUGIN_RESPONSE_NOT_FOUND = "plugin.response.not.found";

	// FUSIONS
	public static final String FUSION_NOT_FOUND = "fusion.not.found";

	// DEMO
	public static final String DEMO_NOT_FOUND = "demo.not.found";

	// MARKET TEST
	public static final String MARKET_TEST_NOT_FOUND = "market.test.not.found";
	public static final String MARKET_TEST_RESPONSE_NOT_FOUND = "market.test.response.not.found";
	public static final String MARKET_TEST_ALREADY_CREATED = "market.test.already.created";
}
