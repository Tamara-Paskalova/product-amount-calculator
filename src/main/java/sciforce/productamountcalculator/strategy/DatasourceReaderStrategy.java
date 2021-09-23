package sciforce.productamountcalculator.strategy;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Component;
import sciforce.productamountcalculator.service.DatasourceReader;

@Component
public class DatasourceReaderStrategy {
    private final List<DatasourceReader> readers;

    public DatasourceReaderStrategy(List<DatasourceReader> readers) {
        this.readers = readers;
    }

    public DatasourceReader getReader(String source) {
        return readers.stream()
                .filter(r -> r.isApplicable(source))
                .findFirst().orElseThrow(NoSuchElementException::new);
    }
}
