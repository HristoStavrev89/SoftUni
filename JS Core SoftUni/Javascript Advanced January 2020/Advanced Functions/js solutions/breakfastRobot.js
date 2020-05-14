function manager() {

    let ingredients = {
        flavour: 0,
        fat: 0,
        protein: 0,
        carbohydrate: 0
    };

    function restock(ingredient, quantity) {
        if (ingredients.hasOwnProperty(ingredient)) {
            ingredients[ingredient] += Number(quantity);
            return 'Success';
        }
    }

    function prepare(recipe, count) {
        count = Number(count);
        let message = '';

        switch(recipe) {
            case 'apple':
            if (ingredients.carbohydrate > count) {
                if (ingredients.flavour > count * 2) {
                    ingredients.flavour -= count * 2;
                    ingredients.carbohydrate -= count;
                    message = 'Success';
                } else {
                    message = "Error: not enough flavour in stock";
                }
            } else {
                message = "Error: not enough carbohydrate in stock";
            }
            break;


            case 'lemonade':
            if (ingredients.carbohydrate > count * 10) {
                if (ingredients.flavour > count * 20) {
                    ingredients.flavour -= count * 20;
                    ingredients.carbohydrate -= count * 10;
                    message = 'Success';
                } else {
                    message = "Error: not enough flavour in stock";
                }
            } else {
                message = "Error: not enough carbohydrate in stock";
            }
            break;
            
            
            case 'burger':
                if (ingredients.carbohydrate > count * 5) {
                    if (ingredients.fat > count * 7) {
                        if (ingredients.flavour > count * 3) {
                            ingredients.flavour -= count * 3;
                            ingredients.fat -= count * 7;
                            ingredients.carbohydrate -= count * 5;
                            message = 'Success';
                        } else {
                            message = "Error: not enough flavour in stock";
                        }
                    } else {
                        message = "Error: not enough fat in stock";
                    }
                } else {
                    message = "Error: not enough carbohydrate in stock";
                }
            break;


            case 'eggs':
            if (ingredients.protein > count * 5) {
                if (ingredients.fat > count) {
                    if (ingredients.flavour > count) {
                        ingredients.protein -= count * 5;
                        ingredients.fat -= count;
                        ingredients.flavour -= count;
                        message = 'Success';
                    } else {
                        message = "Error: not enough flavour in stock";
                    }
                } else {
                    message = "Error: not enough fat in stock";
                }
            } else {
                message = "Error: not enough protein in stock";
            }
            break;



            case 'turkey':
                if (ingredients.protein > count * 10) {
                    if (ingredients.carbohydrate > count * 10) {
                        if (ingredients.fat > count * 10) {
                            if (ingredients.flavour > count * 10) {
                                ingredients.flavour -= count * 10;
                                ingredients.carbohydrate -= count * 10;
                                ingredients.fat -= count * 10;
                                ingredients.protein -= count * 10;
                                message = 'Success';
                            }
                        } else {
                            message = "Error: not enough fat in stock";
                        }
                    } else {
                        message = "Error: not enough carbohydrate in stock";
                    }
                } else {
                    message = "Error: not enough protein in stock";
                }

            break;
        }
        return message;
    }

    function report() {
        return `protein=${ingredients.protein} carbohydrate=${ingredients.carbohydrate} fat=${ingredients.fat} flavour=${ingredients.flavour}`;
    }

    
    return function (data) {
        let tokens = data.split(" ");
        let command = tokens[0];

        if (command === 'restock') {
            return restock(tokens[1], tokens[2]);
        } else if (command === 'prepare') {
            return prepare(tokens[1], tokens[2])
        } else if (command === 'report') {
            return report();
        }
    }
}

let test = manager();

console.log(test("restock carbohydrate 50"));
console.log(test("restock flavour 50"));

console.log(test('report'));

console.log(test("prepare apple 1"));

console.log(test("prepare lemonade 1"));

console.log(test('report'));