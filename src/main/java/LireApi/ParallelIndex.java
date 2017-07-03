package LireApi;

import net.semanticmetadata.lire.builders.GlobalDocumentBuilder;
import net.semanticmetadata.lire.imageanalysis.features.global.AutoColorCorrelogram;
import net.semanticmetadata.lire.imageanalysis.features.global.CEDD;
import net.semanticmetadata.lire.imageanalysis.features.global.FCTH;
import net.semanticmetadata.lire.indexers.parallel.ParallelIndexer;

import java.io.File;
import java.io.IOException;

public class ParallelIndex {

	private static final int nbThreads = 4;

	public static void index(String dirPath) throws IOException {
		File f = new File(dirPath);
		if (!f.exists() || !f.isDirectory()){
			throw new IOException();
		}
		ParallelIndexer indexer = new ParallelIndexer(nbThreads, "index", dirPath);
		indexer.addExtractor(CEDD.class);
		indexer.addExtractor(FCTH.class);
		indexer.addExtractor(AutoColorCorrelogram.class);
		indexer.run();
	}
}
