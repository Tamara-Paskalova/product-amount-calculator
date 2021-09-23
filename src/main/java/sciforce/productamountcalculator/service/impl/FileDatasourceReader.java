package sciforce.productamountcalculator.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Component;
import sciforce.productamountcalculator.dto.ProductDto;
import sciforce.productamountcalculator.service.DatasourceReader;
import sciforce.productamountcalculator.util.SourcePath;

@Component
public class FileDatasourceReader implements DatasourceReader {
    private final ObjectMapper mapper;

    public FileDatasourceReader(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<ProductDto> read(String source) throws Exception {
        return mapper.readValue(new File(source), new TypeReference<List<ProductDto>>() {
        });
    }

    @Override
    public boolean isApplicable(String source) {
        return Objects.equals(SourcePath.getType(source), SourcePath.Type.PATH);
    }
}
