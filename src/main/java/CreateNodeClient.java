/**
 * Created by nafis on 8/5/15.
 */
import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;

import static org.elasticsearch.node.NodeBuilder.*;

public class CreateNodeClient {

    Node node;
    Client CreateNode() {
        node = nodeBuilder().clusterName("nafis_es").node();
        Client client = node.client();
        return client;
    }

    void DeleteNode() {
        node.close();
    }
}
