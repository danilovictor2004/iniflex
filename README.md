# Teste Prático de Programação

## Descrição do Projeto  
Este projeto em **Java** é um teste prático de programação para Projedata, utilizando orientação a objetos para modelar a classe pessoa e funcionário, além de executar uma série de operações sobre uma lista de funcionários disponibilizado no desafio.

---

## Tecnologia Utilizada  
- **Java**

---

## Ferramenta  
- **IntelliJ IDEA Community**

---

## Desafios  
Este projeto implementa os seguintes requisitos:  

### Classe Pessoa  
- **Atributos:**
  - `nome` (String)  
  - `dataNascimento` (LocalDate)

---

### Classe Funcionário  
- **Herda de Pessoa e possui atributos adicionais:**  
  - `salario` (BigDecimal)  
  - `funcao` (String)

---

### Classe Principal  
Realiza as seguintes ações:

- **3.1** – Inserir todos os funcionários, na mesma ordem e informações da tabela fornecida.  
- **3.2** – Remover o funcionário "João" da lista.  
- **3.3** – Imprimir todos os funcionários com todas as suas informações, formatando:  
    - Data no formato dd/MM/yyyy.  
    - Valores numéricos com separador de milhar como ponto e decimal como vírgula.  
- **3.4** – Atualizar a lista com 10% de aumento de salário para todos os funcionários.  
- **3.5** – Agrupar os funcionários por função em um Map, onde:  
    - Chave: Função do funcionário.  
    - Valor: Lista de funcionários que exercem aquela função.  
- **3.6** – Imprimir os funcionários agrupados por função.  
- **3.8** – Imprimir os funcionários que fazem aniversário nos meses 10 e 12.  
- **3.9** – Imprimir o funcionário com a maior idade, exibindo:  
    - Nome.  
    - Idade.  
- **3.10** – Ordenar e imprimir a lista de funcionários em ordem alfabética.  
- **3.11** – Imprimir o total dos salários de todos os funcionários.  
- **3.12** – Imprimir quantos salários mínimos cada funcionário recebe, considerando que o salário mínimo é de R$ 1212,00.

---

## Como Executar o Projeto  
1. Clone o repositório para sua máquina local:  
```bash
git clone <url-do-repositorio>
