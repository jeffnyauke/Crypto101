package com.piestack.crypto.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

@Entity
public class RateResponse {

    @SerializedName("id")
    @Expose
    @PrimaryKey
    @ColumnInfo(name = "id")
    private int id;

    @SerializedName("ETH")
    @Expose
    @ColumnInfo(name = "ETH")
    private Double eTH;

    @SerializedName("BTC")
    @Expose
    @ColumnInfo(name = "BTC")
    public Double bTC;

    @SerializedName("USD")
    @Expose
    @ColumnInfo(name = "USD")
    private Double uSD;

    @SerializedName("AUD")
    @Expose
    @ColumnInfo(name = "AUD")
    private Double aUD;

    @SerializedName("CAD")
    @Expose
    @ColumnInfo(name = "CAD")
    private Double cAD;

    @SerializedName("CHF")
    @Expose
    @ColumnInfo(name = "CHF")
    private Double cHF;

    @SerializedName("JPY")
    @Expose
    @ColumnInfo(name = "JPY")
    private Double jPY;

    @SerializedName("NZD")
    @Expose
    @ColumnInfo(name = "NZD")
    private Double nZD;

    @SerializedName("EUR")
    @Expose
    @ColumnInfo(name = "EUR")
    private Double eUR;

    @SerializedName("GBP")
    @Expose
    @ColumnInfo(name = "GBP")
    private Double gBP;

    @SerializedName("SEK")
    @Expose
    @ColumnInfo(name = "SEK")

    private Double sEK;

    @SerializedName("SGD")
    @Expose
    @ColumnInfo(name = "SGD")
    private Double sGD;

    @SerializedName("CZK")
    @Expose
    @ColumnInfo(name = "CZK")
    private Double cZK;

    @SerializedName("HKD")
    @Expose
    @ColumnInfo(name = "HKD")
    private Double hKD;

    @SerializedName("MXN")
    @Expose
    @ColumnInfo(name = "MXN")
    private Double mXN;

    @SerializedName("RUB")
    @Expose
    @ColumnInfo(name = "RUB")
    private Double rUB;

    @SerializedName("ZAR")
    @Expose
    @ColumnInfo(name = "ZAR")
    private Double zAR;

    @SerializedName("CNH")
    @Expose
    @ColumnInfo(name = "CNH")
    private Double cNH;

    @SerializedName("CNY")
    @Expose
    @ColumnInfo(name = "CNY")
    private Double cNY;

    @SerializedName("INR")
    @Expose
    @ColumnInfo(name = "INR")
    private Double iNR;

    @SerializedName("NGN")
    @Expose
    @ColumnInfo(name = "NGN")
    private Double nGN;

    @SerializedName("KES")
    @Expose
    @ColumnInfo(name = "KES")
    private Double kES;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getETH() {
        return eTH;
    }

    public void setETH(Double eTH) {
        this.eTH = eTH;
    }

    public Double getbTC() {
        return bTC;
    }

    public void setbTC(Double bTC) {
        this.bTC = bTC;
    }

    public Double getUSD() {
        return uSD;
    }

    public void setUSD(Double uSD) {
        this.uSD = uSD;
    }

    public Double getAUD() {
        return aUD;
    }

    public void setAUD(Double aUD) {
        this.aUD = aUD;
    }

    public Double getCAD() {
        return cAD;
    }

    public void setCAD(Double cAD) {
        this.cAD = cAD;
    }

    public Double getCHF() {
        return cHF;
    }

    public void setCHF(Double cHF) {
        this.cHF = cHF;
    }

    public Double getJPY() {
        return jPY;
    }

    public void setJPY(Double jPY) {
        this.jPY = jPY;
    }

    public Double getNZD() {
        return nZD;
    }

    public void setNZD(Double nZD) {
        this.nZD = nZD;
    }

    public Double getEUR() {
        return eUR;
    }

    public void setEUR(Double eUR) {
        this.eUR = eUR;
    }

    public Double getGBP() {
        return gBP;
    }

    public void setGBP(Double gBP) {
        this.gBP = gBP;
    }

    public Double getSEK() {
        return sEK;
    }

    public void setSEK(Double sEK) {
        this.sEK = sEK;
    }

    public Double getSGD() {
        return sGD;
    }

    public void setSGD(Double sGD) {
        this.sGD = sGD;
    }

    public Double getCZK() {
        return cZK;
    }

    public void setCZK(Double cZK) {
        this.cZK = cZK;
    }

