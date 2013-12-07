package cs4240f13.hoowhatyouwearing.objects;

import java.util.ArrayList;
import java.util.Collections;

public class ClothingManager {

	public static ArrayList<Article> determineOutfit(double highTemp, double lowTemp, int centralTemp, boolean isRaining, ClothingList clothingList) {
		boolean isWearingOuterwear = false;
		Article raingear = null;
		double topOffsetTemp = 0;
		ArrayList<Article> retList = new ArrayList<Article>();
		ArrayList<Article> tops = new ArrayList<Article>();
		ArrayList<Article> bottoms = new ArrayList<Article>();
		ArrayList<Article> outerwear = new ArrayList<Article>();
		ArrayList<Article> footwear = new ArrayList<Article>();
		
		// Split up available articles into lists
		for(Article article : clothingList.getClothes()) {
			switch(article.getArticleType()) {
			case TOP:
				tops.add(article);
				break;
			case BOTTOMS:
				bottoms.add(article);
				break;
			case FOOTWEAR:
				footwear.add(article);
				break;
			case OUTERWEAR:
				outerwear.add(article);
				break;
			case RAINGEAR:
				raingear = article;
			default:
				break;
			}
		}
		
		// sort arrays
		tops = sortClothing(tops);
		bottoms = sortClothing(bottoms);
		footwear = sortClothing(footwear);
		outerwear = sortClothing(outerwear);
		
		// Determine top (and if outerwear is needed), bottom, and shoes
		for(Article top : tops) {
			if (centralTemp - top.getArticle().getOffset() < highTemp) {
				retList.add(top);
				topOffsetTemp = centralTemp - top.getArticle().getOffset();
				break;
			}
		}
		
		if (retList.size() == 0) {
			isWearingOuterwear = true;
			loops:
			for(Article out : outerwear) {
				for (Article top : tops) {
					if (centralTemp - top.getArticle().getOffset() - out.getArticle().getOffset() < lowTemp) {
						retList.add(top);
						retList.add(out);
						break loops;
					}
				}
			}
		}
		
		for(Article bottom : bottoms) {
			if (bottoms.indexOf(bottom) == bottoms.size()-1 ||
					centralTemp - bottom.getArticle().getOffset() < lowTemp) {
				retList.add(bottom);
				break;
			}
		}
		
		for(Article footwearItem : footwear) {
			if (footwear.indexOf(footwearItem) == bottoms.size()-1 ||
					centralTemp - footwearItem.getArticle().getOffset() < lowTemp) {
				retList.add(footwearItem);
				break;
			}
		}
		
		// Determine if outerwear is needed
		if (!isWearingOuterwear) {
			for(Article out : outerwear) {
				if (topOffsetTemp - out.getArticle().getOffset() < lowTemp) {
					retList.add(out);
					break;
				}
			}
			if (retList.size() == 3) {
				retList.add(outerwear.get(outerwear.size()-1));
			}
		}
		
		// add raingear if exists
		if (isRaining) {
			for (Article article : retList) {
				if (article.getArticleType() == Article.ArticleType.OUTERWEAR) {
					retList.remove(article);
					break;
				}
			}
			retList.add(raingear);
		}
		
		return retList;
	}
	
	private static ArrayList<Article> sortClothing(ArrayList<Article> articleList) {
		Collections.sort(articleList);
		return articleList;
	}

}
