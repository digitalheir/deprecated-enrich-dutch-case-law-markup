package org.crf.crf.run;


import java.util.List;
import java.util.Set;

import org.crf.crf.filters.CrfFilteredFeature;
import org.crf.postagging.postaggers.crf.CrfPosTagger;
import org.crf.utilities.TaggedToken;

/**
 * Generates set of features to be used by the CRF algorithm for training and inference of {@link CrfPosTagger}.
 * 
 * @author Asher Stern
 * Date: Nov 10, 2014
 *
 */
public abstract class CrfFeatureGenerator<K,G>
{
	public CrfFeatureGenerator(Iterable<? extends List<? extends TaggedToken<K, G> >> corpus, Set<G> tags)
	{
		super();
		this.corpus = corpus;
		this.tags = tags;
	}
	
	/**
	 * Generate the features (to be later retrieved by {@link #getFeatures()}).
	 */
	public abstract void generateFeatures();
	
	/**
	 * Return the set of features earlier generated by {@link #generateFeatures()}.
	 * @return the set of features earlier generated by {@link #generateFeatures()}.
	 */
	public abstract Set<CrfFilteredFeature<K, G>> getFeatures();

	
	
	protected final Iterable<? extends List<? extends TaggedToken<K, G> >> corpus;
	protected final Set<G> tags;
}
