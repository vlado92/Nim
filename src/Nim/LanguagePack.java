package Nim;

public class LanguagePack {

    public enum Language {
        ENGLISH, СРПСКИ, SLOVENŠČINA, ITALIANO, DEUTSCH, HRVATSKI, FRANÇAIS
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
                    case "Select number of stocks:":
                        return "Select number of shelves:";
                    case "Select number of fruits:":
                        return "Select number of fruits:";
                    case "(Hint: 0 is random)":
                        return "(Hint: 0 is random)";
                    case "Stock ":
                        return "Shelf ";
                    case "Accept settings":
                        return "Accept settings";
                    case "Play first":
                        return "Play first";
                    case "Play second":
                        return "Play second";
                    case "Please use only numbers":
                        return "Please use only numbers";
                    case "Maximal number of fruits is 50":
                        return "Maximal number of fruits is 50";
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
                    case "fruits":
                        return "fruits";
                    case "from":
                        return "from";
                    case "In every move you can take any number of fruits from one stock.\n"
                + "In Normal Mode whoever takes the last of the objects wins!\n" 
                + "In Misere Mode whoever takes the last of the objects loses!\n" 
                + "By clicking basket below stock, you take fruits from that stock\n"
                + "When you finish your move, press \"Finish move\" button":
                        return "In every move you can take any number of fruits from one shelf.\n"
                + "In Normal Mode whoever takes the last of the objects wins!\n" 
                + "In Misere Mode whoever takes the last of the objects loses!\n" 
                + "By clicking basket below shelf, you take fruit from that shelf\n"
                + "When you finish your move, press \"Finish move\" button";
                    default:
                        return "Text not available";
                }
            
            case СРПСКИ:
                switch (text) {
                    case "Select type of game:":
                        return "Изаберите тип игре:";
                    case "Select opponent:":
                        return "Изаберите противника:";
                    case "Select number of Stocks:":
                        return "Изаберите број полица:";
                    case "Select number of fruits:":
                        return "Изабериte број воћа:";
                    case "(Hint: 0 is random)":
                        return "(Напомена: 0 је произвољно)";
                    case "Stock ":
                        return "Полица ";
                    case "Accept settings":
                        return "Прихвати подешавања";
                    case "Play first":
                        return "Играј први";
                    case "Play second":
                        return "Играј други";
                    case "Please use only numbers":
                        return "Молим Вас да користите бројеве";
                    case "Maximal number of fruits is 50":
                        return "Максимално воћа је 50";
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
                    case "fruits":
                        return "воће";
                    case "from":
                        return "са";
                    case "In every move you can take any number of fruits from one stock.\n"
                + "In Normal Mode whoever takes the last of the objects wins!\n" 
                + "In Misere Mode whoever takes the last of the objects loses!\n" 
                + "By clicking basket below stock, you take fruits from that stock\n"
                + "When you finish your move, press \"Finish move\" button":
                        return "У сваком потезу можете узети колико желите воћа са једне полице\n"
                +   "У Normal модулу ко узме послетњу воћку је побједио у игри!\n"
                +   "У Misere модулу ко узме послетњу воћку је изгубио у игри!\n"
                +   "Када притиснете кошару испод полице, узимате воће са те полице.\n"
                +   "Када завршите Ваш потез, притисните дугме \"Завши потез\"";
                    default:
                        return "Текст није доступан";
                }
            
