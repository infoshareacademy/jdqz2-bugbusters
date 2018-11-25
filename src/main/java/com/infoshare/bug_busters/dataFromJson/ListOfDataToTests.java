package com.infoshare.bug_busters.dataFromJson;

import java.util.List;

public class ListOfDataToTests {

    List<DataToTestCaseEntry> tests;

    public List<DataToTestCaseEntry> getTests() {
        return tests;
    }

    public void setTests(List<DataToTestCaseEntry> tests) {
        this.tests = tests;
    }

    @Override
    public String toString() {
        return "tests=" + tests;
    }
}
