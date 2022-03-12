const prompt = require('prompt-sync') ();

const count = prompt("Enter the size of the number series : ");

var numArray = [];

for(let i=0; i<Number(count); i++){
    const num = prompt("Enter a number to the given series : ");
    //casting input to Number
    numArray[i] = Number(num);
}

findThirdLargest(numArray);

function findThirdLargest(numArray){

    //sort the number array in descending order
    for(let i=0; i<numArray.length; i++){
        for(let j=i+1; j<numArray.length; j++){
            if(numArray[j]>numArray[i]){
                var temp = numArray[i];
                numArray[i] = numArray[j];
                numArray[j] = temp;
            }
        }
    }
    console.log("The sorted sequence : " + numArray);

    //printing the 3rd largest number in the series
    for(let i=0; i<numArray.length; i++){
        if(i == 2){
            console.log("The third largest number in the series is : " + numArray[i]);
        }
    }
}