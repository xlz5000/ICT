<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기상청 단기예보</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<h2>한국환경공단_에어코리아_대기오염정보 - 시도별 실시간 측정정보 조회</h2>
	
	<button id="btnXml">XML데이터불러오기</button>
	<button id="btnJson">Json 데이터불러오기</button>
	
	<div id="result"></div>
	
	
	<!--  ajax는 일반적인 Controller로 가지 않는다. RestController로 간다.-->
	<script type="text/javascript">
	// 설명과 해설용
	const weatherExplain = {
		POP: { label:"강수확률", interpret: val => val + "% 비 올 확률입니다."},					
		PTY: { label:"강수형태", interpret: val => ({"0":"없음","1":"비","2":"비/눈", "3":"눈", "4":"thskrl"}[val] || "미상" )},
		REH: { label:"습도", interpret: val => val + "% 습도 입니다."},	
		SKY: { label:"하늘상태", interpret: val => ({"1":"맑음","3":"구름많음", "4":"흐림"}[val] || "미상" )},
		T3H: { label: "3시간 기온", interpret: val => val + "℃ 예상 기온입니다." },
		TMN: { label: "일 최저기온", interpret: val => val + "℃ 오늘 아침 최저입니다." },
		TMX: { label: "일 최고기온", interpret: val => val + "℃ 오늘 낮 최고입니다." },
		WSD: { label: "풍속", interpret: val => val + "m/s 바람입니다." }
	}
			
		$("#btnXml").on("click", function(){
			
			
			$("#result").html("<p>XML2 데이터 로딩 중 ... </p>");
			$.ajax({
				
				url: "/weatherXml2",
				method:"POST",
				dataType: "xml",
				success : function(response){
					//console.log(response);
					let table = "<h2>XML 결과</h2><table>";
					table += "<thead>";
					table += "<tr><td>측정소명</td><td>시도명</td><td>아황상가스 농도</td><td>일산화탄소 농도</td>";
					table += "</thead>";
					table +="<tbody>"
					$(response).find("item").each(function(){
						let stationName = $(this).find("stationName").text()
						let sidoName = $(this).find("sidoName").text()
						let so2Value = $(this).find("so2Value").text()
						let coValue = $(this).find("coValue").text()
						

						
						
						table += "<tr>";
						table += "<td>" + stationName +"</td>";
						table += "<td>" + sidoName +"</td>";
						table += "<td>" + so2Value +"</td>";
						table += "<td>" + coValue +"</td>";

						table += "</tr>";

					})
					table += "</tbody>";
					table += "</table>";
					
					
					$("#result").html(table);
					
				},
				error: function(){
					
					alert("가져오기 실패");
				}
				
				
			})
			
			
		})
		$("#btnJson").on("click", function(){
			$("#result").html("<p>JSON2 데이터 로딩 중 ... </p>");
			$.ajax({
				
				url: "/weatherJson2",
				method:"POST",
				dataType: "json",
				success : function(response){
					console.log(response);
					let items = response.response.body.items;
					let table = "<h2>JSON 결과</h2><table>";
					table += "<thead>";
					table += "<tr><td>예보일자</td><td>시간</td><td>항목</td><td>값</td><td>설명</td><td>해석</td></tr>";
					table += "</thead>";
					table +="<tbody>"
		
					$.each(items, function(i, v){
						
						let stationName = v.stationName;
						let sidoName = v.sidoName;
						let so2Value = v.so2Value;
						let coValue = v.coValue;
	
						
						
						
						table += "<tr>";
						table += "<td>" + stationName +"</td>";
						table += "<td>" + sidoName +"</td>";
						table += "<td>" + so2Value +"</td>";
						table += "<td>" + coValue +"</td>";

						table += "</tr>";
						
					})
					
					
					
					
					table += "</tbody>";
					table += "</table>";
					
					
					$("#result").html(table);
					
					
				},
				error: function(){
					
					alert("가져오기 실패");
				}
				
				
			})
			
			
		})
		
	
	
	</script>

</body>
</html>