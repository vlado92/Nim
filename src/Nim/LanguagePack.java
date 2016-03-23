package Nim;

public class LanguagePack {

    public enum Language {
        ENGLISH, СРПСКИ, SLOVENČINA, ITALIANO, DEUTSCH, HRVATSKI, FRANÇAIS
    }
    private static Language language = Language.ENGLISH;

    public static void changeLanguage(Language lang){
        language = lang;
    }
    public static Language getLanguage(){
        return language;
    }
    
    public static String setText(Language languge, String text) {
        switch (languge) {
            case ENGLISH:
                switch (text) {
                    case "Select type of game:":
                        return "Select type of game:";
                    case "Select opponent:":
                        return "Select opponent:";
                    case "Select number of trees:":
                        return "Select number of trees:";
                    case "Select number of Apples:":
                        return "Select number of Apples:";
                    case "(Hint: 0 is random)":
                        return "(Hint: 0 is random)";
                    case "Tree ":
                        return "Tree ";
                    case "Accept settings":
                        return "Accept settings";
                    case "Play first":
                        return "Play first";
                    case "Play second":
                        return "Play second";
                    case "Please use only numbers":
                        return "Please use only numbers";
                    case "Maximal number of apples is 50":
                        return "Maximal number of apples is 50";
                    case "Human":
                        return "Human";
                    case "Computer":
                        return "Computer";
                    case "New Game":
                        return "New Game";
                    case "Instructions":
                        return "Instructions";
                    case "Select language":
                        return "Select language";
                    case "Exit":
                        return "Exit";
                    case "Finish move":
                        return "Finish move";
                    case "Player ":
                        return "Player ";
                    case " won":
                        return " won";
                    case "Want to play again?":
                        return "Want to play again?";
                    case "Question ?":
                        return "Question ?";
                    case "Are you sure you want to cancel this game":
                        return "Are you sure you want to cancel this game";
                    case " and change language?":
                        return " and change language?";
                    case "take":
                        return "take";
                    case "apples":
                        return "apples";
                    case "from":
                        return "from";
                    default:
                        return "Text not available";
                }
            
            case СРПСКИ:
                switch (text) {
                    case "Select type of game:":
                        return "Изаберите тип игре:";
                    case "Select opponent:":
                        return "Изаберите противника:";
                    case "Select number of trees:":
                        return "Изаберите број дрвећа:";
                    case "Select number of Apples:":
                        return "Изабериte број јабука:";
                    case "(Hint: 0 is random)":
                        return "(Напомена: 0 је произвољно)";
                    case "Tree ":
                        return "Дрво ";
                    case "Accept settings":
                        return "Прихвати подешавања";
                    case "Play first":
                        return "Играј први";
                    case "Play second":
                        return "Играј други";
                    case "Please use only numbers":
                        return "Молим Вас да користите бројеве";
                    case "Maximal number of apples is 50":
                        return "Максимално јабука је 50";
                    case "Human":
                        return "Особа";
                    case "Computer":
                        return "Компјутер";
                    case "New Game":
                        return "Нова игра";
                    case "Instructions":
                        return "Инструкције";
                    case "Select language":
                        return "Изаберите језик";
                    case "Exit":
                        return "Изађи";
                    case "Finish move":
                        return "Заврши потез";
                    case "Player ":
                        return "Играч ";
                    case " won":
                        return " је побједио";
                    case "Want to play again?":
                        return "Желите играти опет?";
                    case "Question ?":
                        return "Питање ?";
                    case "Are you sure you want to cancel this game":
                        return "Да ли сте сигурни да желите да прекинете игру";
                    case " and change language?":
                        return " и промјенити језик?";
                    case "take":
                        return "узео";
                    case "apples":
                        return "јабуке";
                    case "from":
                        return "са";
                    default:
                        return "Текст није доступан";
                }
            
            case DEUTSCH:
                switch (text) {
                    case "Select type of game:":
                        return "Wählen Sie die Art von Spiel:";
                    case "Select opponent:":
                        return "Wählen Gegner:";
                    case "Select number of trees:":
                        return "Wählen Sie die Anzahl der Bäume:";
                    case "Select number of Apples:":
                        return "Wählen Sie die Anzahl der Äpfel:";
                    case "(Hint: 0 is random)":
                        return "(Hinweis: 0 ist zufällige)";
                    case "Tree ":
                        return "Baum ";
                    case "Accept settings":
                        return "Einstellungen übernehmen";
                    case "Play first":
                        return "Spielen Sie zuerst";
                    case "Play second":
                        return "Spielen zweite";
                    case "Please use only numbers":
                        return "Bitte verwenden Sie nur Zahlen";
                    case "Maximal number of apples is 50":
                        return "Maximale Anzahl der Äpfel ist 50";
                    case "Human":
                        return "Person";
                    case "Computer":
                        return "Computer";
                    case "New Game":
                        return "Neues Spiel";
                    case "Instructions":
                        return "Anleitung";
                    case "Select language":
                        return "Sprache auswählen";
                    case "Exit":
                        return "Ausfahrt";
                    case "Finish move":
                        return "Ziel bewegen";
                    case "Player ":
                        return "Spieler ";
                    case " won":
                        return " gewonnen";
                    case "Want to play again?":
                        return "Wollen Sie wieder zu spielen?";
                    case "Question ?":
                        return "Frage ?";
                    case "Are you sure you want to cancel this game":
                        return "Bist du sicher, dass du dieses Spiel abbrechen möchten";
                    case " and change language?":
                        return " und die Sprache ändern?";
                    case "take":
                        return "nehmen";
                    case "apples":
                        return "Äpfel";
                    case "from":
                        return "vom";
                    default:
                        return "Text nicht verfügbar";
                }
            
            case ITALIANO:
                switch (text) {
                    case "Select type of game:":
                        return "Selezionare il tipo di gioco:";
                    case "Select opponent:":
                        return "Selezionare avversario:";
                    case "Select number of trees:":
                        return "Seleziona numero di alberi:";
                    case "Select number of Apples:":
                        return "Seleziona numero di mele:";
                    case "(Hint: 0 is random)":
                        return "(Suggerimento: 0 è casuale)";
                    case "Tree ":
                        return "Albero ";
                    case "Accept settings":
                        return "Accetta le impostazioni";
                    case "Play first":
                        return "Gioca prima";
                    case "Play second":
                        return "Giocare secondo";
                    case "Please use only numbers":
                        return "Si prega di utilizzare solo numeri";
                    case "Maximal number of apples is 50":
                        return "Numero massimo di mele è di 50";
                    case "Human":
                        return "Persona";
                    case "Computer":
                        return "Computer";
                    case "New Game":
                        return "Nuovo gioco";
                    case "Instructions":
                        return "Istruzione";
                    case "Select language":
                        return "Seleziona la lingua";
                    case "Exit":
                        return "Uscita";
                    case "Finish move":
                        return "Finitura mossa";
                    case "Player ":
                        return "Giocatore ";
                    case " won":
                        return " ha vinto";
                    case "Want to play again?":
                        return "Vuoi giocare di nuovo?";
                    case "Question ?":
                        return "Domanda ?";
                    case "Are you sure you want to cancel this game":
                        return "Sei sicuro di voler annullare questo gioco";
                    case " and change language?":
                        return " e cambiare la lingua?";
                    case "take":
                        return "prende";
                    case "apples":
                        return "mele";
                    case "from":
                        return "da";
                    default:
                        return "Testo non disponibile";
                }
            
            case HRVATSKI:
                switch (text) {
                    case "Select type of game:":
                        return "Izaberite tip igre:";
                    case "Select opponent:":
                        return "Izaberite protivnika:";
                    case "Select number of trees:":
                        return "Izaberite broj trveća:";
                    case "Select number of Apples:":
                        return "Izaberite broj jabuka:";
                    case "(Hint: 0 is random)":
                        return "(Napomena: 0 je nasumično)";
                    case "Tree ":
                        return "Drvo ";
                    case "Accept settings":
                        return "Prihvati podešavanja";
                    case "Play first":
                        return "Igraj prvi";
                    case "Play second":
                        return "Igraj drugi";
                    case "Please use only numbers":
                        return "Molim Vas da koristite brojeve";
                    case "Maximal number of apples is 50":
                        return "Maksimum jabuka je 50";
                    case "Human":
                        return "Osoba";
                    case "Computer":
                        return "Računalo";
                    case "New Game":
                        return "Nova igra";
                    case "Instructions":
                        return "Instrukcije";
                    case "Select language":
                        return "Izaberite jezik";
                    case "Exit":
                        return "Izađi";
                    case "Finish move":
                        return "Završi potez";
                    case "Player ":
                        return "Igrač ";
                    case " won":
                        return " je pobjedio";
                    case "Want to play again?":
                        return "Želite igrati opet?";
                    case "Question ?":
                        return "Pitanje ?";
                    case "Are you sure you want to cancel this game":
                        return "Da li ste sigurni da želite da prekinete igru";
                    case " and change language?":
                        return " i promjeniti jezik?";
                    case "take":
                        return "uzeo";
                    case "apples":
                        return "jabuke";
                    case "from":
                        return "sa";
                    default:
                        return "Tekst nije dostupan";
                }
            
            case SLOVENČINA:
                switch (text) {
                    case "Select type of game:":
                        return "Izberite tip igre:";
                    case "Select opponent:":
                        return "Izberite nasprotnik:";
                    case "Select number of trees:":
                        return "Izberite število dreves:";
                    case "Select number of Apples:":
                        return "Izberite število jabolk:";
                    case "(Hint: 0 is random)":
                        return "(Namig: 0 naključno)";
                    case "Tree ":
                        return "Drevo ";
                    case "Accept settings":
                        return "Sprejmi nastavitve";
                    case "Play first":
                        return "Igrajte prvi";
                    case "Play second":
                        return "Igrajo drugi";
                    case "Please use only numbers":
                        return "Prosimo, uporabite samo številke";
                    case "Maximal number of apples is 50":
                        return "Maksimalno število jabolk 50";
                    case "Human":
                        return "Oseba";
                    case "Computer":
                        return "Računalnik";
                    case "New Game":
                        return "Nova igra";
                    case "Instructions":
                        return "Navodila";
                    case "Select language":
                        return "Izberi jezik";
                    case "Exit":
                        return "Izhod";
                    case "Finish move":
                        return "Konča poteza";
                    case "Player ":
                        return "Igralec ";
                    case " won":
                        return " je zmagal";
                    case "Want to play again?":
                        return "Želite ponovno igrati?";
                    case "Question ?":
                        return "Vprašanje ?";
                    case "Are you sure you want to cancel this game":
                        return "Ali ste prepričani, da želite preklicati to igro";
                    case " and change language?":
                        return " in spremeniti jezik?";
                    case "take":
                        return "bo";
                    case "apples":
                        return "jabolk";
                    case "from":
                        return "od";
                    default:
                        return "Besedilo ni na voljo";
                }
            
            case FRANÇAIS:
                switch(text){
                    case "Select type of game:":
                        return "Sélectionnez le type de jeu";
                    case "Select opponent:":
                        return "Sélectionnez l'adversaire";
                    case "Select number of trees:":
                        return "Sélectionnez le nombre d'arbres";
                    case "Select number of Apples:":
                        return "Sélectionnez le nombre de pommes";
                    case "(Hint: 0 is random)":
                        return "Conseil : 0 choisit un nombre aléatoire de pommes";
                    case "Tree ":
                        return "arbre ";
                    case "Accept settings":
                        return "Valider";
                    case "Play first":
                        return "Jouer en premier";
                    case "Play second":
                        return "Jouer en deuxième";
                    case "Please use only numbers":
                        return "SVP n'utilisez que des chiffres";
                    case "Maximal number of apples is 50":
                        return "Le nombre maximal de pommes est de 50";
                    case "Human":
                        return "Joueur";
                    case "Computer":
                        return "Ordinateur";
                    case "New Game":
                        return "Nouveau jeu";
                    case "Instructions":
                        return "Instructions";
                    case "Select language":
                        return "Sélectionnez la langue";
                    case "Exit":
                        return "Sortie";
                    case "Finish move":
                        return "Mouvement terminé";
                    case "Player ":
                        return "Joueur ";
                    case " won":
                        return " Victoire";
                    case "Want to play again?":
                        return "Voulez vous rejouer ?";
                    case "Are you sure you want to cancel this game":
                        return "êtes vous sûr de vouloir abandonner ce jeu ?";
                    case " and change language?":
                        return "et de changer la langue ?";
                    case "take":
                        return "prend";
                    case "apples":
                        return "pommes";
                    case "from":
                        return "de l\'";
                    default: 
                        return "texte non disponible";
            }

            default:
                return "Language not available";
        }
    }
}
// player   take  X apples
//Le joueur prend X pommes