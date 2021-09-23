package sciforce.productamountcalculator.service;

import java.util.List;
import sciforce.productamountcalculator.dto.ProductDto;

public interface ProductService {
    void addAllFromSource(String source) throws Exception;

    List<ProductDto> getResult();
}
