/**
 * Created by nafis on 8/5/15.
 */

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.xcontent.XContentBuilder;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

import static org.elasticsearch.common.xcontent.XContentFactory.*;

public class IndexDocs {
    String words[] = {"CALYX", "CAMEO", "CAMES", "CAMPO", "CAMPI", "CANOE", "CANON", "CAPUT", "CAPOS", "CAPON", "CARAT", "CARBO", "CARDS", "CARBS", "CAPHS", "BREAK", "BREAD", "BRAZE", "BREAM", "BREDE", "BRENS", "BRIMS", "BRILL", "BRING"};

    void CreateIndex(Client client) throws IOException {
        int ind, limit = 100;
        Random rand = new Random();
        long startTime = new Date().getTime();

        String textBody, textTitle;
        for (int i = 1; i <= limit; i++) {

            textBody = "";
            for(int j=1;j<=340;j++){
                if(j>1) textBody += " ";
                int w_ind = rand.nextInt(24);
                textBody += words[w_ind];
            }

            textTitle = "";
            for(int j=1;j<=5;j++){
                if(j>1) textTitle += " ";
                int w_ind = rand.nextInt(24);
                textTitle += words[w_ind];
            }

            XContentBuilder builder = jsonBuilder()
                    .startObject()
                    .field("title", textTitle)
                    .field("postDate", new Date())
                    .field("body", textBody)
                    .endObject();

            IndexResponse response = client.prepareIndex("search_test", "test")
                    .setSource(builder)
                    .execute()
                    .actionGet();

            if (i % 10 == 0) {
                System.out.println("Response: " + response.getIndex() + " / " +
                        response.getType() + " / " + response.getId() + " / " + response.isCreated());
            }
        }
        long endTime = new Date().getTime();
        System.out.println("Time needed to insert: " + (endTime - startTime)/1000 );
    }
}

