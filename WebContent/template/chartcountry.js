$(document)
		.ready(
				function() {
					$(document).on(
									'submit',
									'#formCountry',
									function(e) {
										var country = $("#country").val();
										var country1 = $("#country1").val();
										var country2 = $("#country2").val();

										if (country != undefined ) {
											$(".preloader").show();

											$.ajax({
												url : "/ProjectBDII/ServletCountry",
												type : "POST",
												dataType : 'JSON',
												async : false,
												data : {
													"table" : 'country',
													"country" : country,
													"country1" : country1,
													"country2" : country2
												},
												success : function(msg) {
													
													if(msg.error==1){
														alert("Country does not exist");
													}
													
													if(!msg.result){
														console.log("non c'è il result");
													}
													else{
														/* */
														var ctx = document.getElementById('myChart3').getContext('2d');
														var myChart = new Chart(ctx, {
														    type: 'doughnut',
														    data: {
														        labels: msg.rating,
														        datasets: [{
														            label: "Movies for country",
														            data: msg.count,
														            backgroundColor: [
														                'rgba(255, 99, 132, 0.2)',
														                'rgba(54, 162, 235, 0.2)',
														                'rgba(255, 206, 86, 0.2)'
														            ],
														            borderColor: [
														                'rgba(255, 99, 132, 1)',
														                'rgba(54, 162, 235, 1)',
														                'rgba(255, 206, 86, 1)'
														            ],
														            borderWidth: 1
														        }]
														    },
														    
														});
														myChart.canvas.parentNode.style.height = 'auto';
														myChart.canvas.parentNode.style.width = '30vw';
													}

												},
												error : function(msg) {
													alert("Nessuna risposta dalla servlet");
												}
											});

											$(".preloader").hide();
										} else {
											alert("Errore prelevamento campi.");
										}

										return false;
									});

				});




$(document).ready(function(){
	var i=1;
	
	
	  $("#new").click(function(){
		if(i<=2){
	    $("#countries").append("<input type='text' id='country"+(i++)+"'>");
	    } 
	  });

	});
