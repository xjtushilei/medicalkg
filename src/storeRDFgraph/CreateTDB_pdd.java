package storeRDFgraph;

import java.io.IOException;

import org.apache.jena.query.Dataset;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.tdb.TDBFactory;



public class CreateTDB_pdd
{
	
    public static void main(String [] args) throws IOException
    {
    	save3("age_gender");
    	save3("patients_basic");
    	save3("BMI_information");
    	save3("diagnose_icd_information");
    	save3("drug_patients");
    	save3("ddi");
//    	save3("RDF");

    	
    }



    public static void save3(String name)  {
    	System.out.println("start:"+name);
		Dataset ds = TDBFactory.createDataset("M:\\data\\rdf\\wangmeng\\jena\\");
		String filename = "M:\\data\\minic\\pdd_nt\\"+name+".nt";
		RDFDataMgr.read(ds, filename,Lang.NT);
		ds.close();
		System.out.println(" done"); 
	}

 
}