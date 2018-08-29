import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;

import java.sql.*;

public class LuceneAuto {

    static{
        try {
            IndexWriter iwriter = LuceneTopDirectory.getIndexWriter();
            Connection conn = LuceneAuto.openDb();
            Statement stm = conn.createStatement();
            String sql = "select b.descripcion, c.nickName from supnuevo_ventas_commodity_price a,supnuevo_ventas_commodity b,supnuevo_ventas_info c " +
                        "where b.commodityId = a.commodityId and c.ventasId = a.ventasId";
            ResultSet res = stm.executeQuery(sql);
            String descripcion,nickName;
            int count = 0;
            while(res.next()){
                descripcion = res.getString(1);
                nickName = res.getString(2);
                Document doc = new Document();
                doc.add(new Field("descripcion", descripcion, TextField.TYPE_STORED));
                doc.add(new Field("nickName", nickName, TextField.TYPE_STORED));
                iwriter.addDocument(doc);
                count++;
            }
            System.out.println(count);
            iwriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static Connection openDb() {
        Connection conn = null;
        do {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/supnuevo_ventas?useSSL=true", "root",
                        "root");

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException sqle) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("数据库错误");
                }
            }
        } while (conn == null);
        return conn;
    }

}
