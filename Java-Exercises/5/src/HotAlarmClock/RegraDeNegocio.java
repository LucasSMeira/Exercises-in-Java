package HotAlarmClock;


import java.text.CollationKey;
import java.util.Collections;

import series.Periodicidade;
import series.SerieDados;

public class RegraDeNegocio {
    private SerieDadosAlarm assinatura;
    private SerieDadosAlarm gratuito;


    public RegraDeNegocio(){

        assinatura = new SerieDadosAlarm("assinatura", 1, 7, Periodicidade.DIARIA);
        assinatura.adicionarUsuarios(1, 5);
        assinatura.adicionarUsuarios(2, 2);
        assinatura.adicionarUsuarios(3, 8);
        assinatura.adicionarUsuarios(4, 1);
        assinatura.adicionarUsuarios(5, 1);
        assinatura.adicionarUsuarios(6, 3);
        assinatura.adicionarUsuarios(7, 15);
       

       gratuito = new SerieDadosAlarm("gratuito", 1, 7, Periodicidade.DIARIA);
       gratuito.adicionarUsuarios(1, 30);
       gratuito.adicionarUsuarios(2, 10);
       gratuito.adicionarUsuarios(3, 45);
       gratuito.adicionarUsuarios(4, 120);
       gratuito.adicionarUsuarios(5, 85);
       gratuito.adicionarUsuarios(6, 70);
       gratuito.adicionarUsuarios(7, 350);

    }

    
    public int retonaListaAssinatura(int periodo){        
        return assinatura.obterDado(periodo);  
    }

    public int retonaListaGratuito(int periodo){        
        return gratuito.obterDado(periodo);  
    }
}

