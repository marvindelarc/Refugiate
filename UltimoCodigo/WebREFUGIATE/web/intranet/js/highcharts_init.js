$(function () {
    var chart;
    $(document).ready(function() {
    Highcharts.setOptions({
        colors: ['#32353A']
    });
        chart = new Highcharts.Chart({
            chart: {
                renderTo: 'container',
                type: 'column',
                margin: [ 30, 10, 60, 40]
            },
            title: {
                text: 'Registro de Empresas por Mes'
            },
            xAxis: {
                categories: [
                    'Julio 2012',
                    'Agosto 2012',
                    'Setiembre 2012',
                    'Octubre 2012',
                    'Noviembre 2012',
                    'Diciembre 2012',
                    'Enero 2013',
                    'Febrero 2013',
                    'Marzo 2013',
                    'Abril 2013',
                    'Mayo 2013',
                    'Junio 2013',
                    'Julio 2013'
                ],
                labels: {
                    rotation: -45,
                    align: 'right',
                    style: {
                        fontSize: '9px',
                        fontFamily: 'Tahoma, Verdana, sans-serif'
                    }
                }
            },
            yAxis: {
                min: 0,
                title: {
                    text: 'Empresas'
                }
            },
            legend: {
                enabled: false
            },
            tooltip: {
                formatter: function() {
                    return '<b>'+ this.x +'</b><br/>'+
                        'Empresas: '+ Highcharts.numberFormat(this.y, 0);
                }
            },
                series: [{
                name: 'Empresas',
                data: [25, 35, 42,51, 62, 67, 74, 81, 93, 112, 125, 142],
                dataLabels: {
                    enabled: false,
                    rotation: 0,
                    color: '#F07E01',
                    align: 'right',
                    x: -3,
                    y: 20,
                    formatter: function() {
                        return this.y;
                    },
                    style: {
                        fontSize: '11px',
                        fontFamily: 'Verdana, sans-serif'
                    }
                }, 
                pointWidth: 55
            }]
        });
    });
    
});
