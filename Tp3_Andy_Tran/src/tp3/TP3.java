// @author Andy Tran (1938297)
package tp3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class TP3 {
public static void main(String[] args) throws IOException {
    int choix;
    do{
    choix = afficherMenu();
    if(choix==1){afficher();}
    if(choix==2){tri();}
    if(choix==3){rechercheID();}
    if(choix==4){modif();}
    if(choix==5){ajouter();}
    }while(choix!=6);
    }
public static String [][] initialiser() throws IOException{
        FileReader monFr = new FileReader("nutrition.csv");
        BufferedReader fL = new BufferedReader(monFr);
        String ligne = fL.readLine();
        int max = 0;
        while (ligne != null) {
            ligne = fL.readLine();
            max++;
        }
        String tab[][] = new String[max-1][10];
        fL.close();
        FileReader monFr2 = new FileReader("nutrition.csv");
        BufferedReader fL2 = new BufferedReader(monFr2);
        int i = 0;
        ligne = fL2.readLine();
        while (ligne != null && i < tab.length) {
            ligne = fL2.readLine();
            tab[i] = ligne.split(";");
            i++;
        }
        fL2.close();
    return tab;
    }

public static void afficher() throws FileNotFoundException, IOException{
    String[][] tab = new String[9000][8];
    tab=initialiser();
    System.out.println("Id;Catégorie;Description;Energ_Kcal;Protéine;gras;Cholestérol;Sodium");
           for(int j=0; j<tab.length;j++){
               for(int k=0; k<tab[j].length; k++){
                   System.out.print(tab[j][k] + "    ");
               }
               System.out.println("");
           }
}

 public static int afficherMenu(){
     System.out.println("************************************************************************************************\n" +
                        "1-	Afficher l’ensemble des aliments depuis le fichier Nutrition.CSV                 *******\n" +
                        "2-	Afficher les aliments en fonction d’une valeur nutritive à la fois               *******\n" +
                        "3-	Afficher les valeurs nutritives d’un aliment (Recherche par ID)                  *******\n" +
                        "4-	Modifier une valeur nutritive d’un aliment par ID                                *******\n" +
                        "5-	Ajouter un aliment                                                               *******\n" +
                        "6-	Quitter                                                                          *******\n" +
                        "************************************************************************************************");
     int choix; Scanner sc = new Scanner(System.in);
     do{
     choix=sc.nextInt();
     if (choix < 1 || choix > 6){
         System.out.println("Entrée invalide. Re-saisissez votre choix");
     }
     }while(choix < 1 || choix > 6);
     return choix;
 }
 
 public static int rechercheID() throws IOException{
     Scanner sc = new Scanner(System.in);
     int ID; int recommencer=0;
     String tab[][]= new String[9000][8];
     tab=initialiser();
     do{
     System.out.println("Entrez le ID: ");
     do{
     ID = sc.nextInt();
     if(ID<1||ID>tab.length){
         System.out.println("Ce ID n'existe pas. Re-entrez le ID:");
     }
     }while(ID<=0||ID>tab.length);
     for(int i = 0; i < 8; i++){
       System.out.print(tab[ID-1][i]+";");
     }
         System.out.println("");
         System.out.println("Voulez-vous rechercher un autre aliment?");
         System.out.println("1. Oui");
         System.out.println("2. Non");
         do{
         recommencer=sc.nextInt();
         if(recommencer!=1&&recommencer!=2){
             System.out.println("Donnee invalide. Re-entrez votre choix.");
         }
         }while(recommencer!=1&&recommencer!=2);
     }while(recommencer==1);
     return ID;
 }
 public static void modif() throws IOException{
     Scanner sc = new Scanner(System.in);
     int ID; int nutriment; int modifON; int validation=0; int recommencer=0;
     String[] nutrimentNumber = {"Kcal", "Protein", "Gras", "Cholesterol", "Sodium"};
     String tab[][]= new String[9000][8];
     tab=initialiser();
     do{
     System.out.println("Veuillez insérer l’ ID du nutriment pour lequel vous voulez faire des modifications-->");
     do{
     ID = sc.nextInt();
     if(ID<1||ID>tab.length){
         System.out.println("Donnée invalide. Re-entrez le ID:");
     }
     }while(ID<1||ID>tab.length);
     System.out.println("Valeurs originales de l'aliment: ");
     for(int i = 0; i < 8; i++){
       System.out.print(tab[ID-1][i]+";");
     }
     System.out.println(""); System.out.println("");
     System.out.println("Veuillez saisir le numéro correspondant au nutriment  -->\n" +
                        "1- Energ_Kcal; 2-Protéine; 3-gras; 4- Cholestérol; 5- Sodium  -->");
     do{
         nutriment=sc.nextInt();
         if(nutriment<1||nutriment>5){
             System.out.println("Donnée invalide. Re-entrez votre choix: ");
         }
     }while(nutriment<1||nutriment>5);
     System.out.println("Valeur de "+nutrimentNumber[nutriment-1]+" : "+tab[ID-1][nutriment+2]);
     System.out.println("Voulez-vous conserver cette valeur (Oui) ou modifier la valeur (Non) \n" +
                        "1. Oui \n" +
                        "2. Non");
     do{
         modifON=sc.nextInt();
         if(modifON != 1 && modifON != 2){
             System.out.println("Donnée invalide. Re-entrez votre choix: ");
         }
     }while(modifON != 1 && modifON != 2);
    if(modifON==2){
        System.out.println("Entrez la nouvelle donnée de "+nutrimentNumber[nutriment-1]+" :");
        do{
        tab[ID-1][nutriment+2]=sc.nextLine();
        tab[ID-1][nutriment+2]=sc.nextLine();
        if(Integer.parseInt(tab[ID-1][nutriment+2]) <0||Integer.parseInt(tab[ID-1][nutriment+2])>10000){
            System.out.println("Le nombre doit etre compris entre 0 et 10000. Re-entrez votre choix.");
        }
        }while(Integer.parseInt(tab[ID-1][nutriment+2]) <0||Integer.parseInt(tab[ID-1][nutriment+2])>10000);
        System.out.println("Validation de la nouvelle donnee et confirmation");
        System.out.println("1. Oui");
        System.out.println("2. Non");
        do{
        validation = sc.nextInt();
        if(validation !=1 && validation !=2){
            System.out.println("Donnee invalide. Re-entrez votre choix");
        }
        }while(validation !=1 && validation !=2);
        if(validation==1){
        FileOutputStream fo1 = new FileOutputStream("nutrition.csv",false);
        PrintWriter writer1 = new PrintWriter(fo1);
        writer1.close();
    FileOutputStream fo = new FileOutputStream("nutrition.csv", true);
    PrintWriter writer = new PrintWriter(fo);
    writer.println("Id;Catégorie;Description;Energ_Kcal;Protéine;gras;Cholestérol;Sodium");
    for(int j=0; j<tab.length;j++){
               for(int k=0;k<tab[j].length; k++){
                   writer.print(tab[j][k]+";");
               }
               writer.println("");
           }
    writer.close();
    }
        if(validation==2){
            System.out.println("Voulez-vous re-saisir une modification?");
            System.out.println("1. Oui");
            System.out.println("2. Non");
            do{
                recommencer=sc.nextInt();
                if(recommencer!=1&&recommencer!=2){
                    System.out.println("Donnee invalide. Re-entrez votre choix");
                }
            }while(recommencer!=1&&recommencer!=2);
        }
    }
    }while(recommencer==1);
 }
 
 public static void ajouter() throws IOException{
    FileOutputStream fo = new FileOutputStream("nutrition.csv",true);
    PrintWriter fichierSortie = new  PrintWriter(fo); Scanner sc = new Scanner(System.in); int validation;
    int Kcal,protein,gras,cholesterol,sodium; String tab[][]= new String[9000][8]; String cat,description;
    tab=initialiser();
     System.out.println("Veuillez insérer un nouvel aliment sous cette forme :\n" +
                        "Catégorie;Description;Energ_Kcal;Protéine;gras;Cholestérol;Sodium");
     System.out.println("Entrez la categorie: ");
     cat=sc.nextLine();
     System.out.println("Entrez la description: ");
     description=sc.nextLine();
     System.out.println("Entrez le Kcal: ");
     do{
     Kcal=sc.nextInt();
     if(Kcal<0||Kcal>10000){ System.out.println("Le Kcal doit etre compris entre 0 et 10000. Re-entrez votre choix"); }
     }while(Kcal<0||Kcal>10000);
     System.out.println("Entrez le protein: ");
     do{
     protein=sc.nextInt();
     if(protein<0||protein>10000){ System.out.println("Le protein doit etre compris entre 0 et 10000. Re-entrez votre choix"); }
     }while(protein<0||protein>10000);
     System.out.println("Entrez le gras: ");
     do{
     gras=sc.nextInt();
     if(gras<0||gras>10000){ System.out.println("Le gras doit etre compris entre 0 et 10000. Re-entrez votre choix"); }
     }while(gras<0||gras>10000);
     System.out.println("Entrez le cholesterol");
     do{
     cholesterol=sc.nextInt();
     if(cholesterol<0||cholesterol>10000){ System.out.println("Le cholesterol doit etre compris entre 0 et 10000. Re-entrez votre choix"); }
     }while(cholesterol<0||cholesterol>10000);
     System.out.println("Entrez le sodium: ");
     do{
     sodium=sc.nextInt();
     if(sodium<0||sodium>10000){ System.out.println("Le sodium doit etre compris entre 0 et 10000. Re-entrez votre choix"); }
     }while(sodium<0||sodium>10000);
     System.out.println("Validation de la nouvelle entrée --> "+(tab.length+1)+";"+cat+";"+description+";"+Kcal+";"+protein+";"+gras+";"+cholesterol+";"+sodium);
     System.out.println("1. Oui");
     System.out.println("2. Non");
     do{
     validation=sc.nextInt();
     if(validation!=1&&validation!=2){ System.out.println("Donnee invalide. Re-entrez votre choix."); }
     }while(validation!=1&&validation!=2);
     if(validation==1){
     fichierSortie.println((tab.length+1)+";"+cat+";"+description+";"+Kcal+";"+protein+";"+gras+";"+cholesterol+";"+sodium);
     fichierSortie.close();
     System.out.println("Succes. Votre nouvel aliment: "+(tab.length+1)+";"+cat+";"+description+";"+Kcal+";"+protein+";"+gras+";"+cholesterol+";"+sodium+" a été enregistré." );
     }
 }
 public static void echanger(String[][] tab, int i, int j) {
        String[] val1 = tab[i];
        String[] val2 = tab[j];
        tab[i] = val2;
        tab[j] = val1;
    }
 
 public static void tri() throws IOException{
     Scanner sc = new Scanner(System.in);
     int choix; String[] choix1 ={"nutrition_energie.csv", "nutrition_proteins.csv", "nutrition_gras.csv", "nutrition_cholesterol.csv", "nutrition_sodium.csv"};
     String[] choix2 = {"énergie","protéines","gras","cholestérol","sodium"}; String tab[][] = new String[9000][8];
     tab=initialiser(); 
     System.out.println("Quelle valeure nutritive voulez-vous trier?\n"+
                        "1. Kcal\n"+
                        "2. Proteins\n"+
                        "3. Gras\n"+
                        "4. Cholesterol\n"+
                        "5. Sodium");
     do{
     choix=sc.nextInt();
     if(choix<1 || choix>5){
         System.out.println("Donnée invalide. Re-entrez votre choix.");
     }
     }while(choix<1 || choix>5);
        boolean echange;
         do{
            echange = false;
             for (int j = 0; j < tab.length - 1; j++) {

                if (Integer.parseInt(tab[j][(choix+2)]) < Integer.parseInt(tab[j + 1][(choix+2)])) {
                    echange = true;
                    echanger(tab, j, j+1);
                }
            }
        }while(echange);
         PrintWriter writer = new PrintWriter(new FileOutputStream(choix1[choix-1]));
         writer.println("Id;Catégorie;Description;Energ_Kcal;Protéine;gras;Cholestérol;Sodium");
         for(int j=0; j<tab.length;j++){
               for(int k=0;k<tab[j].length; k++){
                   writer.print(tab[j][k]+";");
               }
               writer.println("");
           }
    writer.close();
    System.out.println("Succes. Le fichier: "+choix1[choix-1]+" a été crée et a été trié en fonction de "+choix2[choix-1]+".");
    }
}