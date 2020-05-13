let solution = (function(){

    function getSumOfArrayNumbers(array) {
        return array.reduce((acc, n) => acc + n, 0);
    }

    let multiplyNumbersInArray = (arr) => {
        return arr.reduce((acc, n) => acc * n, 0);
    }

    function add(arr1, arr2) {
        return [getSumOfArrayNumbers(arr1), getSumOfArrayNumbers(arr2)];
    }

    function multiply(array, multiply) {
        return array.reduce((acc, current) => {
            acc.push(current * multiply)

            return acc
        }, [])
    }

    function length(array) {
        return Math.sqrt(array.reduce((acc, current) => (current * current) + acc, 0))
    }

    //Arrow function
    let dot = (arr1, arr2) => {
        return multiplyNumbersInArray(arr1) + multiplyNumbersInArray(arr2);
    }

    let cross = (arr1, arr2) => arr1[0] * arr2[1] - arr1[1] * arr2[0];

     
    return {
        add,
        multiply,
        length,
        dot,
        cross
    }


})();

console.log(solution.add([1, 1], [1, 0]));

console.log(solution.multiply([3.5, -2], 2));

console.log(solution.length([3, -4]));

console.log(solution.dot([1, 0], [0, -1]));

console.log(solution.cross([3, 7], [1, 0]));





