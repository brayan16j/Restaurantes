$(document).ready(function () {
    getRestaurantesList()
    getMenusList()
});

function getFrontRestauranteData() {
    let k = {
        id: $("#id").val(),
        razonSocial: $("#razonSocial").val(),
        nombreComercial: $("#nombreComercial").val(),
        tipoRestaurante: $("#tipoRestaurante").val(),
        ciudad: $("#ciudad").val(),
        horaApertura: $("#horaApertura").val(),
        horaCierre: $("#horaCierre").val(),

    }
    return k;
}

function cleanFields() {
    $("#id").val("");
    $("#razonSocial").val("");
    $("#nombreComercial").val("");
    $("#tipoRestaurante").val("");
    $("#ciudad").val("");
    $("#horaApertura").val("");
    $("#horaCierre").val("");


}

function saveRestaurante() {
    let data = getFrontRestauranteData();
    data.id = null;
    let dataToSend = JSON.stringify(data)
    $.ajax({
        url: "/api/restaurante/save",
        type: "POST",
        datatype: "JSON",
        contentType: 'application/json',
        data: dataToSend,
        success: function (p) {
            console.log(p);
            cleanFields();
            getRestauranteList();
        },
        error: function (xhr, status) {
            //alert('ha sucedido un problema')
        },
        complete: function (xhr, status) {
            //alert('Peticion Realizada')
        }
    });
}


function getRestauranteList() {
    $.ajax({
        url: "/api/restaurante/all",
        type: "GET",
        datatype: "JSON",
        success: function (p) {
            console.log('entro');
            $("#results").empty();
            let l = "";
            for (let i = 0; i < p.length; i++) {

                let menuList = "";
                for (let menus of p[i].menus) {
                    console.log(menus['nombreMenu']);
                    console.log("*************");
                    menuList += '<li>' + menus['nombreMenu'] + ' $ ' + menus['precio'] + '</li>';
                }

                l += ` 
                   <div class="col">
                            <div class="card"><div class="card-header">
                                    <h5 class="card-title">${p[i].razonSocial}</h5>
                            </div>
                           <!--<img src="..." class="card-img-top" alt="...">-->
                               <div class="card-body">
                                   <p class="card-text">Nombre Comercial: ${p[i].nombreComercial}</p>
                                   <p class="card-text">Tipo: ${p[i].tipoRestaurante}</p>
                                   <p class="card-text">Ciudad: ${p[i].ciudad}</p>
                                   <p class="card-text">Hora Apertura: ${p[i].horaApertura}</p>
                                   <p class="card-text">Hora Cierre: ${p[i].horaCierre}</p> 
                                    
                               `;

                l += `                
                                   <p class="card-text">Menus:
                                    <ul>${menuList}</ul>
                                   </p>
                                  `;

                l += `
                               </div>
                               <div class="card-footer">
                                    <button type="button" class="btn btn-outline-primary" onclick="getRestauranteById(${p[i].id})">Actualizar</button>
                                    <button type="button" class="btn btn-outline-primary" onclick="deleteRestauranteById(${p[i].id})">Eliminar</button>
                                            
                               </div>
                       </div>
                   </div>
                   `;
            }
            $("#results").append(l);

        },
        error: function (xhr, status) {
            //alert('ha sucedido un problema')
        },
        complete: function (xhr, status) {
            //alert('Peticion Realizada')
        }
    });
}


function getRestauranteById(idRestaurante) {
    $(".saveButtonJL").hide();
    $(".updateButtonJL").show();
    $.ajax({
        url: "/api/restaurante/" + idRestaurante,
        type: "GET",
        datatype: "JSON",
        success: function (p) {
            console.log(p);
            $("#id").val(p.id);
            $("#razonSocial").val(p.razonSocial);
            $("#nombreComercial").val(p.nombreComercial);
            $("#tipoRestaurante").val(p.tipoRestaurante);
            $("#ciudad").val(p.ciudad);
            $("#horaApertura").val(p.horaApertura);
            $("#horaCierre").val(p.horaCierre);

        },
        error: function (xhr, status) {
            //alert('ha sucedido un problema')
        },
        complete: function (xhr, status) {
            //alert('Peticion Realizada')
        }
    });
}

