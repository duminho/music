<%@page import="bean.Mp3DTO"%>
<%@page import="bean.Mp3DAO"%>
<%@page import="org.jsoup.Jsoup"%>
<%@page import="org.jsoup.nodes.Document"%>
<%@page import="org.jsoup.nodes.Element"%>
<%@page import="org.jsoup.select.Elements"%>
<%@page import="java.io.IOException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>음악을 태우다 낙타</title>
		<link rel="stylesheet" type="text/css" href= "style.css">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
		crossorigin="anonymous">
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	</head>
<body>

		<div id = "top">
			<div id = "title">
			</div>
			
			<div id = "search">
				<form action="">
					<input type="text" id = "searchbox" style = "width: 400px; height: 45px;" placeholder="검색어를 입력해주세요." >
					<button type="submit" class="btn btn-primary btn-lg">검색</button>
				</form>
			</div>
			
			<div id = "login">
				<table>
					<tr>
						<td>
							<img src = "images/Camel.png">
						</td>
						<td>
							<form action="">
								<button type="submit" id = "loginbutton" class="btn btn-info">로그인</button>
							</form>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<div id = "menu">
			<table>
				<ul>
					<li class = "menuselect"><a href = "">음원차트</a>
					<li class = "menuselect"><a href = "">최신음악</a>
					<li class = "menuselect"><a href = "">뉴스토픽</a>
					<li class = "menuselect"><a href = "">에디터추천</a>
					<li class = "menuselect"><a href = "">공지사항</a>
				</ul>
			</table>
		</div>
		<hr class = "hr">
		<div id = "middle">
			<div id = "album">
				<h2>검색 결과</h2>
				<div id="current">
					<ul>
						<li>통합검색</li>
						<li>아티스트</li>
						<li>곡</li>
						<li>앨범</li>
						<li>추천</li>
						<li>동영상</li>
						<li>매거진</li>
						<li>가사</li>
					</ul>
				</div>
			
			<hr>
			<%
				String query = request.getParameter("search");
				String url = "https://www.genie.co.kr/search/searchMain?query="+query;
				Document doc = null;
				try {
					doc = Jsoup.connect(url).get();
				} catch (IOException e) {
					e.printStackTrace();
				}
	
				Elements element = doc.select("span.cover-img");
				// 원하는 내용이 있는 틀(?) 입력
				Elements img = element.select("img");
			%>
			<%= img %>
			<hr color="red">
			${param.search}
				<ul>
				<% 
					element = doc.select("div.info-zone");
					// 원하는 내용이 있는 틀(?) 입력
					for(Element el : element.select("li")){
					
				%>
					<li><%= el.text() %></li>
				<% 
					}
				%>
				</ul>
			</div>
			
			<div id = "hotsearch">
				<h5>인기 검색어</h5>
				<br>
				<ol>
					<li>구로점</li>
					<li>구로점 폐쇄</li>
					<li>구내 식당</li>
					<li>노량진역</li>
					<li>노량진 롯데리아</li>
					<li>노량진 지점</li>
					<li>한국 에콰도르</li>
					<li>이강인</li>
					<li>이광연</li>
					<li>김정은</li>
				</ol>
			</div>
		</div>
		
		<div id = "under">
			<a href = "">회사소개</a> | <a href ="">이용약관</a> | <a href="">개인정보처리방침</a> | <a href = "">청소년보호정책</a> | 이메일주소무단수집거부 | 서비스 이용문의
		<div id = "under2">
		</div>
</body>
</html>