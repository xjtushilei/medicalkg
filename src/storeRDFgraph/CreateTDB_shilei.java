package storeRDFgraph;

import java.io.IOException;

import org.apache.jena.query.Dataset;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.tdb.TDBFactory;
import org.apache.jena.tdb.TDBLoader;
import org.apache.jena.util.FileManager;



public class CreateTDB_shilei
{
	
    public static void main(String [] args) throws IOException
    {
    	save3();
//    	save0();  //创建一个空的tdb，大小和save1和save2的结果一样
//    	save1(); //根据save0，应该没存进去
//    	save2();//根据save0，应该没存进去
//    	save3(); //肯定存进去了，因为文件明显变大了，但是不会查，不懂rdf图什么东西 ，参考 有链接：http://mail-archives.apache.org/mod_mbox/jena-users/201401.mbox/%3CCF05E62A.2F467%25rvesse@dotnetrdf.org%3E
    }
    public static void save0() {
    	String directory = "C:\\RDFdata\\Database0\\";
        Dataset ds = TDBFactory.createDataset(directory);
        ds.end();
        System.out.println("done");
	}
    public static void save1() {
    	String directory = "C:\\RDFdata\\Database1\\";
        Dataset ds = TDBFactory.createDataset(directory);
        Model model = ds.getDefaultModel();//这里使用TDB的默认Model
        String source = "C:\\RDFdata\\source\\drugs.nq";
        TDBLoader.loadModel(model, source); 
        ds.end();
        System.out.println("done");
	}
    public static void save2() {
    	String directory = "C:\\RDFdata\\Database2\\";
        Dataset ds = TDBFactory.createDataset(directory);
        Model model = ds.getDefaultModel();//这里使用TDB的默认Model
        FileManager.get().readModel(model, "C:\\RDFdata\\source\\drugs.nq");
        ds.end();
        System.out.println("done");
	}
    
    public static void save3()  {
		Dataset ds = TDBFactory.createDataset("D:\\RDFdata\\1\\");
		String filename = "D://rdf.nt2";
		RDFDataMgr.read(ds, filename,Lang.N3);
		ds.close();
		System.out.println(" done"); 
	}
//    public static void save3()  {
//		Dataset ds = TDBFactory.createDataset("C:\\RDFdata\\Database3\\");
//		String filename = "C:\\RDFdata\\source\\drugs.nq";
//		RDFDataMgr.read(ds, filename,Lang.NQUADS);
//		ds.close();
//		System.out.println(" done"); 
//	}
//    public static void save4()  {
//		Dataset ds = TDBFactory.createDataset("C:\\RDFdata\\Database5\\");
//		String filename = "D:\\RDFdata\\elastic_sparql_demo_data.nt\\bsbm-generated-dataset.nq";
//		RDFDataMgr.read(ds, filename,Lang.NQUADS);
//		ds.close();
//		System.out.println(" done"); 
//	}
 
}