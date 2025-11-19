package sistemaadocao;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String NOME_ARQUIVO = "dados.dat";

    private List<Animal> animais = new ArrayList<>();
    private List<Adotante> adotantes = new ArrayList<>();
    private List<Adocao> adocoes = new ArrayList<>();

    public static BancoDeDados carregar() {
        File arquivo = new File(NOME_ARQUIVO);

        if (!arquivo.exists()) {
            return new BancoDeDados();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (BancoDeDados) ois.readObject();
        } catch (Exception e) {
            System.out.println("Erro ao carregar arquivo de dados. Criando banco novo.");
            return new BancoDeDados();
        }
    }

    public void salvar() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOME_ARQUIVO))) {
            oos.writeObject(this);
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public List<Adotante> getAdotantes() {
        return adotantes;
    }

    public List<Adocao> getAdocoes() {
        return adocoes;
    }

    public int gerarIdAnimal() {
        int maior = 0;
        for (Animal a : animais) {
            if (a.getId() > maior) {
                maior = a.getId();
            }
        }
        return maior + 1;
    }

    public int gerarIdAdotante() {
        int maior = 0;
        for (Adotante a : adotantes) {
            if (a.getId() > maior) {
                maior = a.getId();
            }
        }
        return maior + 1;
    }

    public int gerarIdAdocao() {
        int maior = 0;
        for (Adocao a : adocoes) {
            if (a.getId() > maior) {
                maior = a.getId();
            }
        }
        return maior + 1;
    }

    public void realizarAdocao(int idAdotante, int idAnimal)
            throws LimiteAdocoesException, AnimalIndisponivelException {

        Adotante adotante = null;
        for (Adotante a : adotantes) {
            if (a.getId() == idAdotante) {
                adotante = a;
                break;
            }
        }

        if (adotante == null) {
            System.out.println("Adotante não encontrado.");
            return;
        }

        Animal animal = null;
        for (Animal an : animais) {
            if (an.getId() == idAnimal) {
                animal = an;
                break;
            }
        }

        if (animal == null) {
            System.out.println("Animal não encontrado.");
            return;
        }

        if (adotante.getQuantidadeAnimaisAdotados() >= 3) {
            throw new LimiteAdocoesException("O adotante já possui 3 animais.");
        }

        if (animal.getStatus() != StatusAnimal.DISPONIVEL) {
            throw new AnimalIndisponivelException("Animal não está disponível para adoção.");
        }

        int idAdocao = gerarIdAdocao();
        Adocao adocao = new Adocao(idAdocao, animal, adotante, LocalDate.now());
        adocoes.add(adocao);

        adotante.incrementarAnimais();
        animal.setStatus(StatusAnimal.ADOTADO);

        salvar();

        System.out.println("Adoção realizada com sucesso!");
    }
}
