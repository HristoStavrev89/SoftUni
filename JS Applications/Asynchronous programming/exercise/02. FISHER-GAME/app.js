function attachEvents() {
    const addButton = document.querySelector('button.add');
    const loadButton = document.querySelector('button.load');
    const catchesDiv = document.getElementById('catches');

    const baseURL = 'https://fisher-game.firebaseio.com/catches.json';
    const deleteAndUpdateURL = 'https://fisher-game.firebaseio.com/catches/';

    addButton.addEventListener('click', () => {
        let angler = document.querySelector('fieldset > input.angler');
        let weight = document.querySelector('fieldset > input.weight');
        let species = document.querySelector('fieldset > input.species');
        let location = document.querySelector('fieldset > input.location');
        let bait = document.querySelector('fieldset > input.bait');
        let captureTime = document.querySelector('fieldset > input.captureTime');


        let obj = JSON.stringify({
            angler: angler.value,
            weight: weight.value,
            species: species.value,
            location: location.value,
            bait: bait.value,
            captureTime: captureTime.value
        });


        fetch(baseURL, {
            method: "POST",
            body: obj
        });




    })

    loadButton.addEventListener('click', () => {
        fetch(baseURL)
            .then((response) => response.json())
            .then(data => {
                Object.keys(data).forEach((key) => appendCatch(key, data))
            })
    })

    function appendCatch(key, data) {
        let { angler, weight, species, location, bait, captureTime } = data[key];

        let catchDiv = createElement('div', 'catch', '');
        catchDiv.setAttribute("data-id", key)

        let anglerLabel = createElement("label", "", "Angler");
        let anglerInput = createElement("input", "angler", angler, "text");

        let weightLabel = createElement("label", "", "Weight");
        let weightInput = createElement("input", "weight", weight, "number");

        let speciesLabel = createElement("label", "", "Species");
        let speciesInput = createElement("input", "species", species, "text");

        let locationLabel = createElement("label", "", "Location");
        let locationInput = createElement("input", "location", location, "text");

        let baitLabel = createElement("label", "", "Bait");
        let baitInput = createElement("input", "bait", bait, "text");

        let captureLabel = createElement("label", "", "Capture Time");
        let captureInput = createElement("input", "captureTime", captureTime, "number");


        //Creating the buttons
        let catchUpdateButton = createElement('button', "update", "Update");
        let catchDeleteButton = createElement('button', "delete", "Delete");


        //Attach to the catchDiv
        catchDiv.appendChild(anglerLabel);
        catchDiv.appendChild(anglerInput);
        catchDiv.appendChild(document.createElement('hr'))

        catchDiv.appendChild(weightLabel);
        catchDiv.appendChild(weightInput);
        catchDiv.appendChild(document.createElement('hr'))

        catchDiv.appendChild(speciesLabel);
        catchDiv.appendChild(speciesInput);
        catchDiv.appendChild(document.createElement('hr'))

        catchDiv.appendChild(locationLabel);
        catchDiv.appendChild(locationInput);
        catchDiv.appendChild(document.createElement('hr'))

        catchDiv.appendChild(baitLabel);
        catchDiv.appendChild(baitInput);
        catchDiv.appendChild(document.createElement('hr'))

        catchDiv.appendChild(captureLabel);
        catchDiv.appendChild(captureInput);
        catchDiv.appendChild(document.createElement('hr'))

        catchDiv.appendChild(catchUpdateButton);
        catchDiv.appendChild(catchDeleteButton);


        catchDeleteButton.addEventListener('click', () => {
            let deleteURL = deleteAndUpdateURL + `${key}.json`
            fetch(deleteURL, {
                    method: "DELETE"
                })
                .then(response => response.json())
                .then(response => console.log(response));

        })

        catchUpdateButton.addEventListener('click', () => {

            // let currentCatchDiv = event.target.parentElement;

            let obj = JSON.stringify({
                angler: anglerInput.value,
                weight: weightInput.value,
                species: speciesInput.value,
                location: locationInput.value,
                bait: baitInput.value,
                captureTime: captureInput.value
            });

            let updateURL = deleteAndUpdateURL + `${key}.json`;

            fetch(updateURL, {
                method: "PUT",
                body: obj
            })

        })


        catchesDiv.appendChild(catchDiv);
    }

    function createElement(tag, className, content, type) {
        let createdElement = document.createElement(tag);

        if (tag === "input") {
            createdElement.type = type;
            createdElement.value = content;
        } else {
            createdElement.innerHTML = content;
        }
        createdElement.className = className;

        return createdElement;
    }
}

attachEvents();