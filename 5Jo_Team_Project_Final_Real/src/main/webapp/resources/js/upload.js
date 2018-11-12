var uf = ''; 
function sw_file_add(size, ext) 
{ 
    eval('sw_file_add_form' + uf).innerHTML += "<input type=file name=file[] size='" + size + "' " + ext + "><div id='sw_file_add_form" + (uf+1) + "'></div>"; 
    uf++; 
} 