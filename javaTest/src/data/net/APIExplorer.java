
package data.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class APIExplorer {

	public static void main(String[] args) {
		new APIExplorer().run();
	}

	private void run() {
		// 1. 요청 url 생성
		StringBuilder urlBuilder = new StringBuilder(
				"https://apis.data.go.kr/1611000/nsdi/IndvdLandPriceService/attr/getIndvdLandPriceAttr");
		try {
			urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8")
					+ "= (key) ");
			urlBuilder.append("&" + URLEncoder.encode("pnu", "UTF-8") + "="
					+ URLEncoder.encode("1111017700102110000", "UTF-8"));			
			urlBuilder.append("&" + URLEncoder.encode("stdrYear", "UTF-8") + "="
					+ URLEncoder.encode("2015", "UTF-8")); 
			urlBuilder.append("&" + URLEncoder.encode("format", "UTF-8") + "="
					+ URLEncoder.encode("xml", "UTF-8")); 
			urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
					+ URLEncoder.encode("10", "UTF-8")); 
			urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "="
					+ URLEncoder.encode("1", "UTF-8")); 
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// 2. connection객체 생성
		URL url = null;
		HttpURLConnection conn = null;
		try {
			url = new URL(urlBuilder.toString());
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			System.out.println("Response code: " + conn.getResponseCode());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 3. 요청전송 및 응답 처리
		BufferedReader br = null;
		try {
			int statusCode = conn.getResponseCode();
			System.out.println(statusCode);
			if (statusCode >= 200 && statusCode <= 300) {
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			Document doc = parseXML(conn.getInputStream());
			// a. field 태그객체 목록으로 가져온다.
			NodeList descNodes = doc.getElementsByTagName("field");
			// b. Corona19Data List객체 생성
			List<LandPrice> list = new ArrayList<>();
			// c. 각 field 태그의 자식태그에서 정보 가져오기
			for (int i = 0; i < descNodes.getLength(); i++) {
				// item
				Node item = descNodes.item(i);
				LandPrice data = new LandPrice();
				// item 자식태그에 순차적으로 접근
				for (Node node = item.getFirstChild(); node != null; node = node.getNextSibling()) {
					System.out.println(node.getNodeName() + " : " + node.getTextContent());

					switch (node.getNodeName()) {
					case "seq":
						data.setSeq(Integer.parseInt(node.getTextContent()));
						break;
					case "pnu":
						data.setPnu(node.getTextContent());
						break;
					case "ldCode":
						data.setLdCode(node.getTextContent());
						break;
					case "regstrSeCode":
						data.setRegstrSeCode(Integer.parseInt(node.getTextContent()));
						break;
					case "regstrSeCodeNm":
						data.setRegstrSeCodeNm(node.getTextContent());
						break;
					case "mnnmSlno":
						data.setMnnmSlno(Integer.parseInt(node.getTextContent()));
						break;
					case "stdrYear":
						data.setStdrYear(Integer.parseInt(node.getTextContent()));
						break;
					case "stdrMt":
						data.setStdrMt(Integer.parseInt(node.getTextContent()));
						break;
					case "pblntfPclnd":
						data.setPblntfPclnd(Integer.parseInt(node.getTextContent()));
						break;
					case "pblntfDe":
						data.setPblntfDe(node.getTextContent());
						break;
					case "stdLandAt":
						data.setStdLandAt(node.getTextContent());
						break;
					case "lastUpdtDt":
						data.setLastUpdtDt(node.getTextContent());
						break;
					}
				}
				// d. List객체에 추가
				list.add(data);
			}
			// e.최종확인
			for (LandPrice d : list) {
				System.out.println(d);
			}
		} catch (

		IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 4. 자원반환
		conn.disconnect();
	}

	private Document parseXML(InputStream stream) {
		DocumentBuilderFactory objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder objDocumentBuilder = null;
		Document doc = null;
		try {
			objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();
			doc = objDocumentBuilder.parse(stream);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) { // Simple API for XML e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}
}
