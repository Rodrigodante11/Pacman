 //criei uma matriz tamanho/tamanho para poder ver os personagens movimentando pois 100/100 nao conseguia ver direito
package application;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;



public class PacmanJogo {
    public static void main(String[] args) throws InterruptedException, IOException  {
        //criei uma matriz tamanho/tamanho para poder ver os personagens movimentando pois 100/100 nao conseguia ver direito
        int tamanho=10;
        
        String[][] campo = new String[tamanho][tamanho];
        List<String> pacmanPassou = new ArrayList<>();
        Pacman pacman= new Pacman();
        pacman.cor="Azul";
        pacman.posicaox=tamanho/2;
        pacman.posicaoy=tamanho/2;
        pacman.setVidas(3);
        pacman.simbolo="c  ";
        
        Inimigo inimigo1= new Inimigo();
        inimigo1.cor="Azul";
        inimigo1.posicaox=0;
        inimigo1.posicaoy=0;
        inimigo1.simbolo="x1 ";
        
        Inimigo inimigo2= new Inimigo();
        inimigo2.cor="Branco";
        inimigo2.posicaox=0;
        inimigo2.posicaoy=tamanho-1;
        inimigo2.simbolo="x2 ";
        
        Inimigo inimigo3= new Inimigo();
        inimigo3.cor="Roxo";
        inimigo3.posicaox=tamanho-1;
        inimigo3.posicaoy=0;
        inimigo3.simbolo="x3 ";
        Inimigo inimigo4= new Inimigo();
        inimigo4.cor="Laranja";
        inimigo4.posicaox=tamanho-1;
        inimigo4.posicaoy=tamanho-1;
        inimigo4.simbolo="x4 ";
        
        for (int x = 0; x < tamanho; x++) 
        {
            for (int y = 0; y < tamanho; y++) 
            {            
                campo[x][y]=".  " ;        
            }
        }
        
  
        
        do{
            try{
                campo[inimigo1.posicaox][inimigo1.posicaoy]=inimigo1.simbolo;
                campo[inimigo2.posicaox][inimigo2.posicaoy]=inimigo2.simbolo;
                campo[inimigo3.posicaox][inimigo3.posicaoy]=inimigo3.simbolo;
                campo[inimigo4.posicaox][inimigo4.posicaoy]=inimigo4.simbolo;
                campo[pacman.posicaox][pacman.posicaoy]=pacman.simbolo;
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Inimigo1: "+inimigo1.posicaox+" : "+inimigo1.posicaoy);
                System.out.println("Inimigo2: "+inimigo2.posicaox+" : "+inimigo2.posicaoy);
                System.out.println("Inimigo3: "+inimigo3.posicaox+" : "+inimigo3.posicaoy);
                System.out.println("Inimigo4: "+inimigo4.posicaox+" : "+inimigo4.posicaoy);
                System.out.println("Erro "+e.getMessage());
            }
            
            for (int x = 0; x < tamanho; x++) 
            {
                for (int y = 0; y <tamanho; y++) 
                {
                    System.out.print(campo[x][y]);
                }
                System.out.println();
            }
            System.out.println("\nPontuação: "+pacman.getPontuacao());
            System.out.println("Pacman Vida: "+pacman.getVidas());
            TimeUnit.SECONDS.sleep(1);
            Random rand=new Random();
            int mover=rand.nextInt(4);
            
            switch (mover){
                
                case 0:
                    
                    if(pacman.posicaox>0){
                        campo[pacman.posicaox][pacman.posicaoy]="   ";
                        pacmanPassou.add(Integer.toString(pacman.posicaox)+Integer.toString(pacman.posicaoy));
                        pacman.moverPraCima();
                    }  
                    if(inimigo1.posicaox<tamanho-1)   {
                           
                        String inimigo1Posicao=Integer.toString(inimigo1.posicaox)+Integer.toString(inimigo1.posicaoy);
                        if(pacmanPassou.contains(inimigo1Posicao)){
                            campo[inimigo1.posicaox][inimigo1.posicaoy]="   ";
                        }else{
                            campo[inimigo1.posicaox][inimigo1.posicaoy]=".  ";
                        }
                        inimigo1.moverPraBaixo();                        
                    }
                    if(inimigo2.posicaoy<tamanho-1){
                        String inimigo2Posicao=Integer.toString(inimigo2.posicaox)+Integer.toString(inimigo2.posicaoy);
                        if(pacmanPassou.contains(inimigo2Posicao)){
                            campo[inimigo2.posicaox][inimigo2.posicaoy]="   ";
                        }else{
                            campo[inimigo2.posicaox][inimigo2.posicaoy]=".  ";
                        }
                        inimigo2.moverPraDireita();
                    }
                    if(inimigo3.posicaoy<tamanho-1) {
                        String inimigo3Posicao=Integer.toString(inimigo3.posicaox)+Integer.toString(inimigo3.posicaoy);
                        if(pacmanPassou.contains(inimigo3Posicao)){
                            campo[inimigo3.posicaox][inimigo3.posicaoy]="   ";
                        }else{
                            campo[inimigo3.posicaox][inimigo3.posicaoy]=".  ";
                        }
                        inimigo3.moverPraDireita();
                    }
                    if(inimigo4.posicaoy>0) {
                       // System.out.println("moverPraEsquerda:Posicao do inimo4: "+inimigo4.posicaox+" : " +inimigo4.posicaoy);
                        String inimigo4Posicao=Integer.toString(inimigo4.posicaox)+Integer.toString(inimigo4.posicaoy);
                        if(pacmanPassou.contains(inimigo4Posicao)){
                            campo[inimigo4.posicaox][inimigo4.posicaoy]="   ";
                        }else{
                            campo[inimigo4.posicaox][inimigo4.posicaoy]=".  ";
                        }
                        inimigo4.moverPraEsquerda();
                       // System.out.println("moverPraEsquerda:Posicao do inimo4: "+inimigo4.posicaox+" : " +inimigo4.posicaoy);
                    }
                     
                break;
                
                case 1:
                    if(pacman.posicaox<tamanho-1){
                        campo[pacman.posicaox][pacman.posicaoy]="   ";
                        pacmanPassou.add(Integer.toString(pacman.posicaox)+Integer.toString(pacman.posicaoy));
                        pacman.moverPraBaixo();
                    }
                    if(inimigo1.posicaoy<tamanho-1){
                        String inimigo1Posicao=Integer.toString(inimigo1.posicaox)+Integer.toString(inimigo1.posicaoy);
                        if(pacmanPassou.contains(inimigo1Posicao)){
                            campo[inimigo1.posicaox][inimigo1.posicaoy]="   ";
                        }else{
                            campo[inimigo1.posicaox][inimigo1.posicaoy]=".  ";
                        }
                        inimigo1.moverPraDireita();
                    }
                    if(inimigo2.posicaoy>0) {
                        String inimigo2Posicao=Integer.toString(inimigo2.posicaox)+Integer.toString(inimigo2.posicaoy);
                        if(pacmanPassou.contains(inimigo2Posicao)){
                            campo[inimigo2.posicaox][inimigo2.posicaoy]="   ";
                        }else{
                            campo[inimigo2.posicaox][inimigo2.posicaoy]=".  ";
                        }
                        inimigo2.moverPraEsquerda();
                    }
                    if(inimigo3.posicaox>0)  {
                        String inimigo3Posicao=Integer.toString(inimigo3.posicaox)+Integer.toString(inimigo3.posicaoy);
                        if(pacmanPassou.contains(inimigo3Posicao)){
                            campo[inimigo3.posicaox][inimigo3.posicaoy]="   ";
                        }else{
                            campo[inimigo3.posicaox][inimigo3.posicaoy]=".  ";
                        }
                        inimigo3.moverPraCima();
                    }
                    if(inimigo4.posicaox>0){
                       // System.out.println("moverPraCima:Posicao do inimo4: "+inimigo4.posicaox+" : " +inimigo4.posicaoy);
                        String inimigo4Posicao=Integer.toString(inimigo4.posicaox)+Integer.toString(inimigo4.posicaoy);
                        if(pacmanPassou.contains(inimigo4Posicao)){
                            campo[inimigo4.posicaox][inimigo4.posicaoy]="   ";
                        }else{
                            campo[inimigo4.posicaox][inimigo4.posicaoy]=".  ";
                        }
                        inimigo4.moverPraCima();
                      //  System.out.println("moverPraCima:Posicao do inimo4: "+inimigo4.posicaox+" : " +inimigo4.posicaoy);
                    }
                        
                    
                break;
                
                case 2:
                    
                    if(pacman.posicaoy<tamanho-1){
                        campo[pacman.posicaox][pacman.posicaoy]="   ";
                        pacmanPassou.add(Integer.toString(pacman.posicaox)+Integer.toString(pacman.posicaoy));
                        pacman.moverPraDireita();
                    }
                    if(inimigo1.posicaoy>0) {
                        String inimigo1Posicao=Integer.toString(inimigo1.posicaox)+Integer.toString(inimigo1.posicaoy);
                        if(pacmanPassou.contains(inimigo1Posicao)){
                            campo[inimigo1.posicaox][inimigo1.posicaoy]="   ";
                        }else{
                            campo[inimigo1.posicaox][inimigo1.posicaoy]=".  ";
                        }
                        inimigo1.moverPraEsquerda();
                    }
                    if(inimigo2.posicaox>0) {
                        String inimigo2Posicao=Integer.toString(inimigo2.posicaox)+Integer.toString(inimigo2.posicaoy);
                        if(pacmanPassou.contains(inimigo2Posicao)){
                            campo[inimigo2.posicaox][inimigo2.posicaoy]="   ";
                        }else{
                            campo[inimigo2.posicaox][inimigo2.posicaoy]=".  ";
                        }
                        inimigo2.moverPraCima();
                    }
                    if(inimigo3.posicaoy>0){
                        String inimigo3Posicao=Integer.toString(inimigo3.posicaox)+Integer.toString(inimigo3.posicaoy);
                        if(pacmanPassou.contains(inimigo3Posicao)){
                            campo[inimigo3.posicaox][inimigo3.posicaoy]="   ";
                        }else{
                            campo[inimigo3.posicaox][inimigo3.posicaoy]=".  ";
                        }
                        inimigo3.moverPraEsquerda();
                    }
                    if(inimigo4.posicaoy<tamanho-1 ) {
                        //System.out.println("moverPraDireita:Posicao do inimo4: "+inimigo4.posicaox+" : " +inimigo4.posicaoy);
                        String inimigo4Posicao=Integer.toString(inimigo4.posicaox)+Integer.toString(inimigo4.posicaoy);
                        if(pacmanPassou.contains(inimigo4Posicao)){
                            campo[inimigo4.posicaox][inimigo4.posicaoy]="   ";
                        }else{
                            campo[inimigo4.posicaox][inimigo4.posicaoy]=".  ";
                        }
                        inimigo4.moverPraDireita();
                        //System.out.println("moverPraDireita:Posicao do inimo4: "+inimigo4.posicaox+" : " +inimigo4.posicaoy);
                    }
                    
                break;
                
                case 3:
                    
                    if(pacman.posicaoy>0){
                        campo[pacman.posicaox][pacman.posicaoy]="   ";
                        pacmanPassou.add(Integer.toString(pacman.posicaox)+Integer.toString(pacman.posicaoy));
                        pacman.moverPraEsquerda();
                    }
                    if(inimigo1.posicaox>0) {
                        String inimigo1Posicao=Integer.toString(inimigo1.posicaox)+Integer.toString(inimigo1.posicaoy);
                        if(pacmanPassou.contains(inimigo1Posicao)){
                            campo[inimigo1.posicaox][inimigo1.posicaoy]="   ";
                        }else{
                            campo[inimigo1.posicaox][inimigo1.posicaoy]=".  ";
                        }
                        inimigo1.moverPraCima();
                    }
                    if(inimigo2.posicaox<tamanho-1){
                        String inimigo2Posicao=Integer.toString(inimigo2.posicaox)+Integer.toString(inimigo2.posicaoy);
                        if(pacmanPassou.contains(inimigo2Posicao)){
                            campo[inimigo2.posicaox][inimigo2.posicaoy]="   ";
                        }else{
                            campo[inimigo2.posicaox][inimigo2.posicaoy]=".  ";
                        }
                        inimigo2.moverPraBaixo();
                    }
                    if(inimigo3.posicaox<tamanho-1){
                        String inimigo3Posicao=Integer.toString(inimigo3.posicaox)+Integer.toString(inimigo3.posicaoy);
                        if(pacmanPassou.contains(inimigo3Posicao)){
                            campo[inimigo3.posicaox][inimigo3.posicaoy]="   ";
                        }else{
                            campo[inimigo3.posicaox][inimigo3.posicaoy]=".  ";
                        }
                        inimigo3.moverPraBaixo();
                    }
                    if(inimigo4.posicaox<tamanho-1) {
                        //System.out.println("moverPraBaixo:Posicao do inimo4: "+inimigo4.posicaox+" : " +inimigo4.posicaoy);
                        String inimigo4Posicao=Integer.toString(inimigo4.posicaox)+Integer.toString(inimigo4.posicaoy);
                        if(pacmanPassou.contains(inimigo4Posicao)){
                            campo[inimigo4.posicaox][inimigo4.posicaoy]="   ";
                        }else{
                            campo[inimigo4.posicaox][inimigo4.posicaoy]=".  ";
                        }
                        inimigo4.moverPraBaixo();
                       // System.out.println("moverPraBaixo:Posicao do inimo4: "+inimigo4.posicaox+" : " +inimigo4.posicaoy);
                    }
                    
                break;   
            }
            
            if(".  ".equals(campo[pacman.posicaox][pacman.posicaoy]))
            {
                
                pacman.ganhaPonto();
            }
            
            if(pacman.posicaox==inimigo1.posicaox && pacman.posicaoy==inimigo1.posicaoy ||
               pacman.posicaox==inimigo2.posicaox && pacman.posicaoy==inimigo2.posicaoy ||
               pacman.posicaox==inimigo3.posicaox && pacman.posicaoy==inimigo3.posicaoy ||
               pacman.posicaox==inimigo4.posicaox && pacman.posicaoy==inimigo4.posicaoy )
                     
            {
                pacman.perdeVida();
            } 
         
        }while(pacman.getVidas()>0);
        if(pacman.getVidas()==0 || pacman.getPontuacao()==(tamanho*tamanho-1)){
            System.out.println("Pacman perdeeeu!");
        }else{
            System.out.println("Pacman Venceu!");
        }
                  
    }

}
