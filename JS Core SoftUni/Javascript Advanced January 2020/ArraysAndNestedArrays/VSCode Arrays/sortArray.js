


function solve(arr) {
    const sortByLength = (a, b) => {
        return a.length - b.length;
    }
    
    const sortAlphabetical = (a, b) => {
       return a.localeCompare(b);
    }
      arr.sort((a, b) => sortByLength(a, b) || sortAlphabetical(a, b));

      arr.forEach(element => {
         console.log(element);
          
      });

      
     
}

solve(['alpha', 
'beta', 
'gamma']
)
console.log('--------------');

solve(['Isacc', 
'Theodor', 
'Jack', 
'Harrison', 
'George']
)
console.log('--------------------');

solve(['test', 
'Deny', 
'omen', 
'Default']
)