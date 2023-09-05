import java.util.List;

import HotAlarmClock.RegraDeNegocio;


public class Principal {
    private RegraDeNegocio regraDeNegocio;

    public Principal(){
        regraDeNegocio = new RegraDeNegocio();

    }
     

    public void executar() {
        System.out.println("Dados de Assinantes (DIARIA)");
        System.out.println("Dia 1: "+regraDeNegocio.retonaListaAssinatura(1));
        System.out.println("Dia 2: "+regraDeNegocio.retonaListaAssinatura(2));
        System.out.println("Dia 3: "+regraDeNegocio.retonaListaAssinatura(3));
        System.out.println("Dia 4: "+regraDeNegocio.retonaListaAssinatura(4));
        System.out.println("Dia 5: "+regraDeNegocio.retonaListaAssinatura(5));
        System.out.println("Dia 6: "+regraDeNegocio.retonaListaAssinatura(6));
        System.out.println("Dia 7: "+regraDeNegocio.retonaListaAssinatura(7));
        
        System.out.println("Dados de users Gratuitos (DIARIA)");
        System.out.println("Dia 1: "+regraDeNegocio.retonaListaGratuito(1));
        System.out.println("Dia 2: "+regraDeNegocio.retonaListaGratuito(2));
        System.out.println("Dia 3: "+regraDeNegocio.retonaListaGratuito(3));
        System.out.println("Dia 4: "+regraDeNegocio.retonaListaGratuito(4));
        System.out.println("Dia 5: "+regraDeNegocio.retonaListaGratuito(5));
        System.out.println("Dia 6: "+regraDeNegocio.retonaListaGratuito(6));
        System.out.println("Dia 7: "+regraDeNegocio.retonaListaGratuito(7));
    }



}
