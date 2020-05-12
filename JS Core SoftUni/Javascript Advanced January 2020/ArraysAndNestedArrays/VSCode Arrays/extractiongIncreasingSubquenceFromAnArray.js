function solve(array) {

   let resultArray = [];

   resultArray[0] = array[0];

   array.forEach(element => {
       if (element > resultArray[resultArray.length - 1]) {
           resultArray.push(element);
       }
   });
    
   resultArray.forEach(element => {
       console.log(element);
       
   })
    
    
}

solve([1, 
    3, 
    8, 
    4, 
    10, 
    12, 
    3, 
    2, 
    24]
    )