package cn.edu.sdu.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.spell.SpellChecker;
import org.apache.lucene.search.suggest.analyzing.AnalyzingInfixSuggester;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

import java.io.IOException;

public class LuceneRAMDirectory implements LuceneTop {

    private static final Directory directory = new RAMDirectory();
    private static final Directory spellDirectory = new RAMDirectory();
    private static final Directory suggestDirectory = new RAMDirectory();

    private static SpellChecker spellChecker;
    private static AnalyzingInfixSuggester suggester;

    static {
        try {
            spellChecker = new SpellChecker(spellDirectory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static {
        try {
            suggester = new AnalyzingInfixSuggester(suggestDirectory, new StandardAnalyzer());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Directory getDirectory() {
        return directory;
    }

    public Directory getSpellDirectory() {
        return spellDirectory;
    }

    public Directory getSuggestDirectory() {
        return directory;
    }

    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

    public AnalyzingInfixSuggester getSuggest() {
        return suggester;
    }

    public IndexWriter getIndexWriter() throws IOException {
        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        config.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
        return new IndexWriter(directory, config);
    }
}
