package com.example.roomdatamvvm.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RechargeListResponse {
    @SerializedName("ERROR")
    @Expose
    private String ERROR;
    @SerializedName("STATUSCODE")
    @Expose
    private String STATUSCODE;
    @SerializedName("MESSAGE")
    @Expose
    private String MESSAGE;
    @SerializedName("REPORT")
    @Expose
    private List<REPORT> REPORT = null;


    public String getERROR() {
        return ERROR;
    }

    public void setERROR(String ERROR) {
        this.ERROR = ERROR;
    }

    public String getSTATUSCODE() {
        return STATUSCODE;
    }

    public void setSTATUSCODE(String STATUSCODE) {
        this.STATUSCODE = STATUSCODE;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public List<com.example.roomdatamvvm.Model.REPORT> getREPORT() {
        return REPORT;
    }

    public void setREPORT(List<com.example.roomdatamvvm.Model.REPORT> REPORT) {
        this.REPORT = REPORT;
    }
}
