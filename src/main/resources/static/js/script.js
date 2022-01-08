function loadDoc() {
  const xhttp = new XMLHttpRequest();
  xhttp.onload = function() {
    //document.getElementById("demo").innerHTML = this.responseText;

    var data=JSON.parse(this.responseText);
    var attach="<table border='1'>"
    for(var i=0;i<data.length;i++){
    	attach += "<tr"+data[i].id+"><td>"+data[i].fromMail+"</td><td>"+data[i].message+"</td></tr>";
    }
    attach += "</table>";
document.getElementById("demo").innerHTML=attach;
  }
  xhttp.open("GET", "http://localhost:8080/mails");
  xhttp.send();
}

function saveMail(){
//alert("running");
 var fromMail = document.getElementById("u-email").innerText;
 var toMail = document.getElementById("inputEmail1").value;
 var subject = document.getElementById("inputPassword1").value;
 var message = document.getElementById("message-user").value;
    const xhttp = new XMLHttpRequest();
    var json='{"fromMail":"'+fromMail+'","toMail": "'+toMail+'","subject": "'+subject+'","message": "'+message+'"}';
    //alert(json);
    xhttp.onload = function() {
   //  if(this.status == '200') {
    // alert(this.responseText);
     //location.reload();}
    
    }
  
    xhttp.open("POST", "http://localhost:8080/mails");
    xhttp.setRequestHeader("Content-Type", "application/JSON");
    xhttp.send(json);

}
var global_check=[];
$('input:checkbox').click(function () {
   if ($(this).is(':checked')) {
      var id = $(this).closest('tr').attr('id');
      //alert(id);
      global_check.push(id);
      //console.log(global_check.toString());
   }
});

$('input:checkbox').click(function () {
   if (!$(this).is(':checked')) {
      var id = $(this).closest('tr').attr('id');
     // alert(id);
      //global_check += id+","
     global_check =  global_check.filter(global_check => global_check !== id);
     // console.log(global_check.toString());
   }
});

function deleteMails(){
const xhttp = new XMLHttpRequest();
if(global_check.length>0){
    var json=global_check.toString();
    //alert(json);
    xhttp.onload = function() {
	location.reload();
    
    }
  
    xhttp.open("DELETE", "http://localhost:8080/mails-delete");
    xhttp.setRequestHeader("Content-Type", "application/JSON");
    xhttp.send(json);
    }
    else{alert("Please slelect messages to be deleted");}
}
  




