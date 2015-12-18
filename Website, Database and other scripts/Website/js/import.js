$(document).ready(function () {
			$("#importForm").submit(function (event) { 
			event.preventDefault();
			 var formData = new FormData($(this)[0]);
			 var fileInput = document.getElementById('file');
			 formData.append('file', fileInput);

				 $.ajax({
						url: importServiceIP+importServicePort+"/import",
						type: 'POST',
						timeout: 10000,
						data: formData,
						async: true,
						cache: false,
						dataType:"text",
						contentType: false,
						processData: false,
						beforeSend:function(){
							$("#importForm").html('<br/><br/><img style="display: block;margin-left: auto;margin-right: auto;" src="images/ajax-loader.gif"/>');
						},
						success: function (returndata) {
							$("#importForm").html('<br/><br/><p style="text-align:center;">Upload succesfull!</p>');
							setTimeout(function(){window.location.href = siteIpForRedirect+"/index.php";},2000);
							
						},
						error: function(jqXHR, textStatus, errorThrown){
							if(textStatus == "timeout"){
								$("#importForm").html('<br/><br/><p style="text-align:center;">Timed out :(</p>');
							}
						}
					});

					return false;
			});});