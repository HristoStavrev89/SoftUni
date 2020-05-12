function solve(data) {
    
    let uniqueArrays = new Set();

let parsedData = data.map(arr => JSON.parse(arr).sort());



for (let i = 0; i < parsedData.length; i++) {

    let currentArray = parsedData[i].sort();

    if (!uniqueArrays.includes(currentArray)) {
        uniqueArrays.push(currentArray)
    }
    
}


    console.log(uniqueArrays);
    
    


}

solve(["[-3, -2, -1, 0, 1, 2, 3, 4]",
"[10, 1, -17, 0, 2, 13]",
"[4, -3, 3, -2, 2, -1, 1, 0]"]
)