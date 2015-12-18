$(document).ready(function () {
			$("#rateForm").submit(function (event) { 
			event.preventDefault();
		//	 var formData = new FormData($(this)[0]);
		 	var formData = $(this).serialize();
		//	var formData = new FormData($('#rateForm')[0]);
			console.log(formData);

				 $.ajax({
						type: "POST",
						contentType: "application/x-www-form-urlencoded;charset=utf-8",
						url: rateServiceIP+rateServicePort+"/rate",
						data: formData,
						dataType: 'text',
						timeout: 3000,
						beforeSend:function(){
							$("#rateForm").html('<br/><br/><img style="display: block;margin-left: auto;margin-right: auto;" src="images/ajax-loader.gif"/>');
						},
						success: function (returndata) {
							$("#rateForm").html('<br/><br/><p style="text-align:center;"><H3>Thanks for rating!<H3></p>');
							setTimeout(function(){window.location.href = siteIpForRedirect+"/index.php";},1500);
						},
						error: function(jqXHR, textStatus, errorThrown){
							if(textStatus == "timeout"){
								$("#rateForm").html('<br/><br/><p style="text-align:center;">Timed out :(</p>');
							}
						}
					});

					return false;
			});});