<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"	href="${pageContext.request.contextPath}/static/styleheet.css"	type="text/css" />

<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<!--<script	src="${pageContext.request.contextPath}/static/jquery-1.7.2.js"></script>-->
<script	src="${pageContext.request.contextPath}/static/moment.js"></script>
<script	src="${pageContext.request.contextPath}/static/jquery.serializejson.min.js"></script>
<title>CMS::Customer</title>
</head>
<body>
  
	<jsp:include page="/WEB-INF/views/topMenu.jsp" />
	
	<h2>Klientide haldus</h2>
	<div id="log"></div>

	<div id="CustomerArea">
		<div class="content">

			<div class="tabhead">
				<div id="main" class="tab"><span class="clink">Põhiandmed</span></div>
				<div id="adr" class="tab"><span class="clink">Aadressid</span></div>
				<div id="comm" class="tab"><span class="clink">Sidevahendid</span></div>
				<div id="grp" class="tab"><span class="clink">Grupid</span></div>
			</div>
			<div class="infonew" id="infoDivNew"></div>
			<div class="info" id="infoDiv"></div>
			<div class="error" id="errorDiv"></div>
			<div class="mainblock" id="mainDiv">
			   <div id="CustomerForm" class="customer"></div>
			   <div id="existingCustomer">
			   <div id="AdrLabelOnMain" class="customer"></div>
			   <div id="CustomerButtons" class="customer"><input type="submit" value="Salvesta" onclick="javascript:postFormX('Customer');" />
			    <input type="submit" value="Kustuta klient" onclick="javascript:deleteCustomer();" /></div>
	          </div>
			</div>
			<div class="mainblock" id="adrDiv">
			   <div id="CstAddressForm"></div>
			   <div id="CstAddressList"></div>
			   
	         </div>
			<div class="mainblock" id="commDiv">
			   <div id="CommDeviceForm"></div>
			   <div id="CommDeviceList"></div>
	         </div>
	         <div class="mainblock" id="grpDiv">
			   <div id="GroupList"></div>
	         </div>
	         
	          <div id ="progressStatus" class="progress">
              <div class="progress-wrap progress">
                  <div class="progress-bar progress"></div>             
              </div>
             </div>
		</div>
		
       
	</div>

	<script>

function isEmpty(str) {
	    return (!str || 0 === str.length);
}
	
