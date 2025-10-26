package bank;

/**
 * Interface für Berechnung von Transaktionsbeträgen
 */
public interface CalculateBill {
    /**
     * Berechnet den finalen Betrag
     * @return berechneter Betrag
     */
    double calculate();
}