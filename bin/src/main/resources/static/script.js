$(document).ready(function() {
	$("#index").click(function() {
		$.get({
			url: "/home",
			success: function(response) {
				$(".content").html(response);
			}
		});
	});
	$("#lichhoc").click(function() {
    		$.get({
    			url: "/lichhoc",
    			success: function(response) {
    				$(".content").html(response);
    			}
    		});
    	});
})


