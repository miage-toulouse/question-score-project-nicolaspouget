package miagem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QuestionAChoixExclusifTest {

	private QuestionAChoixExclusif uneQuestion;
	
	@Before
	public void setUp() throws Exception {
		// given : un objet de type QuestionAChoixExclusif
		this.uneQuestion = new QuestionAChoixExclusif("un énoncé", 2);
	}

	@Test
	public void testGetEnonce() {
		// when : on demande l'énoncé à la question
		String resEnonce = this.uneQuestion.getEnonce();
		// then : l'énoncé est non null
		assertNotNull(resEnonce);
		// and : l'énoncé est bien celui fourni à la construction
		assertEquals("un énoncé", resEnonce);
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
