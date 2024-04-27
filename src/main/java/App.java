
import componentes.*;
import dao.MaquinaDao;
import setup.GerarPdf;
import setup.InserirRegistros;
import setup.Logar;

public class App {
    public static void main(String[] args) {
        Logar logar = new Logar();

        logar.logar();
        GerarPdf gerarPdf = new GerarPdf();
    }
}


