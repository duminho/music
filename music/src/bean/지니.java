package bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class 지니 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String query = sc.nextLine();
		String url = "https://www.genie.co.kr/search/searchMain?query="+query;
		Document doc = null;

		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Elements element = doc.select("div.body-content");
		// 원하는 내용이 있는 틀(?) 입력
		
		System.out.println(doc.toString());
        
	}

}