function updateRestaurante() {
    let data = getFrontRestauranteData();

    let dataToSend = JSON.stringify(data)
    $.ajax({
        url: "/api/restaurante/update",
        type: "PUT",
        datatype: "JSON",
        contentType: 'application/json',
        data: dataToSend,
        success: function (p) {
            console.log(p);
            cleanFields();
            getRestauranteList();
            $(".saveButtonJL").show();
            $(".updateButtonJL").hide();
        },
        error: function (xhr, status) {
            //alert('ha sucedido un problema')
        },
        complete: function (xhr, status) {
            //alert('Peticion Realizada')
        }
    });
}

function cancelUpdateRestaurante() {
    cleanFields();
    $(".saveButtonJL").show();
    $(".updateButtonJL").hide();
}

function deleteRestauranteById(idRestaurante) {
    $.ajax({
        url: "/api/restaurante/" + idRestaurante,
        type: "DELETE",
        datatype: "JSON",
        success: function (p) {
            console.log(p);
            getRestauranteList();
        },
        error: function (xhr, status) {
            //alert('ha sucedido un problema')
        },
        complete: function (xhr, status) {
            //alert('Peticion Realizada')
        }
    });
}


function getFrontMenuData() {
    let k = {
        id: $("#id").val(),
        tipoMenu: $("#tipoMenu").val(),
        nombreMenu: $("#nombreMenu").val(),
        precio: $("#precio").val(),
        restaurante: {
            id: $("#RestauranteSelected").val()
        }
    }
    return k;
}

function getRestaurantesList() {
    $.ajax({
        url: "/api/restaurante/all",
        type: "GET",
        datatype: "JSON",
        success: function (p) {
            console.log(p);
            for (let i = 0; i < p.length; i++) {
                let s = `
                    <option value="${p[i].id}">${p[i].razonSocial}</option>
                `;
                $("#RestauranteSelected").append(s);
            }
        },
        error: function (xhr, status) {
            //alert('ha sucedido un problema')
        },
        complete: function (xhr, status) {
            //alert('Peticion Realizada')
        }
    });
}

function cleanFieldsMenu() {
    $("#id").val("");
    $("#tipoMenu").val("");
    $("#nombreMenu").val("");
    $("#precio").val("");
    $("#RestauranteSelected").val("").change();
}

function saveMenu() {
    let data = getFrontMenuData();
    data.id = null;
    let dataToSend = JSON.stringify(data)
    $.ajax({
        url: "/api/menu/save",
        type: "POST",
        datatype: "JSON",
        contentType: 'application/json',
        data: dataToSend,
        success: function (p) {
            console.log(p);
            cleanFieldsMenu();
            getMenuList();
        },
        error: function (xhr, status) {
            //alert('ha sucedido un problema')
        },
        complete: function (xhr, status) {
            //alert('Peticion Realizada')
        }
    });
}


function getMenuList() {
    $.ajax({
        url: "/api/menu/all",
        type: "GET",
        datatype: "JSON",
        success: function (p) {
            console.log(p);
            $("#menu").empty();
            let l = "";
            for (let i = 0; i < p.length; i++) {
                let ingredienteList = "";
                for (let ingrediente of p[i].ingredientes) {
                    console.log(ingrediente['nombre']);
                    console.log("*************");
                    ingredienteList += '<li>' + ingrediente['nombre'] + ' Calorias: ' + ingrediente['calorias'] + '</li>';
                }

                l += ` 
                   <div class="col">
                            <div class="card"><div class="card-header">
                                    <h5 class="card-title">${p[i].tipoMenu}</h5>
                            </div>
                           <!--<img src="..." class="card-img-top" alt="...">-->
                               <div class="card-body">
                                   <p class="card-text">Tipo: ${p[i].nombreMenu}</p>
                                   <p class="card-text">Precio: ${p[i].precio}</p>
                                   
                                   `;

                l += `                
                                   <p class="card-text">Ingredientes:
                                    <ul>${ingredienteList}</ul>
                                   </p>
                                  `;

                l += ` 
                               </div>
                               <div class="card-footer">
                                    <button type="button" class="btn btn-outline-primary" onclick="getMenuById(${p[i].id})">Actualizar</button>
                                    <button type="button" class="btn btn-outline-primary" onclick="deleteMenuById(${p[i].id})">Eliminar</button>
                                            
                               </div>
                       </div>
                   </div>
                  `;
            }
            $("#menu").append(l);
        },
        error: function (xhr, status) {
            //alert('ha sucedido un problema')
        },
        complete: function (xhr, status) {
            //alert('Peticion Realizada')
        }
    });
}

