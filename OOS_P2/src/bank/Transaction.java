package bank;

/**
 * Abstrakte Basisklasse für alle Transaktionen.
 * Enthält gemeinsame Attribute und Methoden.
 */
public abstract class Transaction implements CalculateBill {

    /**
     * Datum der Transaktion im Format DD.MM.YYYY
     */
    protected String date;

    /**
     * Betrag der Transaktion
     */
    protected double amount;

    /**
     * Beschreibung der Transaktion
     */
    protected String description;

    /**
     * Konstruktor mit allen gemeinsamen Parametern
     * @param date Datum
     * @param amount Betrag
     * @param description Beschreibung
     */
    public Transaction(String date, double amount, String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    /**
     * Copy-Konstruktor
     * @param other zu kopierendes Transaction-Objekt
     */
    public Transaction(Transaction other) {
        this.date = other.date;
        this.amount = other.amount;
        this.description = other.description;
    }

    // Getter
    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    // Setter
    public void setDate(String date) {
        this.date = date;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Abstrakte Methode zur Berechnung - muss in Subklassen implementiert werden
     * @return berechneter Betrag
     */
    @Override
    public abstract double calculate();

    /**
     * Gibt String-Repräsentation zurück
     * @return String mit allen Attributen
     */
    @Override
    public String toString() {
        return "Datum: " + date + ", Betrag: " + amount + ", Beschreibung: " + description;
    }

    /**
     * Vergleicht zwei Transaction-Objekte
     * @param obj zu vergleichendes Objekt
     * @return true wenn gleich, sonst false
     */
    @Override
    public boolean equals(Object obj) {
        // prüfen ob null oder andere Klasse
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Transaction other = (Transaction) obj;
        // alle Attribute vergleichen
        return Double.compare(amount, other.amount) == 0 &&
                date.equals(other.date) &&
                description.equals(other.description);
    }
}