            case DEUTSCH:
                switch (text) {
                    case "Select type of game:":
                        return "Wählen Sie die Art von Spiel:";
                    case "Select opponent:":
                        return "Wählen Gegner:";
                    case "Select number of Stocks:":
                        return "Wählen Sie die Anzahl der Bäume:";
                    case "Select number of fruits:":
                        return "Wählen Sie die Anzahl der Äpfel:";
                    case "(Hint: 0 is random)":
                        return "(Hinweis: 0 ist zufällige)";
                    case "Stock ":
                        return "Baum ";
                    case "Accept settings":
                        return "Einstellungen übernehmen";
                    case "Play first":
                        return "Spielen Sie zuerst";
                    case "Play second":
                        return "Spielen zweite";
                    case "Please use only numbers":
                        return "Bitte verwenden Sie nur Zahlen";
                    case "Maximal number of fruits is 50":
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
                    case "fruits":
                        return "Äpfel";
                    case "from":
                        return "vom";
                    case "In every move you can take any number of fruits from one stock.\n"
                + "In Normal Mode whoever takes the last of the objects wins!\n" 
                + "In Misere Mode whoever takes the last of the objects loses!\n" 
                + "By clicking basket below stock, you take fruits from that stock\n"
                + "When you finish your move, press \"Finish move\" button":
                        return 
                    "Wird Nim gespielt, beginnend mit Pfählen oder Reihen von Objekten.\n"
                +   "In jeder Bewegung eine beliebige Anzahl von Äpfeln aus einem Bäume nehmen kann.\n"
                +   "Im Normal Modus wer auch immer der letzte der Objekte nimmt gewinnt! \n"
                +   "In Misere Modus wer auch immer die letzte der Objekte nimmt verliert!\n"
                +   "Mit dem Korb unter Baum klicken, nehmen Sie Äpfel von diesem Baum\n"
                +   "Wenn Sie Ihren Umzug, drücken Sie beenden \"Ziel bewegen\" Taste";
                        default:
                        return "Text nicht verfügbar";
                }
            
            case ITALIANO:
                switch (text) {
                    case "Select type of game:":
                        return "Selezionare il tipo di gioco:";
                    case "Select opponent:":
                        return "Selezionare avversario:";
                    case "Select number of Stocks:":
                        return "Seleziona numero lo scaffali:";
                    case "Select number of fruits:":
                        return "Seleziona numero di frutta:";
                    case "(Hint: 0 is random)":
                        return "(Suggerimento: 0 è casuale)";
                    case "Stock ":
                        return "Lo scaffali ";
                    case "Accept settings":
                        return "Accetta le impostazioni";
                    case "Play first":
                        return "Gioca prima";
                    case "Play second":
                        return "Giocare secondo";
                    case "Please use only numbers":
                        return "Si prega di utilizzare solo numeri";
                    case "Maximal number of fruits is 50":
                        return "Numero massimo di frutta è di 50";
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
                    case "fruits":
                        return "frutta";
                    case "from":
                        return "da";
                    case "In every move you can take any number of fruits from one stock.\n"
                + "In Normal Mode whoever takes the last of the objects wins!\n" 
                + "In Misere Mode whoever takes the last of the objects loses!\n" 
                + "By clicking basket below stock, you take fruits from that stock\n"
                + "When you finish your move, press \"Finish move\" button":
                    return "In ogni mossa si può prendere qualsiasi numero di frutta da un scaffale.\n"
                            + "Nel Normal modo chi prende l'ultimo degli oggetti vince!\n"
                            +"In modalità Misere chi prende l'ultimo degli oggetti perde!\n"
                            + "Cliccando cesto sotto la scaffale, si prende le frutta da quell'scaffale\n"
                            + "Al termine il vostro movimento, premere il tasto \"Finitura mossa\"";
                    default:
                        return "Testo non disponibile";
                }
            
            case HRVATSKI:
                switch (text) {
                    case "Select type of game:":
                        return "Izaberite tip igre:";
                    case "Select opponent:":
                        return "Izaberite protivnika:";
                    case "Select number of Stocks:":
                        return "Izaberite broj polica:";
                    case "Select number of fruits:":
                        return "Izaberite broj voćki:";
                    case "(Hint: 0 is random)":
                        return "(Napomena: 0 je nasumično)";
                    case "Stock ":
                        return "Polica ";
                    case "Accept settings":
                        return "Prihvati podešavanja";
                    case "Play first":
                        return "Igraj prvi";
                    case "Play second":
                        return "Igraj drugi";
                    case "Please use only numbers":
                        return "Molim Vas da koristite brojeve";
                    case "Maximal number of fruits is 50":
                        return "Maksimum voćki je 50";
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
                    case "fruits":
                        return "voćke";
                    case "from":
                        return "sa";
                    case "In every move you can take any number of fruits from one stock.\n"
                + "In Normal Mode whoever takes the last of the objects wins!\n" 
                + "In Misere Mode whoever takes the last of the objects loses!\n" 
                + "By clicking basket below stock, you take fruits from that stock\n"
                + "When you finish your move, press \"Finish move\" button":
                        return "Svaki potez možete uzeti proizvoljno voćki sa jedne police.\n"
                              +"U Normal modu ko uzme poslednju voćku je pobjedio.\n"
                              +"U Misere modu ko uzme poslednju voćku je izbubio.\n"
                              +"Jabuke uzimate pritiskajući košaru ispod police.\n"
                              +"Kada završite potez, pritisnite dugme \"Završi potez\"";
                    default:
                        return "Tekst nije dostupan";
                }
            
