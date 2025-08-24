package com.iniflex;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.util.Locale;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;
    
    public static final BigDecimal SALARIO_MINIMO = new BigDecimal("1212.00");
    
    public static final DecimalFormat FORMATTER;
    
    static {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
        symbols.setCurrencySymbol("R$ ");
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        
        FORMATTER = new DecimalFormat("¤ #,##0.00", symbols);
        FORMATTER.setCurrency(java.util.Currency.getInstance("BRL"));
        FORMATTER.setRoundingMode(RoundingMode.HALF_EVEN);
    }
    

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }
    

    public BigDecimal getSalario() {
        return salario;
    }
    

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
    

    public String getFuncao() {
        return funcao;
    }
    

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    

    public void aumentarSalario(double percentual) {
        BigDecimal fator = BigDecimal.ONE.add(BigDecimal.valueOf(percentual / 100));
        this.salario = this.salario.multiply(fator).setScale(2, RoundingMode.HALF_EVEN);
    }
    

    public BigDecimal getSalariosMinimos() {
        return this.salario.divide(SALARIO_MINIMO, 2, RoundingMode.HALF_EVEN);
    }
    

    public String getSalarioFormatado() {
        return FORMATTER.format(salario);
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Salário: " + getSalarioFormatado() + ", Função: " + funcao;
    }
}