function getMenuById(idMenus) {
    $(".saveButtonJL").hide();
    $(".updateButtonJL").show();
    $.ajax({
        url: "/api/menu/" + idMenus,
        type: "GET",
        datatype: "JSON",
        success: function (p) {
            console.log(p);
            $("#id").val(p.id);
            $("#tipoMenu").val(p.tipoMenu);
            $("#nombreMenu").val(p.nombreMenu);
            $("#precio").val(p.precio);
            $("#RestauranteSelected").val(p.restaurante.id).change();
        },
        error: function (xhr, status) {
            //alert('ha sucedido un problema')
        },
        complete: function (xhr, status) {
            //alert('Peticion Realizada')
        }
    });
}

function updateMenu() {
    let data = getFrontMenuData();

    let dataToSend = JSON.stringify(data)
    $.ajax({
        url: "/api/menu/update",
        type: "PUT",
        datatype: "JSON",
        contentType: 'application/json',
        data: dataToSend,
        success: function (p) {
            console.log(p);
            cleanFieldsMenu();
            getMenuList();
            $(".saveButtonJL").show();
            $(".updateButtonJL").hide();
        },
        error: function (xhr, status) {
            //alert('ha sucedido un problema')
        },
        complete: function (xhr, status) {
            //alert('Peticion Realizada')
        }
    });
}

function cancelUpdateMenu() {
    cleanFieldsMenu();
    $(".saveButtonJL").show();
    $(".updateButtonJL").hide();
}

function deleteMenuById(idMenu) {
    $.ajax({
        url: "/api/menu/" + idMenu,
        type: "DELETE",
        datatype: "JSON",
        success: function (i) {
            console.log("entro");
            getMenuList(i);
        },
        error: function (xhr, status) {
            //alert('ha sucedido un problema')
        },
        complete: function (xhr, status) {
            //alert('Peticion Realizada')
        }
    });
}

function getFrontIngredienteData() {
    let k = {
        id: $("#id").val(),
        nombre: $("#nombre").val(),
        calorias: $("#calorias").val(),
        menus: {
            id: $("#MenuSelected").val()
        }
    }
    return k;
}

function cleanFieldsIngrediente() {
    $("#id").val("");
    $("#nombre").val("");
    $("#calorias").val("");
    $("#MenuSelected").val("").change();


}

function getMenusList() {
    $.ajax({
        url: "/api/menu/all",
        type: "GET",
        datatype: "JSON",
        success: function (p) {
            console.log(p);
            for (let i = 0; i < p.length; i++) {
                let s = `
                    <option value="${p[i].id}">${p[i].nombreMenu}</option>
                `;
                $("#MenuSelected").append(s);
            }
        },
        error: function (xhr, status) {
            //alert('ha sucedido un problema')
        },
        complete: function (xhr, status) {
            //alert('Peticion Realizada')
        }
    });
}

function saveIngrediente() {
    let data = getFrontIngredienteData();
    data.id = null;
    let dataToSend = JSON.stringify(data)
    $.ajax({
        url: "/api/ingrediente/save",
        type: "POST",
        datatype: "JSON",
        contentType: 'application/json',
        data: dataToSend,
        success: function (p) {
            console.log("line 454"+p);

            cleanFieldsIngrediente();
            getIngredienteList();
        },
        error: function (xhr, status) {
            //alert('ha sucedido un problema')
        },
        complete: function (xhr, status) {
            //alert('Peticion Realizada')
        }
    });
}

