package com.example.SpringBoot.config.headers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class MessageHeaders extends AbstractHeaders {
    public static final String MESSAGE_HEADERS_PROPERTY = MessageHeaders.class.getName();
    public static final String MESSAGE_ID = "com-id";
    public static final String CORRELATION_ID = "com-correlation-id";
    public static final String COM_JWT = "com-jwt";
    protected static final ThreadLocal<DateFormat> DATE_TIME_FORMAT = ThreadLocal.withInitial(() -> {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        return format;
    });
    private String messageId;
    private String correlationId;
    private String jwt;

    public MessageHeaders(String messageId, String correlationId) {
        this.messageId = messageId;
        this.correlationId = correlationId == null ? messageId : correlationId;
    }

    public MessageHeaders(MessageHeaders other) {
        this.messageId = other.messageId;
        this.correlationId = other.correlationId;
        this.jwt = other.jwt;
    }

    protected MessageHeaders(String messageId, String correlationId, String jwt){
        this(messageId, correlationId);
        this.jwt = jwt;
    }

    public MessageHeaders(HttpServletRequest request) {
        if (request != null) {
            Enumeration<String> headerNames = request.getHeaderNames();

            while(headerNames.hasMoreElements()) {
                String headerName = (String)headerNames.nextElement();
                String headerValue = request.getHeader(headerName);
                this.setHeaderValue(headerName, headerValue);
            }

        }
    }

    public MessageHeaders(HttpServletResponse response) {
        if (response != null) {
            Collection<String> headerNames = response.getHeaderNames();
            Iterator var3 = headerNames.iterator();

            while(var3.hasNext()) {
                String headerName = (String)var3.next();
                this.setHeaderValue(headerName, response.getHeader(headerName));
            }

        }
    }

    public MessageHeaders(Map<?, ?> headers) {
        super(headers);
    }
    public boolean isValid() {
        return this.messageId != null && !this.messageId.isEmpty() && this.correlationId != null && !this.correlationId.isEmpty();
    }

    public void setHeaderValue(String name, String value) {
        if (name.startsWith("com-header-")) {
            this.customValues.put(name.substring("com-header-".length()), value);
        } else if ("com-id".equals(name)) {
            this.messageId = value;
        } else if ("com-correlation-id".equals(name)) {
            this.correlationId = value;
        } else if ("com-jwt".equals(name)) {
            this.jwt = value;
        }
    }

    public Map<String, String> toMap() {
        Map<String, String> headers = super.toMap();
        addValue(headers, "com-id", this.messageId);
        addValue(headers, "com-correlation-id", this.correlationId);
        addValue(headers, "com-jwt", this.jwt);
        return headers;
    }
}