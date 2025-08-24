# Teste Prático de Programação - Sistema de Funcionários

Este projeto implementa um sistema de gerenciamento de funcionários conforme os requisitos.

## Estrutura do Projeto

O projeto está organizado da seguinte forma, seguindo o padrão Maven de organização de projetos Java:

- `src/main/java/com/iniflex/Pessoa.java`: Classe que representa uma pessoa com nome e data de nascimento.
- `src/main/java/com/iniflex/Funcionario.java`: Classe que estende Pessoa, adicionando salário e função.
- `src/main/java/com/iniflex/Principal.java`: Classe principal que implementa as operações solicitadas.

## Requisitos

1. Classe Pessoa com atributos: nome (String) e data nascimento (LocalDate).
2. Classe Funcionario que estende a classe Pessoa, com atributos: salário (BigDecimal) e função (String).
3. Classe Principal que executa as seguintes ações:
   - Inserir todos os funcionários
   - Remover o funcionário "João" da lista
   - Imprimir todos os funcionários com formatação adequada
   - Aumentar o salário dos funcionários em 10%
   - Agrupar os funcionários por função
   - Imprimir os funcionários agrupados por função
   - Imprimir os funcionários que fazem aniversário nos meses 10 e 12
   - Imprimir o funcionário com a maior idade
   - Imprimir a lista de funcionários por ordem alfabética
   - Imprimir o total dos salários dos funcionários
   - Imprimir quantos salários mínimos ganha cada funcionário

## Requisitos

- Java 11 ou superior
- Maven (opcional, para build automatizado)

## Como Executar

### Usando Maven (Recomendado)

Se você tem o Maven instalado, pode compilar e executar o projeto com os seguintes comandos:

```bash
# Compilar o projeto com Maven
mvn clean package

# Executar o programa
java -jar target/teste-pratico-1.0-SNAPSHOT.jar
```

### Compilação Manual

Se você não tem o Maven instalado, pode compilar e executar manualmente:

```bash
# Verificar a versão do Java instalada
java -version

# Compilar as classes (ajuste o número da versão conforme sua versão do Java)
# Exemplo para Java 11:
javac -source 11 -target 11 -d target/classes src/main/java/com/iniflex/*.java
# Exemplo para Java 12:
javac -source 12 -target 12 -d target/classes src/main/java/com/iniflex/*.java
# Exemplo para Java 17:
javac -source 17 -target 17 -d target/classes src/main/java/com/iniflex/*.java

# Executar o programa
java -cp target/classes com.iniflex.Principal
```
