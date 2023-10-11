import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        int contaCandidatos = 0;
        int contaVagas = 5;
        int contaListaCandidatos = 0;
        double baseSalarial = 2000.0;
        int tentativasContato = 1;
        String [] listaCandidatos = new String[5];

        double candidatoSalarioPretendido = 0.0;

        String nomeCandidato;
        String[] candidatos = {"DIEGO", "ERICK", "SAMUEL", "PRISCILA", "LUCÍOLA", "JOANA", "JOSÉ", "MARCOS", "ANTÔNIO", "FERNANDO"};
        
        System.out.println("Lista de candidatos aprovados: \n");

        while(contaVagas > 0 && contaCandidatos < candidatos.length){
            candidatoSalarioPretendido = simulaValorPretendido();
            if(candidatoSalarioPretendido <= baseSalarial){
                nomeCandidato = candidatos[contaCandidatos];
                System.out.printf(nomeCandidato + "\n");
                listaCandidatos[contaListaCandidatos] = nomeCandidato;
                contaVagas--;
                contaListaCandidatos++;
            }
            contaCandidatos++;
        }

        System.out.println("\nRelatório de tentativas de contato: \n");

        for(int count = 0; count < contaListaCandidatos; count++){
            tentativasContato = tentativasDeContato();
            if(tentativasContato <= 3){
                System.out.printf("CONSEGUIMOS CONTATO COM " + listaCandidatos[count] + " APOS %d TENTATIVAS. \n", tentativasContato);
            } else {
                System.out.printf("NÃO CONSEGUIMOS CONTATO COM " + listaCandidatos[count] + "\n");
            }
        }
    }

    static int tentativasDeContato(){
        return ThreadLocalRandom.current().nextInt(1, 5);
    }

    static double simulaValorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800.0, 2200.0);
    }
}
