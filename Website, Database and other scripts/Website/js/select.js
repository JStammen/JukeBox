function selectTrackForRating(trId){
		
		document.getElementById('myvalue').value = trId;
		
		request1 = $.ajax({
						dataType: "json",
						url: rateServiceIP+rateServicePort+'/rate/userRating/'+trId+'/'+usernamePHP ,
						timeout: 1000,
						success: function (ratedvalue) { 
							var rateValues = [ "1", "2", "3", "4", "5"];
							var rating = document.getElementById("rating");
								var options = "";
								for (var i = 0; i < rateValues.length; i++) {
									options += '<option value="' + rateValues[i] + '">' + rateValues[i] + '</option>'
								}
								rating.innerHTML = options;
								rating.selectedIndex = ratedvalue - 1;
								
						}}).error(function (jqXHR, textStatus, errorThrown) {
								if( textStatus == "timeout" ) {
									$("#trackInformatie").html("");
									$("#trackInformatie").html("<br\>");
									$("#trackInformatie").html("Rate service timed out");
		}});
		
		request2 = $.ajax({
						dataType: "json",
						url: rateServiceIP+rateServicePort+'/rate/average/'+trId,
						timeout: 1000,
						success: function(averagevalue) { 
							var average = document.getElementById("average");
							average.innerHTML = "<h2>" + averagevalue + "</h2>";	
						}}).error(function (jqXHR, textStatus, errorThrown) {
								if( textStatus == "timeout" ) {
									$("#trackInformatie").html("");
									$("#trackInformatie").html("<br\>");
									$("#trackInformatie").html("Rate service timed out");
		}});
		
		
}