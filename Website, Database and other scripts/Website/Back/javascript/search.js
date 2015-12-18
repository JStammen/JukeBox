$(document).ready(function () {
                            searchbycriteria("%");
                            $('#zoeken').bind('click', function (e) {
                                searchbycriteria($('form input[name=criteria]').val());
                                e.preventDefault();
                                return false;

                            });
                        });

                        function searchbycriteria(criteria) {
                            $.getJSON("http://192.168.0.106:8080/search?criteria=" + criteria, function (data) {
                                $("#container").html("");
                                var headerTr$ = $('<tr\>');
                                headerTr$.append("<th>" + "Title" + "</th>");
                                headerTr$.append("<th>" + "Artist" + "</th>");
                                headerTr$.append("<th>" + "Album" + "</th>");
                                headerTr$.append("<th>" + "Duration" + "</th>");
                                headerTr$.append("<th>" + "Add" + "</th>");

                                $("#container").append(headerTr$);

								var tr;
                                for (var i = 0; i < data.length; i++) {
									var tid = data[i].trackID;
                                    tr = $('<tr id="'+tid+'" onclick="SelectTrack('+tid+')">');
                                    tr.append("<td>" + data[i].title + "</td>");
                                    tr.append("<td>" + data[i].artist.artistName + "</td>");
                                    tr.append("<td>" + data[i].album.name + "</td>");
                                    tr.append("<td>" + data[i].duration + "</td>");
                                    tr.append("<td> <img src='add-icon.png'>  </td>");
									tr.append("</tr>");
																		
									tr.bind("click", function() {
										$(this).toggleClass("clicked");
										$(".clicked").not(this).removeClass("clicked");
									});
									
                                    $("#container").append(tr);
                                }
                            }).error(function (jqXHR, textStatus, errorThrown) {
                                $("#container").html(jqXHR.responseText);
                                console.log("error: " + textStatus);
                                console.log("incoming Text " + jqXHR.responseText);
                            });
							
							/*setTimeout(function() { 
							p.abort(); 
							$("#container").html("Service timed out"); } , 2000);*/
                        }