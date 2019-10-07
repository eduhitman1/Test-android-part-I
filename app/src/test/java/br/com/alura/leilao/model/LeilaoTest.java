package br.com.alura.leilao.model;

import android.icu.text.LocaleDisplayNames;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LeilaoTest {

    public static final double DELTA = 0.0001;
    private final Leilao CONSOLE = new Leilao("Console");
private final Usuario ALEX = new Usuario("Alex");
//private Usuario fran;


    @Test
    public void getDescricao_QuandoRecebeDescricao_DevolveDescricao() {

//executar acão esperada
        String descricaoDevolvida = CONSOLE.getDescricao();

        //testar resultado esperado
        assertEquals( "Console", descricaoDevolvida);
    }



    @Test
    public void deve_DevolveMaiorLance_QuandoRecebeApenasUmLance(){

        CONSOLE.propoe(new Lance (ALEX,200.0));

         double maiorLanceDevolvido= CONSOLE.getMaiorLance();

        assertEquals(200.0, maiorLanceDevolvido, DELTA);
 }


    @Test
    public void deve_DevolveMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente(){
// verifica se devolve maior lance com de um lance em ordem crescente
        CONSOLE.propoe(new Lance(ALEX,100.0));
        CONSOLE.propoe(new Lance(new Usuario("Fran"),200.0));


        double maiorLanceDeolvido= CONSOLE.getMaiorLance();
        assertEquals(200.0, maiorLanceDeolvido, DELTA);
    }

    @Test
    public void deve_DevolveMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemDescrescente(){
        // verifica se devolve maior lance com mais de uma lance em ordem descrecente
        CONSOLE.propoe(new Lance(ALEX,10000.0));
        CONSOLE.propoe(new Lance(new Usuario("Fran"),9000.0));

        double maiorLance= CONSOLE.getMaiorLance();
        assertEquals(10000.0, maiorLance, DELTA);
    }


    @Test
    public void deve_DevolveMenorLance_QuandoRecebeApenasUmLance(){
        // verifica se devolve maior lance com apenas um lance
        CONSOLE.propoe(new Lance (ALEX,200.0));

        double menorLanceDevolvido = CONSOLE.getMenorLance();

        assertEquals(200.0, menorLanceDevolvido, DELTA);
    }

    @Test
    public void deve_DevolveMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente(){
// verifica se devolve maior lance com de um lance em ordem crescente
        CONSOLE.propoe(new Lance(ALEX,100.0));
        CONSOLE.propoe(new Lance(new Usuario("Fran"),200.0));
        double menorLanceDeolvido= CONSOLE.getMenorLance();
        assertEquals(100.0, menorLanceDeolvido, DELTA);
    }


    @Test
    public void deve_DevolveMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemDescrescente(){
        // verifica se devolve maior lance com mais de uma lance em ordem descrecente

        CONSOLE.propoe(new Lance(ALEX,10000.0));
        CONSOLE.propoe(new Lance(new Usuario("Fran"),9000.0));

        double menorLanceDeolvido = CONSOLE.getMenorLance();
        assertEquals(9000.0, menorLanceDeolvido, DELTA);
    }

     @Test
    public void deve_DevolverTresMaioresLances_QuandoRecebeExatosTresLances(){
        CONSOLE.propoe(new Lance(ALEX,200.0));
         CONSOLE.propoe(new Lance(new Usuario("Fran"),300.0));
         CONSOLE.propoe(new Lance(ALEX,400.0));

    List<Lance> tresMaioresLancesDevolvidos = CONSOLE.tresMaioresLances();

    assertEquals(3,tresMaioresLancesDevolvidos.size());
    assertEquals(400.0, tresMaioresLancesDevolvidos.get(0).getValor(), DELTA);
    assertEquals(300.0, tresMaioresLancesDevolvidos.get(1).getValor(), DELTA);
    assertEquals(200.0, tresMaioresLancesDevolvidos.get(2).getValor(), DELTA);
}


@Test
    public void deve_DevolverTresMaioresLances_QuandoNaoRecebeLances(){
        List<Lance> tresMaioresLancesDevolvidos = CONSOLE.tresMaioresLances();
        assertEquals(0,tresMaioresLancesDevolvidos.size());
}


@Test
public void deve_DevolverTresMaioresLances_QuandoRecebeApenasUmLance(){
        CONSOLE.propoe(new Lance(ALEX,200.0));
        List<Lance> tresMaioresLancesDevolvidos = CONSOLE.tresMaioresLances();
        assertEquals(1,tresMaioresLancesDevolvidos.size());
        assertEquals(200.0,tresMaioresLancesDevolvidos.get(0).getValor(),DELTA);
}


@Test
    public void deve_DevolverTresMaioresLances_QuandoRecebeApenasDoisLances(){
        CONSOLE.propoe(new Lance(ALEX, 300.0));
        CONSOLE.propoe(new Lance(new Usuario("Fran"),400.0));
        List<Lance> tresMaioresLancesDevolvidos = CONSOLE.tresMaioresLances();
        assertEquals(2,tresMaioresLancesDevolvidos.size());
    assertEquals(400.0,tresMaioresLancesDevolvidos.get(0).getValor(),DELTA);

    assertEquals( 300.0,tresMaioresLancesDevolvidos.get(1).getValor(),DELTA);
}





@Test
    public void deve_DevolverTresMaioresLances_QuandoRecebeMaisDeTresLances(){
        CONSOLE.propoe(new Lance(ALEX, 300.0));
         final Usuario FRAN = new Usuario("Fran");
    CONSOLE.propoe(new Lance(FRAN, 400.0));
    CONSOLE.propoe(new Lance(ALEX, 500.0));
    CONSOLE.propoe(new Lance(FRAN, 600.0));

    final List<Lance> tresMaioresLancesDevolvidosParaQuatroLances = CONSOLE.tresMaioresLances();
    assertEquals(3, tresMaioresLancesDevolvidosParaQuatroLances.size());
    assertEquals(600.0,tresMaioresLancesDevolvidosParaQuatroLances.get(0).getValor(),DELTA);
    assertEquals(500.0,tresMaioresLancesDevolvidosParaQuatroLances.get(1).getValor(),DELTA);
    assertEquals(400.0,tresMaioresLancesDevolvidosParaQuatroLances.get(2).getValor(),DELTA);


    CONSOLE.propoe(new Lance(ALEX,700.0));
    final List<Lance> tresMaioresLancesDevolvidosParaCincoLances = CONSOLE.tresMaioresLances();

    assertEquals(3,tresMaioresLancesDevolvidosParaCincoLances.size());
    assertEquals(700.0,tresMaioresLancesDevolvidosParaCincoLances.get(0).getValor(),DELTA);
    assertEquals(600.0,tresMaioresLancesDevolvidosParaCincoLances.get(1).getValor(),DELTA);
    assertEquals(500.0,tresMaioresLancesDevolvidosParaCincoLances.get(2).getValor(),DELTA);





}


}