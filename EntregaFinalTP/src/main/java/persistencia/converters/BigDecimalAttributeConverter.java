package persistencia.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.math.BigDecimal;

@Converter(autoApply = true)
public class BigDecimalAttributeConverter implements AttributeConverter<BigDecimal, Double> {

    @Override
    public Double convertToDatabaseColumn(BigDecimal bigDecimal) {
        return bigDecimal == null ? null : bigDecimal.doubleValue();
    }

    @Override
    public BigDecimal convertToEntityAttribute(Double value) {
        return value == null ? null : BigDecimal.valueOf(value).setScale(7, BigDecimal.ROUND_HALF_UP);
    }
}