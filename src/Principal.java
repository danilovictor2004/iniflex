import br.com.projedata.model.Funcionario;

import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
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

        // Imprimir todos os funcionários com todas suas informações, sendo que:
        // • informação de data deve ser exibido no formato dd/mm/aaaa;
        // • informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto
        // e decimal como vírgula.
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat decimalFormatter = new DecimalFormat("#,###.00");

        for (Funcionario funcionario : funcionarios) {
            String dataFormatada = funcionario.getDataNascimento().format(dateFormatter);
            String salarioFormatado = decimalFormatter.format(funcionario.getSalario());

            System.out.printf("""
                       Nome: %s
                       Data de Nascimento: %s
                       Salário: %s
                       Função: %s
                    """, funcionario.getNome(), dataFormatada, salarioFormatado, funcionario.getFuncao());
            System.out.println();
        }

    }
}