package LireApi;

import net.semanticmetadata.lire.builders.GlobalDocumentBuilder;
import net.semanticmetadata.lire.imageanalysis.features.global.AutoColorCorrelogram;
import net.semanticmetadata.lire.imageanalysis.features.global.CEDD;
import net.semanticmetadata.lire.imageanalysis.features.global.FCTH;
import net.semanticmetadata.lire.utils.FileUtils;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

public class Index {
	public static void index(String imgPath) throws IOException {
		File f = new File(imgPath);
		if (!f.exists() || f.isDirectory()) {
			throw new IOException();
		}
		BufferedImage img = ImageIO.read(new FileInputStream(imgPath));

		GlobalDocumentBuilder globalDocumentBuilder = new GlobalDocumentBuilder(false, false);
        globalDocumentBuilder.addExtractor(CEDD.class);
		globalDocumentBuilder.addExtractor(FCTH.class);
		globalDocumentBuilder.addExtractor(AutoColorCorrelogram.class);

		IndexWriterConfig conf = new IndexWriterConfig(new WhitespaceAnalyzer());
		IndexWriter iw = new IndexWriter(FSDirectory.open(Paths.get("index")), conf);

		Document document = globalDocumentBuilder.createDocument(img, imgPath);
		iw.addDocument(document);
		iw.close();
	}
}
