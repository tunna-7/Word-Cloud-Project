 var myContent="Apoorv";
    var reader; //GLOBAL File Reader object for demo purpose only
    function checkFileAPI() {
        if (window.File && window.FileReader && window.FileList && window.Blob) {
            reader = new FileReader();
            return true;
        } else {
            alert('The File APIs are not fully supported by your browser. Fallback required.');
            return false;
        }
    }
    function readText(filePath) {
        var output = ""; //placeholder for text output
        if(filePath.files && filePath.files[0]) {
            reader.onload = function (e) {
                output = e.target.result;
                myContent = output;
                chartBuddy(myContent);
                // console.log(output);
            };//end onload()
            reader.readAsText(filePath.files[0]);
        }//end if html5 filelist support
        else if(ActiveXObject && filePath) { //fallback to IE 6-8 support via ActiveX
            try {
                reader = new ActiveXObject("Scripting.FileSystemObject");
                var file = reader.OpenTextFile(filePath, 1); //ActiveX File Object
                output = file.ReadAll(); //text contents of file
                file.Close(); //close file "input stream"
                myContent = output;
                chartBuddy(myContent);
                //console.log(output);
            } catch (e) {
                if (e.number == -2146827859) {
                    alert('Unable to access local files due to browser security settings. ' +
                     'To overcome this, go to Tools->Internet Options->Security->Custom Level. ' +
                     'Find the setting for "Initialize and script ActiveX controls not marked as safe" and change it to "Enable" or "Prompt"');
                }
            }
        }
        else { //this is where you could fallback to Java Applet, Flash or similar
            return false;
        }
        console.log(myContent);
        return true;


    }



  function chartBuddy(text) {

  //Reading the text file

  let mainArr = text.split("\r\n");
  //removing last element
  mainArr.pop();
  let narr=[];

  // console.log(mainArr);
  let newArr = [];
  for(i of mainArr){
      i = i.slice(0,-1);
      let tempArr = i.split(":[");
      newArr.push(tempArr)
  }

  //console.log(newArr);

  //If I need to find the freq
  for(var i=0;i<newArr.length;i++){

      var obj={
          x : `${newArr[i][0]}`,
          value: `${(newArr[i][1].match(/,/g) || []).length + 1}`,
          custom_field: newArr[i][1].split(', ')
      }
      narr.push(obj);
      // console.log(obj);
      //console.log((newArr[i][1].match(/,/g) || []).length + 1)
  }

    console.log(narr);

  //   var data = narr;
    sendMyData(narr);
  }

  function sendMyData(data){
    var chart = anychart.tagCloud(data);

    // enable HTML for tooltips
    chart.tooltip().useHtml(true);

    // configure tooltips
    chart.tooltip().format(function() {
      var percentOfTotal = (this.getData("value")*100)/this.getStat("sum");
      console.log(percentOfTotal)
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
  }