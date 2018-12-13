package com.infoshare.bug_busters.dataFromJson;

import java.util.List;

public class ListOfDataToTests {

    private List<DataToTestFromJson> testsData;

    public List<DataToTestFromJson> getTestsData() {
        return testsData;
    }

    public void setTestsData(List<DataToTestFromJson> testsData) {
        this.testsData = testsData;
    }

    @Override
    public String toString() {
        return "testsData=" + testsData;
    }
}
