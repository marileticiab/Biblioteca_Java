package bancodedados;

import static bibliotecaprojeto.Bibliotecaprojeto.novoE;
import java.util.Vector;
import modelo.Emprestimo;
import modelo.Livro;
import modelo.Usuario;

public class Fakebancodedados {
    
    //vetores para armazenar usuários e livros
    private static Vector<Livro> estoquelivros = new Vector<>();
    private static Vector<Usuario> usuarios = new Vector<>();
    
    public static Vector <Livro> selectAllLivros(){
  
        //criando novos livros
        estoquelivros.add(new Livro("A política sexual da carne", "Uma teoria "
                + "feminista - vegetariana" , "Alaúde", "Carol J Adams" , 2018, 
                  "000001", "Disponível"));
        
        
        estoquelivros.add(new Livro("Cidades de papel" , "Quentin Jacobsen tem "
                + "uma paixão platônica pela magnífica vizinha e colega de escola Margo Roth Spiegelman."
                + " Até que em um cinco de maio que poderia ter sido outro dia qualquer, ela invade sua"
                + " vida pela janela de seu quarto, com a cara pintada e vestida de ninja, convocando-o a "
                + "fazer parte de um engenhoso plano de vingança. E ele, é claro, aceita.", "Intrínseca",
                "Jonh Green", 2013, "000002", "Disponível"));
        
        
        estoquelivros.add(new Livro("Segundo sexo", "\"Pois, de O segundo sexo a A cerimônia do adeus,"
                + " o empenho principal de Beauvoir foi o de construir uma nova identidade, sobretudo"
                + " feminina, mas comum a todos na exigência da liberdade.","Nova fronteira", "Simone de Beauvoir ", 
                2014, "000003", "Disponível"));
        
        
        estoquelivros.add(new Livro("As extraordinarias cores do amanhã","Leigh Chen Sanders é uma garota meio asiática,"
                + " meio americana, e precisa lidar com um fato: no mesmo dia em que beijou Axel, seu melhor amigo "
                + "(e paixão secreta há anos), sua mãe se suicidou. Além disso, Leigh tem plena certeza de que a mãe "
                + "virou um pássaro.", "Universo dos livros", "Emily X. R. Pan", 2019, "000004", "Disponível"));
        
        estoquelivros.add(new Livro("Me chame pelo seu nome", "Intrinseca", "Andre Aciman" , "000005" ,"Disponível"));
        
        estoquelivros.add(new Livro("Por que lutamos?","Um livro sobre feminismo. Através do olhar amoroso,"
                + " da acolhida generosa, do entendimento de que este é um assunto de todas, todos, todxs nós.", "Planeta", 
                "Maniela D'ávila", 2019, "000005", "Disponível"));
        
        estoquelivros.add(new Livro("A garota do lago", "Summit Lake, uma pequena cidade entre montanhas, é esse tipo de lugar, "
                + "bucólico e com encantadoras casas dispostas à beira"
                + " de um longo trecho de água intocada", "Faro editorial", "Charlie Donlea",2017,"000006", "Disponível"));
        
        return estoquelivros;
    }
    
    public static Vector<Usuario> selectAllUsuarios(){
      
        //criando novos usuários
        usuarios.add(new Usuario("Maria Letícia", "123.456.789 - 02", "3399131-5222", "Rua abc, Lafeiete"));
        usuarios.add(new Usuario("Anassol Seixas" , "147.258.369-05", "339991-36037", "Rua domingos, Ouro Branco"));
        usuarios.add(new Usuario("Luana Aparecida", "147.586.546-09", "319144-46545", "Rua Edgard, Minas Novas"));
        usuarios.add(new Usuario("Heitor Avelar", "758.459.475-04", "119946-14526", "Rua Delfim, Lafaiete"));
          return usuarios;     
    }
    
    
    //adiciona livro no estoque
    public static void insertBancodedados (Livro novoLivro){
        estoquelivros.add(novoLivro);
    }
    
    //adiciona pessoa
    public static void inserUsuario (Usuario novoUsuario){
        usuarios.add(novoUsuario);
    }
    
    //vê se usuário existe
    public static Usuario retornaCpf (String cpf){
        
        Vector <Usuario> usuarioregistrado = selectAllUsuarios();
        
        for(int u = 0; u<usuarioregistrado.size();u++){
            if(usuarioregistrado.get(u).getCpf().equals(cpf)){
                return usuarioregistrado.get(u);
            }
        }
        return null;
    }
    
    //vê se livro existe
    public static Livro retornaCodigo (String codigo){
        
        Vector <Livro> livroregistrado = selectAllLivros();
        
        for(int l = 0; l<livroregistrado.size();l++){
            if(livroregistrado.get(l).getCodigo().equals(codigo)){
                return livroregistrado.get(l);
            }
        }return null;
    }
    
    public static Vector<Emprestimo> selectAllEmprestimos(){
        return novoE;
    }
    
    public static Emprestimo retornaStatus (int num){
        
        Vector <Emprestimo> livroemprestado = selectAllEmprestimos();
        
        for(int u = 0; u<livroemprestado.size();u++){
            if(livroemprestado.get(u).getLivro().equals(num)){
                return livroemprestado.get(u);
            }
        }
        return null;
    }
}
        
 


 