$(document).ready(
		function() {

			$("#form").submit(
					function(event) {

						event.preventDefault();

						var form = {}
						form["description"] = $("#description").val();
						form["date"] = $("#date").val();
						form["email"] = $("#email").val();

						$("#btn-save").prop("disabled", true);

						$.ajax({
							type : "POST",
							contentType : "application/json",
							url : "/api",
							data : JSON.stringify(form),
							cache : false,
							timeout : 600000,

							success : function(data) {
								var json = "<div class="
										+ "\"alert alert-info\">"
										+ "<p>Data saved.</p>" + "</div>";
								$('#info-input').html(json);

								console.log("SUCCESS : ", data);
								$("#btn-save").prop("disabled", false);
								$("#form")[0].reset();
							},

							error : function(e) {
								var json = "<div class="
										+ "\"alert alert-info\">"
										+ "<p>All fields must be filled."
										+ "</p></div>";
								$('#info-input').html(json);

								console.log("ERROR : ", e);
								$("#btn-save").prop("disabled", false);
							}

						});

					});
		});
