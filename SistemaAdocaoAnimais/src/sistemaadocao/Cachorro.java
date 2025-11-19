package sistemaadocao;

public class Cachorro extends Animal implements CuidadosEspeciais {

    public Cachorro(int id, String nome, int idade, String raca) {
        super(id, nome, idade, raca);
    }

    @Override
    public void emitirSom() {
        System.out.println("Au au!");
    }

    @Override
    public void vacinar() {
        System.out.println("Cachorro " + getNome() + " vacinado.");
    }

    @Override
    public void vermifugar() {
        System.out.println("Cachorro " + getNome() + " vermifugado.");
    }
}
