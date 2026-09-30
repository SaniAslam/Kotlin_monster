package org.example.monstre
import org.example.dresseur.Entraineur
import kotlin.math.pow
import kotlin.math.roundToInt

// Représente un individu monstre avec ses caractéristiques,
// son expérience, ses points de vie et son éventuel entraîneur.
class IndividuMonstre(
    val id: Int,
    val nom: String,
    val espece: EspeceMonstre,
    val entraineur: Entraineur? = null,
    expInit: Double
)                       {
    var niveau: Int = 1
    var attaque: Int = this.espece.baseAttaque + (-2..2).random()
    var defense: Int = this.espece.baseDefense + (-2..2).random()
    var vitesse: Int = this.espece.baseVitesse + (-2..2).random()
    var attaqueSpe: Int = this.espece.baseAttaqueSpe + (-2..2).random()
    var defenseSpe: Int = this.espece.baseDefenseSpe + (-2..2).random()
    var pvMax: Int = this.espece.basePv + (-5..5).random()

    var potentiel: Double = 0.5 + Math.random() * 1.5
    var exp: Double = 0.0
        set(nouveauexp) {

            field = nouveauexp

            if (field >= palierExp(niveau + 1)) {
                levelUp()
            }
        }

    var pv: Int = pvMax
        get() = field
        set(nouveauPv) {
            field = nouveauPv.coerceIn(0, pvMax) }

    init {
        this.exp = expInit
    }

    /**
     * Calcule l'expérience totale nécessaire pour atteindre un niveau donné.
     *
     * @param niveau Niveau cible.
     * @return Expérience cumulée nécessaire pour atteindre ce niveau.
     */
    fun palierExp(niveau: Int): Double {
        return 100.0 * (niveau - 1).toDouble().pow(2.0)
    }

    //Augmente le niveau du monstre et ses caractéristiques.

    fun levelUp() {
        niveau++
        attaque += (attaque * potentiel).roundToInt() + (-2..2).random()
        defense += (defense * potentiel).roundToInt() + (-2..2).random()
        vitesse += (vitesse * potentiel).roundToInt() + (-2..2).random()
        attaqueSpe += (attaqueSpe * potentiel).roundToInt() + (-2..2).random()
        defenseSpe += (defenseSpe * potentiel).roundToInt() + (-2..2).random()
        val ancienPvMax = pvMax
        pvMax += (pvMax * potentiel).roundToInt() + (-5..5).random()
        pv += pvMax - ancienPvMax
    }
}
