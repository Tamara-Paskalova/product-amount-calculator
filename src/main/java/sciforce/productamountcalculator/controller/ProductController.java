package sciforce.productamountcalculator.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sciforce.productamountcalculator.dto.ProductDto;
import sciforce.productamountcalculator.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public String addDataToDB(@RequestParam String source) {
        try {
            service.addAllFromSource(source);
        } catch (Exception e) {
            return "Can't read data from source " + source + "!";
        }
        return "Done!";
    }

    @GetMapping
    public List<ProductDto> getResult() {
        return service.getResult();
    }
}
