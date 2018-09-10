<html>
  <head>
  	<meta name="layout" content="kickstart">
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
          
        var data = google.visualization.arrayToDataTable([
                                                          
          [  'Mês'    ,'Reclamações Atendidas' ] ,
          [ '${mes1}' ,  ${valor1} ]             ,
          [ '${mes2}' ,  ${valor2} ]             ,
          [ '${mes3}' ,  ${valor3} ]
          
        ]);

        var options = {
          title: 'Número de Reclamações Atendidas',
          hAxis: {title: 'ANO', titleTextStyle: {color: 'red'}}
        } ;

        var chart = new google.visualization.ColumnChart(document.getElementById('chart_div')) ;
        chart.draw(data, options) ;
      }
    </script>
    
  </head>
  
  <body>
    <div id="chart_div" style="width: 900px; height: 500px;"></div>
  </body>

</html>