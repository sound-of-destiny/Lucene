import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;

public class LuceneSearch {
    public void Query(String keyword){
        try {
            DirectoryReader ireader = DirectoryReader.open(LuceneTopDirectory.getDirectory());
            IndexSearcher isearcher = new IndexSearcher(ireader);
            Analyzer analyzer = new StandardAnalyzer();
            QueryParser parser = new QueryParser("descripcion", analyzer);
            Query query = parser.parse(keyword);
            ScoreDoc[] hits = isearcher.search(query, 1000).scoreDocs;
            System.out.println(hits.length);

            for (int i = 0; i < hits.length; i++) {
                Document hitDoc = isearcher.doc(hits[i].doc);
                System.out.println(hitDoc.get("descripcion"));
                //assertEquals("This is the text to be indexed.", hitDoc.get("fieldname"));
            }
            ireader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
