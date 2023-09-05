package HotAlarmClock;

import java.util.ArrayList;
import java.util.HashMap;

import series.Periodicidade;
import series.SerieDados;

public class SerieDadosAlarm implements SerieDados  {
    private String tipoUsuarios;
    private int periodoInicial;
    private int periodoFinal;
    private Periodicidade p;
    private HashMap<Integer,Integer>dadosAlarm; // Periodo(Dia:10) , Quantidade

    public SerieDadosAlarm(String tipoUsuarios,int periodoInicial,int periodoFinal,Periodicidade p){
        this.tipoUsuarios = tipoUsuarios;
        this.periodoInicial =  periodoInicial;
        this.periodoFinal =  periodoFinal;
        this.p = p;
        dadosAlarm = new HashMap<>();
    }

    @Override
    public String obterIdentificacaoSerie() {
        return tipoUsuarios;
    }

    @Override
    public int obterInicioPeriodo() {
        return periodoInicial;
    }

    @Override
    public int obterFimPeriodo() {
       return periodoFinal;
    }

    @Override
    public Periodicidade obterPeriodicidade() {
        return p;
    }

    @Override
    public int obterDado(int periodo) {
       return dadosAlarm.get(periodo);
    }

    public void adicionarUsuarios(int periodo,int quantidade){
        //periodo = dia (Exemplo dia 10)
        if(periodo >= periodoInicial && periodo <= periodoFinal ){
            dadosAlarm.put(periodo, quantidade);
        }
    }

}
