<%@page import="COM.clsGestor"%>
<%@page import="java.util.List"%>
<%@page import="Entidades.clsEncargado"%>
<div id="tabla">

    <table cellpadding="0" cellspacing="0" border="0" class="table table-striped" id="datatable" width="100%">
        <thead>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Email</th>
                <th>Telefono</th>
                <th>Usuario</th>
                <th>Password</th>                    
                <th>Estado</th>
                <th>Selecionar</th>
            </tr>
        </thead>
        <tbody>
        <%
           List<clsEncargado> lista=clsGestor.ListarEncargado(false);
           if(lista!=null)
           for(clsEncargado entidad : lista)
           {
        %>
        <tr >
            <td><%=entidad.getIdEncargado()%></td>
            <td><%=entidad.getNombre()%></td>
            <td><%=entidad.getApellido()%></td>
            <td><%=entidad.getEmail()%></td>
            <td><%=entidad.getCelular()%></td>
            <td><%=entidad.getUsuario()%></td>
            <td><%=entidad.getPassword()%></td>
            <td class="center">
                <%
                if(entidad.getEstado()==1)
                    out.print("<span class='badge badge-info'>Activo</span>");
                else
                    out.print("<span class='badge badge-important'>Inactivo</span>");
                %>      
            </td>
            <td class="center">
                 <center> <a href="javascript:void(0)" onclick="edit_form(<%=entidad.getIdEncargado()%>,1,'<%=entidad.getNombre()%>','<%=entidad.getApellido()%>','<%=entidad.getEmail()%>','<%=entidad.getCelular()%>','<%=entidad.getUsuario()%>','<%=entidad.getPassword()%>',<%=entidad.getEstado()%>)" class="btn btn-primary btn-sm btn-small">Editar</a></center> 
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