package br.edu.ufcg.srh.adicionais.server;


/**
 * 
 * @author Cleber Gonçalves de Sousa
 */
public class Id implements Comparable<Id> {

    private Long valor;

    public Id(Long valor) {
        Consistency.notNull(valor, new IllegalArgumentException("Id inválido!"));

        this.valor = valor;
    }

    public Id(String valor) {
        try {
            this.valor = Long.valueOf(valor);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Id inválido!");
        }
    }

    public Long getValor() {
        return this.valor;
    }

    public Id anterior() {
        return this.getValor().equals(Long.MIN_VALUE) ? null : new Id(this.getValor() - 1);
    }

    public Id proximo() {
        return this.getValor().equals(Long.MAX_VALUE) ? null : new Id(this.getValor() + 1);
    }

    @Override
    public int compareTo(Id outro) {
        return this.getValor().compareTo(outro.getValor());
    }

    @Override
    public int hashCode() {
        return this.getValor().hashCode();
    }

    @Override
    public boolean equals(Object objeto) {
        return (objeto instanceof Id) && this.getValor().equals(((Id) objeto).getValor());
    }

    @Override
    public String toString() {
        return this.getValor().toString();
    }
}
