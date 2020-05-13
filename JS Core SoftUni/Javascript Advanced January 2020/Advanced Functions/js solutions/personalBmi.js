function solve(...input) {

    let bmi =  Math.round(+input[2] / ((+input[3] / 100) * (+input[3] / 100)))
    
    let status = '';
    if (bmi < 18.5) {
        status = 'underweight';
    } else if (bmi < 25) {
        status = 'normal'
    } else if (bmi < 30) {
        status = 'overweight'
    } else {
        status = 'obese';
        
    }

    let data = {
        name: input[0],
        personalInfo: {
            age: input[1],
            weight: input[2],
            height: input[3]
        },BMI: bmi
        ,
        status: status
    }


    if (status === 'obese') {
        data.recommendation = 'admission required';
    }

    return data;
}

console.log(solve('Honey Boo Boo', 9, 57, 137));




