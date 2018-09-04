package cn.edu.sdu.lucene;

import cn.edu.sdu.lucene.supnuevoVentas.SupnuevoVentasSearch;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.spell.LevenshteinDistance;
import org.apache.lucene.search.spell.LuceneDictionary;
import org.apache.lucene.search.spell.SpellChecker;
import org.apache.lucene.search.suggest.analyzing.AnalyzingInfixSuggester;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class TestMain {
    static {
        try {
            LuceneRAMDirectory lrd = new LuceneRAMDirectory();
            IndexWriter iwriter = lrd.getIndexWriter();
            Connection conn = LuceneUtils.openDb();
            Statement stm = conn.createStatement();
            String sql = "select a.priceId, a.ventasId, a.commodityId, a.codigoEntreno, a.price, a.priceBulto1, a.priceBulto2, "
                    + "a.priceBulto3, a.priceBulto4, a.priceBulto5 , a.imageAttachId, a.orderNum, a.modifyTime, "
                    + "b.descripcion, b.codigo, b.catalogId, b.tamano, b.codigoBulto1, b.tamanoBulto1, b.codigoBulto2, "
                    + "b.tamanoBulto2, b.codigoBulto3, b.tamanoBulto3, b.codigoBulto4, b.tamanoBulto4, b.codigoBulto5, b.tamanoBulto5, "
                    + "b.imageAttachId1, b.imageUseCount1, b.imageAttachId2, b.imageUseCount2, b.imageAttachId3, b.imageUseCount3, b.imageAttachId4, "
                    + "b.imageUseCount4, b.imageAttachId5, b.imageUseCount5, "
                    + "c.nickName, c.razon,  c.nombre, c.cuit, c.contrato, c.desde, c.hasta, c.email, c.pagina, c.direccion, c.cityId, c.telefono,"
                    + "c.principalContactos, c.ropietario, c.rubroDes, c.deliverDes, c.observaciones, c.ventasPlanId, c.commodityOrderNum, c.attachIds, c.searchMode, c.longitude, c.latitude "
                    + "from supnuevo_ventas_commodity_price a, supnuevo_ventas_commodity b, supnuevo_ventas_info c "
                    + "where b.commodityId = a.commodityId and c.ventasId = a.ventasId";
            ResultSet res = stm.executeQuery(sql);
            int count = 0;
            while (res.next()) {
                Document doc = new Document();
                doc.add(new Field("priceId", String.valueOf(res.getObject(1)), TextField.TYPE_STORED));
                doc.add(new Field("ventasId", String.valueOf(res.getObject(2)), TextField.TYPE_STORED));
                doc.add(new Field("commodityId", String.valueOf(res.getObject(3)), TextField.TYPE_STORED));
                doc.add(new Field("codigoEntreno", String.valueOf(res.getObject(4)), TextField.TYPE_STORED));
                doc.add(new Field("price", String.valueOf(res.getObject(5)), TextField.TYPE_STORED));
                doc.add(new Field("priceBulto1", String.valueOf(res.getObject(6)), TextField.TYPE_STORED));
                doc.add(new Field("priceBulto2", String.valueOf(res.getObject(7)), TextField.TYPE_STORED));
                doc.add(new Field("priceBulto3", String.valueOf(res.getObject(8)), TextField.TYPE_STORED));
                doc.add(new Field("priceBulto4", String.valueOf(res.getObject(9)), TextField.TYPE_STORED));
                doc.add(new Field("priceBulto5", String.valueOf(res.getObject(10)), TextField.TYPE_STORED));
                doc.add(new Field("imageAttachId", String.valueOf(res.getObject(11)), TextField.TYPE_STORED));
                doc.add(new Field("orderNum", String.valueOf(res.getObject(12)), TextField.TYPE_STORED));
                doc.add(new Field("modifyTime", String.valueOf(res.getObject(13)), TextField.TYPE_STORED));

                doc.add(new Field("descripcion", String.valueOf(res.getObject(14)), TextField.TYPE_STORED));
                doc.add(new Field("codigo", String.valueOf(res.getObject(15)), TextField.TYPE_STORED));
                doc.add(new Field("catalogId", String.valueOf(res.getObject(16)), TextField.TYPE_STORED));
                doc.add(new Field("codigoBulto1", String.valueOf(res.getObject(17)), TextField.TYPE_STORED));
                doc.add(new Field("tamanoBulto1", String.valueOf(res.getObject(18)), TextField.TYPE_STORED));
                doc.add(new Field("codigoBulto2", String.valueOf(res.getObject(19)), TextField.TYPE_STORED));
                doc.add(new Field("tamanoBulto2", String.valueOf(res.getObject(20)), TextField.TYPE_STORED));
                doc.add(new Field("codigoBulto3", String.valueOf(res.getObject(21)), TextField.TYPE_STORED));
                doc.add(new Field("tamanoBulto3", String.valueOf(res.getObject(22)), TextField.TYPE_STORED));
                doc.add(new Field("codigoBulto4", String.valueOf(res.getObject(23)), TextField.TYPE_STORED));
                doc.add(new Field("tamanoBulto4", String.valueOf(res.getObject(24)), TextField.TYPE_STORED));
                doc.add(new Field("codigoBulto5", String.valueOf(res.getObject(25)), TextField.TYPE_STORED));
                doc.add(new Field("tamanoBulto5", String.valueOf(res.getObject(26)), TextField.TYPE_STORED));
                doc.add(new Field("imageAttachId1", String.valueOf(res.getObject(27)), TextField.TYPE_STORED));
                doc.add(new Field("imageUseCount1", String.valueOf(res.getObject(28)), TextField.TYPE_STORED));
                doc.add(new Field("imageAttachId2", String.valueOf(res.getObject(29)), TextField.TYPE_STORED));
                doc.add(new Field("imageUseCount2", String.valueOf(res.getObject(30)), TextField.TYPE_STORED));
                doc.add(new Field("imageAttachId3", String.valueOf(res.getObject(31)), TextField.TYPE_STORED));
                doc.add(new Field("imageUseCount3", String.valueOf(res.getObject(32)), TextField.TYPE_STORED));
                doc.add(new Field("imageAttachId4", String.valueOf(res.getObject(33)), TextField.TYPE_STORED));
                doc.add(new Field("imageUseCount4", String.valueOf(res.getObject(34)), TextField.TYPE_STORED));
                doc.add(new Field("imageAttachId5", String.valueOf(res.getObject(35)), TextField.TYPE_STORED));
                doc.add(new Field("imageUseCount5", String.valueOf(res.getObject(36)), TextField.TYPE_STORED));

                doc.add(new Field("nickName", String.valueOf(res.getObject(37)), TextField.TYPE_STORED));
                doc.add(new Field("razon", String.valueOf(res.getObject(38)), TextField.TYPE_STORED));
                doc.add(new Field("nombre", String.valueOf(res.getObject(39)), TextField.TYPE_STORED));
                doc.add(new Field("cuit", String.valueOf(res.getObject(40)), TextField.TYPE_STORED));
                doc.add(new Field("contrato", String.valueOf(res.getObject(41)), TextField.TYPE_STORED));
                doc.add(new Field("desde", String.valueOf(res.getObject(42)), TextField.TYPE_STORED));
                doc.add(new Field("hasta", String.valueOf(res.getObject(42)), TextField.TYPE_STORED));
                doc.add(new Field("email", String.valueOf(res.getObject(44)), TextField.TYPE_STORED));
                doc.add(new Field("pagina", String.valueOf(res.getObject(45)), TextField.TYPE_STORED));
                doc.add(new Field("direccion", String.valueOf(res.getObject(46)), TextField.TYPE_STORED));
                doc.add(new Field("cityId", String.valueOf(res.getObject(47)), TextField.TYPE_STORED));
                doc.add(new Field("telefono", String.valueOf(res.getObject(48)), TextField.TYPE_STORED));
                doc.add(new Field("principalContactos", String.valueOf(res.getObject(49)), TextField.TYPE_STORED));
                doc.add(new Field("ropietario", String.valueOf(res.getObject(50)), TextField.TYPE_STORED));
                doc.add(new Field("rubroDes", String.valueOf(res.getObject(51)), TextField.TYPE_STORED));
                doc.add(new Field("deliverDes", String.valueOf(res.getObject(52)), TextField.TYPE_STORED));
                doc.add(new Field("observaciones", String.valueOf(res.getObject(53)), TextField.TYPE_STORED));
                doc.add(new Field("ventasPlanId", String.valueOf(res.getObject(54)), TextField.TYPE_STORED));
                doc.add(new Field("commodityOrderNum", String.valueOf(res.getObject(55)), TextField.TYPE_STORED));
                doc.add(new Field("attachIds", String.valueOf(res.getObject(56)), TextField.TYPE_STORED));
                doc.add(new Field("searchMode", String.valueOf(res.getObject(57)), TextField.TYPE_STORED));
                doc.add(new Field("longitude", String.valueOf(res.getObject(58)), TextField.TYPE_STORED));
                doc.add(new Field("latitude", String.valueOf(res.getObject(59)), TextField.TYPE_STORED));

                iwriter.addDocument(doc);
                count++;
            }
            System.out.println(count);
            iwriter.close();
            SpellChecker spellChecker = lrd.getSpellChecker();
            IndexReader ireader = DirectoryReader.open(lrd.getDirectory());
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

            AnalyzingInfixSuggester suggester = lrd.getSuggest();
            suggester.build(new LuceneDictionary(ireader, "descripcion"));
            suggester.build(new LuceneDictionary(ireader, "codigo"));
            suggester.build(new LuceneDictionary(ireader, "nickName"));
            suggester.build(new LuceneDictionary(ireader, "razon"));
            suggester.build(new LuceneDictionary(ireader, "nombre"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            SupnuevoVentasSearch svs = new SupnuevoVentasSearch();
            LuceneSpellCheck lsc = new LuceneSpellCheck();
            LuceneRAMDirectory lrd = new LuceneRAMDirectory();
            LuceneSuggest ls = new LuceneSuggest();
            LuceneToken lt = new LuceneToken();
            String q = "tes";
            List<String> a = ls.getSuggest(q);
            ArrayList<String> ts = lt.getTokenString(q);
            ArrayList<Document> res = new ArrayList<>();
            for (String qt : ts) {
                if (!lrd.getSpellChecker().exist(qt)) {
                    res = svs.QueryCommodity(lsc.checkSpellRAM(qt));
                }
            }
            for (Document doc : res) {
                String price = doc.get("priceId");
                String temp = price;
            }
            /*SupnuevoVentasIndex li = new SupnuevoVentasIndex();
            HashMap<String, String> map = new HashMap<>();
            map.put("descripcion", "NEW CREMA");
            map.put("commodityId", "1");
            li.updateCommodityIndex(map);*/
            svs.Query("CREM");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
