package modelo;

public class Usuario {
    
    private String nome;
    private String cpf;
    private String telefone;
    private String endereço;

    //construtor
    public Usuario(String nome, String cpf, String telefone, String endereço) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereço = endereço;
    }

    //getters e setters
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }
     
}
