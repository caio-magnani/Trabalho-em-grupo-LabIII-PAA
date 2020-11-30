package timer_catcher.exeptions;

public class InicioNaoIniciadoExeption extends NullPointerException {
    public InicioNaoIniciadoExeption() {
        super();
    }

    @Override
    public String getMessage(){

        return "Marcação de tempo do Inicio precisa ser iniciada, use timer_catcher.TimerCatcher.setInicioDaOperacao(); antes da operação ";
    }
    @Override
    public void printStackTrace() {
        System.out.println(getMessage());
    }
}