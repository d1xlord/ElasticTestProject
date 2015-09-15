/**
 * Created by nafis on 8/5/15.
 */

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilder;

import java.util.Date;
import java.util.Random;

import static org.elasticsearch.index.query.QueryBuilders.*;

public class SearchIndex {

    public SearchIndex(Client client) {
        long startTime = new Date().getTime();
        int ind;

        SearchResponse response = client.prepareSearch("search_test")
                .setTypes("test")
                .execute()
                .actionGet();

        System.out.println(response);

        long endTime = new Date().getTime();

        System.out.println("Execution time: " + (endTime - startTime)/1000 );
    }
}
