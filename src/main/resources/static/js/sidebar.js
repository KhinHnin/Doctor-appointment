$(document).ready(function() {
	var sidebarStatus = 'hidden';
	$("#menu-icon").click(function(){
        
		if(sidebarStatus == 'hidden'){
			$("#hamburger").toggleClass('active');
			$("#sidebar").toggleClass('show-sidebar');
			
			sidebarStatus = 'visible';
		}
		

		else if( sidebarStatus == 'visible'){
			$("#hamburger").toggleClass('active');
			$("#sidebar").toggleClass('hide-sidebar');
			

			sidebarStatus = 'hidden';
		}


	});

});$(document).ready(function() {
	var sidebarStatus = 'hidden';
	$("#menu-icon").click(function(){
        
		if(sidebarStatus == 'hidden'){
			$("#hamburger").toggleClass('active');
			$("#sidebar").toggleClass('show-sidebar');
			
			sidebarStatus = 'visible';
		}
		

		else if( sidebarStatus == 'visible'){
			$("#hamburger").toggleClass('active');
			$("#sidebar").toggleClass('hide-sidebar');
			

			sidebarStatus = 'hidden';
		}


	});

});