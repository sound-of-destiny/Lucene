package cn.edu.sdu.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;

import java.io.IOException;
import java.util.ArrayList;

public class LuceneSearch extends LuceneRAMDirectory{
    public void Query(String keyword) {
        try {
            DirectoryReader ireader = DirectoryReader.open(getDirectory());
            IndexSearcher isearcher = new IndexSearcher(ireader);
            Analyzer analyzer = new StandardAnalyzer();
            QueryParser parser = new QueryParser("descripcion", analyzer);
            Query query = parser.parse(keyword);
            ScoreDoc[] hits = isearcher.search(query, 1000).scoreDocs;
            System.out.println(hits.length);

            for (int i = 0; i < hits.length; i++) {
                Document hitDoc = isearcher.doc(hits[i].doc);
                System.out.println(hitDoc.get("descripcion"));
            }
            ireader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Document> QueryTerm(String field, String keyword) throws IOException {
        ArrayList<Document> docList = new ArrayList<>();
        DirectoryReader ireader = DirectoryReader.open(getDirectory());
        IndexSearcher isearcher = new IndexSearcher(ireader);
        Term commodity = new Term(field, keyword);
        TermQuery query = new TermQuery(commodity);
        ScoreDoc[] hits = isearcher.search(query, 1000).scoreDocs;
        for (ScoreDoc hit : hits) {
            Document doc = isearcher.doc(hit.doc);
            docList.add(doc);
        }
        return docList;
    }

    public ArrayList<Document> multiFieldQuery(String[] fields, String keyword) throws Exception {
        ArrayList<Document> docList = new ArrayList<>();
        DirectoryReader ireader = DirectoryReader.open(getDirectory());
        IndexSearcher isearcher = new IndexSearcher(ireader);
        Analyzer analyzer = new StandardAnalyzer();
        QueryParser parser = new MultiFieldQueryParser(fields, analyzer);
        Query query = parser.parse(keyword);
        ScoreDoc[] hits = isearcher.search(query, 1000).scoreDocs;
        for (ScoreDoc hit : hits) {
            Document doc = isearcher.doc(hit.doc);
            docList.add(doc);
        }
        ireader.close();
        return docList;
    }
}
