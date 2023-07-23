package EntidadesYEstablecimientos;

import lombok.Setter;

public class MedioDeTransporte {
    private Linea linea;
    private TipoDeMedio tipoDeMedio;
    public void setLinea(Linea linea) {
        this.linea = linea;
    }
    public void setTipoDeMedio(TipoDeMedio tipoDeMedio) {
        this.tipoDeMedio = tipoDeMedio;
    }
}
