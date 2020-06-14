$(document).ready(function() {
			$(".preloader").show();
			
			$.ajax({
				url : "/ProjectBDII/ServletES",
				type : "POST",
				dataType : 'JSON',
				async : false,
				data : {
					"flag" : 7
				},
				success : function(msg) {
					
					if(!msg.result){
						console.log("non c'è il result");
					}
					else{
						console.log(msg.count);
						/* */
						var ctx = document.getElementById('myChart').getContext('2d');
						var myChart = new Chart(ctx, {
						    type: 'pie',
						    data: {
						        labels: msg.rating,
						        datasets: [{
						            label: "Rating Netflics",
						            data: msg.count,
						            backgroundColor: [
						                'rgba(255, 99, 132, 0.2)',
						                'rgba(54, 162, 235, 0.2)',
						                'rgba(255, 206, 86, 0.2)',
						                'rgba(75, 192, 192, 0.2)',
						                'rgba(153, 102, 255, 0.2)',
						                'rgba(255, 159, 64, 0.2)',
						                'rgba(0, 128, 0, 0.2)',
						                'rgba(127, 255, 212, 0.2)',
						                
						                'rgb(255, 235, 0, 0.2)',
						                'rgba(255, 0, 141, 0.2)',
						                'rgba(139, 195, 74, 0.2)',
						                'rgba(121, 85, 72, 0.2)',
						                'rgbargb(127, 255, 0, 0.2)',
						                'rgba(255, 0, 0, 0.2)'
						            ],
						            borderColor: [
						                'rgba(255, 99, 132, 1)',
						                'rgba(54, 162, 235, 1)',
						                'rgba(255, 206, 86, 1)',
						                'rgba(75, 192, 192, 1)',
						                'rgba(153, 102, 255, 1)',
						                'rgba(255, 159, 64, 1)',
						                'rgba(0, 128, 0, 1)',
						                'rgb(127, 255, 212,1)',
						                'rgb(255, 235, 0, 1)',
						                'rgba(255, 0, 141, 1)',
						                'rgba(139, 195, 74, 1)',
						                'rgba(121, 85, 72, 1)',
						                'rgbargb(127, 255, 0, 1)',
						                'rgba(255, 0, 0, 1)'
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
		

		return false;

});
