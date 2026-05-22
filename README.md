# 🐾 Sistema de Adoção de Animais  
### Trabalho Acadêmico – Programação Orientada a Objetos (Java)

Este projeto foi desenvolvido como **trabalho de faculdade**, no **2º período**, para a disciplina de **Programação Orientada a Objetos (POO)** utilizando **Java puro**.  

O objetivo principal foi **aprofundar meus conhecimentos em POO**, aplicando conceitos como abstração, herança, polimorfismo, interfaces, encapsulamento e tratamento de exceções, além de implementar **persistência de dados** usando serialização.

---

## 🎯 Objetivo do Sistema

O sistema simula o funcionamento de uma ONG responsável por adoções de animais.  
Ele permite:

- 🐶 **Cadastrar animais** (Cachorro / Gato)  
- 👤 **Cadastrar adotantes**  
- 📄 **Registrar adoções**  
- 📋 **Listar animais, adotantes e adoções**  
- ⚠️ **Validar regras de adoção**:
  - Animal deve estar DISPONÍVEL  
  - Cada adotante pode ter **no máximo 3 animais adotados**

Tudo funciona através de um **menu de console (CLI)** simples e direto.

---

## 🧠 Conceitos de POO Utilizados

Durante o desenvolvimento, aprofundei os seguintes tópicos:

### ✔ Abstração  
Classe abstrata `Animal`, representando o conceito genérico de um animal.

### ✔ Herança  
`Cachorro` e `Gato` herdam de `Animal`.

### ✔ Polimorfismo (sobrescrita)  
Cada tipo de animal implementa seu próprio `emitirSom()`.

### ✔ Interface  
A interface `CuidadosEspeciais` define métodos obrigatórios:
- `vacinar()`
- `vermifugar()`

### ✔ Encapsulamento  
Uso de atributos privados com getters e setters.

### ✔ Sobrecarga  
A classe `Adotante` possui mais de um construtor.

### ✔ Enum  
`StatusAnimal` define os estados `DISPONIVEL` e `ADOTADO`.

### ✔ Exceptions personalizadas  
- `LimiteAdocoesException`  
- `AnimalIndisponivelException`

Essas exceptions reforçam o controle de regras de negócio.

---

## 💾 Persistência de Dados

Os dados são salvos em um arquivo chamado:

dados.dat

Utilizando **serialização** com:
- '89135799'
- '98145478'
- '96940786'

Assim, animais, adotantes e adoções permanecem salvos mesmo após fechar o programa.

---

## 📁 Estrutura do Projeto

src/
└── sistemaadocao/
├── Animal.java
├── Cachorro.java
├── Gato.java
├── Adotante.java
├── Adocao.java
├── StatusAnimal.java
├── CuidadosEspeciais.java
├── LimiteAdocoesException.java
├── AnimalIndisponivelException.java
├── BancoDeDados.java
└── Main.java

---

## ▶️ Como Executar

### ✔ Usando o IntelliJ IDEA

1. Abra o IntelliJ  
2. Vá em **File > Open** e selecione a pasta do projeto  
3. Abra o arquivo `Main.java`  
4. Clique no botão **Run (▶)**  
5. O menu aparecerá no console da IDE  

### ✔ Ou pelo terminal (opcional)

1. Compile:
javac sistemaadocao/*.java
2. Execute:
java sistemaadocao.Main

---

## 🧑‍💻 Sobre o Desenvolvimento

Este projeto foi fundamental para consolidar meu entendimento de:

- Modelagem orientada a objetos  
- Construção de sistemas utilizando classes e regras de negócio  
- Manipulação de listas  
- Persistência de dados simples  
- Tratamento de erros com exceções personalizadas  

A prática reforçou minha base no Java e ampliou minha confiança na implementação de sistemas mais estruturados.

---

## 📌 Autor

Projeto desenvolvido como parte da disciplina de **Programação Orientada a Objetos – Java**, no **2º período da graduação**.





