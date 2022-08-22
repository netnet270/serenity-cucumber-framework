package coccoc.AM.common;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

public class DataDrivenTable {

    public static void getDataTable(DataTable dataTable){
        List<Map<String,String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String campaignName = row.get("Campaign name ");
            String timePeriod = row.get("Time period");
            String bidStrategy = row.get("Bid strategy");
            String dailyLimit = row.get("Daily limit");
        }
    }

}
