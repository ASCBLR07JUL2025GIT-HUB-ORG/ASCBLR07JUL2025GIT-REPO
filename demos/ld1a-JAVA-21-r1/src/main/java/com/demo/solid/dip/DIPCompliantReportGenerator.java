package com.demo.solid.dip;

class DIPCompliantReportGenerator {
    private final ReportStorage storage;

    // Dependency is injected via constructor
    public DIPCompliantReportGenerator(ReportStorage storage) {
        this.storage = storage;
    }

    public void generateReport() {
        String content = "Daily Payment Report";
        storage.store(content);
    }
}