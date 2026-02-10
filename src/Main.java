import br.com.sistemaDeAgendamento.model.TipoUsuario;
import br.com.sistemaDeAgendamento.views.LoginUsuario;
import br.com.sistemaDeAgendamento.views.MenuADM;
import br.com.sistemaDeAgendamento.views.MenuCliente;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

       TipoUsuario tipoUsuario = LoginUsuario.escolherUsuario(scanner);

       if (tipoUsuario == TipoUsuario.ADM){
           System.out.println("Você entrou como adm");
           MenuADM menuADM = new MenuADM();
           menuADM.menu(scanner);
       }else {
           MenuCliente menuCliente = new MenuCliente();
           menuCliente.menu(scanner);
       }

    }
}
