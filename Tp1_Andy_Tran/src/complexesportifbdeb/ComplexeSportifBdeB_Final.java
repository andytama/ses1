/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexesportifbdeb;

import java.util.Scanner;

/**
 *
 * @author 1982887
 */
public class ComplexeSportifBdeB_Final {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double pHT = 0;
        double mTPS = 0;
        double mTVQ = 0;
        final double TPS = 0.05;
        final double TVQ = 0.09975;
        double prixFinal = 0;
        int nbActivite = 0;
        double rabais = 0;
        int age = 0;
        char type_Groupe = 'k';
        int nbPersonnes = 1;
        double rabaisF = 0;
        int nbPersonne = 0;
        int typeFamille = 0;
        double argent;
        String classePersonne = "rz";
        String forfait = "ab";
        char recommencer = 'o';
        char type_Abonnement;
        char type_Forfait = 'f';
        char type_Personne;
        do 
        {
        System.out.println("******************************************");
        System.out.println("*  Bienvenue au complexe Sportif   BDEB  *");
        System.out.println("*       Categorie des abonements:        *");
        System.out.println("*----------------------------------------*");
        System.out.println("* F Forfait (Nombre d'activit�s illimit�)*");
        System.out.println("* A    Activit�s    (Nombre limit� )     *");
        System.out.println("******************************************");
        System.out.println("*    Choisissez le type d'abonnement:    *");
        type_Abonnement = sc.next().charAt(0);
        switch (type_Abonnement) {
            case 'f':
            case 'F':
                System.out.println("******************************************\n"
                        + "*   Bienvenue au complexe Sportif BDEB   *\n"
                        + "*         Cat�gorie de forfait :         *\n"
                        + "*  --------------------------------------*\n"
                        + "*   A       Annuel     750$              *\n"
                        + "*   M       Mensuel    70$               *\n"
                        + "******************************************\n"
                        + "Choisissez le type de forfait :  ");
                type_Forfait = sc.next().charAt(0);
                if (type_Forfait != 'a' || type_Forfait != 'A' || type_Forfait != 'm' || type_Forfait != 'M');

                System.out.println("Donn�e invalide");
                break;
            case 'a':
            case 'A':
                System.out.println("Entrez le nombre d'activit�s auxquelles vous voulez participer :");
                nbActivite = sc.nextInt();
                break;
            default:
                System.out.println("Donn�e invalide");

        }
        if (type_Forfait == 'a' || type_Forfait == 'A' || type_Forfait == 'm' || type_Forfait == 'M' || (nbActivite >= 0 && nbActivite <= 10)) {
            System.out.println("************************************************\n"
                    + "*      Bienvenue au complexe Sportif BDEB      *\n"
                    + "*            Cat�gorie de personnes :          *\n"
                    + "*  --------------------------------------------*\n"
                    + "*             S ou s     Personne seule        *\n"
                    + "*             G ou g     Groupe                *\n"
                    + "*             F ou f     Famille               *\n"
                    + "************************************************\n"
                    + "Entrez la cat�gorie :  ");
            type_Personne = sc.next().charAt(0);
            switch (type_Personne) {
                case 's':
                case 'S':
                    System.out.println("Entrez votre age");
                    age = sc.nextInt();
                    if (age <= 13 && age >= 0) {
                        rabais = 0.1;
                        classePersonne = "Enfant";
                    } else if (age > 13 && age < 18) {
                        rabais = 0.05;
                        classePersonne = "Adolescent";
                    } else if (age >= 60) {
                        rabais = 0.05;
                        classePersonne = "ain�";
                    } else if (age >= 13 || age < 60) {
                        rabais = 0;
                        classePersonne = "Adulte";
                    } else //a reviser
                    {
                        System.out.println("Classe erron�");
                    }
                    nbPersonne = 1;
                    break;
                case 'g':
                case 'G':
                    System.out.println("*****************************************\n"
                            + "* Type de groupe :                      *\n"
                            + "* -------------------                   *\n"
                            + "* A ou a pour aine                      *\n"
                            + "* E ou e pour enfant                    *\n"
                            + "*****************************************\n"
                            + "- Entrez le type :");
                    type_Groupe = sc.next().charAt(0);
                    switch (type_Groupe) {
                        case 'a':
                        case 'A':
                            rabais = 0.12;
                            classePersonne = "Groupe Aine";
                            break;
                        case 'e':
                        case 'E':
                            rabais = 0.15;
                            classePersonne = "Groupe Enfant";
                            break;
                        default:
                            System.out.println("Donn�e invalide");
                            break;
                    }
                    System.out.println("Entrez le nombre de personne qu'il y a dans votre groupe :");
                    nbPersonne = sc.nextInt();
                    if (nbPersonne < 0) {
                        System.out.println("Entrer un nombre positif");
                    }
                    break;

                case 'f':
                case 'F':
                    System.out.println("*********************************************\n"
                            + "* Type de famille :                         *\n"
                            + "* -------------------                       *\n"
                            + "* 1. Deux adultes et deux enfants           *\n"
                            + "* 2. Deux adultes et trois enfants          *\n"
                            + "* 3. Deux adultes et quatre enfants et plus *\n"
                            + "*********************************************\n"
                            + "-Entrez votre choix : 1, 2, 3");
                    typeFamille = sc.nextInt();
                default:
                    System.out.println("Choix de cat�gorie erron�e");
                    switch (typeFamille) {
                        case 1:
                            rabais = 0.1;
                            nbPersonne = 4;
                            classePersonne = "Famille 1";
                            break;
                        case 2:
                            rabais = 0.15;
                            nbPersonnes = 5;
                            classePersonne = "Famille 2";
                            break;
                        case 3:
                            rabais = 0.2;
                            System.out.println("Entrez le nombre de personnes dans votre famille");
                            nbPersonne = sc.nextInt();
                            classePersonne = "Famille 3";
                            if (nbPersonne < 0);
                            System.out.println("Nombre de personnes erron�");
                            break;
                        default:
                            System.out.println("Choix de famille erron�");
                            break;
                    }
            }
            if (type_Forfait == 'a' || type_Forfait == 'A') {
                rabaisF = 750 * nbPersonne * rabais;
                pHT = (750 * nbPersonne) - rabaisF;
                mTPS = pHT * TPS;
                mTVQ = pHT * TVQ;
                prixFinal = pHT + mTPS + mTVQ;
                forfait = "Forfait Annuel";
            } else if (type_Forfait == 'm' || type_Forfait == 'M') {
                rabaisF = 70 * nbPersonne * rabais;
                pHT = (70 * nbPersonne) - rabaisF;
                mTPS = pHT * TPS;
                mTVQ = pHT * TVQ;
                prixFinal = pHT + mTPS + mTVQ;
                forfait = "Forfait Mensuel";
            } else if (nbActivite >= 0 && nbActivite <= 30) {
                rabaisF = 20 * nbActivite * nbPersonne * rabais;
                pHT = (20 * nbActivite * nbPersonne) - rabaisF;
                mTPS = pHT * TPS;
                mTVQ = pHT * TVQ;
                prixFinal = pHT + mTPS + mTVQ;
            } else {
                System.out.println("Donn�e �ronn�e");
            }

            switch (type_Forfait) {
                case 'a':
                case 'A':
                    System.out.println("Facture: \n"
                            + "Categorie: " + forfait + "\n"
                            + "Tarif: " + classePersonne + "\n"
                            + "Nombre de personnes: " + nbPersonne + "\n"
                            + "\n"
                            + "Prix Initial: " + 750 * nbPersonne + "$");
                    System.out.println("Rabais: " + rabaisF + "$");
                    System.out.println("\n"
                            + "Prix a payer: " + pHT + "$");
                    System.out.println("TPS: " + mTPS + "$");
                    System.out.println("TPS: " + mTVQ + "$");
                    System.out.println("---------\n"
                            + "Prix avec taxes: " + prixFinal + "$");
                    break;
                case 'm':
                case 'M':
                    System.out.println("Facture: \n"
                            + "Categorie: " + forfait + "\n"
                            + "Tarif: " + classePersonne + "\n"
                            + "Nombre de personnes: " + nbPersonne + "\n"
                            + "\n"
                            + "Prix Initial: " + 70 * nbPersonne + "$");
                    System.out.println("Rabais: " + rabaisF + "$");
                    System.out.println("\n"
                            + "Prix a payer: " + pHT + "$");
                    System.out.println("TPS: " + mTPS + "$");
                    System.out.println("TPS: " + mTVQ + "$");
                    System.out.println("---------\n"
                            + "Prix avec taxes: " + prixFinal + "$");
                    break;
                default:

            }
            if (type_Abonnement == 'a') {
                System.out.println("Facture: \n"
                        + "Categorie: Activit�s\n"
                        + "Nombre de cours: " + nbActivite + "\n"
                        + "Tarif: " + classePersonne + "\n"
                        + "Nombre de personnes: " + nbPersonne + "\n"
                        + "\n"
                        + "Prix Initial: " + 20 * nbPersonne * nbActivite + "$");
                System.out.println("Rabais: " + rabaisF + "$");
                System.out.println("\n"
                        + "Prix a payer: " + pHT + "$");
                System.out.println("TPS: " + mTPS + "$");
                System.out.println("TPS: " + mTVQ + "$");
                System.out.println("---------\n"
                        + "Prix avec taxes: " + prixFinal + "$");
            } else {
            }
        } else {
            System.out.println("Donn�e invalide");
        }
        System.out.println("Veuillez entrer le montant a payer");
        argent = sc.nextDouble();
        if (argent == prixFinal) {
            System.out.println("Merci !");
        } else if (argent > prixFinal) {
            System.out.println("Voici votre monnaie: " + (argent - prixFinal));
        } else {
            System.out.println("D�sol� le montant est insuffisant");
        } System.out.println("Voulez vous recommencer ? O ou N");       
         recommencer =  sc.next().charAt(0);
        } while (recommencer == 'O');
    }

}
