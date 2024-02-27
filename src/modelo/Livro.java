package modelo;


public class Livro {
    private String nome;
    private String sinopse;
    private String editora;
    private String autor;
    private int ano;
    private String codigo;
    private String status; 

    //construtor
    public Livro(String nome, String editora, String autor, String codigo, String status) {
        this.nome = nome;
        this.editora = editora;
        this.autor = autor;
        this.codigo = codigo;
        this.status = status;
    }

    public Livro(String nome, String sinopse, String editora, String autor, int ano, String codigo, String status) {
        this.nome = nome;
        this.sinopse = sinopse;
        this.editora = editora;
        this.autor = autor;
        this.ano = ano;
        this.codigo = codigo;
        this.status = status;
    }

    //getters e setters
    public String getNome() {
        return nome;
    }

    public String getSinopse() {
        return sinopse;
    }

    public String getEditora() {
        return editora;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getStatus() {
        return status;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
            
}
