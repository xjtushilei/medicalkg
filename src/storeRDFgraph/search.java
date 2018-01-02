package storeRDFgraph;

import java.util.List;

import org.apache.jena.query.Dataset;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.tdb.TDBFactory;
import com.github.jsonldjava.core.JsonLdError;

public class search {

	public static void main(String[] args) throws JsonLdError {
		SelectQuery();
	}

	public static void SelectQuery() {
		Dataset ds = TDBFactory.createDataset("D:\\pdd\\");
		Model model = ds.getDefaultModel();
		// Model model =
		// ds.getNamedModel("http://bio2rdf.org/pharmgkb_resource:bio2rdf.dataset.pharmgkb.R4");
		// //这里需要给出.nq文件中数据s、p、o、context的context
		// System.out.println(model.size());
		// System.out.println(model.isEmpty());

		String query111 = "SELECT distinct ?s ?drug1 ?drug2 " +
			"  WHERE { "
				+ "	 ?s  <http://www.w3.org/1999/02/22-rdf-syntax-ns#type>  <http://kmap.xjtudlc.com/pdd_data/vocabulary:Admission>. "
				+ "  ?s  <http://kmap.xjtudlc.com/pdd_data/property/take_drugbank_id>  ?drug1. "
				+ "  ?s  <http://kmap.xjtudlc.com/pdd_data/property/take_drugbank_id>  ?drug2. "
				+ " ?drug1  <http://kmap.xjtudlc.com/pdd_data/property/interact>  ?drug2 "
				+ "}";
		QueryExecution qexec = QueryExecutionFactory.create(query111, model);
//		System.out.println(qexec.getQuery().toString());
		ResultSet resultSet = qexec.execSelect();
		List<QuerySolution> rerult2 = ResultSetFormatter.toList(resultSet);
		System.out.println(rerult2.size());
		model.close();
		ds.close();
	}

}
// 101718 175685