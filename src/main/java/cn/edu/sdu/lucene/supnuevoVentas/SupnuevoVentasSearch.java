package cn.edu.sdu.lucene.supnuevoVentas;

import cn.edu.sdu.lucene.LuceneSearch;
import cn.edu.sdu.lucene.LuceneSpellCheck;
import cn.edu.sdu.lucene.LuceneToken;
import org.apache.lucene.document.Document;

import java.util.ArrayList;

public class SupnuevoVentasSearch extends LuceneSearch {

    public ArrayList<Document> spellQueryCommodity(String keyword) {
        ArrayList<Document> res = new ArrayList<>();
        try {
            LuceneToken lt = new LuceneToken();
            LuceneSpellCheck lsc = new LuceneSpellCheck();
            ArrayList<String> ts = lt.getTokenString(keyword);
            for (String qt : ts) {
                if (!getSpellChecker().exist(qt)) {
                    res = QueryCommodity(lsc.checkSpellRAM(qt));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public ArrayList<Document> spellQueryVentas(String keyword) {
        ArrayList<Document> res = new ArrayList<>();
        try {
            LuceneToken lt = new LuceneToken();
            LuceneSpellCheck lsc = new LuceneSpellCheck();
            ArrayList<String> ts = lt.getTokenString(keyword);
            for (String qt : ts) {
                if (!getSpellChecker().exist(qt)) {
                    res = QueryVentas(lsc.checkSpellRAM(qt));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public ArrayList<Document> QueryCommodity(String keyword) {
        ArrayList<Document> docList = new ArrayList<>();
        String[] fields = {"descripcion", "codigo"};
        try {
            docList = multiFieldQuery(fields, keyword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return docList;
    }

    public ArrayList<Document> QueryVentas(String keyword) {
        ArrayList<Document> docList = new ArrayList<>();
        String[] fields = {"nickName", "razon", "nombre"};
        try {
            docList = multiFieldQuery(fields, keyword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return docList;
    }

    public ArrayList<Document> QueryCommodityId(String commodityId) {
        ArrayList<Document> docList = new ArrayList<>();
        try {
            docList = QueryTerm("commodityId", commodityId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return docList;
    }

    public ArrayList<Document> QueryVentasId(String ventasId) {
        ArrayList<Document> docList = new ArrayList<>();
        try {
            docList = QueryTerm("ventasId", ventasId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return docList;
    }
}
