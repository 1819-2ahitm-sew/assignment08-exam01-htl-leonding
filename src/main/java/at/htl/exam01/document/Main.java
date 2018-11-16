package at.htl.exam01.document;

public class Main {

    /**
     *
     * Führen Sie hier folgendes durch:
     *
     * 1. Erstellen Sie 2 Bücher und ein email
     *    Buch: "Rowlings", "Harry Potter und der Stein der Weisen"
     *    Email: "Susi", "Bewerbung", "CoolCompany"
     *    Buch: "Tolkien", "lordOfTheRings"
     *
     * 2. Erstellen Sie ein Document-Array und speichern Sie obige Dokumente in diesem Array.
     *
     * 3. Geben Sir die Inhalte dieser Documente wie folgt aus.
     *    Nutzen Sie dabei die Mechanismen der Vererbung.
     *    Erstellen Sie außerdem geeignete toString-Methoden
     *
     * 4. Zählen Sie die Bücher und emails im Array und geben Sie die jeweilige Anzahl aus.
     *
     * @param args
     */
    public static void main(String[] args) {

        Book b1 = new Book("Rowlings", "Harry Potter und der Stein der Weisen");
        Email m1 = new Email("Susi", "Bewerbung", "CoolCompany");
        Book b2 = new Book("Tolkien", "lordOfTheRings");

        Document[] docs = new Document[3];
        docs[0] = b1;
        docs[1] = m1;
        docs[2] = b2;

        int bookNo = 0;
        int emailNo = 0;
        for (int i = 0; i < docs.length; i++) {
            System.out.println(docs[i]);
            if (docs[i] instanceof Book) {
                bookNo++;
            } else {
                emailNo++;
            }
        }

        System.out.println("\nBooks = " + bookNo);
        System.out.println("Emails = " + emailNo);


    }


}
