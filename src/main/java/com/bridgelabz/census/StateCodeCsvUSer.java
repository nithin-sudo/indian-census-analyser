package com.bridgelabz.census;

import com.opencsv.bean.CsvBindByName;

public class StateCodeCsvUSer
{
    public StateCodeCsvUSer(String srNo, String stateName, String TIN, String stateCode) {
        SrNo = srNo;
        StateName = stateName;
        this.TIN = TIN;
        StateCode = stateCode;
    }

    public StateCodeCsvUSer() {
    }

    @CsvBindByName(column = "SrNo")
    private String SrNo;

    @CsvBindByName(column = "StateName ")
    private String StateName;

    @CsvBindByName(column = "TIN")
    private String TIN;

    @CsvBindByName(column = "StateCode")
    private String StateCode;

    public String getSrNo() {
        return SrNo;
    }

    public String getStateName() {
        return StateName;
    }

    public String getTIN() {
        return TIN;
    }

    public String getStateCode() {
        return StateCode;
    }

    public void setSrNo(String srNo) {
        SrNo = srNo;
    }

    public void setStateName(String stateName) {
        StateName = stateName;
    }

    public void setTIN(String TIN) {
        this.TIN = TIN;
    }

    public void setStateCode(String stateCode) {
        StateCode = stateCode;
    }

    @Override
    public String toString() {
        return "StateCodeCSVUser{" +
                "SrNo='" + SrNo + '\'' +
                ", StateName='" + StateName + '\'' +
                ", TIN='" + TIN + '\'' +
                ", StateCode='" + StateCode + '\'' +
                '}';
    }
}
