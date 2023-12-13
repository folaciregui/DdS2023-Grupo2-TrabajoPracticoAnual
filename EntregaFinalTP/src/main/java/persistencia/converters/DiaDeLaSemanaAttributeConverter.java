package persistencia.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.DayOfWeek;


@Converter(autoApply = true)
public class DiaDeLaSemanaAttributeConverter implements AttributeConverter<DayOfWeek, String> {

    @Override
    public String convertToDatabaseColumn(DayOfWeek dayOfWeek) {
        String dia = null;
        switch(dayOfWeek){
            case MONDAY: dia = "Lunes"; break;
            case TUESDAY: dia = "Lunes"; break;
            case WEDNESDAY: dia = "Lunes"; break;
            case THURSDAY: dia = "Lunes"; break;
            case FRIDAY: dia = "Lunes"; break;
            case SATURDAY: dia = "Lunes"; break;
            case SUNDAY: dia = "Lunes"; break;
        }
        return dia;
    }

    @Override
    public DayOfWeek convertToEntityAttribute(String diaEnEspañol) {
        DayOfWeek dia = null;
        if(diaEnEspañol != null){
            switch (diaEnEspañol){
                case "Lunes": dia = DayOfWeek.MONDAY; break;
                case "Martes": dia = DayOfWeek.TUESDAY; break;
                case "Miercoles": dia = DayOfWeek.WEDNESDAY; break;
                case "Jueves": dia = DayOfWeek.THURSDAY; break;
                case "Viernes": dia = DayOfWeek.FRIDAY; break;
                case "Sabado": dia = DayOfWeek.SATURDAY; break;
                case "Domingo": dia = DayOfWeek.SUNDAY; break;
                default: throw new IllegalArgumentException(diaEnEspañol + " no se puede convertir a un DayOfWeek");
            }
        }
        return dia;
    }
}
