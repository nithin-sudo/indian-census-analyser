package com.bridgelabz.census;

import com.opencsv.bean.CsvBindByName;

public class StateCensusAnalyser
{
    public StateCensusAnalyser(String stateName, String population, String areaInSqKm, String densityPerSqKm) {
        StateName = stateName;
        Population = population;
        AreaInSqKm = areaInSqKm;
        DensityPerSqKm = densityPerSqKm;
    }
    @CsvBindByName(column = "StateName")
    private String StateName;
    private String Population;
    private String AreaInSqKm;
    private String DensityPerSqKm;

    public String getStateName() {
        return StateName;
    }

    public String getPopulation() {
        return Population;
    }

    public String getAreaInSqKm() {
        return AreaInSqKm;
    }

    public String getDensityPerSqKm() {
        return DensityPerSqKm;
    }

    public void setStateName(String stateName) {
        StateName = stateName;
    }

    public void setPopulation(String population) {
        Population = population;
    }

    public void setAreaInSqKm(String areaInSqKm) {
        AreaInSqKm = areaInSqKm;
    }

    public void setDensityPerSqKm(String densityPerSqKm) {
        DensityPerSqKm = densityPerSqKm;
    }

    @Override
    public String toString() {
        return "StateCensusAnalyser{" +
                ", StateName='" + StateName + '\'' +
                ", Population='" + Population + '\'' +
                ", AreaInSqKm='" + AreaInSqKm + '\'' +
                ", DensityPerSqKm='" + DensityPerSqKm + '\'' +
                '}';
    }
}
