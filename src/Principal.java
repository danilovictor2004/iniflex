import br.com.projedata.model.Funcionario;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
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

        for (Funcionario funcionario : funcionariosOrdenados) {
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

        // Atualizando os salários com 10% de aumento
        for (Funcionario funcionario : funcionariosOrdenados) {
            BigDecimal salarioAtual = funcionario.getSalario();
            BigDecimal aumento = salarioAtual.multiply(BigDecimal.valueOf(0.10));
            BigDecimal novoSalario = salarioAtual.add(aumento);
            funcionario.setSalario(novoSalario);
        }

        for (Funcionario funcionario : funcionariosOrdenados) {
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

        // Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
        Map<String, List<Funcionario>> agrupadosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        // Imprimir os funcionários, agrupados por função
        for (Map.Entry<String, List<Funcionario>> entry : agrupadosPorFuncao.entrySet()) {
            String cargo = entry.getKey();
            List<Funcionario> funcionariosPorCargo = entry.getValue();

            System.out.println("Cargo: " + cargo);
            for (Funcionario funcionario : funcionariosPorCargo) {
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
}