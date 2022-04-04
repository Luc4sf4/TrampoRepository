		jQuery(document).ready(function() {

			$.ajax({
				method :"GET",
				url : "http://localhost:8081/api/body/id",
				data : "id=" + 3,
				success : function(response) {
				console.log(response);
					$("#id").val(response.id);
					$("prorpiedadeH").text(response.propriedade);
					$("valorH").text(response.valor);
							
			
				}
				
				
			}).fail(function(xhr, status, errorThrown) {
				alert("Erro ao Buscar Usuario por id: " + xhr.reponseText);

			});
			
			
			//appends an "active" class to .popup and .popup-content when the "Open" button is clicked
$(".open").on("click", function() {

  $(".popup-overlay, .popup-content").addClass("active");
});

//removes the "active" class to .popup and .popup-content when the "Close" button is clicked 
$(".close, .popup-overlay").on("click", function() {
  $(".popup-overlay, .popup-content").removeClass("active");
});
			
			
			
			
				});	
			
		
			

	