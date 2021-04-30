
package application;

public abstract class Personagem implements Movel {
    
    protected String cor;
    protected String simbolo;
    
    protected int posicaox;
    protected int posicaoy;
    
    @Override
    public void moverPraCima() {
        posicaox--;
    }

    @Override
    public void moverPraBaixo() {
        posicaox++;
    }

    @Override
    public void moverPraDireita() {
        posicaoy++;
    }

    @Override
    public void moverPraEsquerda() {
        posicaoy--;
    }
    
}
