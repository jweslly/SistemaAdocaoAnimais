package sistemaadocao;

import java.io.Serializable;

public class Adotante implements Serializable {

    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private int quantidadeAnimaisAdotados;

    public Adotante(String nome) {
        this.nome = nome;
    }

    public Adotante(int id, String nome, String cpf, String telefone) {
        this(nome);
        this.id = id;
        this.cpf = cpf;
        this.telefone = telefone;
        this.quantidadeAnimaisAdotados = 0;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getTelefone() { return telefone; }
    public int getQuantidadeAnimaisAdotados() { return quantidadeAnimaisAdotados; }

    public void setNome(String nome) { this.nome = nome; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public void incrementarAnimais() { quantidadeAnimaisAdotados++; }

    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + nome + " | CPF: " + cpf +
                " | Telefone: " + telefone +
                " | Adotados: " + quantidadeAnimaisAdotados;
    }
}
