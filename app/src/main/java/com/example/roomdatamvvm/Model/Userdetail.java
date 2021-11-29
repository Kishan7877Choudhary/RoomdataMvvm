package com.example.roomdatamvvm.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "userdetails")
public class Userdetail {
    @PrimaryKey@NonNull
    @ColumnInfo(name = "ERROR")
    private String ERROR;
    @ColumnInfo(name = "TOKENID")
    private String TOKENID;
    @ColumnInfo(name = "USERID")
    private String USERID;
    @ColumnInfo(name = "MESSAGE")
    private String MESSAGE;


    public String getERROR() {
        return ERROR;
    }

    public void setERROR(String ERROR) {
        this.ERROR = ERROR;
    }

    public String getTOKENID() {
        return TOKENID;
    }

    public void setTOKENID(String TOKENID) {
        this.TOKENID = TOKENID;
    }

    public String getUSERID() {
        return USERID;
    }

    public void setUSERID(String USERID) {
        this.USERID = USERID;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    @Override
    public String toString() {
        return "Userdetail{" +
                ", ERROR=" + ERROR +
                ", TOKENID='" + TOKENID + '\'' +
                ", USERID='" + USERID + '\'' +
                ", MESSAGE=" + MESSAGE +
                '}';
    }
}
