public class Main {
    public static void main(String[] args) {
        Document doc1 = new Document(1, "Документ 1");
        Document doc2 = new Document(2, "Документ 2");

        doc1.addRelatedDocument(doc2);
        doc2.addRelatedDocument(doc1);

        new Thread(() -> doc1.edit()).start();
        new Thread(() -> doc2.edit()).start();
    }
}