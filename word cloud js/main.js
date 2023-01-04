//Reading the text file
const fs = require('fs')
var text = fs.readFileSync("C:/Users/wayus/OneDrive/Desktop/Ayush Wunnava/Timepass/MyText.txt",'utf-8');
let mainArr = text.split("\r\n");
//removing last element
mainArr.pop();
// console.log(mainArr);
let newArr = [];
for(i of mainArr){
    i = i.slice(0,-1);
    let tempArr = i.split(":[");
    newArr.push(tempArr)
}

// console.log(newArr);

//If I need to find the freq
for(var i=0;i<newArr.length;i++){
    console.log((newArr[i][1].match(/,/g) || []).length + 1)
}


