package sistemaadocao;

import java.io.Serializable;
import java.time.LocalDate;

public class Adocao implements Serializable {

    private int id;
    private Animal animal;
    private Adotante adotante;
    private LocalDate dataAdocao;

    public Adocao(int id, Animal animal, Adotante adotante, LocalDate dataAdocao) {
        this.id = id;
        this.animal = animal;
        this.adotante = adotante;
        this.dataAdocao = dataAdocao;
    }
    public int getId() {
        return id;
    }

    public Animal getAnimal() {
        return animal;
    }

    public Adotante getAdotante() {
        return adotante;
    }

    public LocalDate getDataAdocao() {
        return dataAdocao;
    }

    @Override
    public String toString() {
        return "Adoção ID: " + id + " | Adotante: " + adotante.getNome() +
                " | Animal: " + animal.getNome() + " | Data: " + dataAdocao;
    }
}

