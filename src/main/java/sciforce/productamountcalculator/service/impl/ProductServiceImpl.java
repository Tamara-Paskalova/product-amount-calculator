package sciforce.productamountcalculator.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sciforce.productamountcalculator.dao.ProductRepository;
import sciforce.productamountcalculator.dto.ProductDto;
import sciforce.productamountcalculator.model.Product;
import sciforce.productamountcalculator.service.DatasourceReader;
import sciforce.productamountcalculator.service.ProductService;
import sciforce.productamountcalculator.strategy.DatasourceReaderStrategy;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private final DatasourceReaderStrategy strategy;
    private final ModelMapper mapper;

    public ProductServiceImpl(ProductRepository repository,
                              DatasourceReaderStrategy strategy, ModelMapper mapper) {
        this.repository = repository;
        this.strategy = strategy;
        this.mapper = mapper;
    }

    @Override
    public void addAllFromSource(String source) throws Exception {
        DatasourceReader reader = strategy.getReader(source);
        List<Product> products = reader.read(source).stream()
                .map(p -> mapper.map(p, Product.class))
                .collect(Collectors.toList());
        repository.saveAll(products);
    }

    @Override
    public List<ProductDto> getResult() {
        return repository.getResult();
    }
}
