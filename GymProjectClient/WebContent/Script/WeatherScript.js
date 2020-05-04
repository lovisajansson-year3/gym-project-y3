$(document).ready(function () {
	getWeather();
})
	function getWeather(){	
		var lat;
		var long;
		$.ajax({
			method: "GET",
			url: "http://api.ipstack.com/194.47.249.17?access_key=d88d508efc896b6eb4b24f06724b8930", 
			error: ajaxReturn_Error,
			success: ajaxReturn_Success
			});
		function ajaxReturn_Success(result, status, xhr) { 
				ParseJsonFileWeather(result); 
				getLocation();
				}
		function ajaxReturn_Error(result, status, xhr) { 
				console.log("Find ip-address: "+status);
		}
		function ParseJsonFileWeather(result) { 
			lat = result.latitude;
			long = result.longitude; 
			var city = result.city;
			var ipNbr = result.ip
			$("#city").text(city);
			$("#ipNbr").text(ipNbr);
		 }
		function getLocation(){
			$.ajax({
			method: "GET", 
			url: "http://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+long+"&units= metric"+ "&APPID=f6acadbe8101f56f69b6f616a99403fa",
			error: ajaxWeatherReturn_Error,
			success: ajaxWeatherReturn_Success 
			});
		}
		

		
				
		function ajaxWeatherReturn_Success(result, status, xhr) { 
			var sunrise = result.sys.sunrise;
			var sunset = result.sys.sunset;
			var sunriseDate = new Date(sunrise*1000);
			var timeStrSunrise = sunriseDate.toLocaleTimeString(); 
			var sunsetDate = new Date(sunset*1000);
			var timeStrSunset = sunsetDate.toLocaleTimeString();
			$("#sunrise").text("Sunrise: "+timeStrSunrise); 
			$("#sunset").text("Sunset: "+timeStrSunset);
			$("#weather").text(result.weather[0].main);
			$("#degree").text(result.main.temp+" \u2103"); 
			}
		function ajaxWeatherReturn_Error(result, status, xhr) {
			alert("Error i OpenWeaterMap Ajax"); 
			console.log("Ajax-find movie: "+status);
			}
			
		}		 
			
