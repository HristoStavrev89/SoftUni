function solve(arr) {
    let n = Number(arr.pop());

    for (let index = 0; index < arr.length; index+=n) {
        console.log(arr[index]);
    }
}
solve(['5', 
'20', 
'31', 
'4', 
'20', 
'2']
)