function postForm(name){
	//Clear any error
	clearSpanErrors();
	setMsg(0,null);
	var formName = name;
	
	var url = name;
	switch(name) {
	  case "Customer":
		 url = "ajax/"+name;
		 formName = "Customer";
		 break;
	  case "NewCustomer":
			 url = "ajax/Customer";
			 formName = "NewCustomer";
			 break;
	  case "CstAddress":
			 url = "ajax/Address/Customer/"+getCustomerID();
			 formName = "CstAddress";
			break;
	  case "CstAddressOnMain":
			 url = "ajax/Address/Customer/"+getCustomerID();
			 formName = "CstAddressOnMain";
			break;
	  case "CommDevAndType":
			 url = "ajax/CommDevice/Customer/"+getCustomerID();
			formName = "CommDevAndType";
			break;
	  case "Clipboard":
		  formName = "CstAddress";
		  url = "Clipboard/POST";
		  break;
	  case "ClipboardOnMain":
		  formName = "CstAddressOnMain";
		  url = "Clipboard/POST";
		  break;		
	 } 
	
	
	$("#"+formName).submit(function( event ) {
		// Stop form from submitting normally
	event.preventDefault();
		
	//Kuupäeva kontroll
	var birthDate = $("#birthDate").val();
	if(isEmpty(birthDate) == false){
		 var patt = new RegExp("^[0-3][0-9].[0-1][0-9].[0-9]{4}$");
		 if(patt.test(birthDate) == false){

         $("#birthDateErrors").css('color', 'red');
         $("#birthDateErrors").text("Kuupäeva formaat dd.mm.yyyy");
         
         return;
	    }
	}
		  
	if(event.handled !== true) // This will prevent event triggering more then once
	   {
		if(name !=="Clipboard"){
			event.handled = true;
		}
	   
	
	  
	  var convertDate = function(val, inputName) {
		  if (inputName === "birthDate"){ 
			  if(val != null && val.length!==0){
			  return dateConvert(2,val); 
	           }
	          else{return null;}
	      }
		  return val;}
	  
	  var jserial = $("#"+formName).serializeJSON({parseWithFunction: convertDate,parseNumbers: true});
	 // var jserial = $("#"+name).serializeJSON({parseNumbers: true});
	  var jform =  JSON.stringify(jserial);
	 //log(jform);
	
	  $.ajax({
		    type: "POST",
	        url: "${pageContext.request.contextPath}/"+url,
	        datatype:"json",
	        contentType: "application/json; charset=utf-8",
	        data: jform,
	        success: function(response){
	            // we have the response
	            if(response.status == "OK"){
	            	
	            	setMsg(1,response.result);
	            
	            //Kui oli edukas, mis edasi saab
	            switch(name) {
	            case "Customer":
	      	    	//log(JSON.stringify(response));
		            setMsg(1,"Salvestamine õnnestus");
	      	    	
	      		  break;
	      	    case "NewCustomer":
	      	    	//log(JSON.stringify(response));
		            setMsg(1,"Salvestamine õnnestus");
	      	    	if(getCustomerID()==0){
		            	
		               window.history.pushState("Uus", "Uus", "${pageContext.request.contextPath}/customerManager/"+response.result.customer);
		               moveProgressBar(2);
		               setMsg(5,"Uus klient salvestatud, lisa nüüd aadress");
					   $('#adr').click();
					   
	      	    	   
		            }
	      	    	
	      	    	
	      		  break;
	      	    case "CstAddress":
	      	    	var adrComplete =  $('#progressStatus').attr('adr');
	      	    	if(getCustomerID() != 0 && $(".progress").is(':visible') && typeof adrComplete === typeof undefined){
	      	    		moveProgressBar(3);
	      	    		setMsg(6,"Aadress salvestatud, lisa sidevahendid");
	      	    		 $('#progressStatus').attr('adr',1);
	      	    		 $('#comm').click();
	      	    	}else{
	      	    		fillAddressList(getCustomerID());
	      	    	}
	      	    	
	      			break;
	      			
	      	    case "CommDevAndType":
	      	    	var commComplete =  $('#progressStatus').attr('comm');
	      	    	if(getCustomerID() != 0 && $(".progress").is(':visible')&& typeof commComplete === typeof undefined){
	      	    		moveProgressBar(4);
      	    			setMsg(10,"Sidevahend salvestatud, halda gruppe");
      	    			$('#progressStatus').attr('comm',1);
	      	    		$('#grp').click();
	      	    	}else{
	      	    		fillCommDevList(getCustomerID());	
	      	    	}
	      			break;
	      	    
		      	case "Clipboard":
		      		fillClipboard(1);
	      			break;
	      		
	      	     
	            case "ClipboardOnMain":
		      		fillClipboard(2);
	      			break;
	      		
	      	    } 
	            
	            
	          
	            
	             }else{
	            	 setMsg(2,"Salvestamine ei õnnestunud");
	                 //errorInfo = "";
	                 for(i =0 ; i < response.result.length ; i++){
	                    $("#"+response.result[i].field+"Errors").css('color', 'red');
	                     $("#"+response.result[i].field+"Errors").text(response.result[i].defaultMessage);
	                     
	                 }
	                 
	             }
	         },
	         error: function(jqXHR, textStatus){
	        	 setMsg(2,"AJAX postitus nurjus: " +url + " " + textStatus); 
	         }
	    });
	   }//Event handler end
	}); 
	
	
}

