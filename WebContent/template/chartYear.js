$(document).ready(function() {
			$(".preloader").show();
			
			$.ajax({
				url : "/ProjectBDII/ServletYear",
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
						var ctx = document.getElementById('myChart2').getContext('2d');
						var myChart = new Chart(ctx, {
						    type: 'line',
						    data: {
						        labels: msg.rating,
						        datasets: [{
						            label: "Movies for year",
						            data: msg.count,
						            backgroundColor: [
						            	'rgb(218, 101, 13, 0.2)'
						            ],
						            borderColor: [
						            	'rgb(218, 101, 13, 1)'
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
