package modelo;

import static bancodedados.Fakebancodedados.selectAllUsuarios;
import java.util.Date;
import java.util.Vector;
import modelo.Usuario;
import modelo.Livro;
/*import bancodedados.Fakebancodedados;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Vector;
import java.util.Calendar;
*/

public class Emprestimo {
    
    private Date datainicial;
    private Date datafinal;
    private int status;
    private Livro livro;
    private Usuario usuario;
    
    //construtor
    public Emprestimo(Livro livro, Usuario usuario, Date datainicial, Date datafinal, int status) {
        this.livro = livro;
        this.usuario = usuario;
        this.datainicial = datainicial;
        this.datafinal = datafinal;
        this.status = status;
    }

    //getters e setters
    public Date getDatainicial() {
        return datainicial;
    }

    public Date getDatafinal() {
        return datafinal;
    }

    public int getStatus() {
        return status;
    }

    public void setDatafinal(Date datafinal) {
        this.datafinal = datafinal;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    /*
    //inicia-se um empréstimo
    private  void realizaemprestimo(){
        Scanner cod = new Scanner(System.in);
        
        System.out.println("Iniciando novo empréstimo ");
        
       // Emprestimo novoemprestimo = new Emprestimo(null);
       
      String cpf;
      String codigo;
      
      Vector<Livro>cestadelivros=new Vector<>();
      
      //Iniciando novo empréstimo 
      do{
        System.out.println("Informe seu CPF: ");
         cpf = cod.nextLine();
         
         //cancelando o empréstimo
          if (cpf.equalsIgnoreCase("cancelar")) {
                break;
            }

        Usuario selecionausuario = Fakebancodedados.retornaCpf(cpf);
        
        //Esse usuário existe 
        if(selecionausuario != null){
            System.out.println("Nome: " +selecionausuario.getNome());
            
         //Pegando no máximo 3 livros  
         for(int u = 0; u<3;u++){
          System.out.println("Informe o código do livro: ");
          codigo=cod.nextLine();
          
            if(codigo.equalsIgnoreCase("finalizar")){
              break;
             }
            
          Livro selecionalivro = Fakebancodedados.retornaCodigo(codigo);
        
            //se o livro existe 
            if(selecionalivro != null){
                System.out.println("Nome: " + selecionalivro.getNome());
                
                //Vendo se o livro ta disponível
                if(selecionalivro.getStatus().equalsIgnoreCase("Disponível")){
                    System.out.println("Livro disponível");
                    cestadelivros.add(selecionalivro);
                }else{
                    System.out.println("O livro não está disponível");
                    break;
                }
            }
        }
         
         System.out.println("CESTA DE LIVROS: ");
         //mostrando os livros e tornando o livro indisponível
         for(int p = 0; p<3;p++){
             System.out.println(cestadelivros.get(p));
             cestadelivros.get(p).setStatus("Indisponível");
         }
         
         Emprestimo novo = new Emprestimo(livro, usuario, datainicial, datafinal, status);
         
         for(int l = 0; l<3;l++){
            this.livro = cestadelivros.get(l);
         }
         
         this.usuario = selecionausuario;
         
         Date agora = new Date();
         Calendar calendario = Calendar.getInstance();
         calendario.setTime(agora);
         this.datainicial = agora;
        // this.datainicial = calendario.getTime();
         calendario.add(Calendar.DAY_OF_MONTH, 7);
         this.datafinal = calendario.getTime();
         
         this.status = "Emprestado";
     
            System.out.println("Empréstimo realizado com sucesso!");
         
        }else{ 
            System.out.println("Esse usuário não existe ");
        }
    } while (!cpf.equalsIgnoreCase("cancelar")); 
}
    
    //devolvendo o livro
    private void devolucao(){
        
        Scanner ler = new Scanner(System.in);
        
        String codL;
        
        do{
            System.out.println("Devolução---------------");
            System.out.println("Informe o código do livro: ");
            codL = ler.nextLine();
            
            Livro selecionaL = Fakebancodedados.retornaCodigo(codL);
            
            if(selecionaL != null){
                System.out.println("Nome: " + selecionaL.getNome());
                
                selecionaL.setStatus("Dispoível");
                this.livro = null;
                this.usuario = null;
                this.datainicial = null;
                this.datafinal = null;
                this.status = null;
                
                System.out.println("Livro devolvido com sucesso!");
                
            }else{
                System.out.println("Este código não é válido.");
            }
        
        } while (!codL.equalsIgnoreCase("cancelar")); 
    }*/
}


           