function postFormX(name){
	//Clear any error
	clearSpanErrors();
	setMsg(0,null);
	var formName = name;
	
	var url = name;
	switch(name) {
	  case "Customer":
		 url = "ajax/"+name;
		 formName = "Customer";
		  break;
	  case "CstAddressOnMain":
			 url = "ajax/Address/Customer/"+getCustomerID();
			 formName = "CstAddressOnMain";
			break;
	 } 
	
	//Kuupäeva kontroll
	var birthDate = $("#birthDate").val();
	if(isEmpty(birthDate) == false){
		 var patt = new RegExp("^[0-3][0-9].[0-1][0-9].[0-9]{4}$");
		 if(patt.test(birthDate) == false){

         $("#birthDateErrors").css('color', 'red');
         $("#birthDateErrors").text("Kuupäeva formaat dd.mm.yyyy");
         
         return;
	    }
	}
		  

	  var convertDate = function(val, inputName) {
		  if (inputName === "birthDate"){ 
			  if(val != null && val.length!==0){
			  return dateConvert(2,val); 
	           }
	          else{return null;}
	      }
		  return val;}
	  
	  var jserial = $("#"+formName).serializeJSON({parseWithFunction: convertDate,parseNumbers: true});
	  var jform =  JSON.stringify(jserial);
	 //log(jform);
	
	  $.ajax({
		    type: "POST",
	        url: "${pageContext.request.contextPath}/"+url,
	        datatype:"json",
	        contentType: "application/json; charset=utf-8",
	        data: jform,
	        success: function(response){
	            // we have the response
	            if(response.status == "OK"){
	            	
	            	setMsg(1,response.result);
	            
	            //Kui oli edukas, mis edasi saab
	            switch(name) {
	      	    case "Customer":
	      	    	//log(JSON.stringify(response));
		            setMsg(1,"Salvestamine õnnestus");
	      	    	if(getCustomerID()==0){
		            	
		               window.history.pushState("Uus", "Uus", "${pageContext.request.contextPath}/customerManager/"+response.result.customer);
		            }
	      	    	postFormX("CstAddressOnMain");
	      	    	
	      		  break;
	      	    } 
           
	            
	             }else{
	            	 setMsg(2,"Salvestamine ei õnnestunud");
	            	 if(name ==="Customer"){postFormX("CstAddressOnMain");}
	            	 
	                 //errorInfo = "";
	                 for(i =0 ; i < response.result.length ; i++){
	                    $("#"+response.result[i].field+"Errors").css('color', 'red');
	                     $("#"+response.result[i].field+"Errors").text(response.result[i].defaultMessage);
	                     
	                 }
	                 
	             }
	         },
	         error: function(jqXHR, textStatus){
	        	 setMsg(2,"AJAX postitus nurjus: " +url + " " + textStatus); 
	         }
	    });
	
	
	
	
}


function loadForm(name,id){
	if(isNaN(id)){
	   id = 0;	
	}
	
	setMsg(0,null);
		
	var url = "ajax/"+name+"/one/"+id;
	var item = "#"+name+"Form";
	switch(name) {
	  case "Customer":
		  url = "ajax/"+name+"/one/"+id;
		  
		  break;
	  case "NewCustomer":
		  url = "ajax/Customer/one/"+id;
		  item = "#CustomerForm";
		  break;
	  case "CstAddress":
		      
			 url = "ajax/Address/one/"+id;
			 item = "#AdrLabel"+id;
	  break;
	  
	  case "CstAddressOnMain":
		     name = "CstAddressOnMain";
			 url = "ajax/Address/Customer/"+id;
			 item = "#AdrLabelOnMain";
	  break;
	  
	  case "Clipboard":
			 url = "Clipboard/GET";
			 name = "CstAddress";
			 item = "#AdrLabel"+id;
	  break;
	  
	  case "CommDevAndType":
			 url = "ajax/CommDevice/one/"+id;
			 item = "#CommLabel"+id;
	  break;
	  
	 
	} 
	
	$( item ).load( "${pageContext.request.contextPath}/form/"+name, function() {
		if(name == "Customer"){
		  $("#CustomerSubmit").remove();
		 
		}
		if(id!=0){
		var data = "${pageContext.request.contextPath}/"+url;
		  $.getJSON( data, { format: "json"})
		    .done(function( data ) {
		    	//log("Loading "+JSON.stringify(data));
		      $.each(data, function(key, value){
		    	 
		    	 if(value != null && key==='birthDate'){value = dateConvert(1,value);}
		    	 if(value != null && key==='addressType' && value == 1){
		    		 $('[name='+key+']', '#'+name).prop("checked", "checked");
		    	 }else{
			         $('[name='+key+']', '#'+name).val(value);
		    	 }
			  });
		      
		    })
		    .fail(function(){
		    	setMsg(2,"Ajax päring ei õnnestunud: "+data);
		    	if(name === 'CstAddressOnMain'){
		    		setMsg(3,"Aadressi pole loodud");
			      }
		    	if(name === 'Customer'){
		    		setMsg(3,"Ei saa klienti kätte");
			      }
		    	}
		    )
		    //if(name === "CommDevAndType"){$("#commDeviceType").prop("disabled", true);}
		}
		
		if(name === 'CstAddress'){
			  fillClipboard(1);
	      }
		if(name === 'CstAddressOnMain'){
			  fillClipboard(2);
	      }
	});
	
};

