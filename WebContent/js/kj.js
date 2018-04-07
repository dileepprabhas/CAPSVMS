/**
 * 
 */

  function closeMessage(el) {
  	  el.addClass('is-hidden');
  	}

  	$('.js-messageClose').on('click', function(e) {
  	  closeMessage($(this).closest('.Message'));
  	});

  	$('#js-helpMe').on('click', function(e) {
  	  alert('Help you we will, young padawan');
  	  closeMessage($(this).closest('.Message'));
  	});

  	$('#js-authMe').on('click', function(e) {
  	  alert('Okelidokeli, requesting data transfer.');
  	  closeMessage($(this).closest('.Message'));
  	});

  	$('#js-showMe').on('click', function(e) {
  	  alert("You're off to our help section. See you later!");
  	  closeMessage($(this).closest('.Message'));
  	});

  	$(document).ready(function() {
  	  setTimeout(function() {
  	    closeMessage($('#js-timer'));
  	  }, 5000);
  	});
  	
  	 
   	$(document).ready(function() { 

  		(function ($) { 
  			$('.tab ul.tabs').addClass('active').find('> li:eq(0)').addClass('current');
  			
  			$('.tab ul.tabs li a').click(function (g) { 
  				var tab = $(this).closest('.tab'), 
  					index = $(this).closest('li').index();
  				
  				tab.find('ul.tabs > li').removeClass('current');
  				$(this).closest('li').addClass('current');
  				
  				tab.find('.tab_content').find('div.tabs_item').not('div.tabs_item:eq(' + index + ')').slideUp();
  				tab.find('.tab_content').find('div.tabs_item:eq(' + index + ')').slideDown();
  				
  				g.preventDefault();
  			} );
  		})(jQuery);

  	});
   
  	function addCategory(form) {
  	/*	 var url =form.attr("action");
  		 alert(url);
  	    var formData = {};
  	    $(form).find("input[name]").each(function (index, node) {
  	        formData[node.name] = node.value;
  	    });
  	    $.post(url, formData).done(function (data) {
  	        alert(data);
  	    });*/
  	    
  	  var url = form.attr("action");
      var formData = $(form).serializeArray();
      $.post(url, formData).done(function (data) {
          alert(data);
      });
  	} 
  	 
  	function search() {
  	  var input, filter, table, tr, td, i;
  	  input = document.getElementById("myInput");
  	  filter = input.value.toUpperCase();
  	  table = document.getElementById("exCollapsingNavbar3");
  	  tr = table.getElementsByTagName("li");
  	  for (i = 0; i < tr.length; i++) {
  	    td = tr[i].getElementsByTagName("a")[0];
  	    if (td) {
  	      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
  	        tr[i].style.display = "";
  	      } else {
  	        tr[i].style.display = "none";
  	      }
  	    }       
  	  }
  	} 