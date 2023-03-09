<%@ page language="java" contentType="text/html;charset=UTF-8" 
    pageEncoding="UTF-8" import="java.util.*" %>
<% 
	String[] langs={"java","python","C"};
	request.setAttribute("langs", langs);
	String math="35.6";
	List<String> greetings = new ArrayList<>();
	greetings.add("Hello World");
	greetings.add("Have a nice day");
	request.setAttribute("greetings", greetings);
	
	Map<String,String> tel = new HashMap<>();
	tel.put("John","0939888888");
	tel.put("Mary","0917123456");
	request.setAttribute("mobile", tel);
	
%>
<html>
<body>
${math};
${langs[0]}<br>
${langs[1]}<br>
${langs[2]}<p>

${greetings[0]}<br>
${greetings[1]}<br>
${greetings[2]}<p>
The mobile of John : ${mobile.John}<br>
The mobile of Mary : ${mobile['Mary']}<br>
The mobile of John : ${mobile["John"]}<br>
The mobile of Tom : ${mobile["Tom"]}
</body>
</html>
