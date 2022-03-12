//using prompt-sync

const prompt = require('prompt-sync') ();

const word1 = prompt("Enter the first word :  ");
const word2 = prompt("Enter the second word : ");


if(isAnagram(word1, word2)){
    console.log("They are anagram words of each other!");
}

else{
    console.log("They are not anagram words of each other!");
}


function isAnagram(word1,word2){
    var wordArray1 = word1.split('');
    
    var wordArray2 = word2.split('');
    
    //sort wordArray1
    for(let i=0; i<wordArray1.length; i++){
        for(let j=i+1; j<wordArray1.length; j++){
            if(wordArray1[i]>wordArray1[j]){
                var temp=wordArray1[i];
                wordArray1[i]=wordArray1[j];
                wordArray1[j]=temp;
            }
        }
    }
  
    //sort wordArray2
    for(let i=0; i<wordArray2.length; i++){
        for(let j=i+1; j<wordArray2.length; j++){
            if(wordArray2[i]>wordArray2[j]){
                var temp=wordArray2[i];
                wordArray2[i]=wordArray2[j];
                wordArray2[j]=temp;
            }
        }
    }
    
    //checking whether both the arrays have the same length
    var L1 = wordArray1.length;
    var L2 = wordArray2.length;
    if(L1 != L2){
        return false;
    }

    //checking if both words have same characters
    else{
        for(let i=0; i<wordArray1.length; i++){
            if(wordArray1[i]!=wordArray2[i]){
                return false;
            }
        }
        return true;
     }   
}


