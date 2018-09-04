package cn.edu.sdu.lucene;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.spell.LevenshteinDistance;
import org.apache.lucene.search.spell.LuceneDictionary;
import org.apache.lucene.search.spell.SpellChecker;

import java.io.IOException;

public class LuceneSpellCheck extends LuceneRAMDirectory {

    public void reSetSpellChecker() {
        try {
            SpellChecker spellChecker = getSpellChecker();
            spellChecker.clearIndex();
            IndexReader ireader = DirectoryReader.open(getDirectory());
            IndexWriterConfig descripcionconfig = new IndexWriterConfig(new StandardAnalyzer());
            IndexWriterConfig codigoconfig = new IndexWriterConfig(new StandardAnalyzer());
            IndexWriterConfig nickNameconfig = new IndexWriterConfig(new StandardAnalyzer());
            IndexWriterConfig razonconfig = new IndexWriterConfig(new StandardAnalyzer());
            IndexWriterConfig nombreconfig = new IndexWriterConfig(new StandardAnalyzer());

            spellChecker.indexDictionary(new LuceneDictionary(ireader, "descripcion"), descripcionconfig, false);
            spellChecker.indexDictionary(new LuceneDictionary(ireader, "codigo"), codigoconfig, false);
            spellChecker.indexDictionary(new LuceneDictionary(ireader, "nickName"), nickNameconfig, false);
            spellChecker.indexDictionary(new LuceneDictionary(ireader, "razon"), razonconfig, false);
            spellChecker.indexDictionary(new LuceneDictionary(ireader, "nombre"), nombreconfig, false);
            spellChecker.setStringDistance(new LevenshteinDistance());
            spellChecker.setAccuracy(0.5f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String checkSpellRAM(String q) {
        if (q == null || q.isEmpty() || q.length() > LuceneUtils.keywordMaxLength) {
            return null;
        }
        try {
            SpellChecker spellChecker = getSpellChecker();
            return spellChecker.suggestSimilar(q, 3)[0];
        } catch (IOException e) {
            return null;
        }
    }

    public String checkSpellFile(String q) {
        if (q == null || q.isEmpty() || q.length() > LuceneUtils.keywordMaxLength) {
            return null;
        }
        try {
            SpellChecker spellChecker = getSpellChecker();
            return spellChecker.suggestSimilar(q, 1)[0];
        } catch (IOException e) {
            return null;
        }
    }
}
