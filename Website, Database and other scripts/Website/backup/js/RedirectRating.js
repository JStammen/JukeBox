    var posted=0;  
    $(document).ready(function(){
        $('#redirectrating').click(function() {
            window.setInterval(messager, 50);
        });
    });
    function messager(){
            if(posted==0){
              posted = 1;
			 window.location.href = "http://192.168.0.105/index.php";
            }
    };