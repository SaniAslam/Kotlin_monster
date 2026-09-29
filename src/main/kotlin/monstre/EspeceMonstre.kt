package org.example.monstre

import java.io.File
/**

Représente un monstre avec ses caractéristiques, ses statistiques de base et ses différents modificateurs.
@property id Identifiant unique du monstre.
@property nom Nom du monstre.
@property type Type du monstre.
@property baseAttaque Statistique d'attaque de base.
@property baseDefense Statistique de défense de base.
@property baseVitesse Statistique de vitesse de base.
@property baseAttaqueSpe Statistique d'attaque spéciale de base.
@property baseDefenseSpe Statistique de défense spéciale de base.
@property basePv Nombre de points de vie de base.
@property modAttaque Modificateur appliqué à l'attaque.
@property modDefense Modificateur appliqué à la défense.
@property modVitesse Modificateur appliqué à la vitesse.
@property modAttaqueSpe Modificateur appliqué à l'attaque spéciale.
@property modDefenseSpe Modificateur appliqué à la défense spéciale.
@property modPv Modificateur appliqué aux points de vie.
@property description Description du monstre.
@property particularites Particularités du monstre.
@property caractères Caractéristiques ou traits particuliers du monstre.
 */
class EspeceMonstre (
    var id : Int,
    var nom: String,
    var type: String,
    val baseAttaque: Int,
    val baseDefense: Int,
    val baseVitesse: Int,
    val baseAttaqueSpe: Int,
    val baseDefenseSpe: Int,
    val basePv: Int,
    val modAttaque: Double,
    val modDefense: Double,
    val modVitesse: Double,
    val modAttaqueSpe: Double,
    val modDefenseSpe: Double,
    val modPv: Double,
    val description: String = "",
    val particularites: String = "",
    val caractères: String = "",){




    //Et la classe doit avoir une méthode  afficheArt() :
    /**
     * Affiche la représentation artistique ASCII du monstre.
     *
     * @param deFace Détermine si l'art affiché est de face (true) ou de dos (false).
     *               La valeur par défaut est true.
     * @return Une chaîne de caractères contenant l'art ASCII du monstre avec les codes couleur ANSI.
     *         L'art est lu à partir d'un fichier texte dans le dossier resources/art.
     */
    fun afficheArt(deFace: Boolean=true): String{
        val nomFichier = if(deFace) "front" else "back";
        val art=  File("src/main/resources/art/${this.nom.lowercase()}/$nomFichier.txt").readText()
        val safeArt = art.replace("/", "∕")
        return safeArt.replace("\\u001B", "\u001B")
    }

}

