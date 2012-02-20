package mn.aug.restfulandroid.rest.resource;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

public class CatPictures implements Resource {

	List<CatPicture> catPictures;

	/**
	 * Construct CatPictures from its JSON representation
	 * 
	 * @param catPicturesArray
	 * @throws IllegalArgumentException
	 *             - if the JSON does not contain the required keys
	 */
	public CatPictures(JSONArray catPicturesArray) {
		int count = catPicturesArray.length();

		catPictures = new ArrayList<CatPicture>();

		try {
			for (int i = 0; i < count; i++) {
				catPictures.add(new CatPicture(catPicturesArray.getJSONObject(i).getJSONObject(
						"data")));
			}
		} catch (JSONException e) {
			throw new IllegalArgumentException("Error constructing CatPictures. "
					+ e.getLocalizedMessage());
		}
	}

	/**
	 * Get the list of cat pictures
	 * 
	 * @return list of cat pictures
	 */
	public List<CatPicture> getCatPictures() {
		return catPictures;
	}

}