package enumeracaoExercicio.entities;

import java.time.LocalDate;

public class Cliente {
    private String nome;
    private String email;
    private LocalDate nascimento;

    public Cliente() {
    }

    public Cliente(String nome, String email, LocalDate nascimento) {
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
    }

    @Override
    public String toString() {
        return "Cliente: " + nome + " (" + nascimento + ") - " + email;
    }
    
    public String getName() {
        return nome;
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return nascimento;
    }

    public void setBirthDate(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
}
