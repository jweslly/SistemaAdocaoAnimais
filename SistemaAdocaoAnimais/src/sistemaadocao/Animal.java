package sistemaadocao;

import java.io.Serializable;

public abstract class Animal implements Serializable{
    private int id;
    private String nome;
    private int idade;
    private String raca;
    private StatusAnimal status;

    public Animal(int id, String nome, int idade, String raca) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.raca = raca;
        this.status = StatusAnimal.DISPONIVEL;
    }

    public abstract void emitirSom();

    public int getId() {return id; }
    public String getNome() {return nome; }
    public int getIdade() {return idade; }
    public String getRaca() {return raca; }
    public StatusAnimal getStatus() {return status; }

    public void setNome(String n) {this.nome = n; }
    public void setIdade(int i) {this.idade = i; }
    public void setRaca(String r) {this.raca = r; }
    public void setStatus(StatusAnimal s) {this.status = s; }

    @Override
        public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Idade: " + idade + ", Raça: " + raca + ", Status: " + status;
    }
}
