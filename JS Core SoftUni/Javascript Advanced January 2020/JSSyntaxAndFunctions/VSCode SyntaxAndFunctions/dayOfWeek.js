function solve(day) {

    let days = {
        'Monday': 1,
        "Tuesday": 2,
        "Wednesday": 3,
        "Thursday": 4,
        "Friday": 5,
        "Saturday": 6,
        "Sunday": 7
    };
    if (day !== "Monday" && day !== 'Tuesday' && day !== 'Wednesday' && day !== 'Thursday' && day !== 'Friday' && day !== 'Saturday' && day !== 'Sunday') {
        console.log(`error`);
    } else {
        console.log(days[day]);

    }
}

solve("Wednesday");