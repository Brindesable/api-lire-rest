package LireApi;

import LireApi.SearchResult;

import net.semanticmetadata.lire.builders.DocumentBuilder;
import net.semanticmetadata.lire.imageanalysis.features.global.CEDD;
import net.semanticmetadata.lire.searchers.*;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.store.FSDirectory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.io.FileInputStream;

import java.util.List;
import java.util.LinkedList;

public class Search {
	public static List<SearchResult> searchNBest(String imgPath, int n) throws IOException {
		File f = new File(imgPath);
		if (!f.exists() || f.isDirectory()) {
			throw new IOException();
		}
		System.out.println("N : " + n);
		BufferedImage img = ImageIO.read(new FileInputStream(imgPath));

		IndexReader ir = DirectoryReader.open(FSDirectory.open(Paths.get("index")));
		ImageSearcher searcher = new GenericFastImageSearcher(n, CEDD.class);
		ImageSearchHits hits = searcher.search(img, ir);

		List<SearchResult> res = new LinkedList<SearchResult>();
		for (int i = 0; i < hits.length(); i++) {
			String fileName = ir.document(hits.documentID(i)).getValues(DocumentBuilder.FIELD_NAME_IDENTIFIER)[0];
			res.add(new SearchResult(fileName, hits.score(i)));
		}
		return res;
	}
}
