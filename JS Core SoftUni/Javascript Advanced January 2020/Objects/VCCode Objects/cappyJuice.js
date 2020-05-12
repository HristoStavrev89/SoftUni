function cappyJuice(data) {
    let fruits = {};

    let bottles = {};

    for (const line of data) {
        let[juice, quntity] = line.split("=>");

        quntity = Number(quntity);
        
        if (!fruits[juice]) {
            fruits[juice] = quntity;
            
        } else {
            fruits[juice] += quntity;
        }

        let currentQuantity = fruits[juice];
        
        if (currentQuantity >= 1000) {
            bottles[juice] = Math.trunc(currentQuantity / 1000);
        }
    }

    let result = '';

    for (let name in bottles) {
        result += name + "=> " + bottles[name] + "\n";
    }

    return result
}


//Juice factory with reduce function..
function cappyJuiceReduce(data) {
    
    let parsedData = data.reduce((juiceAcc, juiceKVP) => {

        let[juiceName, quntity] = juiceKVP.split(" => ");

        if (juiceAcc.currentJuiceQuantity[juiceName]) {
            juiceAcc.currentJuiceQuantity[juiceName] += Number(quntity);
        } else {
            juiceAcc.currentJuiceQuantity[juiceName] = Number(quntity)
        }

        let bottleQ = Math.floor(juiceAcc.currentJuiceQuantity[juiceName] / 1000);

        if (bottleQ > 0) {
           juiceAcc.completedJuices[juiceName] = bottleQ
        }


        return juiceAcc;

    }, { completedJuices: {}, currentJuiceQuantity: {} }).completedJuices

    return parsedData;
    

}

console.log(cappyJuiceReduce(['Orange => 2000',
'Peach => 1432',
'Banana => 450',
'Peach => 600',
'Strawberry => 549']
));



// console.log(cappyJuice(['Orange => 2000',
// 'Peach => 1432',
// 'Banana => 450',
// 'Peach => 600',
// 'Strawberry => 549']
// ));
