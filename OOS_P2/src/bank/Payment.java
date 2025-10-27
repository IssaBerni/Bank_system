package bank;

/**
 * Klasse für Ein- und Auszahlungen.
 * Erbt von Transaction.
 */
public class Payment extends Transaction {

    /**
     * Zinsen für Einzahlungen (0 bis 1)
     */
    private double incomingInterest;

    /**
     * Zinsen für Auszahlungen (0 bis 1)
     */
    private double outgoingInterest;

    /**
     * Konstruktor mit date, amount und description
     * @param date Datum
     * @param amount Betrag (positiv = Einzahlung, negativ = Auszahlung)
     * @param description Beschreibung
     */
    public Payment(String date, double amount, String description) {
        super(date, amount, description);
        this.incomingInterest = 0.0;
        this.outgoingInterest = 0.0;
    }

    /**
     * Konstruktor mit allen Parametern
     * @param date Datum
     * @param amount Betrag
     * @param description Beschreibung
     * @param incomingInterest Zinsen für Einzahlungen
     * @param outgoingInterest Zinsen für Auszahlungen
     */
    public Payment(String date, double amount, String description,
                   double incomingInterest, double outgoingInterest) {
        this(date, amount, description); // ruft ersten Konstruktor auf
        setIncomingInterest(incomingInterest);
        setOutgoingInterest(outgoingInterest);
    }

    /**
     * Copy-Konstruktor
     * @param other zu kopierendes Payment-Objekt
     */
    public Payment(Payment other) {
        super(other);
        this.incomingInterest = other.incomingInterest;
        this.outgoingInterest = other.outgoingInterest;
    }

    // Getter
    public double getIncomingInterest() {
        return incomingInterest;
    }

    public double getOutgoingInterest() {
        return outgoingInterest;
    }

    // Setter mit Validierung
    public void setIncomingInterest(double incomingInterest) {
        if (incomingInterest < 0 || incomingInterest > 1) {
            System.out.println("Fehler: incomingInterest muss zwischen 0 und 1 liegen!");
            return;
        }
        this.incomingInterest = incomingInterest;
    }

    public void setOutgoingInterest(double outgoingInterest) {
        if (outgoingInterest < 0 || outgoingInterest > 1) {
            System.out.println("Fehler: outgoingInterest muss zwischen 0 und 1 liegen!");
            return;
        }
        this.outgoingInterest = outgoingInterest;
    }

    /**
     * Berechnet den Betrag unter Berücksichtigung der Zinsen
     * Positiver Betrag = Einzahlung: amount * (1 - incomingInterest)
     * Negativer Betrag = Auszahlung: amount * (1 + outgoingInterest)
     * @return berechneter Betrag
     */
    @Override
    public double calculate() {
        if (amount > 0) {
            // Einzahlung - Zinsen werden abgezogen
            return amount * (1 - incomingInterest);
        } else {
            // Auszahlung - Zinsen werden hinzugefügt
            return amount * (1 + outgoingInterest);
        }
    }

    /**
     * String-Repräsentation des Payment-Objekts
     * @return String mit allen Informationen
     */
    @Override
    public String toString() {
        return "Payment: " + super.toString() +
                ", Incoming Interest: " + incomingInterest +
                ", Outgoing Interest: " + outgoingInterest +
                ", Berechneter Betrag: " + calculate();
    }

    /**
     * Vergleicht Payment-Objekte
     * @param obj zu vergleichendes Objekt
     * @return true wenn identisch, sonst false
     */
    @Override
    public boolean equals(Object obj) {
        // erst Parent-Methode aufrufen
        if (!super.equals(obj)) {
            return false;
        }

        Payment other = (Payment) obj;
        // eigene Attribute vergleichen
        return Double.compare(incomingInterest, other.incomingInterest) == 0 &&
                Double.compare(outgoingInterest, other.outgoingInterest) == 0;
    }
}