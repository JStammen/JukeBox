function SelectTrack(trId){
		$(this).toggleClass("clicked");
		document.getElementById('myvalue').value = trId;
		
		$.getJSON('http://192.168.0.106:8090/rate/userRating/'+trId+'/'+usernamePHP , function (ratedvalue) {
		var rateValues = [ "1", "2", "3", "4", "5"];
		var rating = document.getElementById("rating");
			var options = "";
			for (var i = 0; i < rateValues.length; i++) {
				options += '<option value="' + rateValues[i] + '">' + rateValues[i] + '</option>'
			}
			rating.innerHTML = options;
			rating.selectedIndex = ratedvalue - 1;
			
		})
		
		$.getJSON('http://192.168.0.106:8090/rate/average/'+trId, function(averagevalue){
			document.getElementById('average').value = averagevalue;	
		})
		
		
}
