/**
 * Created by nafis on 8/5/15.
 */
import org.elasticsearch.client.Client;

import java.io.IOException;

public class ElasticDocSearch {
    public static void main(String[] args) throws InterruptedException {
        CreateNodeClient test = new CreateNodeClient();
        Client cl = test.CreateNode();

        /*IndexDocs docs = new IndexDocs();
        try {
            docs.CreateIndex(cl);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        new SearchIndex(cl);

        Thread.sleep(1000);
        test.DeleteNode();
    }
}
