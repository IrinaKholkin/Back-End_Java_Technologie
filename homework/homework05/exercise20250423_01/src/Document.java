import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class Document {
    private final int id;
    private final String name;
    private final List<Document> relatedDocs = new ArrayList<>();

    public Document(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public synchronized void addRelatedDocument(Document doc) {
        relatedDocs.add(doc);
    }

    public void edit() {
        List<Document> docsToLock = new ArrayList<>(relatedDocs);
        docsToLock.add(this);
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " редактирует " + name);
            for (Document doc : docsToLock) {
                synchronized (doc) {
                    System.out.println(Thread.currentThread().getName() + " редактирует связанный документ " + doc.name);
                    // имитация редактирования
                }
            }
        }
    }
    public String getName() {
        return name;
    }
    public List<Document> getRelatedDocs() {
        return new ArrayList<>(relatedDocs);
    }
}
