package com.ordepdev.sales;

import com.csvreader.CsvReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class CsvSalesRepository implements SalesRepository {

    private final String fileLocation;
    private PrintStream error;
    private List<Sale> sales;

    public CsvSalesRepository(String fileLocation) {
        this.fileLocation = fileLocation;
        error = System.out;
    }

    public void setError(PrintStream error) {
        this.error = error;
    }

    private int parseInt(String value) { return Integer.parseInt(value.trim()); }

    public List<Sale> loadSales() {
        if (sales == null) {
            sales = new ArrayList<Sale>();
            try {
                CsvReader reader = new CsvReader(new FileReader(fileLocation));
                reader.readHeaders();

                while (reader.readRecord()) {
                    sales.add(new Sale(reader.get("product"),
                            reader.get("store"),
                            parseInt(reader.get("number")),
                            parseInt(reader.get("pricePerItem"))));
                }

                reader.close();

            } catch (IOException e) {
                error.println(e.getMessage());
            }
        }

        return sales;
    }
}
