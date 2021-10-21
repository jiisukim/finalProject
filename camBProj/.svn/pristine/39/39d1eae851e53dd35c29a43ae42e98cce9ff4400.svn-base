<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="weather" ></div>

<style type="text/css">

@import url(http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900);
body {
  background-color: #EEEEEE;
}
*, *:before, *:after {
  box-sizing: border-box;
}

.weather-wrapper {
  display: -webkit-box;
  display: -webkit-flex;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-orient: horizontal;
  -webkit-box-direction: normal;
  -webkit-flex-direction: row;
      -ms-flex-direction: row;
          flex-direction: row;
  -webkit-flex-wrap: wrap;
      -ms-flex-wrap: wrap;
          flex-wrap: wrap;
  -webkit-box-pack: center;
  -webkit-justify-content: center;
      -ms-flex-pack: center;
          justify-content: center;
}

.weather-card {
  margin: 20px 20px;
  border-radius: 20px;
  position: relative;
  overflow: hidden;
  width: 430px;
  height: 210px;
  background-color: white; 
  box-shadow: 0px 0px 25px 1px rgba(50, 50, 50, 0.1);
  -webkit-animation: appear 500ms ease-out forwards;
          animation: appear 500ms ease-out forwards;
}
.weather-card h1 {
  position: absolute;
  font-family: 'Lato', sans-serif;
  font-weight: 300;
  font-size: 80px;
  color: #B8B8B8;
  bottom: 50px;
  left: 35px;
  opacity: 0;
  -webkit-transform: translateX(150px);
      -ms-transform: translateX(150px);
          transform: translateX(150px);
  -webkit-animation: title-appear 500ms ease-out 500ms forwards;
          animation: title-appear 500ms ease-out 500ms forwards;
}
.weather-card p {
  position: absolute;
  font-family: 'Lato', sans-serif;
  font-weight: 300;
  font-size: 28px;
  color: #d2d2d2;
  bottom: 0;
  left: 35px;
  -webkit-animation: title-appear 1s ease-out 500ms forwards;
          animation: title-appear 1s ease-out 500ms forwards;
}

.weather-icon {
  position: relative;
  width: 50px;
  height: 50px;
  top: 0;
  float: right;
  margin: 40px 40px 0 0;
  -webkit-animation: weather-icon-move 5s ease-in-out infinite;
          animation: weather-icon-move 5s ease-in-out infinite;
}

.sun {
  background: #FFCD41;
  border-radius: 50%;
  box-shadow: rgba(255, 255, 0, 0.1) 0 0 0 4px;
  -webkit-animation: light 800ms ease-in-out infinite alternate, weather-icon-move 5s ease-in-out infinite;
          animation: light 800ms ease-in-out infinite alternate, weather-icon-move 5s ease-in-out infinite;
}

@-webkit-keyframes light {
  from {
    box-shadow: rgba(255, 255, 0, 0.2) 0 0 0 10px;
  }
  to {
    box-shadow: rgba(255, 255, 0, 0.2) 0 0 0 17px;
  }
}

@keyframes light {
  from {
    box-shadow: rgba(255, 255, 0, 0.2) 0 0 0 10px;
  }
  to {
    box-shadow: rgba(255, 255, 0, 0.2) 0 0 0 17px;
  }
}
.cloud {
  margin-right: 60px;
  background: #e1e1e1;
  border-radius: 20px;
  width: 25px;
  height: 25px;
  box-shadow: #e1e1e1 24px -6px 0 2px, #e1e1e1 10px 5px 0 5px, #e1e1e1 30px 5px 0 2px, #e1e1e1 11px -8px 0 -3px, #e1e1e1 25px 11px 0 -1px;
}
.cloud:after {
  content: "";
  position: absolute;
  border-radius: 10px;
  background-color: transparent;
  width: 4px;
  height: 12px;
  left: 0;
  top: 31px;
  -webkit-transform: rotate(30deg);
      -ms-transform: rotate(30deg);
          transform: rotate(30deg);
/*   -webkit-animation: rain 800ms ease-in-out infinite alternate; */
/*           animation: rain 800ms ease-in-out infinite alternate; */
}

.rainy {
  margin-right: 60px;
  background: #e1e1e1;
  border-radius: 20px;
  width: 25px;
  height: 25px;
  box-shadow: #e1e1e1 24px -6px 0 2px, #e1e1e1 10px 5px 0 5px, #e1e1e1 30px 5px 0 2px, #e1e1e1 11px -8px 0 -3px, #e1e1e1 25px 11px 0 -1px;
}