function getIngredienteList() {
    $.ajax({
        url: "/api/ingrediente/all",
        type: "GET",
        datatype: "JSON",
        success: function (j) {
            console.log(j);
            $("#ingredientes").empty();
            let l = "";
            l += `
            <table class="table">
                  <thead>
                    <tr>
                      <th scope="col">Ingrediente</th>
                      <th scope="col">Calorias</th>
                      <th scope="col">seleccionar</th>                      
                    </tr>
                  </thead>
            `;
            for (let i = 0; i < j.length; i++) {
                l += ` 
                    <tbody>
                        <tr>
                          <th scope="row">${j[i].nombre}</th>
                          <td class="calorias_${j[i].id}">${j[i].calorias}</td>
                           <td><input type="checkbox" id="calcula_calorias"  onclick="calculacalorias(${j[i].id})" value="${j[i].id}"></td>
                           <td>
                                  <button type="button" class="btn btn-outline-primary" onclick="getIngredienteById(${j[i].id})">Actualizar</button>
                                  <button type="button" class="btn btn-outline-primary" onclick="deleteIngredienteById(${j[i].id})">Eliminar</button>   
                           </td>
                        </tr>
                    </tbody>                                                 
                   `;
            }
            l += `</table>`;
            $("#ingredientes").append(l);
        },
        error: function (xhr, status) {
            //alert('ha sucedido un problema')
        },
        complete: function (xhr, status) {
            //alert('Peticion Realizada')
        }
    });
}


function deleteIngredienteById(idIngrediente) {
    $.ajax({
        url: "/api/menu/" + idIngrediente,
        type: "DELETE",
        datatype: "JSON",
        success: function (p) {
            console.log(p);
            getIngredienteList();
        },
        error: function (xhr, status) {
            //alert('ha sucedido un problema')
        },
        complete: function (xhr, status) {
            //alert('Peticion Realizada')
        }
    });
}

function getIngredienteById(idMenu) {
    $(".saveButtonJL").hide();
    $(".updateButtonJL").show();
    $.ajax({
        url: "/api/ingrediente/" + idMenu,
        type: "GET",
        datatype: "JSON",
        success: function (p) {
            console.log(p);
            $("#id").val(p.id);
            $("#nombre").val(p.nombre);
            $("#calorias").val(p.calorias);
            $("#MenuSelected").val(p.menus.id).change();
        },
        error: function (xhr, status) {
            //alert('ha sucedido un problema')
        },
        complete: function (xhr, status) {
            //alert('Peticion Realizada')
        }
    });
}

function updateIngrediente() {
    let data = getFrontIngredienteData();

    let dataToSend = JSON.stringify(data)
    $.ajax({
        url: "/api/ingrediente/update",
        type: "PUT",
        datatype: "JSON",
        contentType: 'application/json',
        data: dataToSend,
        success: function (p) {
            console.log(p);
            cleanFieldsIngrediente();
            getIngredienteList();
            $(".saveButtonJL").show();
            $(".updateButtonJL").hide();
        },
        error: function (xhr, status) {
            //alert('ha sucedido un problema')
        },
        complete: function (xhr, status) {
            //alert('Peticion Realizada')
        }
    });
}

function cancelUpdateIngrediente() {
    cleanFieldsIngrediente();
    $(".saveButtonJL").show();
    $(".updateButtonJL").hide();
}

let array = [];

function calculacalorias (id){

    let calorias = $(".calorias_"+id).text();
    ncalorias = parseInt(calorias);
    array.push(ncalorias);
    console.log(array);
    let sum=0;
    for (let i of array) sum+=i;
    console.log(sum)
    if (sum >2000){
        alert("Ingredientes superan 2000 Cal");
        $("#numero_calorias").empty();
        $("#numero_calorias_1").css('color','red');
    }

    $("#numero_calorias").empty();
    $("#numero_calorias").append(sum);
}