function dateConvert(mode,date){
	if(mode ==1 && date != null){
		return moment(date).format('DD.MM.YYYY');
	}
	if(mode ==2 && date != null){
		return moment(date,'DD.MM.YYYY').format('x');
	}
		
}

function clearSpanErrors(){
	 $('.spanError').css('color', '#fff');
	 setMsg(0,null);
}

//Varja või näida info. error 
function setMsg(mode,info){
	switch(mode) {
	  case 1:
		  $("#infoDiv").show();
		  $("#errorDiv").hide();
		  $("#infoDiv" ).empty().append(info);
		  break;  
	  case 2:
		  $("#infoDiv").hide();
		  $("#errorDiv").show();
		  $("#errorDiv" ).empty().append(info);
	      break;
	  case 3:
		  $("#infoDiv").show();
		  $("#errorDiv").hide();
		  $("#infoDiv" ).append(info+"<br>");
		  break;
	  case 4:
		  $("#infoDiv").hide();
		  $("#errorDiv").show();
		  $("#infoDiv" ).append(info);
		  break; 
	  case 5:
		  if(getCustomerID()!=0){
		  info += ' <span class="link" onClick="javascript:skipPart(3)">Jäta vahele</span>';
		  }
		  $("#infoDivNew").show();
		  $("#infoDivNew" ).empty().append(info);
		  break;
	  case 6:
		  if(getCustomerID()!=0){
		  info += ' <span class="link" onClick="javascript:skipPart(4)">Jäta vahele</span>';
		  }
		  $("#infoDivNew").show();
		  $("#infoDivNew" ).empty().append(info);
		  break;
	  case 8:
		  if(getCustomerID()!=0){
		  info += ' <span class="link" onClick="javascript:skipPart(5)">Klientide otsing</span>';
		  }
		  $("#infoDivNew").show();
		  $("#infoDivNew" ).empty().append(info);
		  break;
	  case 10:
		  $("#infoDivNew").show();
		  $("#infoDivNew" ).empty().append(info);
		  break;
	  case 11:
		  $("#infoDivNew").hide();
		  $("#infoDivNew" ).empty();
		  break;
	  default:
		  $("#infoDiv").empty();
          $("#errorDiv").empty();
		  $("#infoDiv").hide();
	      $("#errorDiv").hide();
	} 
}

function skipPart(step){
	moveProgressBar(step);
	if(step == 3){
	setMsg(6,"");
	   $('#comm').click();
	}
	if(step == 4){
		setMsg(11,"");
		   $('#grp').click();
	}
	if(step == 5){
		window.open("${pageContext.request.contextPath}/Search","_self");
	}
}

function log(message){
	$( "#log" ).append( message +"<br>"); 
}


function fillFirstAddressList(){
	
	var html='';
	html += '<div class="address" id="AdrLabel0"></div>';
	$('#CstAddressList').empty().append(html);
	 
}


