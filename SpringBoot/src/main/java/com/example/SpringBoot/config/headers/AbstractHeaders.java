package com.example.SpringBoot.config.headers;

// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.HashMap;
import java.util.Map;
public abstract class AbstractHeaders implements Headers {
    protected Map<String, String> customValues = new HashMap();
    public AbstractHeaders() {
    }
    public AbstractHeaders(Map<?, ?> headers) {
        if (headers != null) {
            headers.entrySet().stream().filter((h) -> {
                return h != null && h.getValue() != null && h.getKey() != null;
            }).filter((h) -> {
                return h.getValue() instanceof String;
            }).forEach((h) -> {
                this.setHeaderValue((String)h.getKey(), (String)h.getValue());
            });
        }
    }
    public Map<String, String> toMap() {
        return new HashMap();
    }
    protected static void addValue(Map<String, String> map, String key, String value) {
        if (value != null && !value.trim().isEmpty()) {
            map.put(key, value);
        }
    }
    public Map<String, String> getCustomValues() {
        return this.customValues;
    }
    public void setCustomValues(Map<String, String> customValues) {
        this.customValues = customValues;
    }
}
