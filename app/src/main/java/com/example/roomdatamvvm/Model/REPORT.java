package com.example.roomdatamvvm.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "report", indices = @Index(value = {"RechargeID"},unique = true))
public class REPORT {
    @PrimaryKey(autoGenerate = true)
    private int actorId;

    @SerializedName("RechargeID")
    @ColumnInfo(name = "RechargeID")
    private String RechargeID;

    @SerializedName("TxnId")
    @ColumnInfo(name = "TxnId")
    private String TxnId;

    @SerializedName("FullName")
    @ColumnInfo(name = "FullName")
    private String FullName;

    @SerializedName("MobileNO")
    @ColumnInfo(name = "MobileNO")
    private String MobileNO;

    @SerializedName("Operator")
    @ColumnInfo(name = "Operator")
    private String Operator;

    @SerializedName("Amount")
    @ColumnInfo(name = "Amount")
    private String Amount;

    @SerializedName("Date")
    @ColumnInfo(name = "Date")
    private String Date;

    @SerializedName("Status")
    @ColumnInfo(name = "Status")
    private String Status;

    @SerializedName("OrignalOperatorId")
    @ColumnInfo(name = "OrignalOperatorId")
    private String OrignalOperatorId;

    @SerializedName("Image")
    @ColumnInfo(name = "Image")
    private String Image;



    public REPORT(String RechargeID, String TxnId, String FullName,String MobileNO, String Operator, String Amount,
                  String Date, String Status, String OrignalOperatorId,String Image) {
        this.RechargeID = RechargeID;
        this.TxnId = TxnId;
        this.FullName = FullName;
        this.MobileNO = MobileNO;
        this.Operator = Operator;
        this.Amount = Amount;
        this.Date = Date;
        this.Status = Status;
        this.OrignalOperatorId = OrignalOperatorId;
        this.Image = Image;

    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getRechargeID() {
        return RechargeID;
    }

    public void setRechargeID(String rechargeID) {
        RechargeID = rechargeID;
    }

    public String getTxnId() {
        return TxnId;
    }

    public void setTxnId(String txnId) {
        TxnId = txnId;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getMobileNO() {
        return MobileNO;
    }

    public void setMobileNO(String mobileNO) {
        MobileNO = mobileNO;
    }

    public String getOperator() {
        return Operator;
    }

    public void setOperator(String operator) {
        Operator = operator;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getOrignalOperatorId() {
        return OrignalOperatorId;
    }

    public void setOrignalOperatorId(String orignalOperatorId) {
        OrignalOperatorId = orignalOperatorId;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    @Override
    public String toString() {
        return "REPORT{" +
                "actorId=" + actorId +
                ", RechargeID=" + RechargeID +
                ", TxnId='" + TxnId + '\'' +
                ", FullName=" + FullName +
                ", MobileNO='" + MobileNO + '\'' +
                ", Operator=" + Operator +
                ", Amount='" + Amount + '\'' +
                ", Date=" + Date +
                ", Status='" + Status + '\'' +
                ", OrignalOperatorId='" + OrignalOperatorId + '\'' +
                ", Image=" + Image +
                '}';
    }
}
