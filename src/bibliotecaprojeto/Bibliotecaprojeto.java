package bibliotecaprojeto;

import bancodedados.Fakebancodedados;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import modelo.Emprestimo;
import modelo.Livro;
import modelo.Usuario;

public class Bibliotecaprojeto {

    public static Vector<Emprestimo> novoE = new Vector<>();
    
    public static void cadastrodelivros(){
        Scanner entrada = new Scanner(System.in);
        
        //Pegando as informações do livro para o cadastro
        System.out.println("---------Cadastro de um novo livro---------");
        System.out.println("Informe o nome do livro: ");
        String nome = entrada.nextLine();
        
        System.out.println("Informe a sinopse do livro: ");
        String sinopse = entrada.nextLine();
        
        System.out.println("Informe a editora do livro: ");
        String editora = entrada.nextLine();
        
        System.out.println("Informe o codigo do livro: ");
        String codigo = entrada.nextLine();
        
        System.out.println("Informe o autor(a) do livro: ");
        String autor = entrada.nextLine();
        
        System.out.println("Informe o ano de lançamento do livro: ");
        int ano = entrada.nextInt();
        
       
        
        System.out.println("Informe o status do livro: ");
        String status = entrada.nextLine();
        
        // entrada.skip("\n");
        
        Livro novoLivro = new Livro(nome, sinopse, editora, autor, ano, codigo, status);
        
        Fakebancodedados.insertBancodedados(novoLivro);
        
        }
    
     //Pegando informações para o cadastro de um novo usuario
        public static void cadastrodeUsuario(){
            Scanner scan = new Scanner (System.in);
            // Pegando as informações para o cadastro de um novo usuário
            System.out.println("------------Cadastro de um novo usuário----------------");
            System.out.println("Informe o nome do novo usuário: ");
            String nome = scan.nextLine();
            System.out.println("Informe o cpf do usuário: ");
            String cpf = scan.nextLine();
            System.out.println("Informe o telefone do usuário: ");
            String telefone = scan.nextLine();
            System.out.println("Informe o endereço do usuário: ");
            String endereço = scan.nextLine();
            
            scan.skip("\n");
            
            Usuario novoUsuario = new Usuario(nome, cpf, telefone, endereço);
            
           Fakebancodedados.inserUsuario(novoUsuario);
            
    }
    
    //inicia-se um empréstimo
    private static void realizaemprestimo(){
        Scanner cod = new Scanner(System.in);
        
        System.out.println("Iniciando novo empréstimo ");
        
       // Emprestimo novoemprestimo = new Emprestimo(null);
       
      String cpf;
      String codigo;
      
      Vector<Livro>cestadelivros=new Vector<>();
      
      //Iniciando novo empréstimo 
      do{
        System.out.println("Informe seu CPF: ou 'cancelar'");
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
          System.out.println("Informe o código do livro: ou finalizar");
          codigo=cod.nextLine();
          
            if(codigo.equalsIgnoreCase("Finalizar")){
              break;
             }
            
          Livro selecionalivro = Fakebancodedados.retornaCodigo(codigo);
        
            //se o livro existe 
            if(selecionalivro != null){
                System.out.println("Nome: " + selecionalivro.getNome());
                
                //Vendo se o livro ta disponível
                if(selecionalivro.getStatus().equalsIgnoreCase("Disponível")){
                    System.out.println("Livro disponível");
                    //adicionando na cesta 
                    cestadelivros.add(selecionalivro);
                }else{
                    System.out.println("O livro não está disponível");
                    break;
                }
            }
        }
          SimpleDateFormat formatoData = 
                new SimpleDateFormat("dd/MM/yyyy");
        
         System.out.println("CESTA DE LIVROS: ");
       //  mostrando os livros e tornando o livro indisponível

         for(Livro l: cestadelivros){
             
             System.out.println("Nome: "+l.getNome());
               l.setStatus("Indisponivel");
         }
             
        
         Date agora = new Date();
         Calendar calendario = Calendar.getInstance();
         calendario.setTime(agora);
         calendario.add(Calendar.DAY_OF_MONTH, 7);
        
         
         Random g = new Random();
         int num = g.nextInt(3);
         
         for(int l = 0; l<cestadelivros.size();l++){   
            novoE.add(new Emprestimo(cestadelivros.get(l), 
                    selecionausuario, 
                    agora, 
                    calendario.getTime(), 
                    num));
         }
          System.out.println("Empréstimo realizado com sucesso!");
          System.out.println("Data de devoluçao  " +formatoData.format(calendario.getTime()));
           
            break;
         
        }else{ 
            System.out.println("Esse usuário não existe ");
        }
    } while (!cpf.equalsIgnoreCase("cancelar")); 
}
    
    //devolvendo o livro
    private static void devolucao(){
        
        Scanner ler = new Scanner(System.in);
        
        String codL;
        int x;
        
        do{
            System.out.println("Devolução---------------");
            System.out.println("Informe o código do livro: ");
            codL = ler.nextLine();
            
            Livro selecionaL = Fakebancodedados.retornaCodigo(codL);
            
            if(selecionaL != null){
                System.out.println("Nome: " + selecionaL.getNome());
                
                x = ler.nextInt();
                Emprestimo selecionaEmprestimo = Fakebancodedados.retornaStatus(x);
                
                if(selecionaEmprestimo != null){
                    //verificando cada emprestimo correspondente ao seu "status"
                    for(int u = 0; u<novoE.size();u++){
                        //if(novoE.get(u).getStatus() == x){
                            selecionaL.setStatus("Dispoível");
                            selecionaEmprestimo.setDatafinal(null);
                            selecionaEmprestimo.setLivro(null);
                            selecionaEmprestimo.setUsuario(null);
                       // }
                    }
                    
                    System.out.println("Livro devolvido com sucesso!");
                }else{
                    System.out.println("Este empréstimo não existe");
                }
                
            }else{
                System.out.println("Este código não é válido.");
            }
        
        } while (!codL.equalsIgnoreCase("cancelar")); 
    }
        
    public static void main(String[] args) {
       
        //iniciando bd
        Fakebancodedados.selectAllLivros();
        Fakebancodedados.selectAllUsuarios();
        
        //menu
        Scanner entrada = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Digite:\n 1 - Cadastro de Usuário"
                    + " \n2 - Cadastro de livro"
                    + "\n3 - Empréstimo"
                    + "\n4 - Devolução \n5 - Fim Sistema");

            opcao = entrada.nextInt();

            //opção escolhida
            switch (opcao) {
                case 1:
                    cadastrodeUsuario();
                    break;
                case 2:
                    cadastrodelivros();
                    break;
                case 3:
                    realizaemprestimo();
                    break;
                case 4:
                    devolucao();
                    break;
                case 5:
                    System.out.println("Encerrando o sistema");
                    break;
                //invalido, diferente de 1 a 5
                default:
                    System.out.println("Opção inválida!!!\n\n");
            }

        } while (opcao != 5);

    }
}
        
   