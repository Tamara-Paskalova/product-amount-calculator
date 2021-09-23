package sciforce.productamountcalculator.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Objects;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;
import sciforce.productamountcalculator.dto.ProductDto;
import sciforce.productamountcalculator.service.DatasourceReader;
import sciforce.productamountcalculator.util.SourcePath;

@Component
public class UrlDatasourceReader implements DatasourceReader {
    private final ObjectMapper mapper;

    public UrlDatasourceReader(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<ProductDto> read(String source) throws Exception {
        HttpGet request = new HttpGet(source);
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
                CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                return mapper.readValue(result, new TypeReference<List<ProductDto>>() {
                });
            }
        }
        throw new Exception();
    }

    @Override
    public boolean isApplicable(String source) {
        return Objects.equals(SourcePath.getType(source), SourcePath.Type.URL);
    }
}
