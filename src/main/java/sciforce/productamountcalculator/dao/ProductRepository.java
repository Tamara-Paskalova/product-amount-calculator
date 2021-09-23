package sciforce.productamountcalculator.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sciforce.productamountcalculator.dto.ProductDto;
import sciforce.productamountcalculator.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select NEW sciforce.productamountcalculator.dto.ProductDto(p.productUuid, "
            + "p.productName, sum(p.amount)) from Product p group by p.productUuid")
    List<ProductDto> getResult();
}
