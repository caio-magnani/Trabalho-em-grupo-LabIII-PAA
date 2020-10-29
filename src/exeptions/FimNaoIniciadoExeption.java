package exeptions;

public class FimNaoIniciadoExeption extends NullPointerException{
    public FimNaoIniciadoExeption() {
        super();
    }
    @Override
    public String getMessage(){

        return "Marcação de tempo do Fim precisa ser iniciado," +
                " use TimerCatcher.setFimDaOperacao(); " +
                "apos da função da classe : AlgoritimosASerAnalisados ";
    }
    @Override
    public void printStackTrace() {
        System.out.println(getMessage());
    }
}
