package net.cyancj.sistemae_cepuns.utils;

import org.json.JSONObject;

public class JsonResponse {
    private final JSONObject json;
    private String message;
    private boolean success;

    public JsonResponse() {
        json = new JSONObject();
        success = false;
    }

    private void build() {
        json.put("message", message);
        json.put("success", success);
    }

    public void success() {
        success = true;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getJson() {
        build();
        return json.toString();
    }
}
