package sciforce.productamountcalculator.service;

import java.util.List;
import sciforce.productamountcalculator.dto.ProductDto;

public interface DatasourceReader {
    List<ProductDto> read(String source) throws Exception;

    boolean isApplicable(String source);
}
