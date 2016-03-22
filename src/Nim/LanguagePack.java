package Nim;

public class LanguagePack {

    public enum Language {
        ENGLISH, СРПСКИ, SLOVENČINA, ITALIANO, DEUTSCH, HRVATSKI
    }
        private static Language language = Language.ENGLISH;
    
    public static void changeLanguage(Language lang){
        language = lang;
    }
    public static Language getLanguage(){
        return language;
    }
    
    public static String setText(Language languge, String text) {
        switch(text) {
            // <editor-fold defaultstate="collapsed" desc="Done cases">
            case "Select type of game:":{
                switch (languge) {
                    case ENGLISH:
                        return "Select type of game:";
                    case СРПСКИ:
                        return "Изаберите тип игре:";
                    case DEUTSCH:
                        return "Wählen Sie die Art von Spiel:";
                    case ITALIANO:
                        return "Selezionare il tipo di gioco:";
                    case HRVATSKI:
                        return "Izaberite tip igre:";
                    case SLOVENČINA:
                        return "Izberite tip igre:";
                    default:
                        return "Language not inputed";
                }
            }
            case "Select oponent:":{
                switch (languge) {
                    case ENGLISH:
                        return "Select opponent:";
                    case СРПСКИ:
                        return "Изаберите противника:";
                    case DEUTSCH:
                        return "Wählen Gegner:";
                    case ITALIANO:
                        return "Selezionare avversario:";
                    case HRVATSKI:
                        return "Izaberite protivnika:";
                    case SLOVENČINA:
                        return "Izberite nasprotnik:";
                    default:
                        return "Language not inputed";
                }
            }
            case "Select number of trees:":{
                switch (languge) {
                    case ENGLISH:
                        return "Select number of trees:";
                    case СРПСКИ:
                        return "Изаберите број трвећа:";
                    case DEUTSCH:
                        return "Wählen Sie die Anzahl der Bäume:";
                    case ITALIANO:
                        return "Seleziona numero di alberi:";
                    case HRVATSKI:
                        return "Izaberite broj trveća:";
                    case SLOVENČINA:
                        return "Izberite število dreves:";
                    default:
                        return "Language not inputed";
                }
            }
            case "Select number of Apples:":{
                switch (languge) {
                    case ENGLISH:
                        return "Select number of Apples:";
                    case СРПСКИ:
                        return "Изабериte број јабука:";
                    case DEUTSCH:
                        return "Wählen Sie die Anzahl der Äpfel:";
                    case ITALIANO:
                        return "Seleziona numero di mele:";
                    case HRVATSKI:
                        return "Izaberite broj jabuka:";
                    case SLOVENČINA:
                        return "Izberite število jabolk:";
                    default:
                        return "Language not inputed";
                }
            }
                case "(Hint: 0 means random)":{
                switch (languge) {
                    case ENGLISH:
                        return "(Hint: 0 is random)";
                    case СРПСКИ:
                        return "(Напомена: 0 је произвољно)";
                    case DEUTSCH:
                        return "(Hinweis: 0 ist zufällige)";
                    case ITALIANO:
                        return "(Suggerimento: 0 0 è casuale)";
                    case HRVATSKI:
                        return "(Napomena: 0 je nasumično)";
                    case SLOVENČINA:
                        return "(Namig: 0 naključno)";
                    default:
                        return "Language not inputed";
                }
            }
            case "Tree ":{
                switch (languge) {
                    case ENGLISH:
                        return "Tree ";
                    case СРПСКИ:
                        return "Дрво ";
                    case DEUTSCH:
                        return "Baum ";
                    case ITALIANO:
                        return "Albero ";
                    case HRVATSKI:
                        return "Drvo ";
                    case SLOVENČINA:
                        return "Drevo ";
                    default:
                        return "Language not inputed";
                }
            }
            case "Accept settings":{
                switch (languge) {
                    case ENGLISH:
                        return "Accept settings";
                    case СРПСКИ:
                        return "Прихвати подешавања";
                    case DEUTSCH:
                        return "Einstellungen übernehmen";
                    case ITALIANO:
                        return "Accetta le impostazioni";
                    case HRVATSKI:
                        return "Prihvati podešavanja";
                    case SLOVENČINA:
                        return "Sprejmi nastavitve";
                    default:
                        return "Language not inputed";
                }
            }
            case "Play first":{
                switch (languge) {
                    case ENGLISH:
                        return "Play first";
                    case СРПСКИ:
                        return "Играј први";
                    case DEUTSCH:
                        return "Spielen Sie zuerst";
                    case ITALIANO:
                        return "Gioca prima";
                    case HRVATSKI:
                        return "Igraj prvi";
                    case SLOVENČINA:
                        return "Igrajte prvi";
                    default:
                        return "Language not inputed";
                }
            }
            case "Play second":{
                switch (languge) {
                    case ENGLISH:
                        return "Play second";
                    case СРПСКИ:
                        return "Играј други";
                    case DEUTSCH:
                        return "Spielen zweite";
                    case ITALIANO:
                        return "Giocare secondo";
                    case HRVATSKI:
                        return "Igraj drugi";
                    case SLOVENČINA:
                        return "Igrajo drugi";
                    default:
                        return "Language not inputed";
                }
            }
            case "Please use only numbers":{
                switch (languge) {
                    case ENGLISH:
                        return "Please use only numbers";
                    case СРПСКИ:
                        return "Молим Вас да користите бројеве";
                    case DEUTSCH:
                        return "Bitte verwenden Sie nur Zahlen";
                    case ITALIANO:
                        return "Si prega di utilizzare solo numeri";
                    case HRVATSKI:
                        return "Molim Vas da koristite brojeve";
                    case SLOVENČINA:
                        return "Prosimo, uporabite samo številke";
                    default:
                        return "Language not inputed";
                }
            }
            case "Maximal number of apples is 50":{
                switch (languge) {
                    case ENGLISH:
                        return "Maximal number of apples is 50";
                    case СРПСКИ:
                        return "Максимално јабука је 50";
                    case DEUTSCH:
                        return "Maximale Anzahl der Äpfel ist 50";
                    case ITALIANO:
                        return "Numero massimo di mele è di 50";
                    case HRVATSKI:
                        return "Maksimum jabuka je 50";
                    case SLOVENČINA:
                        return "Maksimalno število jabolk 50";
                    default:
                        return "Language not inputed";
                }
            }
            case "Human":{
                switch (languge) {
                    case ENGLISH:
                        return "Human";
                    case СРПСКИ:
                        return "Особа";
                    case DEUTSCH:
                        return "Person";
                    case ITALIANO:
                        return "Persona";
                    case HRVATSKI:
                        return "Osoba";
                    case SLOVENČINA:
                        return "Oseba";
                    default:
                        return "Language not inputed";
                }
            }
            case "Computer":{
                switch (languge) {
                    case ENGLISH:
                        return "Computer";
                    case СРПСКИ:
                        return "Компјутер";
                    case DEUTSCH:
                        return "Computer";
                    case ITALIANO:
                        return "Computer";
                    case HRVATSKI:
                        return "Računalo";
                    case SLOVENČINA:
                        return "Računalnik";
                    default:
                        return "Language not inputed";
                }
            }
            case "New Game":{
                switch (languge) {
                    case ENGLISH:
                        return "New Game";
                    case СРПСКИ:
                        return "Нова игра";
                    case DEUTSCH:
                        return "Neues Spiel";
                    case ITALIANO:
                        return "Nuovo gioco";
                    case HRVATSKI:
                        return "Nova igra";
                    case SLOVENČINA:
                        return "Nova igra";
                    default:
                        return "Language not inputed";
                }
            }
            case "Instructions":{
                switch (languge) {
                    case ENGLISH:
                        return "Instructions";
                    case СРПСКИ:
                        return "Инструкције";
                    case DEUTSCH:
                        return "Anleitung";
                    case ITALIANO:
                        return "Istruzione";
                    case HRVATSKI:
                        return "Instrukcije";
                    case SLOVENČINA:
                        return "Navodila";
                    default:
                        return "Language not inputed";
                }
            }
            case "Select language":{
                switch (languge) {
                    case ENGLISH:
                        return "Select language";
                    case СРПСКИ:
                        return "Изаберите језик";
                    case DEUTSCH:
                        return "Sprache auswählen";
                    case ITALIANO:
                        return "Seleziona la lingua";
                    case HRVATSKI:
                        return "Izaberite jezik";
                    case SLOVENČINA:
                        return "Izberi jezik";
                    default:
                        return "Language not inputed";
                }
            }
            case "Exit":{
                switch (languge) {
                    case ENGLISH:
                        return "Exit";
                    case СРПСКИ:
                        return "Изађи";
                    case DEUTSCH:
                        return "Ausfahrt";
                    case ITALIANO:
                        return "Uscita";
                    case HRVATSKI:
                        return "Izađi";
                    case SLOVENČINA:
                        return "Izhod";
                    default:
                        return "Language not inputed";
                }
            }
            //</editor-fold>
            case "Finish move":{
                switch (languge) {
                    case ENGLISH:
                        return "Finish move";
                    case СРПСКИ:
                        return "Заврши потез";
                    case DEUTSCH:
                        return "Ziel bewegen";
                    case ITALIANO:
                        return "Finitura mossa";
                    case HRVATSKI:
                        return "Završi potez";
                    case SLOVENČINA:
                        return "Konča poteza";
                    default:
                        return "Language not inputed";
                }
            }
            case "Player ":{
                switch (languge) {
                    case ENGLISH:
                        return "Player ";
                    case СРПСКИ:
                        return "Играч ";
                    case DEUTSCH:
                        return "Spieler ";
                    case ITALIANO:
                        return "Giocatore ";
                    case HRVATSKI:
                        return "Igrač ";
                    case SLOVENČINA:
                        return "Igralec ";
                    default:
                        return "Language not inputed";
                }
            }
            case " won":{
                switch (languge) {
                    case ENGLISH:
                        return " won";
                    case СРПСКИ:
                        return " је побједио";
                    case DEUTSCH:
                        return " gewonnen";
                    case ITALIANO:
                        return " ha vinto";
                    case HRVATSKI:
                        return " je pobjedio";
                    case SLOVENČINA:
                        return " je zmagal";
                    default:
                        return "Language not inputed";
                }
            }
            case "Want to play again?":{
                switch (languge) {
                    case ENGLISH:
                        return "Want to play again?";
                    case СРПСКИ:
                        return "Желите играти опет?";
                    case DEUTSCH:
                        return "Wollen Sie wieder zu spielen?";
                    case ITALIANO:
                        return "Vuoi giocare di nuovo?";
                    case HRVATSKI:
                        return "Želite igrati opet?";
                    case SLOVENČINA:
                        return "Želite ponovno igrati?";
                    default:
                        return "Language not inputed";
                }
            }
            case "QUESTION ?":{
                switch (languge) {
                    case ENGLISH:
                        return "QUESTION ?";
                    case СРПСКИ:
                        return "Питање ?";
                    case DEUTSCH:
                        return "Frage ?";
                    case ITALIANO:
                        return "Domanda ?";
                    case HRVATSKI:
                        return "Pitanje ?";
                    case SLOVENČINA:
                        return "Vprašanje ?";
                    default:
                        return "Language not inputed";
                }
            }
            case "Are you sure you want to cancel this game":{
                switch (languge) {
                    case ENGLISH:
                        return "Are you sure you want to cancel this game";
                    case СРПСКИ:
                        return "Да ли сте сигурни да желите да прекинете игру";
                    case DEUTSCH:
                        return "Bist du sicher, dass du dieses Spiel abbrechen möchten";
                    case ITALIANO:
                        return "Sei sicuro di voler annullare questo gioco";
                    case HRVATSKI:
                        return "Da li ste sigurni da želite da prekinete igru";
                    case SLOVENČINA:
                        return "Ali ste prepričani, da želite preklicati to igro";
                    default:
                        return "Language not inputed";
                }
            }
            case " and change language?":{
                switch (languge) {
                    case ENGLISH:
                        return " and change language?";
                    case СРПСКИ:
                        return " и промјенити језик?";
                    case DEUTSCH:
                        return " und die Sprache ändern?";
                    case ITALIANO:
                        return " e cambiare la lingua?";
                    case HRVATSKI:
                        return " i promjeniti jezik?";
                    case SLOVENČINA:
                        return " in spremeniti jezik?";
                    default:
                        return "Language not inputed";
                }
            }
            default:
                return "Text not recognized";
        }
    }
}