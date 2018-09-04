package cn.edu.sdu.lucene;

import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;

import java.io.IOException;

public class LuceneIndex extends LuceneRAMDirectory {

    public void deleteIndex(String field, String keyword) throws IOException {
        IndexWriter iwriter = getIndexWriter();
        Term term = new Term(field, keyword);
        iwriter.deleteDocuments(term);
        iwriter.close();
    }

}
