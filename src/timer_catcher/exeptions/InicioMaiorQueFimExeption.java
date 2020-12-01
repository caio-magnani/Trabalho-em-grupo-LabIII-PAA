package timer_catcher.exeptions;

public class InicioMaiorQueFimExeption extends Exception {
    public InicioMaiorQueFimExeption() {
        super();
    }

    @Override
    public String getMessage() {
        return "Marcação de tempo do Inicio é maior que a marcação de tempo do Fim, ou seja, tem algo de errado!";
    }
    @Override
    public void printStackTrace() {
        System.out.println(getMessage());
    }
}