function fillAddressList(id){
	
	var html='';
	var data = "${pageContext.request.contextPath}/ajax/Address/CustomerAll/"+id;
	  $.getJSON( data, { format: "json"})
	    .done(function( data ) {
	    	
	      $.each(data, function(i, obj){
	    	  
	    	  
	    	  html += '<div class="address" id="AdrLabel'+obj.cstAddress+'">';
	    	  html += '<table><tr><td>Peamine aadress</td><td>';
	    	  
	    	  html += '<input type="checkbox" id="AdrIsMain'+obj.cstAddress+'" class="AdrIsMain"';
	    	  if(obj.addressType != null && obj.addressType ==1){
	    		  html += ' checked="checked" disabled'; 
	    	  }
	    	  
	    	  html += ' onClick="setMainAddress('+obj.cstAddress+');"/></td></tr>';
	    	  html += '<tr><td>ID</td><td>' +obj.cstAddress + '</td></tr>';
	    	  html += '<tr><td>Aadress</td><td>' +obj.address + '</td></tr>';
	    	  html += '<tr><td>Maja</td><td>' +obj.house + '</td></tr>';
	    	  html += '<tr><td>Linn/Küla</td><td>' +obj.townCounty + '</td></tr>';
	    	  html += '<tr><td>Maakond</td><td>' +obj.county + '</td></tr>';
	    	  html += '<tr><td>Indeks</td><td>' +obj.zip + '</td></tr>';
	    	  html += '<tr><td>Märkused</td><td>' +obj.note + '</td></tr>';
	    	  html += '<tr><td>Kustutamisele</td><td><input type="checkbox" id="AdrSelected'+obj.cstAddress+'" class="AdrSelected"/></td></tr>';
	    	  html += '<tr><td>Muuda</td><td><input class="AdrChangeButton" type="submit" value="Muuda" onClick="javascript:editAddress('+obj.cstAddress+');"/></td></tr></table></div>';
		  });
	      
	      
	      html += '<div class="address" id="AdrLabel0">';
	      html += '<input class="AdrChangeButton" type="submit" value="Lisa Uus" onClick="javascript:editAddress(0);"/></div>';
	      
	      html += '<div class="address"><a href = "javascript:deleteSelected(1);">Kustuta valitud</a></div>';
	      
	      $('#CstAddressList').empty().append(html);
	    })
	    .fail(function(){setMsg(2,"Ajax päring ei õnnestunud: "+ data);})
}

function fillFirstCommDevList(){
	
	var html='';
	      html += '<div class="device" id="CommLabel0"></div>';
	      $('#CommDeviceList').empty().append(html);
	
}

function fillCommDevList(id){
	
	var html='';
	var data = "${pageContext.request.contextPath}/ajax/CommDevice/CustomerAll/"+id;
	  $.getJSON( data, { format: "json"})
	    .done(function( data ) {
	    	
	      $.each(data, function(i, obj){
	    	  
	    	  html += '<div class="device" id="CommLabel'+obj.commDevice+'">';
	    	  html += '<span class="link" onClick="javascript:setOrder('+obj.commDevice+',1)">ülesse</span> <span class="link" onClick="javascript:setOrder('+obj.commDevice+',2)">alla</span>';
	    	  html += '<table><tr><td>'+obj.typeName+'</td><td>'+ obj.valueText+'</td></tr>';
	    	  html += '<tr><td>Kustutamisele</td><td><input type="checkbox" id="CommSelected'+obj.commDevice+'" class="CommSelected"/></td></tr>';
	    	  html += '<tr><td>Muuda</td><td><input class="CommChangeButton" type="submit" value="Muuda" onClick="javascript:editCommDevice('+obj.commDevice+');"/></td></tr></table></div>';
		  });
	      
	      
	      html += '<div class="device" id="CommLabel0">';
	      html += '<input class="CommChangeButton" type="submit" value="Lisa Uus" onClick="javascript:editCommDevice(0);"/></div>';
	      
	      html += '<div class="device"><a href = "javascript:deleteSelected(2);">Kustuta valitud</a></div>';
	      
	      $('#CommDeviceList').empty().append(html);
	    })
	    .fail(function(){setMsg(2,"Ajax päring ei õnnestunud: "+ data);})
}

function fillGroupList(id){
	
	var html='';
	var data = "${pageContext.request.contextPath}/ajax/Group/Get/"+id;
	  $.getJSON( data, { format: "json"})
	    .done(function( data ) {
	      html += '<div class="group" id="groupLabel"><table>';
	      html += '<tr><th>Grupi nimi</th><th>Kirjeldus</th><th>grupis</th></tr>'
	      $.each(data, function(i, obj){
	    	  html += '<tr><td>'+obj.name+'</td><td>'+ obj.description+'</td><td>';
	    	  
	    	  html += '<input type="checkbox" id="isInGroup'+obj.group+'" class="isInGroup"';
	    	  if(obj.customer != null){
	    		  html += ' checked="checked"'; 
	    	  }
	    	  html += '/></td></tr>';
	    	  
		  });
	      
	      
	      html += '</table></div><div class="group">';
	      html += '<input class="GroupChangeButton" type="submit" value="Salvesta" onClick="javascript:editGroups();"/></div>';
	      
	      $('#GroupList').empty().append(html);
	    })
	    .fail(function(){setMsg(2,"Ajax päring ei õnnestunud: "+ data);})
}

