<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Calcolatrice</title>
</head>
<body>
	<h1> Benvenuto nella calcolatrice </h1>
	<form action="calcServlet" method="post">
		<p> Primo operatore: 
		<input type="text" name="first" size="20">
		</p>
		<p> 
		Scegli l'operazione: 
		<input type="submit" name="operazione" value="Somma" />
		<input type="submit" name="operazione" value="Sottrai" />
		<input type="submit" name="operazione" value="Moltiplica" />
		<input type="submit" name="operazione" value="Dividi" />
		</p>
		<p> 
		Secondo operatore: 
		<input type="text" name="second" size="20"> 
		</p>
		
	</form>
</body>
</html>