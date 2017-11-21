package com.kowalczyk.workouter.model.response;

public class ApiError extends ResponseBase {
    private String faultString;
    private String faultCode;

    public ApiError(String faultString, String faultCode) {
        this.faultString = faultString;
        this.faultCode = faultCode;
    }

    public String getFaultString() {
        return faultString;
    }

    public void setFaultString(String faultString) {
        this.faultString = faultString;
    }

    public String getFaultCode() {
        return faultCode;
    }

    public void setFaultCode(String faultcode) {
        this.faultCode = faultcode;
    }

    @Override
    public String toString() {
        return "faultString: " + faultString + ", faultCode: " + faultCode;
    }
}
