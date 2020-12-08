//Andy Tran (1938297)
package tp2;
import java.util.Random;
import java.util.Scanner;
public class TP2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); Random rand = new Random();
        int tab6[] = new int [6] ;  int tab8[] = new int [8] ; int tab10[] = new int[10] ; boolean jokerON = false;
        int ChoixJeu ; int typeGrille = 0 ;  int  recommencer=0 ; int  saisirJoker1[] = new int[1] ; int total = 0;
        char[] joker=new char[3];int choixJoker=0; int similaire=99; char[] jokerRand= new char[3];int fauxTotal=0;
        int lire6[] = new int[6]; int lire8[] = new int[8]; int lire10[] = new int [10];int argent=0;int vraiTotal;
        int rtab6[]= new int[6]; int rtab8[]= new int[8]; int rtab10[]=new int[10]; char jokerRand2[]= new char[3];
        
        do{
        do{
        afficherLesRegles();
        ChoixJeu=sc.nextInt();
        if (ChoixJeu!=1 && ChoixJeu!=2){
        System.out.println("Entrée invalide. Resaisissez le choix de jeu.");}
        }while(ChoixJeu!=1 && ChoixJeu!=2);
        
        if(ChoixJeu==2){
        initialiserCombinaison(tab6);
        initialiserJoker(jokerRand);
        typeGrille = typeGrille(typeGrille);
        if(typeGrille==1){ lireCombinaisonJoueur6(lire6); }
        else if(typeGrille==2){ lireCombinaisonJoueur8(lire8); }
        else if(typeGrille==3){ lireCombinaisonJoueur10(lire10); }
        choixJoker = choixJoker(choixJoker);
        if(choixJoker==1){ saisirJoker(joker); }
        if(typeGrille==1){afficherGrilles(lire6, tab6); similaire = verifierGrille(lire6, tab6);}
        else if(typeGrille==2){afficherGrilles(lire8, tab6); similaire = verifierGrille(lire8, tab6);}
        else if(typeGrille==3){afficherGrilles(lire10, tab6); similaire = verifierGrille(lire10, tab6);}
        System.out.println(""); System.out.println("similaire: "+ similaire);
        if(choixJoker==1){
        afficherJoker(joker, jokerRand);
        jokerON=verifierJoker(joker, jokerRand);
        }if(jokerON){System.out.println("Vous avez gagné le joker!"); }
        else if(!jokerON){System.out.println("Vous avez perdu le joker.");}
        total= evaluerGain(argent, similaire);
        if(jokerON){total=total*2;}
        if(choixJoker==1){total=total-10;}
        if(typeGrille==1){total=total-10;}
        if(typeGrille==2){total=total-20;}
        if(typeGrille==3){total=total-30;}
        System.out.println("Votre gain: $ " + total);
        if(total<0){System.out.println("Vous avez perdu.");}
        else if(total>=0 && jokerON){System.out.println("Vouz avez gagner!");}
        else if(total>=0 && !jokerON){System.out.println("Vouz avez gagner! Achetez le joker la prochaine fois pour doubler vos gains.");}
        }
        
        if(ChoixJeu==1){
        initialiserCombinaison(tab6);
        initialiserJoker(jokerRand);
        typeGrille = typeGrille(typeGrille);
        if(typeGrille==1){initialiserCombinaison(rtab6); similaire = verifierGrille(rtab6, tab6); afficherGrilles(rtab6, tab6);}
        else if(typeGrille==2){initialiserCombinaison8(rtab8); similaire = verifierGrille(rtab8, tab6); afficherGrilles(rtab8, tab6);}
        else if(typeGrille==3){initialiserCombinaison10(rtab10); similaire = verifierGrille(rtab10, tab6); afficherGrilles(rtab10, tab6);}
        System.out.println(""); System.out.println("similaire: "+ similaire);
        choixJoker = choixJoker(choixJoker);
        if (choixJoker==1){
        initialiserJoker(jokerRand2);
        afficherJoker(jokerRand2, jokerRand);
        jokerON=verifierJoker(jokerRand2, jokerRand);
        }if(jokerON){System.out.println("Vous avez gagner le joker!"); }
        else if(!jokerON){System.out.println("Vous avez perdu le joker."); }
        total= evaluerGain(argent, similaire);
        if(jokerON){total=total*2;}
        if(choixJoker==1){total=total-10;}
        if(typeGrille==1){total=total-10;}
        if(typeGrille==2){total=total-20;}
        if(typeGrille==3){total=total-30;}
        System.out.println("Votre gain: " + total);
        if(total<0){System.out.println("Vous avez perdu.");}
        else if(total>=0 && jokerON){System.out.println("Vouz avez gagner!");}
        else if(total>=0 && !jokerON){System.out.println("Vouz avez gagner! Achetez le joker la prochaine fois pour doubler vos gains.");}
        }
        fauxTotal=fauxTotal+total;
        vraiTotal=fauxTotal+100;
        System.out.println("Votre montant total: $" + vraiTotal);
        recommencer=recommencer(recommencer);
        if(recommencer==1 && vraiTotal<=0){ System.out.println("Desolé. Vous ne pouvez pas recommencer parce que vous n'avez plus d'argent.");}
        }while(recommencer==1 && vraiTotal>0);
        System.out.println("Merci d'avoir joué. À la prochaine.");
    }
    
    public static void afficherLesRegles(){
        System.out.println("************ CHOIX JEU ************\n" +
                           "\n" +
                           "1- La machine choisit la combinaison des nombres\n" +
                           "2- Le joueur choisit la combinaison des nombres \n" +
                           "\n" +
                           "************************************");
    }
    public static void initialiserCombinaison(int tab6[]){
        Random rand = new Random();
        int[] temp=new int[6];
        int current;
        
        for (int i=0; i<6; i++){
            do{
            current=rand.nextInt(30)+1;
            }while(contient(temp, current));
            temp[i]=current;
            tab6[i]=current;
        }
    }
    public static void initialiserCombinaison8(int tab8[]){
        Random rand = new Random();
        int[] temp=new int[8];
        int current;
        
        for (int i=0; i<8; i++){
            do{
            current=rand.nextInt(30)+1;
            }while(contient(temp, current));
            temp[i]=current;
            tab8[i]=current;
        }
    }
    public static void initialiserCombinaison10(int tab10[]){
        Random rand = new Random();
        int[] temp=new int[10];
        int current;
        
        for (int i=0; i<10; i++){
            do{
            current=rand.nextInt(30)+1;
            }while(contient(temp, current));
            temp[i]=current;
            tab10[i]=current;
        }
    }
    public static void initialiserJoker(char joker1[]){
        Random rand = new Random();
        char[] joker={'♠','♥','♦'}; int temp;
        do{
            for(int i=0;i<3;i++){
            temp=rand.nextInt(3);
                switch (temp) {
                    case 0:
                        joker1[i]=joker[0];
                        break;
                    case 1:
                        joker1[i]=joker[1];
                        break;
                    case 2:
                        joker1[i]=joker[2];
                        break;
                    default:
                        break;
                }
            }
        }while(joker1[0]==joker1[1] || joker1[0]==joker1[2] || joker1[1]==joker1[2]);
    }
    public static void lireCombinaisonJoueur6(int lire6[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez entrer vos 6 nombres.");
        for (int i=0; i<6; i++){
            do{
        lire6[i]=sc.nextInt();
        if(lire6[i]>30 || lire6[i]<=0){
            System.out.println("Les nombres doivent etre comprises entre 1 et 30 et ne doivent pas se repeter. Re-entrez votre choix.");
        }
            }while(lire6[i]>30 || lire6[i]<=0);
    }
    }
        public static void lireCombinaisonJoueur8(int lire8[]){
        Scanner sc = new Scanner(System.in);
            System.out.println("Veuillez entrer vos 8 nombres.");
        for (int i=0; i<8; i++){
        do{
        lire8[i]=sc.nextInt();
        if(lire8[i]>30 || lire8[i]<=0){
            System.out.println("Les nombres doivent etre comprises entre 1 et 30. Re-entrez votre choix.");
        }
            }while(lire8[i]>30 || lire8[i]<=0);
    }
    }
        public static void lireCombinaisonJoueur10(int lire10[]){
        Scanner sc = new Scanner(System.in);
            System.out.println("Veuillez entrer vos 10 nombres.");
        for (int i=0; i<10; i++){
            do{
        lire10[i]=sc.nextInt();
        if(lire10[i]>30 || lire10[i]<=0){
            System.out.println("Les nombres doivent etre comprises entre 1 et 30. Re-entrez votre choix.");
        }
            }while(lire10[i]>30 || lire10[i]<=0);
    }
    }
    public static void lireJokerJoueur(char jokerLire[]){
        Scanner sc = new Scanner(System.in);
        for (int i=0; i<3; i++){
        jokerLire[i]=sc.nextLine().charAt(i);}
    }
    public static boolean contient(int tableau[], int a){
        for(int i=0; i<tableau.length; i++){
            if (tableau[i]==a){
                 return true;
            }
        }return false;
    }
    
    public static int typeGrille(int typeGrille){
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("*********** TYPE DE GRILLE ***************\n" +
                               "\n" +
                               "* 1- Jouer à 6 nombres, prix 10$\n" +
                               "* 2-Jouer à 8 nombres, prix 20$\n" +
                               "* 3-Jouer à 10 nombres, prix 30$\n" +
                               "\n" +
                               "*******************************************");
            typeGrille=sc.nextInt();
            if (typeGrille !=1 && typeGrille != 2 && typeGrille != 3){
            System.out.println("Entrée invalide. Resaisissez le type de grille.");}
            }while(typeGrille !=1 && typeGrille != 2 && typeGrille != 3);
        switch (typeGrille) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            default:
                break;
        }
        return typeGrille;
    }
    public static int choixJoker(int choixJoker){
        Scanner sc = new Scanner(System.in);
        do{
        System.out.println("******* DOUBLER VOS GAIN, JOKER *******\n" +
                           "******* Ne manquez pas votre chance ********\n" +
                           "\n" +
                           "* 1- Oui (10$ supplémentaire)\n" +
                           "* 2-Non \n" +
                           "\n" +
                           "******************************************");
        choixJoker=sc.nextInt();
        if(choixJoker!=1 && choixJoker!=2){
            System.out.println("Entrée invalide. Re-entrez votre choix.");}
        }while(choixJoker!=1 && choixJoker!=2);
        if (choixJoker==1){
            return 1;
        }else if (choixJoker==2){
            return 2;
        }
       return choixJoker; 
    }
    public static int recommencer(int recommencer){
        Scanner sc = new Scanner(System.in);
        do{
        System.out.println("*********** REJOUER ENCORE ? *************\n" +
                           "\n" +
                           "Voulez-vous recommencer ?\n" +
                           "1- Oui\n" +
                           "2-Non\n" +
                           "\n" +
                           "*******************************************");
        recommencer=sc.nextInt();
        if (recommencer!=1 && recommencer!=2){
            System.out.println("Entrée invalide. Re-entrez votre choix.");
        }
        }while(recommencer!=1 && recommencer!=2);
        return recommencer;
    }
    public static int verifierGrille(int joueur[], int tab6[]){
        int similaire=0;
        for(int i=0; i<joueur.length; i++){
           for (int j=0; j<tab6.length; j++){
            if(joueur[i]==tab6[j]){
                similaire++;
            }
        }
        }return similaire;
    }
    public static char[] saisirJoker(char joker[]){
        Scanner sc = new Scanner(System.in); int saisirJoker;
        System.out.println("Choisissez votre choix de Joker.");
        do{
        System.out.println("1. ♠, ♥, ♦\n" +
                           "2. ♠, ♦, ♥\n" +
                           "3. ♥, ♠, ♦\n" +
                           "4. ♥, ♦, ♠\n" +
                           "5. ♦, ♥, ♠\n" +
                           "6. ♦, ♠, ♥");
        saisirJoker=sc.nextInt();
        if (saisirJoker!=1 && saisirJoker!=2 && saisirJoker!=3 && saisirJoker!=4 && saisirJoker!=5 && saisirJoker!=6){
            System.out.println("Entree invalide. Re-entrez votre choix.");
        }
        }while(saisirJoker!=1 && saisirJoker!=2 && saisirJoker!=3 && saisirJoker!=4 && saisirJoker!=5 && saisirJoker!=6);
        switch (saisirJoker) {
            case 1:
                joker[0]='♠';
                joker[1]='♥';
                joker[2]='♦';
                break;
            case 2:
                joker[0]='♠';
                joker[1]='♦';
                joker[2]='♥';
                break;
            case 3:
                joker[0]='♥';
                joker[1]='♠';
                joker[2]='♦';
                break;
            case 4:
                joker[0]='♥';
                joker[1]='♦';
                joker[2]='♠';
                break;
            case 5:
                joker[0]='♦';
                joker[1]='♥';
                joker[2]='♠';
                break;
            case 6:
                joker[0]='♦';
                joker[1]='♠';
                joker[2]='♥';
                break;
            default:
                break;
        }
        return joker;
    }
    public static boolean verifierJoker(char jokerJoueur[], char jokerGagnant[]){
        if(jokerJoueur[0]==jokerGagnant[0] && jokerJoueur[1]==jokerGagnant[1] && jokerJoueur[2]==jokerGagnant[2]){
            return true;
        }else{ return false; }   
    }
    public static void afficherGrilles(int tabJoueur[], int tabGagnant[]){
        System.out.println("Tableau Joueur: ");
        boolean echange = true;
      
        do{
            echange = false;
             for (int j = 0; j < tabJoueur.length - 1; j++) {
                if (tabJoueur[j] > tabJoueur[j + 1]) {
                    echange = true;
                    echanger(tabJoueur, j, j + 1);
                }
            }
        }while(echange ==true);
        for(int i=0;i<tabJoueur.length; i++){
        System.out.print(tabJoueur[i]+" ");
    }System.out.println("");
        System.out.println("Tableau Gagnant: ");
        do{
            echange = false;
             for (int j = 0; j < tabGagnant.length - 1; j++) {
                if (tabGagnant[j] > tabGagnant[j + 1]) {
                    echange = true;
                    echanger(tabGagnant, j, j + 1);
                }
            }
        }while(echange ==true);
        for(int i=0;i<tabGagnant.length; i++){
        System.out.print(tabGagnant[i]+" ");
    }
    }
    public static void afficherJoker(char jokerJoueur[], char jokerGagnant[]){
        System.out.println("Joker Joueur: ");
        System.out.println(jokerJoueur[0]+" "+jokerJoueur[1]+" "+jokerJoueur[2]);
        System.out.println("Joker Gagnant: ");
        System.out.println(jokerGagnant[0]+" "+jokerGagnant[1]+" "+jokerGagnant[2]);
    }
    public static int evaluerGain(int argent, int similaire){
        char jokerJoueur[]; char jokerGagnant;
        switch (similaire) {
            case 0:
            case 1:
            case 2:
            case 3:
                argent=0;
                break;
            case 4:
                argent=20;
                break;
            case 5:
                argent=40;
                break;
            case 6:
                argent=60;
                break;
            default:
                break;
        }
        return argent;
    }
    public static void echanger(int[] tab, int i, int j) {
        int val1 = tab[i];
        int val2 = tab[j];
        tab[i] = val2;
        tab[j] = val1;
    }
    }