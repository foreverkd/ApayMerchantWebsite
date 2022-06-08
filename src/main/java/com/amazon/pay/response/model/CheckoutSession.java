package com.amazon.pay.response.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CheckoutSession {
    private String checkoutSessionId;

    public String getCheckoutSessionId() {
        return checkoutSessionId;
    }

    public void setCheckoutSessionId(String checkoutSessionId) {
        this.checkoutSessionId = checkoutSessionId;
    }

    public CheckoutSession(String checkoutSessionId) {
        this.checkoutSessionId = checkoutSessionId;
    }

    public CheckoutSession() {}
}
