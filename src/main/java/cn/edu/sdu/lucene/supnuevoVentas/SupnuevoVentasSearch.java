package cn.edu.sdu.lucene.supnuevoVentas;

import java.util.ArrayList;

import org.apache.lucene.document.Document;

import cn.edu.sdu.lucene.LuceneSearch;

public class SupnuevoVentasSearch extends LuceneSearch {
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

    public ArrayList<Document> QueryCommodityId(String string) {
        ArrayList<Document> docList = new ArrayList<>();
        try {
            docList = QueryTerm("commodityId", string);
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
