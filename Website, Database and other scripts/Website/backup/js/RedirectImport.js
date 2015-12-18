    var eventposted=0;  
    $(document).ready(function(){
        $('#redirectimport').click(function() {
            window.setInterval(message, 1000);
        });
    });
    function message(){
            if(eventposted==0){
              eventposted = 1;
             document.getElementById("light").innerHTML = "<H3>Upload succesfull!</H3>";
			 window.setInterval(redirect, 20000);	 
            }
    };
	function redirect(){
		window.location.href = "http://192.168.0.105/index.php";
	};