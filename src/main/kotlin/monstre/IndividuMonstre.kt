package org.example.monstre

import org.example.dresseur.Entraineur


    //Représente un individu monstre avec ses caractéristiques, son expérience, ses points de vie et son éventuel entraîneur.

class IndividuMonstre(val id : Int, val nom : String, val espece : EspeceMonstre, val entraineur: Entraineur? = null, expInit : Double
){
    var niveau: Int = 1
    var attaque: Int = this.espece.baseAttaque + (-2..2).random()
    var defense: Int = this.espece.baseDefense + (-2..2).random()
    var vitesse: Int = this.espece.baseVitesse + (-2..2).random()
    var attaqueSpe: Int = this.espece.baseAttaqueSpe + (-2..2).random()
    var defenseSpe: Int = this.espece.baseDefenseSpe + (-2..2).random()
    var pvMax: Int = this.espece.basePv + (-5..5).random()
    var potentiel: Double = 0.5 + Math.random() * 1.5
    var exp: Double = 0.0
        get() = field
        set(value) {
            field = value
        }
    var pv: Int = pvMax //Ne peut pas être inférieur à 0 ni supérieur à pvMax
        get() = field
        set(nouveauPv) {
            field = nouveauPv.coerceIn(0, pvMax)
        }

}
