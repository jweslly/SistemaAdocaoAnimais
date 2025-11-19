package sistemaadocao;

public class Gato extends Animal implements CuidadosEspeciais {

    public Gato(int id, String nome, int idade, String raca) {
        super(id, nome, idade, raca);
    }

    @Override
    public void emitirSom() {
        System.out.println("Miau!");
    }

    @Override
    public void vacinar() {
        System.out.println("Gato " + getNome() + " vacinado.");
    }

    @Override
    public void vermifugar() {
        System.out.println("Gato " + getNome() + " vermifugado.");
    }
}
