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
import org.apache.lucene.benchmark.quality.trec.TrecJudge;
import org.apache.lucene.benchmark.quality.trec.TrecTopicsReader;
import org.apache.lucene.benchmark.quality.utils.SimpleQQParser;
import org.apache.lucene.benchmark.quality.utils.SubmissionReport;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.FSDirectory;

public class PrecisionandRecall {

	public static void main(String[] args) throws Throwable {

		File topicsFile = new File("benchmark/topics.txt");
		File qrelsFile = new File("benchmark/qrels.txt");
		
		
		FSDirectory dir = FSDirectory.open(Paths.get("index"));
		
		IndexReader ir = DirectoryReader.open(dir);
		
		IndexSearcher indexSearcher = new IndexSearcher(ir);

		String docNameField = "filename";

		PrintWriter logger = new PrintWriter(System.out, true);

		TrecTopicsReader qReader = new TrecTopicsReader(); // #1
		
		QualityQuery qqs[] = qReader.readQueries(new BufferedReader(new FileReader(topicsFile))); // #1

		Judge judge = new TrecJudge(new BufferedReader(new FileReader(qrelsFile))); // #2

		judge.validateData(qqs, logger); // #3

		QualityQueryParser qqParser = new SimpleQQParser("title", "contents"); // #4

		QualityBenchmark qrun = new QualityBenchmark(qqs, qqParser, indexSearcher, docNameField);
		
		SubmissionReport submitLog = null;
		QualityStats stats[] = qrun.execute(judge, submitLog, logger);// #5

		QualityStats avg = QualityStats.average(stats); // #6
		avg.log("SUMMARY", 2, logger, "  ");
		dir.close();
	}
}

/*
#1 Read TREC topics as QualityQuery[]
#2 Create Judge from TREC Qrel file
#3 Verify query and Judge match
#4 Create parser to translate queries into Lucene queries
#5 Run benchmark
#6 Print precision and recall measures
*/
