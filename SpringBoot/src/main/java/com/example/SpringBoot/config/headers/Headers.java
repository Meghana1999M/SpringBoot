package com.example.SpringBoot.config.headers;

import java.util.Map;
public interface Headers {
    void setHeaderValue(String var1, String var2);
    Map<String, String> toMap();
}
