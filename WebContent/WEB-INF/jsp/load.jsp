<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
	<script type="text/javascript">
		var auto_refresh=setInterval( function()
		{
		$('#load').load('chatbox').fadeIn('slow');
		},
		10000);
		
        function ck(){ 
            $.ajax({url:'start.php'});
            }
	</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Open fire bug : chek ajax calls</title>
</head>
<body onload=ck(); >
	<h2>for monitering ajax working</h2>
	<div id="load">here</div>
</body>
</html>