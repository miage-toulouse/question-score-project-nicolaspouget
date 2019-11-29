package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ScoreCalculateurTest {

    private ScoreCalculateur scoreCalculateur;
    private List<Integer> listeChoixEtudiants;
    private QuestionAChoix questionAChoixMultiple;

    @Before
    public void setUp() throws Exception {

        this.listeChoixEtudiants = new ArrayList<Integer>();
        this.questionAChoixMultiple = new QuestionAChoixMultiple("q1",new ArrayList<Integer>(Arrays.asList(2,3,5)), 5);
        this.scoreCalculateur = new ScoreCalculateur();


    }

    @Test
    public void testCalculeScore() {
        // when : quand 2 réponses d'étudiants sont fausses sur les trois résultats possibles
        this.listeChoixEtudiants.add(1);
        this.listeChoixEtudiants.add(4);

        // and : on demande le calcule du score
        Float score = new Float(this.scoreCalculateur.calculeScore(this.listeChoixEtudiants,this.questionAChoixMultiple));

        // then : le score doit être égal à 1
        assertEquals(score, new Float(0f));

        // when : quand 2 réponses des étudiants sont correctes
        this.listeChoixEtudiants.clear();
        this.listeChoixEtudiants.add(2);
        this.listeChoixEtudiants.add(3);

        // and : on demande le calcul du score
        score = new Float(this.scoreCalculateur.calculeScore(this.listeChoixEtudiants,this.questionAChoixMultiple));

        // and : on calcul le score attendu
        Float scoreAttendu = new Float(2f*100f/3f);

        // then : le score doit être égal à 66,67
        assertEquals(score, scoreAttendu);

        // when : quand 3 réponses des étudiants sont correctes
        this.listeChoixEtudiants.clear();
        this.listeChoixEtudiants.add(2);
        this.listeChoixEtudiants.add(3);
        this.listeChoixEtudiants.add(5);

        // and : on demande le calcul du score
        score = new Float(this.scoreCalculateur.calculeScore(this.listeChoixEtudiants,this.questionAChoixMultiple));

        // and : on calcul le score attendu
        scoreAttendu = new Float(100f);

        // then : le score doit être égal à 100
        assertEquals(score, scoreAttendu);

        /**
         * quand on calcule le score pour une liste de réponses contenant les valeurs 1,2,3,4,5 on obtient 0 à 0,01 près comme résultat ;
         * quand on calcule le score pour une liste de réponses contenant les valeurs 1,2 et 3 on obtient 16.66 à 0,01 près comme résultat ;
         */
        // when : quand 3 réponses des étudiants sont correctes et 2 incorrectes
        this.listeChoixEtudiants.clear();
        this.listeChoixEtudiants.add(1);
        this.listeChoixEtudiants.add(2);
        this.listeChoixEtudiants.add(3);
        this.listeChoixEtudiants.add(4);
        this.listeChoixEtudiants.add(5);

        // and : on demande le calcul du score
        score = new Float(this.scoreCalculateur.calculeScore(this.listeChoixEtudiants,this.questionAChoixMultiple));

        // and : on calcul le score attendu
        scoreAttendu = new Float(0f);

        // then : le score doit être égal à 0
        assertEquals(score, scoreAttendu);

        // when : quand 3 réponses des étudiants sont correctes
        this.listeChoixEtudiants.clear();
        this.listeChoixEtudiants.add(1);
        this.listeChoixEtudiants.add(2);
        this.listeChoixEtudiants.add(3);

        // and : on demande le calcul du score
        score = new Float(this.scoreCalculateur.calculeScore(this.listeChoixEtudiants,this.questionAChoixMultiple));

        // and : on calcul le score attendu
        scoreAttendu = new Float(100f/6f);

        // then : le score doit être égal à 0
        assertEquals(score, scoreAttendu, 0.02);

    }
}