import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
       // analisarCandidato(1900.0);
       // analisarCandidato(2200.0);
       // analisarCandidato(2000.0);
       //selecaoCandidatos();
       String [] candidatos = {"FELIPE","MARCIA", "JULIA", "PAULO", "AUGUSTO" };
       for(String candidato: candidatos){
            entrandoEmContato(candidato);
       }

    }
    static void entrandoEmContato(String candidato){
            int tentativasRealizadas = 1;
            boolean continuarTentando = true;
            boolean atendeu=false;
            do {
                atendeu= atender();    
                continuarTentando = !atendeu;
                if (continuarTentando) 
                    tentativasRealizadas++;
                else
                    System.out.println("CONTATO REALIZADO COM SUCESSO");
            }while(continuarTentando && tentativasRealizadas<3); 
            
            if (atendeu)
                System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + " TENTATIVA");
            else
                System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + " NUMERO MAXIMO TENTATIVAS " + tentativasRealizadas );

                
            

    }
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }
    static void imprimirSelecionados(){
        String [] candidatos = {"FELIPE","MARCIA", "JULIA", "PAULO", "AUGUSTO" };

        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");

        for(int indice=0; indice < candidatos.length;indice++){
            System.out.println("O candidato de n° " + indice + " é " + candidatos[indice]);
        }
        System.out.println("Forma abreviada de interação for each ");

        for(String candidato: candidatos) {
            System.out.println("O candidato selecionado foi: " + candidatos);
        }
    }
    static void selecaoCandidatos(){
        String [] candidatos = {"FELIPE" , "MARCIA" , "JULIA" , "PAULO"," MONICA " , " MONIQUE " , "FABRICIO ", " ANDERSON ", "MEL" , "ERICK" };

        int candidatoSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while (candidatoSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " Solicitou este valor de salario " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println(" O candidato " + candidato + " foi selecionado para a vaga" );
                candidatoSelecionados++;
            }
            candidatosAtual++;
        }
    }
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2000);
    }
    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if (salarioBase < salarioPretendido){
            System.out.println("Ligar para o candidato");
        }else if (salarioBase == salarioPretendido)
            System.out.println("Ligar para o candidato com contra proposta");
        else {
            System.out.println("Aguardar demais candidatos");
        }
    }
    
}


