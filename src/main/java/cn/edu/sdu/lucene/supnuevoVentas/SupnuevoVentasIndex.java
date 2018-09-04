package cn.edu.sdu.lucene.supnuevoVentas;

import cn.edu.sdu.lucene.LuceneIndex;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class SupnuevoVentasIndex extends LuceneIndex {
    public void updateIndexCommodity(ArrayList<Document> docList, HashMap<String, String> map) throws IOException {
        IndexWriter iwriter = getIndexWriter();
        for (Document doc : docList) {
            Document newDoc = new Document();
            newDoc.add(doc.getField("priceId"));
            newDoc.add(doc.getField("ventasId"));
            newDoc.add(doc.getField("commodityId"));
            newDoc.add(doc.getField("codigoEntreno"));
            newDoc.add(doc.getField("price"));
            newDoc.add(doc.getField("priceBulto1"));
            newDoc.add(doc.getField("priceBulto2"));
            newDoc.add(doc.getField("priceBulto3"));
            newDoc.add(doc.getField("priceBulto4"));
            newDoc.add(doc.getField("priceBulto5"));
            newDoc.add(doc.getField("imageAttachId"));
            newDoc.add(doc.getField("orderNum"));
            newDoc.add(doc.getField("modifyTime"));

            newDoc.add(doc.getField("nickName"));
            newDoc.add(doc.getField("razon"));
            newDoc.add(doc.getField("nombre"));
            newDoc.add(doc.getField("cuit"));
            newDoc.add(doc.getField("contrato"));
            newDoc.add(doc.getField("desde"));
            newDoc.add(doc.getField("hasta"));
            newDoc.add(doc.getField("email"));
            newDoc.add(doc.getField("pagina"));
            newDoc.add(doc.getField("direccion"));
            newDoc.add(doc.getField("cityId"));
            newDoc.add(doc.getField("telefono"));
            newDoc.add(doc.getField("principalContactos"));
            newDoc.add(doc.getField("ropietario"));
            newDoc.add(doc.getField("rubroDes"));
            newDoc.add(doc.getField("deliverDes"));
            newDoc.add(doc.getField("observaciones"));
            newDoc.add(doc.getField("ventasPlanId"));
            newDoc.add(doc.getField("commodityOrderNum"));
            newDoc.add(doc.getField("attachIds"));
            newDoc.add(doc.getField("searchMode"));
            newDoc.add(doc.getField("longitude"));
            newDoc.add(doc.getField("latitude"));

            newDoc.add(new TextField("descripcion", map.get("descripcion"), Field.Store.YES));
            newDoc.add(new TextField("codigo", map.get("codigo"), Field.Store.YES));
            newDoc.add(new TextField("catalogId", map.get("catalogId"), Field.Store.YES));
            newDoc.add(new TextField("tamano", map.get("tamano"), Field.Store.YES));

            newDoc.add(new TextField("codigoBulto1", map.get("codigoBulto1"), Field.Store.YES));
            newDoc.add(new TextField("tamanoBulto1", map.get("tamanoBulto1"), Field.Store.YES));
            newDoc.add(new TextField("codigoBulto2", map.get("codigoBulto2"), Field.Store.YES));
            newDoc.add(new TextField("tamanoBulto2", map.get("tamanoBulto2"), Field.Store.YES));
            newDoc.add(new TextField("codigoBulto3", map.get("codigoBulto3"), Field.Store.YES));
            newDoc.add(new TextField("tamanoBulto3", map.get("tamanoBulto3"), Field.Store.YES));
            newDoc.add(new TextField("codigoBulto4", map.get("codigoBulto4"), Field.Store.YES));
            newDoc.add(new TextField("tamanoBulto4", map.get("tamanoBulto4"), Field.Store.YES));
            newDoc.add(new TextField("codigoBulto5", map.get("codigoBulto5"), Field.Store.YES));
            newDoc.add(new TextField("tamanoBulto6", map.get("tamanoBulto5"), Field.Store.YES));

            newDoc.add(new TextField("imageAttachId1", map.get("imageAttachId1"), Field.Store.YES));
            newDoc.add(new TextField("imageUseCount1", map.get("imageUseCount1"), Field.Store.YES));
            newDoc.add(new TextField("imageAttachId2", map.get("imageAttachId2"), Field.Store.YES));
            newDoc.add(new TextField("imageUseCount2", map.get("imageUseCount2"), Field.Store.YES));
            newDoc.add(new TextField("imageAttachId3", map.get("imageAttachId3"), Field.Store.YES));
            newDoc.add(new TextField("imageUseCount3", map.get("imageUseCount3"), Field.Store.YES));
            newDoc.add(new TextField("imageAttachId4", map.get("imageAttachId4"), Field.Store.YES));
            newDoc.add(new TextField("imageUseCount4", map.get("imageUseCount4"), Field.Store.YES));
            newDoc.add(new TextField("imageAttachId5", map.get("imageAttachId5"), Field.Store.YES));
            newDoc.add(new TextField("imageUseCount5", map.get("imageUseCount5"), Field.Store.YES));
            iwriter.addDocument(newDoc);
        }
        iwriter.close();
    }

    public void updateIndexVentas(ArrayList<Document> docList, HashMap<String, String> map) throws IOException {
        IndexWriter iwriter = getIndexWriter();
        for (Document doc : docList) {
            Document newDoc = new Document();
            newDoc.add(doc.getField("priceId"));
            newDoc.add(doc.getField("ventasId"));
            newDoc.add(doc.getField("commodityId"));
            newDoc.add(doc.getField("codigoEntreno"));
            newDoc.add(doc.getField("price"));
            newDoc.add(doc.getField("priceBulto1"));
            newDoc.add(doc.getField("priceBulto2"));
            newDoc.add(doc.getField("priceBulto3"));
            newDoc.add(doc.getField("priceBulto4"));
            newDoc.add(doc.getField("priceBulto5"));
            newDoc.add(doc.getField("imageAttachId"));
            newDoc.add(doc.getField("orderNum"));
            newDoc.add(doc.getField("modifyTime"));

            newDoc.add(doc.getField("descripcion"));
            newDoc.add(doc.getField("codigo"));
            newDoc.add(doc.getField("catalogId"));
            newDoc.add(doc.getField("tamano"));
            newDoc.add(doc.getField("codigoBulto1"));
            newDoc.add(doc.getField("tamanoBulto1"));
            newDoc.add(doc.getField("codigoBulto2"));
            newDoc.add(doc.getField("tamanoBulto2"));
            newDoc.add(doc.getField("codigoBulto3"));
            newDoc.add(doc.getField("tamanoBulto3"));
            newDoc.add(doc.getField("codigoBulto4"));
            newDoc.add(doc.getField("tamanoBulto4"));
            newDoc.add(doc.getField("codigoBulto5"));
            newDoc.add(doc.getField("tamanoBulto5"));
            newDoc.add(doc.getField("imageAttachId1"));
            newDoc.add(doc.getField("imageUseCount1"));
            newDoc.add(doc.getField("imageAttachId2"));
            newDoc.add(doc.getField("imageUseCount2"));
            newDoc.add(doc.getField("imageAttachId3"));
            newDoc.add(doc.getField("imageUseCount3"));
            newDoc.add(doc.getField("imageAttachId4"));
            newDoc.add(doc.getField("imageUseCount4"));
            newDoc.add(doc.getField("imageAttachId5"));
            newDoc.add(doc.getField("imageUseCount5"));

            newDoc.add(new TextField("nickName", map.get("nickName"), Field.Store.YES));
            newDoc.add(new TextField("razon", map.get("razon"), Field.Store.YES));
            newDoc.add(new TextField("nombre", map.get("nombre"), Field.Store.YES));
            newDoc.add(new TextField("cuit", map.get("cuit"), Field.Store.YES));

            newDoc.add(new TextField("contrato", map.get("contrato"), Field.Store.YES));
            newDoc.add(new TextField("desde", map.get("desde"), Field.Store.YES));
            newDoc.add(new TextField("hasta", map.get("hasta"), Field.Store.YES));
            newDoc.add(new TextField("email", map.get("email"), Field.Store.YES));
            newDoc.add(new TextField("pagina", map.get("pagina"), Field.Store.YES));
            newDoc.add(new TextField("direccion", map.get("direccion"), Field.Store.YES));
            newDoc.add(new TextField("cityId", map.get("cityId"), Field.Store.YES));
            newDoc.add(new TextField("telefono", map.get("telefono"), Field.Store.YES));
            newDoc.add(new TextField("principalContactos", map.get("principalContactos"), Field.Store.YES));
            newDoc.add(new TextField("ropietario", map.get("ropietario"), Field.Store.YES));

            newDoc.add(new TextField("rubroDes", map.get("rubroDes"), Field.Store.YES));
            newDoc.add(new TextField("deliverDes", map.get("deliverDes"), Field.Store.YES));
            newDoc.add(new TextField("observaciones", map.get("observaciones"), Field.Store.YES));
            newDoc.add(new TextField("ventasPlanId", map.get("ventasPlanId"), Field.Store.YES));
            newDoc.add(new TextField("commodityOrderNum", map.get("commodityOrderNum"), Field.Store.YES));
            newDoc.add(new TextField("attachIds", map.get("attachIds"), Field.Store.YES));
            newDoc.add(new TextField("searchMode", map.get("searchMode"), Field.Store.YES));
            newDoc.add(new TextField("longitude", map.get("longitude"), Field.Store.YES));
            newDoc.add(new TextField("latitude", map.get("latitude"), Field.Store.YES));

            iwriter.addDocument(newDoc);
        }
        iwriter.close();
    }

    public void updateCommodityIndex(HashMap<String, String> map) {
        try {
            SupnuevoVentasSearch ls = new SupnuevoVentasSearch();
            ArrayList<Document> docList = ls.QueryCommodityId(map.get("commodityId"));
            deleteIndex("commodityId", map.get("commodityId"));
            updateIndexCommodity(docList, map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateVentasIndex(HashMap<String, String> map) {
        try {
            SupnuevoVentasSearch ls = new SupnuevoVentasSearch();
            ArrayList<Document> docList = ls.QueryVentasId(map.get("ventasId"));
            deleteIndex("ventasId", map.get("ventasId"));
            updateIndexVentas(docList, map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addIndex(HashMap<String, String> map) {
        try {
            IndexWriter iwriter = getIndexWriter();
            Document doc = new Document();
            doc.add(new Field("priceId", String.valueOf(map.get("priceId")), TextField.TYPE_STORED));
            doc.add(new Field("ventasId", String.valueOf(map.get("ventasId")), TextField.TYPE_STORED));
            doc.add(new Field("commodityId", String.valueOf(map.get("commodityId")), TextField.TYPE_STORED));
            doc.add(new Field("codigoEntreno", String.valueOf(map.get("codigoEntreno")), TextField.TYPE_STORED));
            doc.add(new Field("price", String.valueOf(map.get("price")), TextField.TYPE_STORED));
            doc.add(new Field("priceBulto1", String.valueOf(map.get("priceBulto1")), TextField.TYPE_STORED));
            doc.add(new Field("priceBulto2", String.valueOf(map.get("priceBulto2")), TextField.TYPE_STORED));
            doc.add(new Field("priceBulto3", String.valueOf(map.get("priceBulto3")), TextField.TYPE_STORED));
            doc.add(new Field("priceBulto4", String.valueOf(map.get("priceBulto4")), TextField.TYPE_STORED));
            doc.add(new Field("priceBulto5", String.valueOf(map.get("priceBulto5")), TextField.TYPE_STORED));
            doc.add(new Field("imageAttachId", String.valueOf(map.get("imageAttachId")), TextField.TYPE_STORED));
            doc.add(new Field("orderNum", String.valueOf(map.get("orderNum")), TextField.TYPE_STORED));
            doc.add(new Field("modifyTime", String.valueOf(map.get("modifyTime")), TextField.TYPE_STORED));

            doc.add(new TextField("descripcion", map.get("descripcion"), Field.Store.YES));
            doc.add(new TextField("codigo", map.get("codigo"), Field.Store.YES));
            doc.add(new TextField("catalogId", map.get("catalogId"), Field.Store.YES));
            doc.add(new TextField("tamano", map.get("tamano"), Field.Store.YES));

            doc.add(new TextField("codigoBulto1", map.get("codigoBulto1"), Field.Store.YES));
            doc.add(new TextField("tamanoBulto1", map.get("tamanoBulto1"), Field.Store.YES));
            doc.add(new TextField("codigoBulto2", map.get("codigoBulto2"), Field.Store.YES));
            doc.add(new TextField("tamanoBulto2", map.get("tamanoBulto2"), Field.Store.YES));
            doc.add(new TextField("codigoBulto3", map.get("codigoBulto3"), Field.Store.YES));
            doc.add(new TextField("tamanoBulto3", map.get("tamanoBulto3"), Field.Store.YES));
            doc.add(new TextField("codigoBulto4", map.get("codigoBulto4"), Field.Store.YES));
            doc.add(new TextField("tamanoBulto4", map.get("tamanoBulto4"), Field.Store.YES));
            doc.add(new TextField("codigoBulto5", map.get("codigoBulto5"), Field.Store.YES));
            doc.add(new TextField("tamanoBulto6", map.get("tamanoBulto5"), Field.Store.YES));

            doc.add(new TextField("imageAttachId1", map.get("imageAttachId1"), Field.Store.YES));
            doc.add(new TextField("imageUseCount1", map.get("imageUseCount1"), Field.Store.YES));
            doc.add(new TextField("imageAttachId2", map.get("imageAttachId2"), Field.Store.YES));
            doc.add(new TextField("imageUseCount2", map.get("imageUseCount2"), Field.Store.YES));
            doc.add(new TextField("imageAttachId3", map.get("imageAttachId3"), Field.Store.YES));
            doc.add(new TextField("imageUseCount3", map.get("imageUseCount3"), Field.Store.YES));
            doc.add(new TextField("imageAttachId4", map.get("imageAttachId4"), Field.Store.YES));
            doc.add(new TextField("imageUseCount4", map.get("imageUseCount4"), Field.Store.YES));
            doc.add(new TextField("imageAttachId5", map.get("imageAttachId5"), Field.Store.YES));
            doc.add(new TextField("imageUseCount5", map.get("imageUseCount5"), Field.Store.YES));

            doc.add(new TextField("nickName", map.get("nickName"), Field.Store.YES));
            doc.add(new TextField("razon", map.get("razon"), Field.Store.YES));
            doc.add(new TextField("nombre", map.get("nombre"), Field.Store.YES));
            doc.add(new TextField("cuit", map.get("cuit"), Field.Store.YES));

            doc.add(new TextField("contrato", map.get("contrato"), Field.Store.YES));
            doc.add(new TextField("desde", map.get("desde"), Field.Store.YES));
            doc.add(new TextField("hasta", map.get("hasta"), Field.Store.YES));
            doc.add(new TextField("email", map.get("email"), Field.Store.YES));
            doc.add(new TextField("pagina", map.get("pagina"), Field.Store.YES));
            doc.add(new TextField("direccion", map.get("direccion"), Field.Store.YES));
            doc.add(new TextField("cityId", map.get("cityId"), Field.Store.YES));
            doc.add(new TextField("telefono", map.get("telefono"), Field.Store.YES));
            doc.add(new TextField("principalContactos", map.get("principalContactos"), Field.Store.YES));
            doc.add(new TextField("ropietario", map.get("ropietario"), Field.Store.YES));

            doc.add(new TextField("rubroDes", map.get("rubroDes"), Field.Store.YES));
            doc.add(new TextField("deliverDes", map.get("deliverDes"), Field.Store.YES));
            doc.add(new TextField("observaciones", map.get("observaciones"), Field.Store.YES));
            doc.add(new TextField("ventasPlanId", map.get("ventasPlanId"), Field.Store.YES));
            doc.add(new TextField("commodityOrderNum", map.get("commodityOrderNum"), Field.Store.YES));
            doc.add(new TextField("attachIds", map.get("attachIds"), Field.Store.YES));
            doc.add(new TextField("searchMode", map.get("searchMode"), Field.Store.YES));
            doc.add(new TextField("longitude", map.get("longitude"), Field.Store.YES));
            doc.add(new TextField("latitude", map.get("latitude"), Field.Store.YES));
            iwriter.addDocument(doc);
            iwriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