function fillClipboard(type){
	
	var name = "Clipboard";
	var paste = "CstAddress";
	if(type == 2){
		name = "ClipboardOnMain";
		paste = "CstAddressOnMain";
	}
	
	$('#'+name).empty();
	var html='';
	var data = "${pageContext.request.contextPath}/Clipboard/GET";
	  $.getJSON( data, { format: "json"})
	    .done(function( obj ) {
	    	if(obj!=null){
	    	  html += '<div class="clipboard">';
	 	      html += '<table>';
	    	  html += '<tr><td>Aadress</td><td>' +obj.address + '</td></tr>';
	    	  html += '<tr><td>Maja</td><td>' +obj.house + '</td></tr>';
	    	  html += '<tr><td>Linn/Küla</td><td>' +obj.townCounty + '</td></tr>';
	    	  html += '<tr><td>Maakond</td><td>' +obj.county + '</td></tr>';
	    	  html += '<tr><td>Indeks</td><td>' +obj.zip + '</td></tr>';
	    	  html += '<tr><td>Märkused</td><td>' +obj.note + '</td></tr>';
	    	  html += '<tr><td><span class="link" onClick="javascript:clearClipboard(\''+name+'\');">Tühjenda</span></td>';
	    	  html += '<td><input class="AdrChangeButton" type="submit" value="Kleebi" onClick="javascript:pasteAddress(\''+paste+'\');"/></td></tr></table></div>';
		  
	      $('#'+name).empty().append(html);
	    	}
	    })
	
}

function editAddress(id){
	$('#AdrLabel'+id).empty();
	setMsg(0,null);
	//Keela teised nupud
	$(".AdrChangeButton").each(function() {
		$(this).prop("disabled", true);
	});
	
	loadForm('CstAddress',id);
}

function pasteAddress(name){
	$("#"+name).submit(function( event ) {
		
	event.preventDefault();
	
	setMsg(0,null);
	var data = "${pageContext.request.contextPath}/Clipboard/GET";
	  $.getJSON( data, { format: "json"})
	    .done(function( data ) {
	    	//log("Loading "+JSON.stringify(data));
	      $.each(data, function(key, value){
	    	 
	    	 
	    	 if(key==='address' || key==='county' || key==='house' || key==='note' || key==='zip' || key==='townCounty' ){
	    		    $('[name='+key+']', '#'+name).val(value);
	    	 }
		  });
	       })
	    .fail(function(){setMsg(2,"Ajax päring ei õnnestunud: "+data);})
	});   
	
}
//Tühjenda clipboard
function clearClipboard(name){
	setMsg(0,null);
	link = "${pageContext.request.contextPath}/Clipboard/CLEAR";
	 $.getJSON( link, { format: "json"})
	    .done(function( data ) {
	    	if(data.status == "OK"){
	    		setMsg(1,data.result);
	    		$('#'+name).empty();
	               }else{
	            setMsg(2,data.result);
	          }	
	    })
	  .fail(function(){setMsg(2,"Ajax päring ei õnnestunud: "+data);
	  });
}

function editCommDevice(id){
	$('#CommLabel'+id).empty();
	setMsg(0,null);
	//Keela teised nupud
	$(".CommChangeButton").each(function() {
		$(this).prop("disabled", true);
	});
	
	loadForm('CommDevAndType',id);
}

$(document).ready(function() {
	$('#main').click();
	
}); 

//säti peamine aadress
function setMainAddress(addressID){
	setMsg(0,null);
	
		var url = "Address/Customer/"+getCustomerID()+"/Active/"+addressID;
		if($('#AdrIsMain'+addressID).prop("disabled") != true){
			
			var data = "${pageContext.request.contextPath}/ajax/"+url;
			  $.getJSON( data, { format: "json"})
			    .done(function( data ) {
			    	//log("Loading "+JSON.stringify(data));
			    	
			    	if(data.status == "OK"){
			            setMsg(1,"Salvestatud. Uue peamise aadressi ID: "+ addressID);
			            $('.AdrIsMain').prop("checked", "");
						$('.AdrIsMain').prop("disabled", false);
						
					   
					   $('#AdrIsMain'+addressID).prop("checked", "checked");
					   $('#AdrIsMain'+addressID).prop("disabled", true);
			          }else{
			            setMsg(2,"Salvestamine ei õnnestunud: "+ data.result);
			          }	
			      
			    })
			  .fail(function(){setMsg(2,"Ajax päring ei õnnestunud: "+data);
			  $('#AdrIsMain'+addressID).prop("checked", "");
			  })
		   
		}
		
}

