import java.util.Scanner;

public class Notes {
    public static void main(String[] args) {
        String[] llistaAssignatures = new String[10];
        float[] llistaNotes = new float[llistaAssignatures.length];
        Scanner sc = new Scanner(System.in);
        int comptadorMps=0;
        int mpsAprovats=0;
        float sumaTotal=0;


        for(int i=0;i<llistaAssignatures.length;i++){
            System.out.print("Introdueix una assignatura (exit per finalitzar): ");
            String entradaTeclat = sc.nextLine();
            if(entradaTeclat.equalsIgnoreCase("exit")){
                break;
            }else{
                llistaAssignatures[i] = entradaTeclat;
                comptadorMps++;
            }
        }

        for(int i=0;i<comptadorMps;i++){
            float notaEntrada;
            do{
                System.out.print("Introdueix la nota de "+llistaAssignatures[i]+" : ");
                notaEntrada = sc.nextFloat();
            }while(notaEntrada<0 || notaEntrada>10);
            llistaNotes[i] = notaEntrada;
            sumaTotal+=llistaNotes[i];
            sc.nextLine();
        }

        if(mpsAprovats!=0) {
            //MPs aprovats
            System.out.println("Mps Aprovats: ");
            for (int i = 0; i < comptadorMps; i++) {
                if (llistaNotes[i] >= 5) {
                    System.out.print(llistaAssignatures[i]);
                    System.out.print(" -> ");
                    System.out.println(llistaNotes[i]);
                    mpsAprovats++;

                }
            }
        }

        if(comptadorMps!=mpsAprovats){
            //MPs suspeses
            System.out.println("Mps que cal recuperar: ");
            for(int i=0;i<comptadorMps;i++){
                if(llistaNotes[i]<5){
                    System.out.print(llistaAssignatures[i]);
                    System.out.print(" -> ");
                    System.out.println(llistaNotes[i]);
                }
            }
        }







        if(comptadorMps==mpsAprovats){
            System.out.println("Tot aprovat");
            float notaFinal = sumaTotal/comptadorMps;
            System.out.println("La teva nota final és: "+notaFinal);
        }else{
            System.out.println("Has palmat algun");
        }

    }
}
