function searchByCriteria(criteria) {

    request = $.ajax({
        dataType: "json",
        url: searchServiceIP+searchServicePort+"/search?criteria="+ criteria,
        timeout: 2000,
        success: function (data) {
            $("#container").html("");
            var headerTr$ = $('<tr\>');
            headerTr$.append("<th>" + "Preview" + "</th>");
            headerTr$.append("<th>" + "Title" + "</th>");
            headerTr$.append("<th>" + "Artist" + "</th>");
            headerTr$.append("<th>" + "Album" + "</th>");
            headerTr$.append("<th>" + "Duration" + "</th>");
			
            $("#container").append(headerTr$);

            var tr;
            for (var i = 0; i < data.length; i++) {
                var tid = data[i].trackID;
               tr = $("<tr id=\"" + tid + "\" ondblclick=\"playTrack(" + tid + ",'" + data[i].title + "','" + data[i].album.name + "')\"" +
                        " onclick=\"selectTrack()\">");	
                tr.append("<td> <img id='prevButton' src=\"Buttons/play.png\" class='PreviewButton' onclick=\"playPreview("+i+","+tid+")\"> </td>");
                tr.append("<td>" + data[i].title + "</td>");
                tr.append("<td>" + data[i].artist.artistName + "</td>");
                tr.append("<td>" + data[i].album.name + "</td>");
                tr.append("<td>" + data[i].duration + "</td>");
				tr.append("<td style=\"display:none;\">" + tid + "</td>");
                tr.append("</tr>");

                $("#container").append(tr);
            }
        }}).error(function (jqXHR, textStatus, errorThrown) {
        if (textStatus == "timeout") {
            $("#container").html("service timed out");
        }
        $("#container").html(jqXHR.responseText);
        console.log("error: " + textStatus);
        console.log("incoming Text " + jqXHR.responseText);
    });

}