    public Double getHKD() {
        return hKD;
    }

    public void setHKD(Double hKD) {
        this.hKD = hKD;
    }

    public Double getMXN() {
        return mXN;
    }

    public void setMXN(Double mXN) {
        this.mXN = mXN;
    }

    public Double getRUB() {
        return rUB;
    }

    public void setRUB(Double rUB) {
        this.rUB = rUB;
    }

    public Double getZAR() {
        return zAR;
    }

    public void setZAR(Double zAR) {
        this.zAR = zAR;
    }

    public Double getCNH() {
        return cNH;
    }

    public void setCNH(Double cNH) {
        this.cNH = cNH;
    }

    public Double getCNY() {
        return cNY;
    }

    public void setCNY(Double cNY) {
        this.cNY = cNY;
    }

    public Double getINR() {
        return iNR;
    }

    public void setINR(Double iNR) {
        this.iNR = iNR;
    }

    public Double getNGN() {
        return nGN;
    }

    public void setNGN(Double nGN) {
        this.nGN = nGN;
    }

    public Double getKES() {
        return kES;
    }

    public void setKES(Double kES) {
        this.kES = kES;
    }


    public List<Rate> toRateArray(){
        List<Rate> array = new ArrayList<>();
        if(eTH != null) array.add(new Rate("ETH","Ethereum",String.valueOf(eTH)));
        if(bTC != null) array.add(new Rate("BTC","Bitcoin",String.valueOf(bTC)));
        if(uSD != null) array.add(new Rate("USD","USA Dollar",String.valueOf(uSD)));
        if(aUD != null) array.add(new Rate("AUD","Australian Dollar",String.valueOf(aUD)));
        if(cAD != null) array.add(new Rate("CAD","Canadian Dollar",String.valueOf(cAD)));
        if(cHF != null) array.add(new Rate("CHF","Swiss Franc",String.valueOf(cHF)));
        if(jPY != null) array.add(new Rate("JPY","Japanese Yen",String.valueOf(jPY)));
        if(nZD != null) array.add(new Rate("NZD","New Zealand Dollar",String.valueOf(nZD)));
        if(eUR != null) array.add(new Rate("EUR","Euro",String.valueOf(eUR)));
        if(gBP != null) array.add(new Rate("GBP","Great Britain Pound",String.valueOf(gBP)));
        if(sEK != null) array.add(new Rate("SEK","Swedish Krona",String.valueOf(sEK)));
        if(sGD != null) array.add(new Rate("SGD","Singapore Dollar",String.valueOf(sGD)));
        if(hKD != null) array.add(new Rate("HKD","Hong Kong Dollar",String.valueOf(hKD)));
        if(mXN != null) array.add(new Rate("MXN","Mexican Peso",String.valueOf(mXN)));
        if(rUB != null) array.add(new Rate("RUB","Russian Ruble",String.valueOf(rUB)));
        if(zAR != null) array.add(new Rate("ZAR","South Africa Rand",String.valueOf(zAR)));
        if(cNH != null) array.add(new Rate("CNH","Chinese Offshore Yuan",String.valueOf(cNH)));
        if(cNY != null) array.add(new Rate("CNY","Chinese Yuan",String.valueOf(cNY)));
        if(iNR != null) array.add(new Rate("INR","Indian Rupee",String.valueOf(iNR)));
        if(nGN != null) array.add(new Rate("NGN","Naira",String.valueOf(nGN)));
        if(kES != null) array.add(new Rate("KES","Kenyan Shilling",String.valueOf(kES)));
        return array;
    }

    @Override
    public String toString() {
        return "RateResponse{" +
                "id=" + id +
                ", eTH=" + eTH +
                ", bTC=" + bTC +
                ", uSD=" + uSD +
                ", aUD=" + aUD +
                ", cAD=" + cAD +
                ", cHF=" + cHF +
                ", jPY=" + jPY +
                ", nZD=" + nZD +
                ", eUR=" + eUR +
                ", gBP=" + gBP +
                ", sEK=" + sEK +
                ", sGD=" + sGD +
                ", cZK=" + cZK +
                ", hKD=" + hKD +
                ", mXN=" + mXN +
                ", rUB=" + rUB +
                ", zAR=" + zAR +
                ", cNH=" + cNH +
                ", cNY=" + cNY +
                ", iNR=" + iNR +
                ", nGN=" + nGN +
                ", kES=" + kES +
                '}';
    }
}