.rainy:after{
  content: "";
  position: absolute;
  border-radius: 10px;
  background-color: transparent;
  width: 4px;
  height: 12px;
  left: 0;
  top: 31px;
  -webkit-transform: rotate(30deg);
      -ms-transform: rotate(30deg);
          transform: rotate(30deg);
  -webkit-animation: rain 800ms ease-in-out infinite alternate;
          animation: rain 800ms ease-in-out infinite alternate;
}

.snowy {
  margin-right: 60px;
  background: #e1e1e1;
  border-radius: 20px;
  width: 25px;
  height: 25px;
  box-shadow: #e1e1e1 24px -6px 0 2px, #e1e1e1 10px 5px 0 5px, #e1e1e1 30px 5px 0 2px, #e1e1e1 11px -8px 0 -3px, #e1e1e1 25px 11px 0 -1px;
}

.snowy:after{
  content: "";
  position: absolute;
  border-radius: 10px;
  background-color: transparent;
  width: 7px;
  height: 7px;
  left: 0;
  top: 31px;
  -webkit-transform: rotate(30deg);
      -ms-transform: rotate(30deg);
          transform: rotate(30deg);
  -webkit-animation: snow 800ms ease-in-out infinite alternate;
          animation: snow 800ms ease-in-out infinite alternate;
}

@-webkit-keyframes rain {
  from {
    box-shadow: #2092A9 8px 0px, #2092A9 32px -6px, #2092A9 20px 0px;
  }
  to {
    box-shadow: #2092A9 8px 6px, #2092A9 32px 0px, #2092A9 20px 6px;
  }
}

@keyframes rain {
  from {
    box-shadow: #2092A9 8px 0px, #2092A9 32px -6px, #2092A9 20px 0px;
  }
  to {
    box-shadow: #2092A9 8px 6px, #2092A9 32px 0px, #2092A9 20px 6px;
  }
}

@-webkit-keyframes snow {
  from {
    box-shadow: #e4f2f5 8px 0px, #e4f2f5 32px -6px, #e4f2f5 20px 0px;
  }
  to {
    box-shadow: #e4f2f5 8px 6px, #e4f2f5 32px 0px, #e4f2f5 20px 6px;
  }
}

@keyframes snow {
  from {
    box-shadow: #e4f2f5 8px 0px, #e4f2f5 32px -6px, #e4f2f5 20px 0px;
  }
  to {
    box-shadow: #e4f2f5 8px 6px, #e4f2f5 32px 0px, #e4f2f5 20px 6px;
  }
}
@-webkit-keyframes weather-icon-move {
  50% {
    -webkit-transform: translateY(-8px);
            transform: translateY(-8px);
  }
}
@keyframes weather-icon-move {
  50% {
    -webkit-transform: translateY(-8px);
            transform: translateY(-8px);
  }
}
.inspiration {
  color: #aeaeae;
  font-family: 'Lato', sans-serif;
  font-weight: 300;
  font-size: 24px;
  text-align: center;
}
.inspiration a {
  color: #FA565F;
  font-weight: 400;
  -webkit-animation: all 300ms ease-in-out;
          animation: all 300ms ease-in-out;
}

@-webkit-keyframes appear {
  0% {
    -webkit-transform: scale(0);
            transform: scale(0);
  }
  50% {
    -webkit-transform: scale(1.05);
            transform: scale(1.05);
  }
  75% {
    -webkit-transform: scale(0.95);
            transform: scale(0.95);
  }
  100% {
    -webkit-transform: scale(1);
            transform: scale(1);
  }
}

@keyframes appear {
  0% {
    -webkit-transform: scale(0);
            transform: scale(0);
  }
  50% {
    -webkit-transform: scale(1.05);
            transform: scale(1.05);
  }
  75% {
    -webkit-transform: scale(0.95);
            transform: scale(0.95);
  }
  100% {
    -webkit-transform: scale(1);
            transform: scale(1);
  }
}
@-webkit-keyframes title-appear {
  from {
    opacity: 0;
    -webkit-transform: translateX(150px);
            transform: translateX(150px);
  }
  to {
    opacity: 1;
    -webkit-transform: translateX(0px);
            transform: translateX(0px);
  }
}
@keyframes title-appear {
  from {
    opacity: 0;
    -webkit-transform: translateX(150px);
            transform: translateX(150px);
  }
  to {
    opacity: 1;
    -webkit-transform: translateX(0px);
            transform: translateX(0px);
  }
}

</style>

<script type="text/javascript" src="/resources/js/jquery.min.js"></script>

<script type="text/javascript">