//Muuda Järjekorda
function setOrder(id,order){
	setMsg(0,null);
	link = "${pageContext.request.contextPath}/ajax/CommDevice/Order/"+id+"/"+order;
	 $.getJSON( link, { format: "json"})
	    .done(function( data ) {
	    	if(data.status == "OK"){
	    		setMsg(1,data.result);
	    		fillCommDevList(getCustomerID());
	               }else{
	            setMsg(2,data.result);
	          }	
	    })
	  .fail(function(){setMsg(2,"Ajax päring ei õnnestunud: "+data);
	  });
	
}


//Kustuta valitud
function deleteSelected(type){
	var url = "";
	var counter = 0;
	setMsg(0,null);
	if(type == 1){
	var errorAdr = "";
		$(".AdrSelected").each(function() {
			  if( $(this).is(':checked')){
				if($('#'+$(this).attr('id').replace("AdrSelected","AdrIsMain")).is(':checked')){
					errorAdr = " Peamist aadressi saab kustutada vaid koos kliendiga";				
				}
			    else{
				if(counter !=0){url += ",";}
			    url += $(this).attr('id').replace("AdrSelected","");
			    counter++;
			    }
			  }
			});
		if(isEmpty(errorAdr)==false){setMsg(2,errorAdr);}
		else{
		link = "${pageContext.request.contextPath}/ajax/Address/DeleteMultiple/"+url;
			 $.getJSON( link, { format: "json"})
			    .done(function( data ) {
			    	if(data.status == "OK"){
			    		setMsg(1,data.result+errorAdr);
			    		
			               }else{
			            setMsg(2,data.result+errorAdr);
			          }	
			    	fillAddressList(getCustomerID());
			    })
			  .fail(function(){setMsg(2,"Ajax päring ei õnnestunud: "+data);
			  });
		}
	
	}
	if(type == 2){
		
		$(".CommSelected").each(function() {
		  if( $(this).is(':checked')){
		    //log($(this).attr('id').replace("CommSelected",""));
		    if(counter !=0){url += ",";}
		    url += $(this).attr('id').replace("CommSelected","");
		    counter++;
		  }
		});
		link = "${pageContext.request.contextPath}/ajax/CommDevice/DeleteMultiple/"+url;
		 $.getJSON( link, { format: "json"})
		    .done(function( data ) {
		    	if(data.status == "OK"){
		    		setMsg(1,data.result);
		    		fillCommDevList(getCustomerID());
		               }else{
		            setMsg(2,data.result);
		          }	
		    })
		  .fail(function(){setMsg(2,"Ajax päring ei õnnestunud: "+data);
		  });
		
		}
}

function editGroups(){
	var url = "";
	var counter = 0;
	setMsg(0,null);
	$(".isInGroup").each(function() {
		  if( $(this).is(':checked')){
		    
		    if(counter !=0){url += ",";}
		    url += $(this).attr('id').replace("isInGroup","");
		    counter++;
		  }
		});
	if(counter == 0){url="CLEARALL";}
		link = '${pageContext.request.contextPath}/ajax/Group/Put/'+getCustomerID()+'/'+url;
		 $.getJSON( link, { format: "json"})
		    .done(function( data ) {
		    	if(data.status == "OK"){
		    		if(getCustomerID() != 0 && $(".progress").is(':visible')){
		    			setMsg(8,data.result);	
		    		}
		    		else{   
		    		setMsg(1,data.result);}
		    		   
		    		   fillGroupList(getCustomerID());
		               
		    	  }else{
		              setMsg(2,data.result);
		          }	
		    })
		  .fail(function(){setMsg(2,"Ajax päring ei õnnestunud: "+data);
		});
}

