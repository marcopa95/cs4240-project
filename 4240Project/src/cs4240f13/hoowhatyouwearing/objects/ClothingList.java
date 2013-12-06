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
	
	public void removeClothing(Article.ArticleType ArticleType, Article.Clothing Article){
		for(int i=0; i<array.size();i++){
			if(array.get(i).getArticle() == Article && array.get(i).getArticleType() == ArticleType)
				array.remove(i);
			}
	}
	
	public void clearClothes(){
		array.clear();
	}
	
	public String listClothing(){
		String list="";
		for(int i=0;i<array.size();i++){
			list += array.get(i).getArticleType() + ": " + array.get(i).getArticle() + "\n";
		}
		return list;
	}
	
	public String getClothing(Article.ArticleType ArticleType, Article.Clothing Article){
		Article temp = null;
		for(int i=0;i<array.size();i++){
			if(array.get(i).getArticle() == Article && array.get(i).getArticleType() == ArticleType)
				temp = array.get(i);
		}
		String article = temp.getArticleType() + ": " + temp.getArticle();
		
		return article;
	}
	}

