package cn.edu.sdu.lucene;

import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.spell.LuceneDictionary;
import org.apache.lucene.search.suggest.Lookup.LookupResult;
import org.apache.lucene.search.suggest.analyzing.AnalyzingInfixSuggester;

import java.util.ArrayList;
import java.util.List;

public class LuceneSuggest extends LuceneRAMDirectory {

    public void reSetSuggest() {
        try {
            IndexReader ireader = DirectoryReader.open(getDirectory());
            AnalyzingInfixSuggester suggester = getSuggest();
            suggester.build(new LuceneDictionary(ireader, "descripcion"));
            suggester.build(new LuceneDictionary(ireader, "codigo"));
            suggester.build(new LuceneDictionary(ireader, "nickName"));
            suggester.build(new LuceneDictionary(ireader, "razon"));
            suggester.build(new LuceneDictionary(ireader, "nombre"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getSuggest(String keyword) {
        List<String> res = new ArrayList<>();
        try {
            List<LookupResult> sug = getSuggest().lookup(keyword, 5, false, true);
            for (LookupResult result : sug) {
                res.add(result.key.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

}
