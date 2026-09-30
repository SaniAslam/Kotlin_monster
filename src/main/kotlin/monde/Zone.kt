package org.example.monde

import org.example.monstre.EspeceMonstre


/**
 * Représente une zone du monde dans laquelle le joueur peut rencontrer
 * différentes espèces de monstres.
 *
 * @property id Identifiant unique de la zone.
 * @property nom Nom de la zone.
 * @property expZone Expérience gagnée dans cette zone.
 * @property especesMonstres Liste des espèces de monstres pouvant apparaître dans la zone.
 * @property zoneSuivante Zone accessible après cette zone.
 * @property zonePrecedente Zone accessible avant cette zone.
 */
class Zone(
    var id : Int,
    var nom : String,
    var expZone : Int,
    var especesMonstres : MutableList<EspeceMonstre> = mutableListOf(),
    var zoneSuivante : Zone? = null,
    var zonePrecedente : Zone? = null


    //TODO genereMonstre()
    //TODO rencontreMonstre()

)
