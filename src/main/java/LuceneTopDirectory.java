import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

import java.io.IOException;

public class LuceneTopDirectory {

    private static final Directory directory = new RAMDirectory();

    public static Directory getDirectory(){
        return directory;
    }

    public static IndexWriter getIndexWriter() throws IOException {
        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        /*if (create){
            config.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
        }else {
            config.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
        }*/

        return new IndexWriter(directory, config);
    }

}
