package teste;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class Searcher {

	IndexSearcher indexSearcher;
	QueryParser queryParser;
	Query query;

	public Searcher(String indexDirectoryPath) throws IOException{
		Directory indexDirectory = FSDirectory.open(Paths.get(indexDirectoryPath));
		IndexReader ir = DirectoryReader.open(indexDirectory);
		indexSearcher = new IndexSearcher(ir);
		queryParser = new QueryParser(LuceneConstants.CONTENTS, new StandardAnalyzer());
	}

	public TopDocs search(String searchQuery) throws IOException, ParseException, org.apache.lucene.queryparser.classic.ParseException{
		
		///QueryParser.parse(searchQuery);
		//BasicQueryFactory factory = new BasicQueryFactory(1000 /*maxBasicQueries*/);
		//Query luceneQuery = QueryParser.parse(searchQuery).makeLuceneQueryField(LuceneConstants.CONTENTS, factory);
		///topDocs = searcher.search(luceneQuery, 1000);
		//return indexSearcher.search(luceneQuery, LuceneConstants.MAX_SEARCH);*/
		//return indexSearcher.searchFred(luceneQuery, LuceneConstants.MAX_SEARCH);
		//Query query = QueryParser.parse(searchQuery).makeLuceneQueryField(LuceneConstants.CONTENTS, factory);
	      //return indexSearcher.search(query, LuceneConstants.MAX_SEARCH);
		//Query query = QueryParser.parse(searchQuery).makeLuceneQueryField(LuceneConstants.CONTENTS, factory);
        //return indexSearcher.search(query, LuceneConstants.MAX_SEARCH); 

		query = queryParser.parse(searchQuery);
		return indexSearcher.search(query, LuceneConstants.MAX_SEARCH);
		
	}

	public Document getDocument(ScoreDoc scoreDoc) 
			throws CorruptIndexException, IOException{
		return indexSearcher.doc(scoreDoc.doc);	
	}

	//public void close() throws IOException{
		//indexSearcher.
	//}
}
