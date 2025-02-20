package br.com.projedata.desafio;

import br.com.projedata.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Desafio {

    private static final BigDecimal SALARIO_MINIMO = new BigDecimal("1212.00");

    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DecimalFormat decimalFormatter = new DecimalFormat("#,###.00");

    List<Funcionario> funcionarios = Funcionario.listaFuncionarios();

    public void resolucaoDesafio1() {
        List<Funcionario> funcionariosOrdenados = funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .collect(Collectors.toList());

        for (Funcionario funcionario : funcionariosOrdenados) {
            System.out.println(funcionario.getNome());
        }
    }

    public void resolucaoDesafio2() {
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));
        System.out.println();
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getNome());
        }
    }

    public void resolucaoDesafio3() {
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getNome());
        }
    }

    public void resolucaoDesafio4() {
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

    public void resolucaoDesafio5() {
        for (Funcionario funcionario : funcionarios) {
            BigDecimal salarioAtual = funcionario.getSalario();
            BigDecimal aumento = salarioAtual.multiply(BigDecimal.valueOf(0.10));
            BigDecimal novoSalario = salarioAtual.add(aumento);
            funcionario.setSalario(novoSalario);
        }

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

    public void resolucaoDesafio6() {
        Map<String, List<Funcionario>> agrupadosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        for (Map.Entry<String, List<Funcionario>> entry : agrupadosPorFuncao.entrySet()) {
            String funcao = entry.getKey();
            List<Funcionario> funcionariosPorCargo = entry.getValue();

            System.out.println("Função: " + funcao);
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

    public void resolucaoDesafio7() {
        System.out.println("""
                ---------
                Aniversariantes do mês 10 e 12
                """);
        List<Funcionario> aniversariantes = funcionarios.stream()
                .filter(funcionario -> {
                    int mesNascimento = funcionario.getDataNascimento().getMonthValue();
                    return mesNascimento == Month.OCTOBER.getValue() || mesNascimento == Month.DECEMBER.getValue();
                })
                .collect(Collectors.toList());

        aniversariantes.forEach(funcionario -> {
            String dataFormatada = funcionario.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            System.out.printf("""
                      Nome: %s
                      Data de Nascimento: %s
                      Função: %s
                """, funcionario.getNome(), dataFormatada, funcionario.getFuncao());
            System.out.println();
        });
    }

    public void resolucaoDesafio8() {
        Optional<Funcionario> maisVelho = funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento));

        maisVelho.ifPresent(funcionario -> {
            int idade = Period.between(funcionario.getDataNascimento(), LocalDate.now()).getYears();
            System.out.printf("Funcionário mais velho: %s, Idade: %d anos%n", funcionario.getNome(), idade);
        });
    }

    public void resolucaoDesafio9() {
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        decimalFormatter = new DecimalFormat("#,###.00");
        String totalFormatado = decimalFormatter.format(totalSalarios);

        System.out.println("Total dos Salários: R$ " + totalFormatado);
    }

    public void resolucaoDesafio10() {
        decimalFormatter = new DecimalFormat("#,###.00");

        System.out.println("Quantidade de Salários Mínimos por Funcionário:");
        DecimalFormat finalDecimalFormatter = decimalFormatter;
        funcionarios.forEach(funcionario -> {
            BigDecimal qtdSalariosMinimos = funcionario.getSalario().divide(SALARIO_MINIMO, 2, RoundingMode.HALF_UP);

            System.out.printf("%s ganha %s salários mínimos%n",
                    funcionario.getNome(),
                    finalDecimalFormatter.format(qtdSalariosMinimos));
        });
    }

    public void quebraLinha() {
        System.out.println();
    }

}
