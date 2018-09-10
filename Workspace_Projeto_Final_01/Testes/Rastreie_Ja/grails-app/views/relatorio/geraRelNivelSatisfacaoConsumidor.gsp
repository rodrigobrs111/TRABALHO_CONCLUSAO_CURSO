<html>
  <head>
  	<meta name="layout" content="kickstart">
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
          
        var data = google.visualization.arrayToDataTable([
                                                          
          [  'Mês'    ,'Muito Ruim' , 'Ruim' , 'Regular' , 'Bom' , 'Muito Bom' , 'Excelente'],
          [ '${mes1}' ,  ${muitoRuim1} , ${ruim1} , ${regular1} , ${bom1} , ${muitoBom1} , ${excelente1} ] ,
          [ '${mes2}' ,  ${muitoRuim2} , ${ruim2} , ${regular2} , ${bom2} , ${muitoBom2} , ${excelente2} ] ,
          [ '${mes3}' ,  ${muitoRuim3} , ${ruim3} , ${regular3} , ${bom3} , ${muitoBom3} , ${excelente3} ]
          
        ]);

        var options = {
          title: 'Nível de Satisfação do Consumidor',
          hAxis: {title: 'ANO', titleTextStyle: {color: 'red'}}
        };

        var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
    
  </head>
  
  <body>
    <div id="chart_div" style="width: 900px; height: 500px;"></div>
  </body>

</html>