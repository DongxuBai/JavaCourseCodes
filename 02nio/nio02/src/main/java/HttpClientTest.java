import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author Bai
 * @since 2021/11/14
 */
public class HttpClientTest {

    public static void main(String[] args) throws IOException {
        CloseableHttpClient aDefault = HttpClients.createDefault();
        CloseableHttpResponse execute = aDefault.execute(new HttpGet("http://localhost:8801"));

        System.out.println(EntityUtils.toString(execute.getEntity()));
    }
}
