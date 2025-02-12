import br.com.projedata.model.Funcionario;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Principal {
    public static void main(String[] args) {

        List<Funcionario> funcionarios = Funcionario.listaFuncionarios();

        // Inserir todos os funcionários.
        List<Funcionario> funcionariosOrdenados = funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .collect(Collectors.toList());

        for (Funcionario funcionario : funcionariosOrdenados) {
            System.out.println(funcionario.getNome());
        }

        // Remover o funcionário “João” da lista
        funcionariosOrdenados.removeIf(funcionario -> funcionario.getNome().equals("João"));
        System.out.println();
        for (Funcionario funcionario : funcionariosOrdenados) {
            System.out.println(funcionario.getNome());
        }

    }
}