/**
 * 
 */

$(document).ready(function() {
    var url;
    $('.main2 a').on('Click', function() {
    	$( "#result" ).load( "form/address", function() {
    		  alert( "Load was performed." );
    		});
    });
}); 


