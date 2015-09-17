package edu.mssm.pharm.maayanlab.Harmonizome.json.serdes;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import edu.mssm.pharm.maayanlab.Harmonizome.model.Attribute;
import edu.mssm.pharm.maayanlab.Harmonizome.model.Dataset;
import edu.mssm.pharm.maayanlab.Harmonizome.model.Feature;
import edu.mssm.pharm.maayanlab.Harmonizome.model.GeneSet;

public class GeneSetMetadataSerializer implements JsonSerializer<GeneSet> {

	public JsonElement serialize(final GeneSet geneSet, final Type type, final JsonSerializationContext context) {
		JsonObject result = new JsonObject();
		Attribute attribute = geneSet.getAttribute();
		Dataset dataset = geneSet.getDataset();
		result.add("attribute", context.serialize(attribute));
		result.add("dataset", context.serialize(dataset));

		JsonArray jsonArray = new JsonArray();
		for (Feature feature : geneSet.getFeatures()) {
			jsonArray.add(context.serialize(feature, Feature.class));
		}
		result.add("features", jsonArray);		

		return result;
	}
}