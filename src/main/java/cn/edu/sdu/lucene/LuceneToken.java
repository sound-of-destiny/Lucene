package cn.edu.sdu.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.util.ArrayList;

public class LuceneToken {
    public ArrayList<String> getTokenString(String q) {
        ArrayList<String> st = new ArrayList<>();
        try {
            Analyzer ana = new StandardAnalyzer();
            TokenStream ts = ana.tokenStream("", q);
            ts.reset();
            CharTermAttribute term = ts.getAttribute(CharTermAttribute.class);
            while (ts.incrementToken()) {
                st.add(term.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }
}
