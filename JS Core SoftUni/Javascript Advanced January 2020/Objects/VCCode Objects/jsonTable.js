function solve(input) {

    let employee = [];

    let html = "<table>\n"

    for (let i = 0; i < input.length; i++) {
        let currentJSON = JSON.parse(input[i]);
        employee.push(currentJSON);
    }

    for (let current of employee) {
        html += "   <tr>\n";
        html += "      <td>" + current.name + "</td>\n";
        html += "      <td>" + current.position + "</td>\n";
        html += "      <td>" + current.salary + "</td>\n";
        html += "   </tr>\n"
    }
    html += "</table>"

    return html;
}
console.log(solve(['{"name":"Pesho","position":"Promenliva","salary":100000}',
    '{"name":"Teo","position":"Lecturer","salary":1000}',
    '{"name":"Georgi","position":"Lecturer","salary":1000}']
));