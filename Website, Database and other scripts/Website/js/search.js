function searchByCriteria(criteria) {

    request = $.ajax({
        dataType: "json",
        url: searchServiceIP+searchServicePort+"/search?criteria=" + criteria,
        timeout: 3000,
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
                tr.append("<td> <img id='prevButton" + i + "' src=\"Buttons/play.png\" class='PreviewButton' onclick=\"playPreview(" + i + "," + tid + "):togglePreview(" + i + "," + tid + ")\"> </td>");
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
function togglePreview(i, selectedId) {
    var button = "prevButton" + i;
    var prevButton = document.getElementById(button);
    if (selectedId > 0 && prevIsPlaying == false) {
        prevButton.value = "pausebutton";
        prevButton.src = "Buttons/pause.png";
    } else if (prevIsPlaying == true && currentPreview == i) {
        prevButton.value = "playbutton";
        prevButton.src = "Buttons/play.png";
    } else if (prevIsPlaying == true && currentPreview != i) {
        prevButton.value = "pausebutton";
        prevButton.src = "Buttons/pause.png";
    }
}