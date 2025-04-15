package Projeto.Dominio;

import java.util.Objects;

public class Cliente2 {
    //Atributos
    private String nome;
    private String cpf;
    private long telefone;
    private String endereco;
    private int numeroEndereco;
    private String cidade;
    private String estado;

    //construtor

    public Cliente2(String nome, String cpf, long telefone, String endereco, int numeroEndereco, String cidade, String estado) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.numeroEndereco = numeroEndereco;
        this.cidade = cidade;
        this.estado = estado;
    }


    //get e set

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(int numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente2 cliente2 = (Cliente2) o;
        return Objects.equals(cpf, cliente2.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }

    @Override
    public String toString() {
        return "Cliente2{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone=" + telefone +
                ", endereco='" + endereco + '\'' +
                ", numeroEndereco=" + numeroEndereco +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
