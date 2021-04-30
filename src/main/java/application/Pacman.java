package application;

public class Pacman extends Personagem {
    private int pontuacao;
    private int vidas;
    
    public void perdeVida(){
        vidas--;
    }
    
    public void ganhaPonto(){
        pontuacao++;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public int getVidas() {
        return vidas;
    }

    
    
}
