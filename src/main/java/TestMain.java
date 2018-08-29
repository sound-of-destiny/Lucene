import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;

public class TestMain {

    public static void main(String[] args){
        try {
            LuceneSearch ls = new LuceneSearch();
            ls.Query("CREM");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