            case SLOVENŠČINA:
                switch (text) {
                    case "Select type of game:":
                        return "Izberite tip igre:";
                    case "Select opponent:":
                        return "Izberite nasprotnika:";
                    case "Select number of Stocks:":
                        return "Izberite število police:";
                    case "Select number of fruits:":
                        return "Izberite število jabolk:";
                    case "(Hint: 0 is random)":
                        return "(Namig: će izbereš 0, bo število naključno)";
                    case "Stock ":
                        return "Polica ";
                    case "Accept settings":
                        return "Sprejmi nastavitve";
                    case "Play first":
                        return "Igraš prvi";
                    case "Play second":
                        return "Igraš drugi";
                    case "Please use only numbers":
                        return "Prosimo, uporabite samo številke";
                    case "Maximal number of fruits is 50":
                        return "Maksimalno število sadje je 50";
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
                        return "Končaj potezo";
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
                        return "bo vzel";
                    case "fruits":
                        return "sadje";
                    case "from":
                        return "od";
                    case "In every move you can take any number of fruits from one stock.\n"
                + "In Normal Mode whoever takes the last of the objects wins!\n" 
                + "In Misere Mode whoever takes the last of the objects loses!\n" 
                + "By clicking basket below stock, you take fruits from that stock\n"
                + "When you finish your move, press \"Finish move\" button":
                        return "V vsaki potezi lahko vzameš poljubno število sadje iz eno polico.\n"
                +   "V Normal načinu kdor vzame zadnji predmetov, zmaga!\n"
                +   "V Misere načinu kdor vzame zadnji predmetov, zgubi!\n"
                +   "S klikom na koš pod polico, ste vzeli sadje sa te police\n"
                                +"Ko končate potezo, pritisnite gumb \"Konča poteza\"";
                    default:
                        return "Besedilo ni na voljo";
                }
            
            case FRANÇAIS:
                switch(text){
                    case "Select type of game:":
                        return "Sélectionnez le type de jeu";
                    case "Select opponent:":
                        return "Sélectionnez l'adversaire";
                    case "Select number of Stocks:":
                        return "Sélectionnez le nombre d'étagères";
                    case "Select number of fruits:":
                        return "Sélectionnez le nombre de fruit";
                    case "(Hint: 0 is random)":
                        return "Conseil : 0 choisit un nombre aléatoire de pommes";
                    case "Stock ":
                        return "Étagères ";
                    case "Accept settings":
                        return "Valider";
                    case "Play first":
                        return "Jouer en premier";
                    case "Play second":
                        return "Jouer en deuxième";
                    case "Please use only numbers":
                        return "SVP n'utilisez que des chiffres";
                    case "Maximal number of fruits is 50":
                        return "Le maximal de fruits est de 50";
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
                        return "Êtes vous sûr de vouloir abandonner ce jeu";
                    case " and change language?":
                        return " et changer la langue ?";
                    case "take":
                        return "prend";
                    case "fruits":
                        return "fruits";
                    case "from":
                        return "de l\'";
                    case "In every move you can take any number of fruits from one stock.\n"
                + "In Normal Mode whoever takes the last of the objects wins!\n" 
                + "In Misere Mode whoever takes the last of the objects loses!\n" 
                + "By clicking basket below stock, you take fruits from that stock\n"
                + "When you finish your move, press \"Finish move\" button":
                        return "À chaque mouvement vous pouvez prendre n'importe quel nombre\nde fruits d'un seul étagère\n"
+                   "Dans le mode Normal, quiconque prend le dernier objet gagne\n"
+                   "Dans le mode Misere , quiconque prend le dernier objet perd\n"
+                   "En cliquant sur le panier en dessous d'un étagère, vous prenez\n"
                  + "des fruits de cet étagère. Quand vous avez fini vos opérations,\n"
                                + "appuyez sur le bouton \"Mouvement terminé\"";
                    default: 
                        return "texte non disponible";
            }

            default:
                return "Language not available";
        }
    }
}