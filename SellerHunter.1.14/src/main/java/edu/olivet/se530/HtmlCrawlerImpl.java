package edu.olivet.se530;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class HtmlCrawlerImpl implements HtmlCrawler {
	private static final String AMAZON_HOST = "http://www.amazon.com";
	
	public Document getDocument(String isbn, String condition) throws MalformedURLException,IOException {
		String url = String.format("%s/gp/offer-listing/%s/ref=olp_tab_%s?ie=UTF8&condition=%s&sr=8-1", 
			     AMAZON_HOST, isbn, condition.toLowerCase(), condition.toLowerCase());
		Connection conn = getConnection(new URL(url));
		Document document = conn.get();
		return document;
	}
	
	Connection getConnection(URL url) {
		Connection conn = Jsoup.connect(url.toExternalForm());
		conn.timeout(8000);
		conn.header("Connection", "keep-alive");
		conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;");
		conn.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36");
		conn.header("Accept-Encoding", "gzip, deflate");
		conn.header("Accept-Language", "en-US,en;q=0.8,zh-CN;q=0.6,zh;q=0.4");
		conn.header("Cache-Control", "max-age=0");
		conn.header("Host", url.getHost());
		return conn;
	}
	
	
}
