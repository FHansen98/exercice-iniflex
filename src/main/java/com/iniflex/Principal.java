package com.iniflex;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Principal {
    
    private List<Funcionario> funcionarios;
    
    public Principal() {
        this.funcionarios = new ArrayList<>();
    }
    
    public static void main(String[] args) {
        Principal principal = new Principal();
        
        // 3.1 - Inserir todos os funcionários
        principal.inserirFuncionarios();
        System.out.println("Lista de funcionários inseridos:");
        principal.imprimirFuncionarios();
        System.out.println();
        
        // 3.2 - Remover o funcionário "João" da lista
        principal.removerFuncionario("João");
        System.out.println("Lista após remover o funcionário João:");
        principal.imprimirFuncionarios();
        System.out.println();
        
        // 3.4 - Aplicar aumento de 10% para todos os funcionários
        principal.aumentarSalarios(10);
        System.out.println("Lista após aumento salarial de 10%:");
        principal.imprimirFuncionarios();
        System.out.println();
        
        // 3.5 e 3.6 - Agrupar e imprimir funcionários por função
        principal.agruparEImprimirPorFuncao();
        System.out.println();
        
        // 3.8 - Imprimir funcionários que fazem aniversário nos meses 10 e 12
        principal.imprimirAniversariantesMes(10, 12);
        System.out.println();
        
        // 3.9 - Imprimir funcionário com maior idade
        principal.imprimirFuncionarioMaiorIdade();
        System.out.println();
        
        // 3.10 - Imprimir lista de funcionários por ordem alfabética
        principal.imprimirFuncionariosOrdemAlfabetica();
        System.out.println();
        
        // 3.11 - Imprimir total dos salários dos funcionários
        principal.imprimirTotalSalarios();
        System.out.println();
        
        // 3.12 - Imprimir quantos salários mínimos ganha cada funcionário
        principal.imprimirSalariosMinimos();
    }
    
    public void inserirFuncionarios() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        funcionarios.add(new Funcionario("Maria", LocalDate.parse("18/10/2000", formatter), 
                new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.parse("12/05/1990", formatter), 
                new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.parse("02/05/1961", formatter), 
                new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.parse("14/10/1988", formatter), 
                new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.parse("05/01/1995", formatter), 
                new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.parse("19/11/1999", formatter), 
                new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.parse("31/03/1993", formatter), 
                new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.parse("08/07/1994", formatter), 
                new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.parse("24/05/2003", formatter), 
                new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.parse("02/09/1996", formatter), 
                new BigDecimal("2799.93"), "Gerente"));
    }
    
    public void removerFuncionario(String nome) {
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals(nome));
    }
    
    public void imprimirFuncionarios() {
        funcionarios.forEach(System.out::println);
    }
    
    public void aumentarSalarios(double percentual) {
        funcionarios.forEach(funcionario -> funcionario.aumentarSalario(percentual));
    }
    
    public void agruparEImprimirPorFuncao() {
        System.out.println("Funcionários agrupados por função:");
        
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
        
        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println("Função: " + funcao);
            lista.forEach(funcionario -> System.out.println("  - " + funcionario.getNome()));
        });
    }
    
    public void imprimirAniversariantesMes(int... meses) {
        System.out.println("Funcionários que fazem aniversário nos meses " + 
                java.util.Arrays.toString(meses) + ":");
        
        List<Funcionario> aniversariantes = funcionarios.stream()
                .filter(funcionario -> {
                    int mesAniversario = funcionario.getMesAniversario();
                    for (int mes : meses) {
                        if (mesAniversario == mes) {
                            return true;
                        }
                    }
                    return false;
                })
                .collect(Collectors.toList());
        
        if (aniversariantes.isEmpty()) {
            System.out.println("Não há aniversariantes nos meses especificados.");
        } else {
            aniversariantes.forEach(funcionario -> 
                System.out.println(funcionario.getNome() + " - " + funcionario.getDataNascimentoFormatada()));
        }
    }
    
    public void imprimirFuncionarioMaiorIdade() {
        Funcionario maisVelho = funcionarios.stream()
                .max(Comparator.comparing(Pessoa::getIdade))
                .orElse(null);
        
        if (maisVelho != null) {
            System.out.println("Funcionário com maior idade:");
            System.out.println("Nome: " + maisVelho.getNome() + ", Idade: " + maisVelho.getIdade() + " anos");
        } else {
            System.out.println("Não há funcionários na lista.");
        }
    }
    
    public void imprimirFuncionariosOrdemAlfabetica() {
        System.out.println("Funcionários em ordem alfabética:");
        
        funcionarios.stream()
                .sorted(Comparator.comparing(Pessoa::getNome))
                .forEach(funcionario -> System.out.println(funcionario.getNome()));
    }
    
    public void imprimirTotalSalarios() {
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_EVEN);
        
        System.out.println("Total dos salários: " + 
                Funcionario.FORMATTER.format(totalSalarios));
    }
    
    public void imprimirSalariosMinimos() {
        System.out.println("Salários mínimos por funcionário:");
        
        funcionarios.forEach(funcionario -> {
            BigDecimal salariosMinimos = funcionario.getSalariosMinimos();
            System.out.println(funcionario.getNome() + ": " + 
                    salariosMinimos + " salários mínimos");
        });
    }
}
