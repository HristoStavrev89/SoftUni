function solve(arr) {
let n = [];

let current = 1;
for (let index = 0; index < arr.length; index++) {
    
    switch (arr[index]) {
        case 'add':
            n[index] = current;
            break;
    case 'remove':
        n.pop();
        break;
    }
    
    current++;
    

}


if (n.length === 0) {
    console.log('Empty');
    
}

 n.filter(element => element !== undefined).forEach(element => console.log(element)
 );
}
// console.log(solve(['add', 
// 'add', 
// 'add', 
// 'add']
// ));

// console.log(solve(['add', 
// 'add', 
// 'remove', 
// 'add', 
// 'add']
// ));

// solve(['add', 
// 'add', 
// 'add', 
// 'add']
//)

solve(['remove', 
'remove', 
'remove']
)

