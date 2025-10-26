import bank.Payment;
import bank.Transfer;

/**
 * Main-Klasse zum Testen der Funktionalität
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("=== PAYMENT TESTS ===\n");

        // Test Payment mit Einzahlung
        Payment p1 = new Payment("01.01.2023", 1000.0, "Gehalt", 0.05, 0.1);
        System.out.println(p1);
        System.out.println("Erwartet: 950.0, Erhalten: " + p1.calculate());
        System.out.println();

        // Test Payment mit Auszahlung
        Payment p2 = new Payment("02.01.2023", -1000.0, "Bargeld", 0.05, 0.1);
        System.out.println(p2);
        System.out.println("Erwartet: -1100.0, Erhalten: " + p2.calculate());
        System.out.println();

        // Test mit nur 3 Parametern
        Payment p3 = new Payment("05.01.2023", 500.0, "Test");
        System.out.println(p3);
        System.out.println();

        // Test Copy-Konstruktor
        Payment p4 = new Payment(p1);
        System.out.println("Kopie von p1: " + p4);
        System.out.println();

        // Test equals
        System.out.println("p1.equals(p4): " + p1.equals(p4));
        System.out.println("p1.equals(p2): " + p1.equals(p2));
        System.out.println();

        System.out.println("=== TRANSFER TESTS ===\n");

        // Test Transfer mit 5 Parametern
        Transfer t1 = new Transfer("10.01.2023", 500.0, "Miete", "Alice", "Bob");
        System.out.println(t1);
        System.out.println("Erwartet: 500.0, Erhalten: " + t1.calculate());
        System.out.println();

        // Test Transfer mit 3 Parametern
        Transfer t2 = new Transfer("12.01.2023", 200.0, "Einkauf");
        System.out.println(t2);
        System.out.println();

        // Test Copy-Konstruktor
        Transfer t3 = new Transfer(t1);
        System.out.println("Kopie: " + t3);
        System.out.println();

        // Test equals
        System.out.println("t1.equals(t3): " + t1.equals(t3));
        System.out.println("t1.equals(t2): " + t1.equals(t2));
        System.out.println();

        System.out.println("=== VALIDIERUNGS-TESTS ===\n");

        // Test ungültiger Transfer-Betrag (negativ)
        System.out.println("Test: Negativer Transfer-Betrag");
        Transfer invalidTransfer = new Transfer("15.01.2023", -100.0, "Ungültig");
        System.out.println();

        // Test ungültige Zinssätze
        System.out.println("Test: Ungültige Zinssätze im Konstruktor");
        Payment invalidPayment = new Payment("20.01.2023", 500.0, "Test", 1.5, -0.1);
        System.out.println();

        // Test Setter mit ungültigen Werten
        System.out.println("Test: Ungültige Werte in Settern");
        p1.setIncomingInterest(2.0);
        p1.setOutgoingInterest(-0.5);
        System.out.println();

        System.out.println("=== ALLE TESTS ABGESCHLOSSEN ===");
    }
}