$(document).ready(function(){

	$.ajax({
		url:"http://api.openweathermap.org/data/2.5/forecast?id=1835848&APPID=f8b8761c25df03a84389bdbb6a97a6c5&units=metric",
		dataType:"json",
		success:function(city){
			$.each(city.list, function(key) {

				// 오늘 날짜 구하는 코딩
				var now = new Date();
			    var year= now.getFullYear();
			    var mon = (now.getMonth()+1)>9 ? ''+(now.getMonth()+1) : '0'+(now.getMonth()+1);
			    var day = now.getDate()>9 ? ''+now.getDate() : '0'+now.getDate();
			    var today = year + '-' + mon + '-' + day;
			    var week = new Array('일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일');	// 요일

			    
			    // api에서 받는 날짜
			    var date = city.list[key].dt_txt.substring(0,10)
			    var time = city.list[key].dt_txt.substring(11,13)
			    var yoil = new Date(date).getDay();	// 받아 오는 날짜의 요일 일-0 월-1 화-2....
			    var todayLabel = week[yoil];
			    
			    var max=(Math.round(city.list[key].main.temp_max))+"˚C";


			    // 날씨
			    var weath = city.list[key].weather[0].description;
			    if(date === today) {
			    	console.log("today time" + time + " " + weath);
// 			    	if(time === '12') { // 12가 안 나올 수도 있음 -  임시 방편으로 오늘 날씨 중 가장 먼저 나온 하나만 출력하기
			    		console.log("in >>" + weath);
			    		if (weath === 'clear sky') { //sky is clear
				    		$("#weather").append("<div style='float:left;' class='weather-card'><div class='weather-icon sun'></div><h1>"+max+"</h1><p>"+todayLabel+"</p></div>");
			    			return false;
				    	} else if(weath === 'few clouds'){
				    		$("#weather").append("<div style='float:left;' class='weather-card'><div class='weather-icon cloud'></div><h1>"+max+"</h1><p>"+todayLabel+"</p></div>");
			    			return false;
				    	} else if(weath === 'scattered clouds'){
				    		$("#weather").append("<div style='float:left;' class='weather-card'><div class='weather-icon cloud'></div><h1>"+max+"</h1><p>"+todayLabel+"</p></div>");
			    			return false;
				    	} else if(weath === 'broken clouds'){
				    		$("#weather").append("<div style='float:left;' class='weather-card'><div class='weather-icon cloud'></div><h1>"+max+"</h1><p>"+todayLabel+"</p></div>");
			    			return false;
				    	} else if(weath === 'overcast clouds'){
				    		$("#weather").append("<div style='float:left;' class='weather-card'><div class='weather-icon cloud'></div><h1>"+max+"</h1><p>"+todayLabel+"</p></div>");
			    			return false;
				    	} else if(weath === 'shower rain'){
				    		$("#weather").append("<div style='float:left;' class='weather-card'><div class='weather-icon rainy'></div><h1>"+max+"</h1><p>"+todayLabel+"</p></div>");
			    			return false;
				    	} else if(weath === 'light rain'){
				    		$("#weather").append("<div style='float:left;' class='weather-card'><div class='weather-icon rainy'></div><h1>"+max+"</h1><p>"+todayLabel+"</p></div>");
			    			return false;
				    	} else if(weath === 'moderate rain'){
				    		$("#weather").append("<div style='float:left;' class='weather-card'><div class='weather-icon rainy'></div><h1>"+max+"</h1><p>"+todayLabel+"</p></div>");
			    			return false;
				    	} else if(weath === 'Rain'){
				    		$("#weather").append("<div style='float:left;' class='weather-card'><div class='weather-icon rainy'></div><h1>"+max+"</h1><p>"+todayLabel+"</p></div>");
			    			return false;
				    	} else if(weath === 'Thunderstorm'){
				    		$("#weather").append("<div style='float:left;' class='weather-card'><div class='weather-icon rainy'></div><h1>"+max+"</h1><p>"+todayLabel+"</p></div>");
			    			return false;
				    	} else if(weath === 'snow'){
				    		$("#weather").append("<div style='float:left;' class='weather-card'><div class='weather-icon snow'></div><h1>"+max+"</h1><p>"+todayLabel+"</p></div>");
			    			return false;
				    	} else if(weath === 'mist'){
				    		$("#weather").append("<div style='float:left;' class='weather-card'><div class='weather-icon cloud'></div><h1>"+max+"</h1><p>"+todayLabel+"</p></div>");
			    			return false;
				    	}
			    	}
// 			    }  
			});
		}
	});

})

</script>