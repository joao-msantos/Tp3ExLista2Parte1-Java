import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n Bem-vindo a lista 2 (parte 1) do TP3. Os exercícios estão colocados em sequência. \n Digite qualquer tecla para continuar ...");
        scanner.next();

        System.out.println("Crie uma classe Chamada CartãoWEB. Essa classe representará todos os cartões web e deverá ter apenas dois atributos: email(String) e nome(String).");
        System.out.println("Crie um construtor recebendo essas Strings e valide se o email é válido. Caso contrário inicialize a string com 'email invalido'.\n");

        String[] nomes = new String[5];
        String[] emails = new String[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("\nCaso haja problema, aperte ENTER duas vezes após digitar o nome/email.\n");
            System.out.println("Nome " + (i + 1) + ": ");
            scanner.nextLine();
            nomes[i] = scanner.nextLine();

            System.out.println("Email " + (i + 1) + ": ");
            scanner.nextLine();
            emails[i] = scanner.nextLine();
        }

        Aniversario aniversario = new Aniversario(nomes[0], emails[0]);
        Pascoa pascoa = new Pascoa(nomes[1], emails[1]);
        Pascoa pascoa2 = new Pascoa(nomes[2], emails[2]);
        Natal natal = new Natal(nomes[3], emails[3]);
        DiaDosNamorados diaDosNamorados = new DiaDosNamorados(nomes[4], emails[4]);

        List<IShowMessage> iList = new LinkedList<>();

        iList.add(aniversario);
        iList.add(pascoa);

        iList.add(natal);
        iList.add(diaDosNamorados);
        iList.add(pascoa2);

        iList.forEach(cartao -> System.out.println(cartao.showMessage()));

    }
    public static class CartaoWEB
    {
        public String email;
        public String nome;

        public CartaoWEB(String nome, String email)
        {
            this.nome = nome;
            boolean a = false;

            for(int i = 0; i < email.length(); i++)
            {
                char caracter = email.charAt(i);
                if(caracter == '@'){
                    a = true;
                }
            }
            if(a == false){
                this.email = "email inválido";
            } else{
                this.email = email;
            }
        }
    }

    public interface IShowMessage
    {
        String showMessage();
    }
    public static class Aniversario extends CartaoWEB implements IShowMessage {

        public Aniversario(String nome, String email){
           super(nome,email);
        }

        @Override
        public String showMessage(){
            return String.format("mensagem para: %s \n Parabéns, %s pelo seu Aniversário. \n======================================", nome, email);
        }
    }

    public static class Pascoa extends CartaoWEB implements IShowMessage {

        public Pascoa(String nome, String email){
            super(nome,email);
        }

        @Override
        public String showMessage(){
            return String.format("mensagem para: %s \n Parabéns, %s pela Pascoa. \n======================================", nome, email);
        }
    }

    public static class Natal extends CartaoWEB implements IShowMessage {

        public Natal(String nome, String email){
            super(nome,email);
        }

        @Override
        public String showMessage(){
            return String.format("mensagem para: %s \n Parabéns, %s pelo Natal. \n======================================", nome, email);
        }
    }

    public static class DiaDosNamorados extends CartaoWEB implements IShowMessage {

        public DiaDosNamorados(String nome, String email){
            super(nome,email);
        }

        @Override
        public String showMessage(){
            return String.format("mensagem para: %s \n Parabéns, %s pelo dia dos namorados. \n======================================", nome, email);
        }
    }
}

