<%@page import="COM.clsGestor"%>
<%@page import="java.util.List"%>
<%@page import="Entidades.clsHabitacion"%>
<div id="tabla">

    <table cellpadding="0" cellspacing="0" border="0" class="table table-striped" id="datatable" width="100%">
        <thead>
            <tr>
                <th>Id</th>
                <th>Id Costo Hab</th>
                <th>Numero</th>
                <th>Piso</th>
                <th>Vista</th>
                <th>Estado</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<clsHabitacion> lista=clsGestor.ListarHabitacion(false);
                if(lista!=null)
                for(clsHabitacion entidad : lista)
                {
            %>
            <tr>
                <td><%=entidad.getIdHabitacion()%></td>
                <td><%=entidad.getObjCostoTipoHabitacion().getIdCostoTipoHabitacion()%></td>
                <td><%=entidad.getNumero()%></td>
                <td><%=entidad.getPiso()%></td>                
                <td class="center">
                    <%
                        if(entidad.getVista()==1)
                            out.print("<span>Vista</span>");
                        else
                            out.print("<span>Sin Vista</span>");
                    %>      
                </td>
                <td class="center">
                    <%
                        if(entidad.getEstado()==1)
                            out.print("<span class='badge badge-info'>Activo</span>");
                        else
                            out.print("<span class='badge badge-important'>Inactivo</span>");
                    %>      
                </td>
                <td class="center">
                     <center> <a href="javascript:void(0)" onclick="edit_form(<%=entidad.getIdHabitacion()%>,<%=entidad.getObjCostoTipoHabitacion().getIdCostoTipoHabitacion()%>,<%=entidad.getNumero()%>,<%=entidad.getPiso()%>,<%=entidad.getVista()%>,<%=entidad.getEstado()%>)" class="btn btn-primary btn-sm btn-small">Editar</a></center> 
                </td>
            </tr>
                <%}%> 
        </tbody>
    </table>
   <script type="text/javascript">
$(function () { 
          
   /* Set the defaults for DataTables initialisation */
    $.extend( true, $.fn.dataTable.defaults, {
        "sDom": "<'row-fluid'<'span6'l><'span6'f>r>t<'row-fluid'<'span12'p i>>",
        "sPaginationType": "bootstrap",
        "oLanguage": {
            "sLengthMenu": "_MENU_"
        }
    } );


    /* Default class modification */
    $.extend( $.fn.dataTableExt.oStdClasses, {
        "sWrapper": "dataTables_wrapper form-inline"
    } );


    /* API method to get paging information */
    $.fn.dataTableExt.oApi.fnPagingInfo = function ( oSettings )
    {
        return {
            "iStart":         oSettings._iDisplayStart,
            "iEnd":           oSettings.fnDisplayEnd(),
            "iLength":        oSettings._iDisplayLength,
            "iTotal":         oSettings.fnRecordsTotal(),
            "iFilteredTotal": oSettings.fnRecordsDisplay(),
            "iPage":          oSettings._iDisplayLength === -1 ?
                    0 : Math.ceil( oSettings._iDisplayStart / oSettings._iDisplayLength ),
            "iTotalPages":    oSettings._iDisplayLength === -1 ?
                    0 : Math.ceil( oSettings.fnRecordsDisplay() / oSettings._iDisplayLength )
        };
    };


    /* Bootstrap style pagination control */
    $.extend( $.fn.dataTableExt.oPagination, {
        "bootstrap": {
            "fnInit": function( oSettings, nPaging, fnDraw ) {
                var oLang = oSettings.oLanguage.oPaginate;
                var fnClickHandler = function ( e ) {
                    e.preventDefault();
                    if ( oSettings.oApi._fnPageChange(oSettings, e.data.action) ) {
                        fnDraw( oSettings );
                    }
                };

                $(nPaging).addClass('pagination').append(
                    '<ul>'+
                        '<li class="prev disabled"><a href="#"><i class="icon-chevron-left"></i></a></li>'+
                        '<li class="next disabled"><a href="#"><i class="icon-chevron-right"></i></a></li>'+
                    '</ul>'
                );
                var els = $('a', nPaging);
                $(els[0]).bind( 'click.DT', { action: "previous" }, fnClickHandler );
                $(els[1]).bind( 'click.DT', { action: "next" }, fnClickHandler );
            },

            "fnUpdate": function ( oSettings, fnDraw ) {
                var iListLength = 5;
                var oPaging = oSettings.oInstance.fnPagingInfo();
                var an = oSettings.aanFeatures.p;
                var i, ien, j, sClass, iStart, iEnd, iHalf=Math.floor(iListLength/2);

                if ( oPaging.iTotalPages < iListLength) {
                    iStart = 1;
                    iEnd = oPaging.iTotalPages;
                }
                else if ( oPaging.iPage <= iHalf ) {
                    iStart = 1;
                    iEnd = iListLength;
                } else if ( oPaging.iPage >= (oPaging.iTotalPages-iHalf) ) {
                    iStart = oPaging.iTotalPages - iListLength + 1;
                    iEnd = oPaging.iTotalPages;
                } else {
                    iStart = oPaging.iPage - iHalf + 1;
                    iEnd = iStart + iListLength - 1;
                }

                for ( i=0, ien=an.length ; i<ien ; i++ ) {
                    // Remove the middle elements
                    $('li:gt(0)', an[i]).filter(':not(:last)').remove();

                    // Add the new list items and their event handlers
                    for ( j=iStart ; j<=iEnd ; j++ ) {
                        sClass = (j==oPaging.iPage+1) ? 'class="active"' : '';
                        $('<li '+sClass+'><a href="#">'+j+'</a></li>')
                            .insertBefore( $('li:last', an[i])[0] )
                            .bind('click', function (e) {
                                e.preventDefault();
                                oSettings._iDisplayStart = (parseInt($('a', this).text(),10)-1) * oPaging.iLength;
                                fnDraw( oSettings );
                            } );
                    }

                    // Add / remove disabled classes from the static elements
                    if ( oPaging.iPage === 0 ) {
                        $('li:first', an[i]).addClass('disabled');
                    } else {
                        $('li:first', an[i]).removeClass('disabled');
                    }

                    if ( oPaging.iPage === oPaging.iTotalPages-1 || oPaging.iTotalPages === 0 ) {
                        $('li:last', an[i]).addClass('disabled');
                    } else {
                        $('li:last', an[i]).removeClass('disabled');
                    }
                }
            }
	}
    } );


    /*
     * Initialse DataTables, with no sorting on the 'details' column
     */
    $('#datatable').dataTable( {
        "sScrollY": "210px",
        "sDom": "<'row-fluid'<'span6'l><'span6'f>r>t<'row-fluid'<'span12'p i>>",
        "aaSorting": [],
        "oLanguage": {
            "sLengthMenu": "_MENU_ ",
            "sInfo": "Mostrando del  <b>_START_ al _END_</b> de _TOTAL_ entradas"
        },
    });
});
</script>
    </div>