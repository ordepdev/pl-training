package com.ordepdev.sales;

public class ReportRunner {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("You must provide a file path.");
            System.exit(-1);
        }

        CsvSalesRepository repository = new CsvSalesRepository(args[0]);
        SalesAnalysisService analyser = new SalesAnalysisService(repository);
        SalesReport report = new SalesReport(System.out, analyser);
        report.report();
    }
}
