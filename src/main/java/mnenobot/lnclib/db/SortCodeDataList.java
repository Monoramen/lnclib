package mnenobot.lnclib.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import mnenobot.lnclib.sorting.Quick;
import mnenobot.lnclib.sorting.QuickSortWithLeadingZeros;

public class SortCodeDataList  extends DatabaseOperation {
        private List<String> data;


    @Override
    protected String getQuerry() {
        return "SELECT code FROM ru_word_codes";
    }

    @Override
    protected void setParameters(PreparedStatement statement) throws SQLException {

    }

    @Override
    protected void handleResults(ResultSet resultSet) throws SQLException {
        List<String> dataList = new ArrayList<>();
        while (resultSet.next()) {
            dataList.add(resultSet.getString("code"));
        }
        String[] dataArray = new String[dataList.size()];
        for (int i = 0; i < dataList.size(); i++) {
            dataArray[i] = dataList.get(i);
        }
        QuickSortWithLeadingZeros.quickSort(dataArray, 0, dataArray.length - 1);
        data = Arrays.asList(dataArray);
    }



    public List<String> getSortedData() {
        execute();
        return data;
    }
}
