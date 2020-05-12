function solve(data) {
    
    let cars = {};


    for (let line of data) {
        let[ brand, model, count ] = line.split(" | ");
        count = Number(count);

        if (!cars[brand]) {
            cars[brand] = {};
        }

        let models = cars[brand];

        if (!models[model]) {
            models[model] = count;
        } else {
            models[model] += count
        }
    }

    Object.keys(cars)
    .map(brand => {
        console.log(brand);

        let models = cars[brand];

        Object.keys(models)
        .map(model => {


            let count = models[model];

            console.log(`###${model} -> ${count}`);
            

        })
        
    })


    
}

solve(['Audi | Q7 | 1000',
'Audi | Q6 | 100',
'BMW | X5 | 1000',
'BMW | X6 | 100',
'Citroen | C4 | 123',
'Volga | GAZ-24 | 1000000',
'Lada | Niva | 1000000',
'Lada | Jigula | 1000000',
'Citroen | C4 | 22',
'Citroen | C5 | 10']
)