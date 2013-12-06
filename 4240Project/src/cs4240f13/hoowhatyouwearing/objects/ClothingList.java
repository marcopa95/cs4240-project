package cs4240f13.hoowhatyouwearing.objects;

import java.util.ArrayList;

public class ClothingList {
	
	private ArrayList<Article> array = new ArrayList<Article>();
	
	public ClothingList(){
	
	}
	
	public void addClothing(Article.ArticleType ArticleType, Article.Clothing Article){
		Article article = new Article(ArticleType, Article);
		array.add(article);
	}
	
	public void removeClothing(String ArticleType, String Article){
		for(int i=0; i<array.size();i++){
			if(array.get(i).getArticle().equals(Article) && array.get(i).getArticleType().equals(ArticleType))
				array.remove(i);
			}
	}
	
	public void clearClothes(){
		array.clear();
	}
	
	public void listClothing(){
		for(int i=0;i<array.size();i++){
			System.out.println(array.get(i).getArticleType() + " " + array.get(i).getArticle());
		}
	}
}
