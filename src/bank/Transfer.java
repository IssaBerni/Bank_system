package bank;

/**
 * Klasse für Überweisungen.
 * Erbt von Transaction.
 */
public class Transfer extends Transaction {

    /**
     * Sender der Überweisung
     */
    private String sender;

    /**
     * Empfänger der Überweisung
     */
    private String recipient;

    /**
     * Konstruktor mit date, amount und description
     * @param date Datum
     * @param amount Betrag (nur positiv erlaubt)
     * @param description Beschreibung
     */
    public Transfer(String date, double amount, String description) {
        super(date, amount, description);
        // Validierung: nur positive Beträge erlaubt
        if (amount < 0) {
            System.out.println("Fehler: Transfer-Betrag muss positiv sein!");
        }
        this.sender = "";
        this.recipient = "";
    }

    /**
     * Konstruktor mit allen Parametern
     * @param date Datum
     * @param amount Betrag
     * @param description Beschreibung
     * @param sender Sender
     * @param recipient Empfänger
     */
    public Transfer(String date, double amount, String description,
                    String sender, String recipient) {
        this(date, amount, description); // ruft ersten Konstruktor auf
        this.sender = sender;
        this.recipient = recipient;
    }

    /**
     * Copy-Konstruktor
     * @param other zu kopierendes Transfer-Objekt
     */
    public Transfer(Transfer other) {
        super(other);
        this.sender = other.sender;
        this.recipient = other.recipient;
    }

    // Getter
    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    // Setter
    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    /**
     * Berechnet den Betrag
     * Bei Transfer keine Gebühren, daher wird amount unverändert zurückgegeben
     * @return Betrag ohne Änderungen
     */
    @Override
    public double calculate() {
        return amount;
    }

    /**
     * String-Repräsentation
     * @return String mit allen Infos
     */
    @Override
    public String toString() {
        return "Transfer: " + super.toString() +
                ", Sender: " + sender +
                ", Empfänger: " + recipient +
                ", Berechneter Betrag: " + calculate();
    }

    /**
     * Vergleicht Transfer-Objekte
     * @param obj Objekt zum Vergleichen
     * @return true falls gleich
     */
    @Override
    public boolean equals(Object obj) {
        // zuerst Parent checken
        if (!super.equals(obj)) {
            return false;
        }

        Transfer other = (Transfer) obj;
        // dann eigene Attribute
        return sender.equals(other.sender) &&
                recipient.equals(other.recipient);
    }
}