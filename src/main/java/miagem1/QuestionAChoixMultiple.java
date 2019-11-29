package miagem1;

import java.util.List;

/**
 * Classe répresentant une question à choix multiple
 */
public class QuestionAChoixMultiple implements QuestionAChoix {

    private String enonce;
    private List<Integer> indicesBonnesReponses;
    private int nombreDePropositions;

    /**
     * Une question à choix multiple est complètement caractérisé par son énoncé et la liste des indices qui forment
     * la bonne réponse
     * @param enonce l'énoncé de la question
     * @param indicesBonnesReponses la liste des indices formant la bonne réponse.
     */
    public QuestionAChoixMultiple(String enonce, List<Integer> indicesBonnesReponses, int n) {
        this.enonce = enonce;
        this.indicesBonnesReponses = indicesBonnesReponses;
        this.nombreDePropositions = n;
    }

    /**
     * Récupère l'énoncé de la question
     * @return l'énoncé de la question
     */
    public String getEnonce() {
        return enonce;
    }

    /**
     * Récupère le nombre de proposition
     * @return le nombre de propositions
     */
    public int getNombreDePropositions(){return this.nombreDePropositions;}

    /**
     * Opération permettant de récupérer le score donné par un choix.
     * @param indiceChoix l'indice du choix
     * @return 100/n si indiceChoix appartient à la liste des indices formant la bonne réponse, 0 sinon
     */
    public float getScoreForIndice(int indiceChoix) {
        if (indicesBonnesReponses.contains(indiceChoix)) {
            return 100f/((float)(indicesBonnesReponses.size()));
        }else{
            return (100f/((float)(this.nombreDePropositions - indicesBonnesReponses.size())))*-1f;
        }

    }
}
