const isNotEmptyString = x => x !== "";
const trimMyStrings = x => x.trim();
const parseNumber = x => Number(x) ? Math.floor((Number(x) * 100) / 100) : x;

function deserializeStringToArrayOfValues(str) {
    return str
        .split("|")
        .filter(isNotEmptyString)
        .map(trimMyStrings)
        .map(parseNumber);
}

function solve(data) {
    let keys = deserializeStringToArrayOfValues(data[0]);
    return data
        .slice(1)
        .map(deserializeStringToArrayOfValues)
        .map(x => x.reduce((res, val, i) => {
            res[keys[i]] = val;
            return res;
        }, {}));
}

console.log(solve(['| Town | Latitude | Longitude |',
    '| Sofia | 42.696552 | 23.32601 |',
    '| Beijing | 39.913818 | 116.363625 |']
));