package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class QuestionAChoixMultipleTest {

    private QuestionAChoixMultiple uneQuestion;

    @Before
    public void setUp() throws Exception {

        List<Integer> listeChoix = new ArrayList<Integer>();
        listeChoix.add(1);
        listeChoix.add(2);

        // given : un objet de type QuestionAChoixMultiple
        this.uneQuestion = new QuestionAChoixMultiple("un énoncé", listeChoix);

    }

    @Test
    public void testGetEnonce() {
        // when : on demande l'énoncé à la question
        String resEnonce = this.uneQuestion.getEnonce();

        // then : l'énoncé est non null
        assertNotNull(resEnonce);
    }

    @Test
    public void testGetScoreForIndice() {
        // when : un étudiant fourni l'indice correspondant la bonne réponse
        int indiceEtudiant = 2;
        // and : on demande le calcule du score
        Float resScore = this.uneQuestion.getScoreForIndice(indiceEtudiant);
        // then : le score obtenu est de 100
        assertEquals(new Float(100f), resScore);
        // when : un étudiant fourni l'indice correspondant à une mauvaise réponse
        indiceEtudiant = 3;
        // and : on demande le calcule du score
        resScore = this.uneQuestion.getScoreForIndice(indiceEtudiant);
        // then : le score obtenu est de 100
        assertEquals(new Float(0f), resScore);
    }

}