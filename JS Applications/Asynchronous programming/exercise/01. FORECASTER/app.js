function attachEvents() {

    let weatherButton = document.getElementById('submit');
    let locationName = document.getElementById('location');
    let currentDiv = document.getElementById('current');
    let forecastParentDiv = document.getElementById('forecast');
    let upcomingDiv = document.getElementById('upcoming');

    const locationsURL = 'https://judgetests.firebaseio.com/locations.json';
    const baseURL = 'https://judgetests.firebaseio.com/forecast/';

    const symbols = {
        Sunny: "&#x2600", // ☀
        "Partly sunny": "&#x26C5", // ⛅
        Overcast: "&#x2601", // ☁
        Rain: "&#x2614", // ☂
        Degrees: "&#176" // °
    }




    weatherButton.addEventListener('click', () => {

        fetch(locationsURL)
            .then(response => response.json())
            .then(data => {
                let { name, code } = data.find((city) => city.name === locationName.value);


                //fetch today
                let current = fetch(baseURL + `today/${code}.json`)
                    .then((response) => response.json());

                //fetch upcoming
                let upcoming = fetch(baseURL + `upcoming/${code}.json`)
                    .then((response) => response.json());

                Promise.all([current, upcoming])
                    .then(showForecast)
                    .catch((e) => {
                        forecastParentDiv.textContent = 'ERROR';
                    });

                locationName.value = '';
            });
    });

    function createElement(ele, elementClassName, content) {
        let element = document.createElement(ele);
        element.className = elementClassName;
        element.innerHTML = content;
        return element;
    }

    function showForecast([currentData, upcomingData]) {
        forecastParentDiv.style.display = 'block';

        showCurrent(currentData);
        showUpcoming(upcomingData);
    }

    function showCurrent(currentData) {

        foreCastDiv = createElement("div", "forecasts", "");

        let currentSymbol = symbols[currentData.forecast.condition];

        let conditionSymbolSpan = createElement("span", "condition symbol", currentSymbol);
        let conditionInfoSpan = createElement("span", "condition", "");


        let forecastCitySpan = createElement("span", "forecast-data", currentData.name);

        let temperatures = `${currentData.forecast.low}${symbols.Degrees}/${currentData.forecast.high}${symbols.Degrees}`;
        let forecastTempsSpan = createElement("span", "forecast-data", temperatures);


        let forecastConditionSpan = createElement("span", "forecast-data", currentData.forecast.condition);

        foreCastDiv.appendChild(conditionSymbolSpan);
        currentDiv.appendChild(foreCastDiv);

        conditionInfoSpan.appendChild(forecastCitySpan);
        conditionInfoSpan.appendChild(forecastTempsSpan);
        conditionInfoSpan.appendChild(forecastConditionSpan);

        foreCastDiv.appendChild(conditionInfoSpan);
    }

    function showUpcoming(upcomingData) {

        let forecastInfo = createElement("div", "forecast-info", "");

        upcomingData.forecast.forEach(obj => {

            let upcomingSpan = createElement("span", "upcoming", "");


            let conditionSymbolSpan = createElement("span", "symbol", symbols[obj.condition]);

            let temperatures = `${obj.low}${symbols.Degrees}/${obj.high}${symbols.Degrees}`;
            let forecastTempsSpan = createElement("span", "forecast-data", temperatures);
            let forecastConditionSpan = createElement("span", "forecast-data", obj.condition);

            upcomingSpan.appendChild(conditionSymbolSpan)
            upcomingSpan.appendChild(forecastTempsSpan)
            upcomingSpan.appendChild(forecastConditionSpan)
            forecastInfo.appendChild(upcomingSpan);
        })

        upcomingDiv.appendChild(forecastInfo);
    }

}

attachEvents();