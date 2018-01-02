package storeRDFgraph;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.jena.query.Dataset;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.tdb.TDBFactory;

public class CreateTDB_pdd2_one_jar {

	public static void main(String[] args) throws IOException {
		
		if (args.length != 1) {
			System.out.println("参数不对！请传入1个参数:nt文件所在文件夹位置");
			System.exit(-1);
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String output = args[0] + "\\" + df.format(new Date());
		Dataset ds = TDBFactory.createDataset(output);
		Collection<File> files = FileUtils.listFiles(new File(args[0]), new String[] { "nt" }, false);
		for (File file : files) {
			System.out.println("start:" + file.getAbsolutePath());
			RDFDataMgr.read(ds, file.getAbsolutePath(), Lang.NT);
			System.out.println(" done");
		}
		System.out.println("目前一共条数：" + ds.getDefaultModel().size());
		ds.close();
		System.out.println("最终输出位置：" + output);

		

	}

}