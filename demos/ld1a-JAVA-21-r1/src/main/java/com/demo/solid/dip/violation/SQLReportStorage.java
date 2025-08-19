package com.demo.solid.dip.violation;

class SQLReportStorage {
    public void store(String reportContent) {
        System.out.println("[SQL] Stored report: " + reportContent);
    }
}

class HardCodedReportGenerator {
    public void generateReport() {
        SQLReportStorage storage = new SQLReportStorage();  // ❌ Concrete dependency
        storage.store("Daily Payment Report");
    }
}