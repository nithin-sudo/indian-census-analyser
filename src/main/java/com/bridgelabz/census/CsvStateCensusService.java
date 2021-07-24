package com.bridgelabz.census;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class CsvStateCensusService
{
    private static final String STATE_CODE_CSV_FILE_PATH = "~/IdeaProjects/Indian-Census-Analyser/src/main/resources/StateCensusData.csv";
    int count = 0;
    public int checkNumberOfRecords() {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(STATE_CODE_CSV_FILE_PATH));
        ) {
            CsvToBean<StateCensusAnalyser> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(StateCensusAnalyser.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<StateCensusAnalyser> stateCodeCSVUserIterator = csvToBean.iterator();
            while (stateCodeCSVUserIterator.hasNext()) {
                StateCensusAnalyser stateCodeCSVUser = stateCodeCSVUserIterator.next();
                System.out.println("State : " + stateCodeCSVUser.getStateName());
                System.out.println("Population : " + stateCodeCSVUser.getPopulation());
                System.out.println("Area : " + stateCodeCSVUser.getAreaInSqKm());
                System.out.println("Density: " + stateCodeCSVUser.getDensityPerSqKm());
                System.out.println("==========================");
                count += 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
    public static void main(String[] args) {
        CsvStateCensusService csvStateCensusService = new CsvStateCensusService();
        csvStateCensusService.checkNumberOfRecords();
    }
}
