package lucene.ri;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.file.Paths;

import org.apache.lucene.benchmark.quality.Judge;
import org.apache.lucene.benchmark.quality.QualityBenchmark;
import org.apache.lucene.benchmark.quality.QualityQuery;
import org.apache.lucene.benchmark.quality.QualityQueryParser;
import org.apache.lucene.benchmark.quality.QualityStats;
import org.apache.lucene.benchmark.quality.trec.TrecTopicsReader;
import org.apache.lucene.benchmark.quality.utils.SimpleQQParser;
import org.apache.lucene.benchmark.quality.utils.SubmissionReport;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;

import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class PrecisionRecall {

	//public static void main(String[] args) throws Throwable {
			
		 /*(File topicsFile = new File("data/record1.txt");
		 File qrelsFile = new File("data/record2.txt");
		 
		 IndexSearcher indexSearcher;
		 Directory indexDirectory = FSDirectory.open(Paths.get("index"));
		 IndexReader ir = DirectoryReader.open(indexDirectory);
		 indexSearcher = new IndexSearcher(ir);
		 */
		 //Searcher searcher = new Searcher("index");// = new IndexSearcher("indexes/MeetLucene");
		 
		 
		//String docNameField = "filename";

		//PrintWriter logger = new PrintWriter(System.out, true); 
		 
		TrecTopicsReader qReader = new TrecTopicsReader(); //#1 Read TREC topics as QualityQuery[] 
//		QualityQuery qqs[] = qReader.readQueries(new BufferedReader(new FileReader(topicsFile))); //#1

//		Judge judge =  new Judge()
		/* {	
			@Override
			public boolean validateData(QualityQuery[] arg0, PrintWriter arg1) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public int maxRecall(QualityQuery arg0) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public boolean isRelevant(String arg0, QualityQuery arg1) {
				// TODO Auto-generated method stub
				return false;
			}
		};*/
		
		// = new Judge(new BufferedReader(new FileReader(qrelsFile))); //#2 Create Judge from TREC Qrel file 
		 
		//judge.//.validateData(qqs, logger); //#3 Verify query and Judge match 

		QualityQueryParser qqParser = new SimpleQQParser("title", "contents"); //#4 Create parser to translate queries into Lucene queries 
		//SimpleQQParser q = new SimpleQQParser("Title", "contents");
		 
//		QualityBenchmark qrun = new QualityBenchmark(qqs, qqParser, indexSearcher, docNameField);//= new QualityBenchmark(qqs, qqParser, searcher, docNameField);
		//new QualityBenchmark();
		SubmissionReport submitLog = null;
		//QualityStats stats[] = qrun.execute(judge, submitLog, logger);//#5 Run benchmark 

//		QualityStats avg = QualityStats.average(stats); //#6 Print precision and recall measure 
//		avg.log("SUMMARY",2,logger, " ");
		//	}

}
