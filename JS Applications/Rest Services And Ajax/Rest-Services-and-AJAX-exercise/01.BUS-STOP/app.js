function getInfo() {
    const validBusses = ['1287', '1308', '1327', '2334'];
    let stopId = document.getElementById('stopId');
    let stopInfo = document.getElementById('stopName');
    let busesList = document.getElementById('buses'); // ul

    if (!validBusses.includes(stopId.value)) {
        stopInfo.textContent = 'Error';
        busesList.textContent = '';
        stopId.value = '';
        return;
    }

    const url = `https://judgetests.firebaseio.com/businfo/${stopId.value}.json`;

    //Response
    //then == map -> json
    fetch(url)
        //Response
        .then((response) => response.json())
        //Promise
        .then((data) => {

            stopInfo.textContent = data.name;

            Object.keys(data.buses).forEach(key => {
                let li = document.createElement('li');
                li.textContent = `Bus ${key} arrives in ${data.buses[key]} minutes`;

                busesList.appendChild(li);
            })
            stopId.value = '';
        });
}