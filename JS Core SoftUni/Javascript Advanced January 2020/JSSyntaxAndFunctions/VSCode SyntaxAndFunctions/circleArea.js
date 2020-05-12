function solve(x) {
    switch (typeof(x)) {
        case `number`:
            res = x * x * Math.PI;
            console.log(res.toFixed(2));
            break;
        default:
            res = `We can not calculate the circle area, because we receive a ${typeof(x)}.`
            console.log(res);
            break;
    }
    var res;
}
solve('name')

