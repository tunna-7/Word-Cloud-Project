// var data = [
//     {   "className":"Ayush",
//         "frequency": 20,
//         "location":["C:\Users\wayus\OneDrive\Desktop\Ayush Wunnava\Timepass\word cloud java\main\First.java"]
//     },
//     {   "className":"First",
//         "frequency": 15,
//         "location":["C:\Users\wayus\OneDrive\Desktop\Ayush Wunnava\Timepass\word cloud java\main\First.java"]
//     },
//     {   "className":"ThirdProtect",
//         "frequency": 10,
//         "location":["C:\Users\wayus\OneDrive\Desktop\Ayush Wunnava\Timepass\word cloud java\main\main 2\main 3\Thrid.java"]
//     }
// ];
anychart.onDocumentReady(function () {

    // create data   
    var data = [
      { x: "Ayush", 
        value: 20, 
        custom_field: [
            "C:\\Users\\wayus\\OneDrive\Desktop\\Ayush Wunnava\\Timepass\\word cloud java\\main\\First.java",
            "C:\\Users\\wayus\\OneDrive\\Desktop\\Ayush Wunnava\\Timepass\\word cloud java\\main\\Second.java",
            "C:\\Users\\wayus\\OneDrive\\Desktop\\Ayush Wunnava\\Timepass\\word cloud java\\main\\Second.java",
            "C:\\Users\\wayus\\OneDrive\Desktop\\Ayush Wunnava\\Timepass\\word cloud java\\main\\First.java",
            "C:\\Users\\wayus\\OneDrive\\Desktop\\Ayush Wunnava\\Timepass\\word cloud java\\main\\Second.java",
            "C:\\Users\\wayus\\OneDrive\\Desktop\\Ayush Wunnava\\Timepass\\word cloud java\\main\\Second.java",
        ]
    },
      {x: "First", value: 15, custom_field: ["C:\Users\wayus\OneDrive\Desktop\Ayush Wunnava\Timepass\word cloud java\main\First.java"]},
      {x: "ThirdProtect", value: 10, custom_field: ["C:\Users\wayus\OneDrive\Desktop\Ayush Wunnava\Timepass\word cloud java\main\main 2\main 3\Thrid.java"]},
    ];

    // create a chart and set the data
    var chart = anychart.tagCloud(data);

    // enable HTML for tooltips
    chart.tooltip().useHtml(true);

    // configure tooltips
    chart.tooltip().format(function() {
      var percentOfTotal = (this.getData("value")*100)/this.getStat("sum");
      if (percentOfTotal < 7)
        return percentOfTotal.toFixed(1) +
               "%<br><br>" + this.getData("custom_field");
      if (percentOfTotal > 15)
        return "<span style='font-size:26'>" +
               percentOfTotal.toFixed(1) +
               "%</span><br><br>" +
               this.getData("custom_field");
      return "<span style='font-size:18'>" +
             percentOfTotal.toFixed(1) +
             "%</span><br><br>" +
             this.getData("custom_field");
    });

    // set the chart title
    chart.title("Ayush Assignment: Word Cloud");

    // set the container id
    chart.container("container");

    // initiate drawing the chart
    chart.draw();
});