//Navigeerimine tabide vahel
$('.tab').click(function() {
	  $('.tab').css('background-color', '#fff');
	  setMsg(0,null); 
	  $(this).css('background-color', 'linen');
	  
		  var customerID = getCustomerID(); 
		  
		  var progress =  $('.progress-wrap').attr('progress-percent');
		  if(customerID != 0 && typeof progress === typeof undefined){
			  $(".progress").hide();
			  $("#infoDivNew").hide();
		  }
		  
		  switch($(this).attr('id')) {
		  case "main":
			  $(".mainblock").hide();
			  $("#mainDiv").show();
			  if(customerID!=0){
				  setMsg(11,null);
				 $("#existingCustomer").show();
			     loadForm('Customer',customerID);
			     loadForm('CstAddressOnMain',customerID);
			  }else{
				  $("#existingCustomer").hide();
				  loadForm('NewCustomer',customerID);  
				  moveProgressBar(1);
				  setMsg(10,"Sisesta uue kliendi andmed");
				  
			  }
		        break;  
		  case "adr":
			  if(progress >25 || (customerID != 0 && $(".progress").is(':hidden'))){
			  $(".mainblock").hide();
			  $("#adrDiv").show();
			  
			   var adrComplete =  $('#progressStatus').attr('adr');
			   if(progress >25 && typeof adrComplete === typeof undefined){
				   fillFirstAddressList();     
				   $('#AdrLabel0').empty();
				   loadForm('CstAddress',0);
			   }
			   else{
				   if(typeof adrComplete !== typeof undefined){setMsg(11,null);}
				   fillAddressList(customerID);   
			   }
			    
			  }else{setMsg(10,"Põhiandmed tühjad");}
		        break;
		  case "comm":
			  if(progress >50 || (customerID != 0 && $(".progress").is(':hidden'))){
			  $(".mainblock").hide();
			  $("#commDiv").show();
			  
			  var commComplete =  $('#progressStatus').attr('comm');
			  if(progress >50 && typeof commComplete === typeof undefined){
				   fillFirstCommDevList();     
				   $('#CommLabel0').empty();
				   loadForm('CommDevAndType',0);
			   }
			   else{
				   if(typeof commComplete !== typeof undefined){setMsg(11,null);}
				   fillCommDevList(customerID);   
			   }
			  
			  
			  //loadForm('CommDevice',customerID);
			  }else{setMsg(5,"Aadress täitmata");}
		        break;
		  case "grp":
			  if(progress >75 || (customerID != 0 && $(".progress").is(':hidden'))){
			  $(".mainblock").hide();
			  $("#grpDiv").show();
			    fillGroupList(customerID);
			    if(progress >75){setMsg(8,"Ongi kõik");}
			    
			  //log(dateConvert(2,"28.07.1980"));
			  }else{
				  if(progress >50){
					  setMsg(5,"Aadress täitmata");
				  }
				  else{
				  setMsg(6,"Sidevahendeid pole");}
				}
		        break;
		  default:
			  alert("Kummaline valik");
		} 
		  
	});

function deleteCustomer(){
	if(getCustomerID()!= 0){
		
		setMsg(1,"Kustutan "+getCustomerID());
		var link = "${pageContext.request.contextPath}/ajax/Customer/Delete/"+getCustomerID();
		 $.getJSON( link, { format: "json"})
		    .done(function( data ) {
		    	if(data.status == "OK"){
		    		setMsg(1,data.result);
		    		sleep(5000);
		    		skipPart(5);
		               }else{
		            setMsg(2,data.result);
		          }	
		    })
		  .fail(function(){setMsg(2,"Ajax päring ei õnnestunud: "+data);
		  });
		   
		
	}
	
}

function sleep(milliseconds) {
    var start = new Date().getTime();
    for (var i = 0; i < 1e7; i++) {
        if ((new Date().getTime() - start) > milliseconds){
            break;
        }
    }
}

function getCustomerID(){
	var url = window.location.pathname;
	var id = url.substring(url.lastIndexOf('/')+1);
	return id;
}


function moveProgressBar(step) {
	  var percent = 25;
      switch(step){
      case 1:
    	  percent = 25;
    	  break;
      case 2:
    	  percent = 50;
    	  break;
      case 3:
    	  percent = 75;
    	  break;
      case 4:
    	  percent = 100;
    	  break;
      
      default:
    	  percent = 25;
    		  
      }
      $('.progress-wrap').attr('progress-percent',percent);
      var getPercent = (percent / 100);
      var getProgressWrapWidth = $('.progress-wrap').width();
      var progressTotal = getPercent * getProgressWrapWidth;
      var animationLength = 2500;
      $('.progress-bar').stop().animate({
          left: progressTotal
      }, animationLength);
  }

</script>
	

</body>
</html>